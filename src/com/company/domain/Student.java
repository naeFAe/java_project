package com.company.domain;

public class Student extends Persoana {
    private String clasa;
    private String grupa;
    private String an;

    public Student(String prenume, String nume, String id,String clasa, String grupa, String an) {
        super(prenume, nume, id);
        this.clasa = clasa;
        this.grupa = grupa;
        this.an = an;
    }
    public String getClasa() {
        return clasa;
    }

    public void setClasa(String clasa) {
        this.clasa = clasa;
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

    public String getGrupa() {
        return grupa;
    }

    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }

    public String getAn() {
        return an;
    }

    public void setAn(String an) {
        this.an = an;
    }


}

