package com.ri.securenote.controllers;

import com.ri.securenote.models.AuditLog;
import com.ri.securenote.services.AuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/audit")
public class AuditLogController {

    @Autowired
    private AuditLogService auditLogService;

    @GetMapping
    public List<AuditLog> getAuditLog() {
        return auditLogService.getAllAuditLogs();
    }

    @GetMapping("/note/{noteId}")
    public List<AuditLog> getAuditLogByNoteId(@PathVariable Long noteId) {
        return auditLogService.getAuditLogsByNoteId(noteId);
    }
}
