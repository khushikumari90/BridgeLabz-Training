package com.bridgelabz.fundoonotes.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// UC6: Labels/Tags Management
@Entity
@Table(name = "note_labels")
@Getter
@Setter
@NoArgsConstructor
public class NoteLabel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String label;

    // soft-delete flag, matches Day 14's soft-delete pattern
    private boolean isDeleted = false;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;
}
