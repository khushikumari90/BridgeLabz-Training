package com.bridgelabz.fundoonotes.specification;

import com.bridgelabz.fundoonotes.entity.Note;
import com.bridgelabz.fundoonotes.entity.User;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

// UC7: builds one flexible search query combining title text, state, and label filters
public class NoteSpecification {

    public static Specification<Note> search(User owner, String titleText, String state, String labelName) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            // ALWAYS unconditional - a search can never leak another user's notes
            predicates.add(cb.equal(root.get("owner"), owner));

            if (titleText != null && !titleText.isBlank()) {
                predicates.add(cb.like(cb.lower(root.get("title")), "%" + titleText.toLowerCase() + "%"));
            }

            if (state != null && !state.isBlank()) {
                switch (state.toUpperCase()) {
                    case "PINNED" -> predicates.add(cb.isTrue(root.get("isPined")));
                    case "ARCHIVED" -> predicates.add(cb.isTrue(root.get("isArchived")));
                    case "TRASHED" -> predicates.add(cb.isTrue(root.get("isDeleted")));
                    case "ACTIVE" -> {
                        predicates.add(cb.isFalse(root.get("isArchived")));
                        predicates.add(cb.isFalse(root.get("isDeleted")));
                    }
                    default -> { /* unknown state value - ignore, don't filter */ }
                }
            }

            if (labelName != null && !labelName.isBlank()) {
                predicates.add(cb.equal(root.join("labels").get("label"), labelName));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
