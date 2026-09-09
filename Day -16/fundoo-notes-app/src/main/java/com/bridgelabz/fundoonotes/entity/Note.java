package com.bridgelabz.fundoonotes.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

// UC4: Notes CRUD with Ownership
@Entity
@Table(name = "notes")
@Getter
@Setter
@NoArgsConstructor
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int noteId;

    private String title;

    private String description;

    private boolean isPined = false;
    private boolean isArchived = false;
    private boolean isDeleted = false;

    private String color;

    // e.g. TEXT, CHECKLIST, IMAGE, LINK
    private String typeOfNote;

    private String imageUrl;

    private String linkUrl;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;

    // UC6: a note can have multiple labels
    @ManyToMany
    @JoinTable(name = "note_note_labels",
            joinColumns = @JoinColumn(name = "note_id"),
            inverseJoinColumns = @JoinColumn(name = "label_id"))
    private Set<NoteLabel> labels = new HashSet<>();
}
