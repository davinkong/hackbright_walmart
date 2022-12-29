package com.ems.employeesystem.controllers;


import com.ems.employeesystem.dtos.InformationDto;
import com.ems.employeesystem.services.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/info")
public class InformationController {
    @Autowired
    private InformationService informationService;


    @GetMapping("/employee/{employeeId}")
    public List<InformationDto> getNoteByEmployee(@PathVariable Long employeeId) {
        return informationService.getAllNotesByEmployeeId(employeeId);
    }


    @PostMapping("/employee/{employeeId}")
    public void addNote(@RequestBody InformationDto informationDto, @PathVariable Long employeeId){
        informationService.addNote(informationDto, employeeId);
    }


    @DeleteMapping("/{noteId}")
    public void deleteNoteById(@PathVariable Long noteId){
        informationService.deleteNoteById(noteId);
    }


    @PutMapping
    public void updateNote(@RequestBody InformationDto informationDto){
        informationService.updateNoteById(informationDto);
    }


    @GetMapping("/{noteId}")
    public Optional<InformationDto> getNoteById(@PathVariable Long noteId){
        return informationService.getNoteById(noteId);
    }
}
