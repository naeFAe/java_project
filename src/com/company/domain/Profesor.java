package com.company.domain;

public class Profesor extends Persoana {
    private Curs curs;

    public Profesor(String prenume, String nume, String id,Curs curs) {
        super(prenume, nume, id);
        this.curs = curs;
    }

    public Curs getCurs() {
        return this.curs;
    }

    public void setCurs(Curs curs) {
        this.curs = curs;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    @Override
    public String getPrenume() {
        return prenume;
    }

    @Override
    public String getNume() {
        return nume;
    }

}


