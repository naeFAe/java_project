package com.company.domains;

public class Seminar extends Curs {
    private int pondere;

    public Seminar(String nume, String ora, String zi, Examen colocviul, String data, int pondere) {
        super(nume, ora, zi, colocviul);
        this.pondere = pondere;
    }

    public int getPondere() {
        return pondere;
    }

    public void setPondere(int pondere) {
        this.pondere = pondere;
    }
}
