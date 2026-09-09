package com.bridgelabz.fundoonotes.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoteCheckListRequest {

    @NotBlank(message = "Item name is required")
    private String itemName;

    // e.g. "PENDING", "DONE" - kept as a plain string for now, not an enum
    private String status;
}
