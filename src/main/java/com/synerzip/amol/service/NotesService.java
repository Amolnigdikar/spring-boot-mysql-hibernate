package com.synerzip.amol.service;

import com.synerzip.amol.dto.NotesDTO;
import com.synerzip.amol.model.Notes;

import java.util.List;

public interface NotesService {

    List<Notes> getAllNotes();

    Notes createNewNote(NotesDTO notesDTO);

    Notes getNote(Long noteId);

    Notes updateNote(Long noteId, NotesDTO notesDTO);

    void deleteNote(Long noteId);
}
