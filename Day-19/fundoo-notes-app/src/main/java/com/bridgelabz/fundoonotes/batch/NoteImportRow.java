package com.bridgelabz.fundoonotes.batch;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// UC11: one row read out of the uploaded Excel sheet, before it becomes a real Note
@Getter
@Setter
@NoArgsConstructor
public class NoteImportRow {

    private String title;
    private String description;
    private String color;
    private String typeOfNote;
}
