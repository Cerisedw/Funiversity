package com.switchfully.funiversity.classes.course;

public class CourseDto {
    private final String id;
    private final String name;
    private final int studyPoints;
    private final String idProfessor;

    public CourseDto(String id, String name, int studyPoints, String idProfessor) {
        this.id = id;
        this.name = name;
        this.studyPoints = studyPoints;
        this.idProfessor = idProfessor;
    }

    public String getId() {
        return id;
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
