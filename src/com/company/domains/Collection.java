package com.company.domains;

import java.util.ArrayList;


public class Collection {
    private ArrayList <Student> elevi = new ArrayList<>();
    private ArrayList <Profesor> profesor = new ArrayList<>();

    public ArrayList<Student> getElevi() {
        return elevi;
    }

    public void setElevi(ArrayList<Student> elevi) {
        this.elevi = elevi;
    }

    public ArrayList<Profesor> getProfesor() {
        return profesor;
    }

    public void setProfesor(ArrayList<Profesor> profesor) {
        this.profesor = profesor;
    }
}

