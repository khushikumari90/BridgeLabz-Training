package com.app.fundoo.service;

import com.app.fundoo.dto.LabelRequest;
import com.app.fundoo.dto.LabelResponse;

import java.util.List;

public interface LabelService {
    LabelResponse createLabel(Long userId, LabelRequest request);
    List<LabelResponse> getAllLabels(Long userId);
    void addLabelToNote(Long userId, Long noteId, Long labelId);
    void removeLabelFromNote(Long userId, Long noteId, Long labelId);
}