package com.bridgelabz.fundoonotes.batch;

import com.bridgelabz.fundoonotes.entity.Note;
import com.bridgelabz.fundoonotes.entity.User;
import org.springframework.batch.item.ItemProcessor;

// UC11: turns a raw Excel row into a real Note, attached to the user who triggered the import.
// Returning null tells Spring Batch to SKIP this row (counted separately from writes).
public class NoteImportProcessor implements ItemProcessor<NoteImportRow, Note> {

    private final User owner;

    public NoteImportProcessor(User owner) {
        this.owner = owner;
    }

    @Override
    public Note process(NoteImportRow row) {
        if (row.getTitle() == null || row.getTitle().isBlank()) {
            // deliberately invalid rows (blank titles) are skipped, not written
            return null;
        }

        Note note = new Note();
        note.setTitle(row.getTitle());
        note.setDescription(row.getDescription());
        note.setColor(row.getColor());
        note.setTypeOfNote(row.getTypeOfNote());
        note.setOwner(owner);

        return note;
    }
}
