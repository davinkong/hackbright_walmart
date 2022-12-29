package com.ems.employeesystem.services;


import com.ems.employeesystem.dtos.InformationDto;
import com.ems.employeesystem.entities.Employee;
import com.ems.employeesystem.entities.Information;
import com.ems.employeesystem.repositories.EmployeeRepository;
import com.ems.employeesystem.repositories.InformationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InformationServiceImpl implements InformationService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private InformationRepository informationRepository;

    //Add a Note
    @Override
    @Transactional
    public void addNote(InformationDto informationDto, Long employeeId){
        Optional<Employee> userOptional = employeeRepository.findById(employeeId);
        Information information = new Information(informationDto);
        userOptional.ifPresent(information::setEmployee);
        informationRepository.saveAndFlush(information);
    }



    //deleting a Note
    @Override
    @Transactional
    public void deleteNoteById(Long noteId){
        Optional<Information> noteOptional = informationRepository.findById(noteId);
        noteOptional.ifPresent(information -> informationRepository.delete(information));
    }

    //updating a Note

    @Override
    public void updateNoteById(InformationDto informationDto){
        Optional<Information> infoOptional = informationRepository.findById(informationDto.getId());
        infoOptional.ifPresent(note -> {
            note.setStreet(informationDto.getStreet());
            note.setCity(informationDto.getCity());
            note.setState(informationDto.getState());
            note.setZipCode(informationDto.getZipCode());
            note.setPhoneNumber(informationDto.getPhoneNumber());
            informationRepository.saveAndFlush(note);
        });
    }

    //finding all notes by User
    @Override
    public List<InformationDto> getAllNotesByEmployeeId(Long employeeId){
        Optional<Employee> userOptional = employeeRepository.findById(employeeId);
        if(userOptional.isPresent()){
            List<Information> informationList = informationRepository.findAllByEmployeeEquals(userOptional.get());
            return informationList.stream().map(information -> new InformationDto(information)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    //method for getting a Note by the Note “id”
    @Override
    public Optional<InformationDto> getNoteById(Long noteId){
        Optional<Information> infoOptional = informationRepository.findById(noteId);
        if (infoOptional.isPresent()){
            return Optional.of(new InformationDto(infoOptional.get()));
        }
        return Optional.empty();
    }

}
