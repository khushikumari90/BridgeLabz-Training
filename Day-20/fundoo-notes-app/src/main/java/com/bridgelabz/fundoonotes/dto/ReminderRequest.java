package com.bridgelabz.fundoonotes.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReminderRequest {

    @NotNull(message = "Reminder time is required")
    private LocalDateTime reminderTime;
}
