package com.bridgelabz.fundoonotes.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

// UC10: minimal stub request until Collaborators (UC13) exists properly -
// just enough to trigger the "note shared" RabbitMQ event
@Getter
@Setter
public class ShareNoteRequest {

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String sharedWithEmail;
}
