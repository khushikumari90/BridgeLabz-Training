package com.bridgelabz.fundoonotes.repository;

import com.bridgelabz.fundoonotes.entity.Note;
import com.bridgelabz.fundoonotes.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Integer> {

    // scoped to the owner so a user only ever gets their own notes
    Optional<Note> findByNoteIdAndOwner(int noteId, User owner);

    List<Note> findByOwner(User owner);

    // UC5: archive/trash lists should exclude notes in other states
    List<Note> findByOwnerAndIsArchivedTrueAndIsDeletedFalse(User owner);

    List<Note> findByOwnerAndIsDeletedTrue(User owner);
}
