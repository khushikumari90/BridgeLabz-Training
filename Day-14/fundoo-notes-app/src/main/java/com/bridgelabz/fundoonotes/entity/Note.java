package com.bridgelabz.fundoonotes.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
