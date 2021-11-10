package com.synerzip.amol.controller;

import com.synerzip.amol.dto.NotesDTO;
import com.synerzip.amol.model.Notes;
import com.synerzip.amol.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class NotesController {

    @Autowired
    NotesService notesService;

    @GetMapping("/notes")
    public List<Notes> getAllNotes(){
        return notesService.getAllNotes();
    }

    @PostMapping("/add/note")
    public Notes addNote(@Valid @RequestBody NotesDTO notes){
        System.out.println(notes.toString());
       return notesService.createNewNote(notes);
    }

    @GetMapping("/note/{noteId}")
    public Notes getNoteById(@PathVariable(value = "noteId") Long noteId){
        return notesService.getNote(noteId);
    }

    @PutMapping("/update/note/{noteId}")
    public Notes updateNote(@PathVariable(value = "noteId") Long noteId,@Valid @RequestBody NotesDTO notesDTO){
        return notesService.updateNote(noteId,notesDTO);
    }

    @DeleteMapping("/delete/note/{noteId}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "noteId") Long noteId){
        notesService.deleteNote(noteId);
        return  ResponseEntity.ok().build();
    }

}
