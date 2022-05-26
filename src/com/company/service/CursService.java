package com.company.service;

import com.company.domain.Curs;
import com.company.domain.Examen;
import com.company.domain.Student;
import com.company.exceptions.InvalidDataException;
import com.company.persistance.CursRepo;

import javax.sound.midi.InvalidMidiDataException;
import java.io.*;

public class CursService implements GenericCSV<Curs>{
    private CursRepo cursRepo = new CursRepo();

    public void registerNewCurs(String nume, String ora, String zi, String data_examen,String ora_examen,String sala_examen) throws InvalidDataException {

        if(nume == null || nume.trim().isEmpty()) {
            throw new InvalidDataException("Nume Invalid");
        }

        if(ora == null || ora.trim().isEmpty()) {
            throw new InvalidDataException("Ora Invalid");
        }

        if(zi == null || zi.trim().isEmpty()) {
            throw new InvalidDataException("Zi Invalid");
        }
        if(data_examen == null || data_examen.trim().isEmpty()) {
            throw new InvalidDataException("Data examen Invalid");
        }
        if(ora_examen == null || ora_examen.trim().isEmpty()) {
            throw new InvalidDataException("Ora examen Invalid");
        }
        if(sala_examen == null || sala_examen.trim().isEmpty()) {
            throw new InvalidDataException("Sala examen Invalid");
        }
        Examen examen = new Examen(data_examen,ora_examen,sala_examen);
        Curs curs = new Curs(nume,ora,zi,examen);
        cursRepo.add(curs);

    }
    @Override
    public void read() throws IOException {
        String line = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader("files/curs.csv"));
            while((line = br.readLine()) != null){
                String[] values = line.split(",");
                Examen examen = new Examen(values[3],values[4],values[5]);
                Curs curs = new Curs(values[0],values[1],values[2],examen);
                cursRepo.add(curs);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @Override
    public void write(Curs curs) throws IOException {
        try{
            FileWriter fw = new FileWriter("files/curs.csv",true);
            fw.write("\n" + curs.getNume() + "," + curs.getOra() + "," + curs.getZi()
                    + "," +curs.getExamen().getData_examen() + "," + curs.getExamen().getOra_examen()
                    + "," + curs.getExamen().getSala() + ",");
            fw.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void printAllCurs(){
        for(int i=0;i< cursRepo.getSize();i++)
            System.out.println(cursRepo.get(i));
    }
}
