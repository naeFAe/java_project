package com.company.domain;

public class Curs {
    private String nume;
    private String ora;
    private String zi;
    private Examen examen;

    public Curs(String nume, String ora, String zi, Examen examen) {
        this.nume = nume;
        this.ora = ora;
        this.zi = zi;
        this.examen = examen;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }

    public String getZi() {
        return zi;
    }

    public void setZi(String zi) {
        this.zi = zi;
    }


    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    @Override
    public String toString() {
        return "Curs{" +
                "nume='" + nume + '\'' +
                ", ora='" + ora + '\'' +
                ", zi='" + zi + '\'' +
                ", examen=" + examen +
                '}';
    }
}
