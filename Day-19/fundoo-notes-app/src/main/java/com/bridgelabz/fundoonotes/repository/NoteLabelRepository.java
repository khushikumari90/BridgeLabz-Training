package com.bridgelabz.fundoonotes.repository;

import com.bridgelabz.fundoonotes.entity.NoteLabel;
import com.bridgelabz.fundoonotes.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NoteLabelRepository extends JpaRepository<NoteLabel, Integer> {

    Optional<NoteLabel> findByIdAndOwner(int id, User owner);

    // deleted labels don't show up in the list
    List<NoteLabel> findByOwnerAndIsDeletedFalse(User owner);

    // used for the per-user uniqueness check - two users can each have "Work",
    // but one user can't have two identical (non-deleted) labels
    boolean existsByOwnerAndLabelIgnoreCaseAndIsDeletedFalse(User owner, String label);
}
