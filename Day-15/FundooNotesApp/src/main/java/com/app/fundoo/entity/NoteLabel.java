package com.app.fundoo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"userId", "labelName"}))
public class NoteLabel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long labelId;

    private String labelName;

    @Column(nullable = false)
    private Long userId; // owner of this label

    @ManyToMany
    @JoinTable(name = "note_label_mapping",
            joinColumns = @JoinColumn(name = "label_id"),
            inverseJoinColumns = @JoinColumn(name = "note_id")
    )
    private java.util.Set<Note> notes = new java.util.HashSet<>();
}