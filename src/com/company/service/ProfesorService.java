package com.company.service;

import com.company.domain.Curs;
import com.company.domain.Examen;
import com.company.domain.Profesor;
import com.company.domain.Student;
import com.company.persistance.ProfesorRepo;

import javax.sound.midi.InvalidMidiDataException;
import java.io.*;
import java.util.Vector;

public class ProfesorService implements GenericCSV<Profesor>{

    private ProfesorRepo profesorRepo =new ProfesorRepo();
    private static final ProfesorService instance = new ProfesorService();
    public static ProfesorService getInstance(){
        return instance;
    }



    public void addProfesor(Profesor profesor){
            profesorRepo.add(profesor);
    }
    public void printAllProf(){
        for(int i=0;i< profesorRepo.getSize();i++)
            System.out.println(profesorRepo.get(i));
    }
    public  void sortProfesori(){
        for(int i = 0; i < profesorRepo.getSize()-1; i++){
            for(int j = i+1; j < profesorRepo.getSize(); j++)
            {
                Profesor studentTemp = new Profesor(null,null,null);
                if(profesorRepo.get(i).getNume().compareTo(profesorRepo.get(j).getNume()) > 0 )
                {
                    studentTemp = profesorRepo.get(i);
                    profesorRepo.update(i, profesorRepo.get(j));
                    profesorRepo.update(j, studentTemp);
                }
            }
        }
    }

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



    @Override
    public void read() throws IOException {
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("files/profesor.csv"));
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Examen examen = new Examen(values[5], values[6], values[7]);
                Curs curs = new Curs(values[2], values[3], values[4], examen);
                Profesor profesor = new Profesor(values[0], values[1], curs);
                profesorRepo.add(profesor);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public void write(Profesor profesor) throws IOException {
        try{
        FileWriter fw = new FileWriter("files/profesor.csv",true);
        fw.write( "\n"+ profesor.getPrenume() + ',' + profesor.getNume() + ',' + profesor.getCurs().getNume() + ','
                + profesor.getCurs().getOra() + ',' + profesor.getCurs().getZi() + ',' + profesor.getCurs().getExamen().getData_examen()
                + ',' +profesor.getCurs().getExamen().getOra_examen() + ','
                + profesor.getCurs().getExamen().getSala() + ',');
        fw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
