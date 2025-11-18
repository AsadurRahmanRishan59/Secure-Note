package com.ri.securenote.services;

import com.ri.securenote.models.AuditLog;
import com.ri.securenote.models.Note;

import java.util.List;

public interface AuditLogService {
    public void logNoteCreation(String username, Note note);

    public void logNoteUpdate(String username, Note note);

    public void logNoteDeletion(String username, Long noteId);

    List<AuditLog> getAllAuditLogs();

    List<AuditLog> getAuditLogsByNoteId(Long noteId);
}
