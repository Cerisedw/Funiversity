package com.switchfully.funiversity.repository;

import com.switchfully.funiversity.classes.course.Course;
import com.switchfully.funiversity.classes.professor.Professor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Repository
public class CourseRepository {
    private final ProfessorRepository repoProf = new ProfessorRepository();
    private final List<Professor> listProfs = repoProf.getListOfProfessors();
    private final List<Course> listOfCourses = new ArrayList<>(List.of(
            new Course("Switchfully", 4, getRandomProfId()),
            new Course("WoW Academy", 6, getRandomProfId()),
            new Course("Something", 0, getRandomProfId())
    ));
    public List<Course> getListOfCourses() {
        return listOfCourses;
    }
    public Optional<Course> getCourseById(String id) {
        return listOfCourses.stream().filter(c->c.getId().equals(id)).findFirst();
    }
    public boolean addCourse(Course prof){
        return getListOfCourses().add(prof);
    }
    public Course updateCourse(String id, Course prof){
        return listOfCourses.set(Integer.parseInt(id), prof);
    }
    public boolean deleteCourse(String id){
        return getListOfCourses().removeIf(c->c.getId().equals(id));
    }
    private String getRandomProfId(){
        Random rand = new Random();
        Professor prof = repoProf.getListOfProfessors().get(rand.nextInt(listProfs.size() - 1));
        return prof.getId();
    }
}
