package com.company.domains;

public abstract class Persoana {
    protected String prenume;
    protected String nume;

    //constructor
    public Persoana(String prenume, String nume){
        this.prenume = prenume;
        this.nume = nume;
    }

    //setter

    public abstract void setPrenume(String prenume);

    public abstract String getPrenume();

    public abstract String getNume();

}

