package com.synerzip.amol.service.impl;

import com.synerzip.amol.dto.NotesDTO;
import com.synerzip.amol.exception.ResourceNotFoundException;
import com.synerzip.amol.model.Notes;
import com.synerzip.amol.repository.NotesRepository;
import com.synerzip.amol.service.NotesService;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesServiceImpl implements NotesService {

    @Autowired
    NotesRepository notesRepository;
    @Override
    public List<Notes> getAllNotes() {
        return notesRepository.findAll();
    }

    @Override
    public Notes createNewNote(NotesDTO notesDTO) {
        Notes notes=new Notes();
        BeanUtils.copyProperties(notesDTO,notes);
        return notesRepository.save(notes);
    }

    @Override
    public Notes getNote(Long noteId) {
        return notesRepository.findById(noteId).orElseThrow(()-> new ResourceNotFoundException("Note","id",noteId));
    }

    @Override
    public Notes updateNote(Long noteId, NotesDTO notesDTO) {
        Notes notes= notesRepository.findById(noteId).orElseThrow(()-> new ResourceNotFoundException("Note","id",noteId));
        BeanUtils.copyProperties(notesDTO,notes);
        return notesRepository.save(notes);
    }

    @Override
    public void deleteNote(Long noteId) {
        Notes notes= notesRepository.findById(noteId).orElseThrow(()-> new ResourceNotFoundException("Note","id",noteId));
        notesRepository.delete(notes);
    }
}
