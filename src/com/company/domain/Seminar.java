package com.company.domain;

public class Seminar extends Curs {
    private String pondere;

    public Seminar(String nume, String ora, String zi, Examen examen, String pondere) {
        super(nume, ora, zi, examen);
        this.pondere = pondere;
    }

    public String getPondere() {
        return pondere;
    }

    public void setPondere(String pondere) {
        this.pondere = pondere;
    }
}
