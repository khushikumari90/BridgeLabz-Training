package com.bridgelabz.fundoonotes.batch;

import com.bridgelabz.fundoonotes.dto.ImportResult;
import com.bridgelabz.fundoonotes.entity.Note;
import com.bridgelabz.fundoonotes.entity.User;
import com.bridgelabz.fundoonotes.repository.NoteRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

// UC11: builds and runs the import Job/Step by hand per request, since the reader/processor
// need per-request data (the uploaded file's path, the current user) rather than being fixed beans
@Service
public class NoteImportService {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;
    private final JobLauncher jobLauncher;
    private final NoteRepository noteRepository;

    public NoteImportService(JobRepository jobRepository,
                              PlatformTransactionManager transactionManager,
                              JobLauncher jobLauncher,
                              NoteRepository noteRepository) {
        this.jobRepository = jobRepository;
        this.transactionManager = transactionManager;
        this.jobLauncher = jobLauncher;
        this.noteRepository = noteRepository;
    }

    public ImportResult importNotes(MultipartFile file, User owner) throws Exception {

        File tempFile = File.createTempFile("notes-import-", ".xlsx");
        file.transferTo(tempFile);

        try {
            RepositoryItemWriter<Note> writer = new RepositoryItemWriter<>();
            writer.setRepository(noteRepository);
            writer.setMethodName("save");

            Step importNotesStep = new StepBuilder("importNotesStep", jobRepository)
                    .<NoteImportRow, Note>chunk(100, transactionManager)
                    .reader(new ExcelNoteItemReader())
                    .processor(new NoteImportProcessor(owner))
                    .writer(writer)
                    .build();

            Job importNotesJob = new JobBuilder("importNotesJob", jobRepository)
                    .start(importNotesStep)
                    .build();

            JobParameters jobParameters = new JobParametersBuilder()
                    .addString("filePath", tempFile.getAbsolutePath())
                    .addLong("startedAt", System.currentTimeMillis()) // makes each run unique
                    .toJobParameters();

            JobExecution jobExecution = jobLauncher.run(importNotesJob, jobParameters);

            long readCount = 0, writeCount = 0, skipCount = 0;
            for (StepExecution stepExecution : jobExecution.getStepExecutions()) {
                readCount += stepExecution.getReadCount();
                writeCount += stepExecution.getWriteCount();
                skipCount += stepExecution.getSkipCount(); // already sums read/write/process skips
            }

            return new ImportResult(readCount, writeCount, skipCount);

        } finally {
            Files.deleteIfExists(tempFile.toPath());
        }
    }
}
