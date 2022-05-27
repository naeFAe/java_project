package com.company.domain;

public abstract class Persoana {
    protected String prenume;
    protected String nume;
    protected String id;

    //constructor
    public Persoana(String prenume, String nume, String id){
        this.prenume = prenume;
        this.nume = nume;
        this.id = id;
    }

    //setter

    public abstract void setPrenume(String prenume);

    public abstract String getPrenume();

    public abstract String getNume();

    public String getId() {
        return id;
    }
}

