package com.ems.employeesystem.services;

import com.ems.employeesystem.dtos.InformationDto;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;


public interface InformationService {
    //Add a Note
    @Transactional
    void addNote(InformationDto informationDto, Long employeeId);

    //deleting a Note
    @Transactional
    void deleteNoteById(Long noteId);

    void updateNoteById(InformationDto informationDto);

    //finding all notes by User
    List<InformationDto> getAllNotesByEmployeeId(Long employeeId);

    //method for getting a Note by the Note “id”
    Optional<InformationDto> getNoteById(Long noteId);
}
