package com.bridgelabz.fundoonotes.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoteLabelRequest {

    @NotBlank(message = "Label is required")
    private String label;
}
