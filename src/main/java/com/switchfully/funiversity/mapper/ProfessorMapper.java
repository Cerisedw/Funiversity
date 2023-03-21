package com.switchfully.funiversity.mapper;

import com.switchfully.funiversity.classes.professor.Professor;
import com.switchfully.funiversity.classes.professor.ProfessorDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProfessorMapper {
    public ProfessorDto professorToProfessorDto(Professor professor){
        return new ProfessorDto(professor.getId(),
                professor.getFirstName(),
                professor.getLastName());
    }
    public Professor professorDtoToProfessor(ProfessorDto profDto){
        return new Professor(profDto.getId(),
                profDto.getFirstName(),
                profDto.getLastName());
    }
    public List<ProfessorDto> listProfessorsToListProfessorsDto(List<Professor> listProfessors){
        return Optional.of(listProfessors)
                .map(p->p.stream()
                        .map(this::professorToProfessorDto))
                .get().toList();
    }
    public List<Professor> listProfessorsDtoToListProfessors(List<ProfessorDto> listProfDto){
        return Optional.of(listProfDto)
                .map(lp->lp.stream()
                        .map(this::professorDtoToProfessor))
                .get().toList();
    }
}
