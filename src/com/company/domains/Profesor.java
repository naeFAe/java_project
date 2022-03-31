package com.company.domains;

public class Profesor extends Persoana {
    private Curs curs;

    public Profesor(String prenume, String nume, Curs curs) {
        super(prenume, nume);
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
        return "profesor{" +
                "prenume='" + prenume + '\'' +
                ", nume='" + nume + '\'' +
                ", curs='" + curs + '\'' +
                '}';
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


