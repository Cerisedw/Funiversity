package com.switchfully.funiversity.mapper;

import com.switchfully.funiversity.classes.course.Course;
import com.switchfully.funiversity.classes.course.CourseDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CourseMapper {
    public CourseDto courseToCourseDto(Course course){
        return new CourseDto(course.getId(), course.getName(),
                course.getStudyPoints(), course.getIdProfessor());
    }
    public Course courseDtoToCourse(CourseDto courseDto){
        return new Course(courseDto.getId(), courseDto.getName(),
                courseDto.getStudyPoints(), courseDto.getIdProfessor());
    }
    public List<CourseDto> listCoursesToListCoursesDto(List<Course> listCourses){
        return Optional.of(listCourses)
                .map(c->c.stream()
                        .map(this::courseToCourseDto))
                .get().toList();
    }
    public List<Course> listCoursesDtoToListCourses(List<CourseDto> listCoursesDto){
        return Optional.of(listCoursesDto)
                .map(c->c.stream()
                        .map(this::courseDtoToCourse))
                .get().toList();
    }
}
