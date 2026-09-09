package com.bridgelabz.fundoonotes.repository;

import com.bridgelabz.fundoonotes.entity.Note;
import com.bridgelabz.fundoonotes.entity.NoteCheckList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NoteCheckListRepository extends JpaRepository<NoteCheckList, Integer> {

    // scoped to the parent note, so checklist items never leak across notes
    Optional<NoteCheckList> findByIdAndNote(int id, Note note);

    List<NoteCheckList> findByNoteAndIsDeletedFalse(Note note);
}
