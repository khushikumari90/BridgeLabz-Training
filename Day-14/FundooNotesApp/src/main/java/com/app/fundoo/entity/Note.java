package com.app.fundoo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noteId;

    private String title;
    private String description;

    private boolean isPinned;
    private boolean isArchived;
    private boolean isDeleted;

    private String color;
    private String typeOfNote;
    private String imageUrl;
    private String linkUrl;

    @Column(nullable = false)
    private Long userId; // owner
}