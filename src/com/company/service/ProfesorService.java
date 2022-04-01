package com.company.service;

import com.company.domain.Curs;
import com.company.domain.Examen;
import com.company.domain.Profesor;
import com.company.persistance.ProfesorRepo;

import javax.sound.midi.InvalidMidiDataException;

public class ProfesorService {
    private ProfesorRepo profesorRepo =new ProfesorRepo();

    public void registerNewProfesor(String prenume,String nume,String nume_curs,String ora_curs,String zi_curs,String data_examen,String ora_examen,String sala_examen ) throws InvalidMidiDataException {
        if(prenume == null || prenume.trim().isEmpty()){
            throw new InvalidMidiDataException("Prenume Invalid");

        }
        if(nume == null || nume.trim().isEmpty()){
            throw new InvalidMidiDataException("Nume Invalid");
        }

        if(nume_curs == null || nume_curs.trim().isEmpty()){
            throw new InvalidMidiDataException("Nume curs Invalid");
        }

        if(ora_curs == null || ora_curs.trim().isEmpty()){
            throw new InvalidMidiDataException("Ora curs Invalida");
        }

        if(zi_curs == null || zi_curs.trim().isEmpty()){
            throw new InvalidMidiDataException("Ziua cursului este Invalida");
        }

        if(data_examen == null || data_examen.trim().isEmpty()){
            throw new InvalidMidiDataException("Data examenului este Invalida");
        }

        if(ora_examen == null || ora_examen.trim().isEmpty()){
            throw new InvalidMidiDataException("Ora examenului este Invalida");
        }

        if(sala_examen == null || sala_examen.trim().isEmpty()){
            throw new InvalidMidiDataException("Sala examenului este Invalida");
        }

        Examen examen = new Examen(data_examen,ora_examen,sala_examen);
        Curs curs = new Curs(nume_curs,ora_curs,zi_curs,examen);
        Profesor profesor = new Profesor(prenume,nume,curs);
        profesorRepo.add(profesor);
    }
}
