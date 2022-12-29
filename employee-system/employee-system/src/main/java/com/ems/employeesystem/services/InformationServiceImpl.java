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



    @Transactional
    public void addNote(InformationDto informationDto, Long employeeId){
        Optional<Employee> userOptional = employeeRepository.findById(employeeId);
        Information information = new Information(informationDto);
        userOptional.ifPresent(information::setEmployee);
        informationRepository.saveAndFlush(information);
    }





    @Transactional
    public void deleteNoteById(Long noteId){
        Optional<Information> noteOptional = informationRepository.findById(noteId);
        noteOptional.ifPresent(information -> informationRepository.delete(information));
    }


    @Transactional
    public void updateNoteById(InformationDto informationDto){
        Optional<Information> infoOptional = informationRepository.findById(informationDto.getId());
        infoOptional.ifPresent(information -> {
            information.setStreet(informationDto.getStreet());
            information.setCity(informationDto.getCity());
            information.setState(informationDto.getState());
            information.setZipCode(informationDto.getZipCode());
            information.setPhoneNumber(informationDto.getPhoneNumber());
            informationRepository.saveAndFlush(information);
        });
    }

    //finding all notes by User

    public List<InformationDto> getAllNotesByEmployeeId(Long employeeId){
        Optional<Employee> userOptional = employeeRepository.findById(employeeId);
        if(userOptional.isPresent()){
            List<Information> informationList = informationRepository.findAllByEmployeeEquals(userOptional.get());
            return informationList.stream().map(information -> new InformationDto(information)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }



    public Optional<InformationDto> getNoteById(Long noteId){
        Optional<Information> infoOptional = informationRepository.findById(noteId);
        if (infoOptional.isPresent()){
            return Optional.of(new InformationDto(infoOptional.get()));
        }
        return Optional.empty();
    }

}
