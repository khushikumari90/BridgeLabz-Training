package com.bridgelabz.fundoonotes.service;

import com.bridgelabz.fundoonotes.dto.NoteLabelRequest;
import com.bridgelabz.fundoonotes.entity.Note;
import com.bridgelabz.fundoonotes.entity.NoteLabel;
import com.bridgelabz.fundoonotes.entity.User;
import com.bridgelabz.fundoonotes.exception.DuplicateLabelException;
import com.bridgelabz.fundoonotes.exception.NoteLabelNotFoundException;
import com.bridgelabz.fundoonotes.exception.NoteNotFoundException;
import com.bridgelabz.fundoonotes.repository.NoteLabelRepository;
import com.bridgelabz.fundoonotes.repository.NoteRepository;
import com.bridgelabz.fundoonotes.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteLabelService {

    private final NoteLabelRepository noteLabelRepository;
    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    public NoteLabelService(NoteLabelRepository noteLabelRepository,
                             NoteRepository noteRepository,
                             UserRepository userRepository) {
        this.noteLabelRepository = noteLabelRepository;
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
    }

    private User getCurrentUser() {
        int userId = (int) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Logged in user not found"));
    }

    public NoteLabel createLabel(NoteLabelRequest request) {
        User owner = getCurrentUser();

        // uniqueness is scoped per-user, so a plain @Column(unique) on the entity won't work here
        if (noteLabelRepository.existsByOwnerAndLabelIgnoreCaseAndIsDeletedFalse(owner, request.getLabel())) {
            throw new DuplicateLabelException(request.getLabel());
        }

        NoteLabel noteLabel = new NoteLabel();
        noteLabel.setLabel(request.getLabel());
        noteLabel.setOwner(owner);

        return noteLabelRepository.save(noteLabel);
    }

    public NoteLabel updateLabel(int labelId, NoteLabelRequest request) {
        NoteLabel noteLabel = getLabelForCurrentUser(labelId);
        noteLabel.setLabel(request.getLabel());
        return noteLabelRepository.save(noteLabel);
    }

    public void deleteLabel(int labelId) {
        NoteLabel noteLabel = getLabelForCurrentUser(labelId);
        noteLabel.setDeleted(true); // soft delete
        noteLabelRepository.save(noteLabel);
    }

    public List<NoteLabel> getLabelList() {
        User owner = getCurrentUser();
        return noteLabelRepository.findByOwnerAndIsDeletedFalse(owner);
    }

    public Note addLabelToNote(int noteId, int labelId) {
        Note note = getNoteForCurrentUser(noteId);
        NoteLabel label = getLabelForCurrentUser(labelId);

        note.getLabels().add(label);
        return noteRepository.save(note);
    }

    public Note removeLabelFromNote(int noteId, int labelId) {
        Note note = getNoteForCurrentUser(noteId);
        NoteLabel label = getLabelForCurrentUser(labelId);

        note.getLabels().remove(label);
        return noteRepository.save(note);
    }

    private NoteLabel getLabelForCurrentUser(int labelId) {
        User owner = getCurrentUser();
        return noteLabelRepository.findByIdAndOwner(labelId, owner)
                .orElseThrow(() -> new NoteLabelNotFoundException(labelId));
    }

    private Note getNoteForCurrentUser(int noteId) {
        User owner = getCurrentUser();
        return noteRepository.findByNoteIdAndOwner(noteId, owner)
                .orElseThrow(() -> new NoteNotFoundException(noteId));
    }
}
