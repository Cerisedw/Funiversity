package com.switchfully.funiversity.classes.professor;

public class CreateProfessorDto {
    private String firstName;
    private String lastName;

    public CreateProfessorDto(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
