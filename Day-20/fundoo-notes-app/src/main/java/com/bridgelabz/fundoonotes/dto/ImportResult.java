package com.bridgelabz.fundoonotes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ImportResult {

    private long readCount;
    private long writeCount;
    private long skipCount;
}
