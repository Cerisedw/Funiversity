package com.switchfully.funiversity.classes.course;

import java.util.UUID;

public class Course {
    private final String id;
    private final String name;
    private final int studyPoints;
    private final String idProfessor;

    public Course(String name, int studyPoints, String idProfessor) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.studyPoints = rangeOfStudyPoints(studyPoints);
        this.idProfessor = idProfessor;
    }
    public Course(String id, String name, int studyPoints, String idProfessor){
        this.id = id;
        this.name = name;
        this.studyPoints = studyPoints;
        this.idProfessor = idProfessor;
    }

    private int rangeOfStudyPoints(int studyPoints){
        if(studyPoints >= 0 && studyPoints <= 6) return studyPoints;
        else return 0;
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
