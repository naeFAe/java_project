package com.company.domains;

public class Examen {
    private String data_examen;
    private String ora_examen;
    private String sala;

    public Examen(String data_examen, String ora_examen, String sala) {
        this.data_examen = data_examen;
        this.ora_examen = ora_examen;
        this.sala = sala;
    }

    public String getData_examen() {
        return data_examen;
    }

    public void setData_examen(String data_examen) {
        this.data_examen = data_examen;
    }

    public String getOra_examen() {
        return ora_examen;
    }

    public void setOra_examen(String ora_examen) {
        this.ora_examen = ora_examen;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }
}
