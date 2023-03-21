package com.switchfully.funiversity.controller;

import com.switchfully.funiversity.classes.course.CourseDto;
import com.switchfully.funiversity.classes.professor.ProfessorDto;
import com.switchfully.funiversity.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/courses")
public class CourseController {
    private final CourseService service;
    public CourseController(CourseService service) {
        this.service = service;
    }
    @GetMapping(produces="application/json")
    public List<CourseDto> getCourses(){
        return service.getAllCourses();
    }
    @GetMapping(path = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public CourseDto getCourse(@PathVariable String id){
        return service.getCourseById(id);
    }
    @GetMapping(path = "/{id}/professor", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ProfessorDto getCourseProfessor(@PathVariable String id) { return service.getProfessorOfCourse(id); }
}
