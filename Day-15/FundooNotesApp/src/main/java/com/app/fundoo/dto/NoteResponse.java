package com.app.fundoo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoteResponse {
    private Long noteId;
    private String title;
    private String description;
    private boolean isPinned;
    private boolean isArchived;
    private String color;
    private String typeOfNote;
    private String imageUrl;
    private String linkUrl;
}