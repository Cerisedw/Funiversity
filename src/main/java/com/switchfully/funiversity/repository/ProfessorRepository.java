package com.switchfully.funiversity.repository;

import com.switchfully.funiversity.classes.professor.Professor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProfessorRepository {
    private static final List<Professor> listOfProfessors = new ArrayList<>(List.of(
            new Professor("Max", "TheGoat"), new Professor("Buns", "Hanet"),
            new Professor("Evelynn", "Nova"), new Professor("Mike", "Toast")
    ));

    public List<Professor> getListOfProfessors() {
        return listOfProfessors;
    }
    public Optional<Professor> getProfessorById(String id) {
        return listOfProfessors.stream().filter(p->p.getId().equals(id)).findFirst();
    }
    public boolean addProfessor(Professor prof){
        return getListOfProfessors().add(prof);
    }
    public Professor updateProfessor(String id, Professor prof){
        return listOfProfessors.set(Integer.parseInt(id), prof);
    }
    public boolean deleteProfessor(String id){
        return getListOfProfessors().removeIf(p->p.getId().equals(id));
    }
}
