package com.switchfully.funiversity.service;

import com.switchfully.funiversity.classes.course.CourseDto;
import com.switchfully.funiversity.classes.professor.ProfessorDto;
import com.switchfully.funiversity.mapper.CourseMapper;
import com.switchfully.funiversity.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseMapper mapper;
    private final CourseRepository repo;
    private final ProfessorService profService;

    public CourseService(CourseMapper mapper, CourseRepository repo, ProfessorService profService) {
        this.mapper = mapper;
        this.repo = repo;
        this.profService = profService;
    }
    public List<CourseDto> getAllCourses(){
        return mapper.listCoursesToListCoursesDto(repo.getListOfCourses());
    }
    public CourseDto getCourseById(String id) {
        return mapper.courseToCourseDto(repo.getCourseById(id).orElseThrow());
    }
    public ProfessorDto getProfessorOfCourse(String idCourse){
        //String idProf = repo.getCourseById(idCourse).orElseThrow().getIdProfessor();
        //return profService.getProfessorById(idProf);
        return profService.getProfessorById(getCourseById(idCourse).getIdProfessor());
    }
}
