package com.ri.securenote.repositories;

import com.ri.securenote.models.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {

     List<AuditLog> findByNoteId(Long noteId);
}
