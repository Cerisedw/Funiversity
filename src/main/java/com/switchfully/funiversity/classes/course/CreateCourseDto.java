package com.switchfully.funiversity.classes.course;

public class CreateCourseDto {
    private final String name;
    private final int studyPoints;
    private final String idProfessor;

    public CreateCourseDto(String name, int studyPoints, String idProfessor) {
        this.name = name;
        this.studyPoints = studyPoints;
        this.idProfessor = idProfessor;
    }

    public String getName() {
        return name;
    }

    public int getStudyPoints() {
        return studyPoints;
    }

    public String getIdProfessor() {
        return idProfessor;
    }
}
