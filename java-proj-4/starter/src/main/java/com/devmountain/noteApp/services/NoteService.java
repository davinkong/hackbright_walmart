package com.devmountain.noteApp.services;

import com.devmountain.noteApp.dtos.NoteDto;
import java.util.*;

import javax.transaction.Transactional;

public interface NoteService {
    //Add a Note
    @Transactional
    void addNote(NoteDto noteDto, Long userId);

    //deleting a Note
    @Transactional
    void deleteNoteById(Long noteId);

    void updateNoteById(NoteDto noteDto);

    //finding all notes by User
    List<NoteDto> getAllNotesByUserId(Long userId);

    //method for getting a Note by the Note “id”
    Optional<NoteDto> getNoteById(Long noteId);
}
