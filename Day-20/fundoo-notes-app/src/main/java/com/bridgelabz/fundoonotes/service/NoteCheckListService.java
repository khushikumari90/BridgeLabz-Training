package com.bridgelabz.fundoonotes.service;

import com.bridgelabz.fundoonotes.dto.NoteCheckListRequest;
import com.bridgelabz.fundoonotes.entity.Note;
import com.bridgelabz.fundoonotes.entity.NoteCheckList;
import com.bridgelabz.fundoonotes.exception.NoteCheckListNotFoundException;
import com.bridgelabz.fundoonotes.repository.NoteCheckListRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// UC12: Checklist Items on Notes
// Ownership check happens at the Note level (via NoteService.getNoteDetail), since a checklist
// item's implicit owner is always whoever owns the parent note - there's no separate owner field here.
@Service
public class NoteCheckListService {

    private final NoteCheckListRepository noteCheckListRepository;
    private final NoteService noteService;

    public NoteCheckListService(NoteCheckListRepository noteCheckListRepository, NoteService noteService) {
        this.noteCheckListRepository = noteCheckListRepository;
        this.noteService = noteService;
    }

    public List<NoteCheckList> getChecklistItems(int noteId) {
        Note note = noteService.getNoteDetail(noteId); // throws NoteNotFoundException if not owned
        return noteCheckListRepository.findByNoteAndIsDeletedFalse(note);
    }

    public NoteCheckList addChecklistItem(int noteId, NoteCheckListRequest request) {
        Note note = noteService.getNoteDetail(noteId);

        NoteCheckList item = new NoteCheckList();
        item.setItemName(request.getItemName());
        item.setStatus(request.getStatus() != null ? request.getStatus() : "PENDING");
        item.setNote(note);

        return noteCheckListRepository.save(item);
    }

    public NoteCheckList updateChecklistItem(int noteId, int itemId, NoteCheckListRequest request) {
        NoteCheckList item = getChecklistItemForNote(noteId, itemId);

        item.setItemName(request.getItemName());
        if (request.getStatus() != null) {
            item.setStatus(request.getStatus());
        }

        return noteCheckListRepository.save(item);
    }

    public void deleteChecklistItem(int noteId, int itemId) {
        NoteCheckList item = getChecklistItemForNote(noteId, itemId);
        item.setDeleted(true); // soft delete, same pattern as labels
        noteCheckListRepository.save(item);
    }

    // "mark all complete" - one transaction updating multiple checklist items at once
    public List<NoteCheckList> markAllComplete(int noteId) {
        Note note = noteService.getNoteDetail(noteId);
        List<NoteCheckList> items = noteCheckListRepository.findByNoteAndIsDeletedFalse(note);

        items.forEach(item -> item.setStatus("DONE"));

        return noteCheckListRepository.saveAll(items);
    }

    private NoteCheckList getChecklistItemForNote(int noteId, int itemId) {
        Note note = noteService.getNoteDetail(noteId); // confirms the note belongs to the current user
        return noteCheckListRepository.findByIdAndNote(itemId, note)
                .orElseThrow(() -> new NoteCheckListNotFoundException(itemId));
    }
}
