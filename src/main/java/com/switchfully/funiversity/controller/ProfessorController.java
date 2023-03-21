package com.switchfully.funiversity.controller;

import com.switchfully.funiversity.classes.professor.CreateProfessorDto;
import com.switchfully.funiversity.classes.professor.ProfessorDto;
import com.switchfully.funiversity.service.ProfessorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/professors")
public class ProfessorController {
    private final ProfessorService service;

    public ProfessorController(ProfessorService service) {
        this.service = service;
    }

    @GetMapping(produces="application/json")
    public List<ProfessorDto> getProfessors(){
        return service.getAllProfessors();
    }
    @GetMapping(path = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ProfessorDto getProfessor(@PathVariable String id){
        return service.getProfessorById(id);
    }
    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ProfessorDto createProfessor(@RequestBody CreateProfessorDto professorToCreate){
        return service.addProfessor(professorToCreate);
    }
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProfessor(@PathVariable String id){
        service.deleteProfessor(id);
    }
    @PutMapping(consumes = "application/json", produces = "application/json", path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProfessorDto updateProfessor(@RequestBody CreateProfessorDto updateMovieDto, @PathVariable String id){
        return service.updateProfessor(updateMovieDto, id);
    }
}
