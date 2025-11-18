package com.ri.securenote.services.impl;

import com.ri.securenote.models.Note;
import com.ri.securenote.repositories.NoteRepository;
import com.ri.securenote.services.AuditLogService;
import com.ri.securenote.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private AuditLogService auditLogService;

    @Override
    public Note createNoteForUser(String userName, String content) {
        Note note = new Note();
        note.setContent(content);
        note.setOwnerUsername(userName);
        Note savedNote = noteRepository.save(note);
        auditLogService.logNoteCreation(userName, savedNote);
        return savedNote;
    }

    @Override
    public Note updateNoteForUser(Long noteId, String content, String userName) {
        Note note = noteRepository.findById(noteId).orElseThrow(() -> new RuntimeException("Note not found"));
        note.setContent(content);
        Note savedNote = noteRepository.save(note);
        auditLogService.logNoteUpdate(userName, savedNote);
        return savedNote;
    }

    @Override
    public void deleteNoteForUser(Long noteId, String userName) {
        Note note = noteRepository.findById(noteId).orElseThrow(() -> new RuntimeException("Note not found"));
        noteRepository.delete(note);
        auditLogService.logNoteDeletion(userName, noteId);
    }

    @Override
    public List<Note> getNotesForUser(String userName) {
        return noteRepository.findByOwnerUsername(userName);
    }
}
