package com.synerzip.amol.repository;

import com.synerzip.amol.model.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends JpaRepository<Notes,Long> {
}