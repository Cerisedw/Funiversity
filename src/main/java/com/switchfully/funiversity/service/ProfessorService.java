package com.switchfully.funiversity.service;

import com.switchfully.funiversity.classes.professor.CreateProfessorDto;
import com.switchfully.funiversity.classes.professor.Professor;
import com.switchfully.funiversity.classes.professor.ProfessorDto;
import com.switchfully.funiversity.mapper.ProfessorMapper;
import com.switchfully.funiversity.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {
    private final ProfessorMapper mapper;
    private final ProfessorRepository repo;

    public ProfessorService(ProfessorMapper mapper, ProfessorRepository repo) {
        this.mapper = mapper;
        this.repo = repo;
    }
    public List<ProfessorDto> getAllProfessors(){
        return mapper.listProfessorsToListProfessorsDto(repo.getListOfProfessors());
    }
    public ProfessorDto getProfessorById(String id){
        return mapper.professorToProfessorDto(
                repo.getProfessorById(id).orElseThrow()
        );
    }
    public ProfessorDto addProfessor(CreateProfessorDto profToCreate){
        Professor newProf = new Professor(profToCreate.getFirstName(), profToCreate.getLastName());
        repo.addProfessor(newProf);
        return mapper.professorToProfessorDto(newProf);
    }

    public void deleteProfessor(String id) {
        repo.deleteProfessor(id);
    }
    public ProfessorDto updateProfessor(CreateProfessorDto updateProfessor, String id) {
        Professor prof = repo.getProfessorById(id).orElseThrow();
        if(updateProfessor.getFirstName() != null) prof.setFirstName(updateProfessor.getFirstName());
        if(updateProfessor.getLastName() != null) prof.setLastName(updateProfessor.getLastName());
        repo.updateProfessor(id, prof);
        return mapper.professorToProfessorDto(prof);
    }
}
