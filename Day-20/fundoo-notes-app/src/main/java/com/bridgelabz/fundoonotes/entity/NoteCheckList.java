package com.bridgelabz.fundoonotes.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// UC12: Checklist Items on Notes - title-less "to-do" sub-items belonging to a note
@Entity
@Table(name = "note_checklists")
@Getter
@Setter
@NoArgsConstructor
public class NoteCheckList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String itemName;

    // e.g. "PENDING", "DONE"
    private String status;

    private boolean isDeleted = false;

    @ManyToOne
    @JoinColumn(name = "note_id")
    private Note note;
}
