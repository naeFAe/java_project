package com.company.service;

import com.company.domain.Curs;
import com.company.domain.Examen;
import com.company.domain.Profesor;
import com.company.domain.Seminar;
import com.company.persistance.SeminarRepo;

import javax.sound.midi.InvalidMidiDataException;
import java.io.*;

public class SeminarService implements GenericCSV<Seminar>{
    private SeminarRepo seminarRepo =new SeminarRepo();
    public void registerNewSeminar(String nume, String ora, String zi, String data_examen,String ora_examen,String sala_examen,String pondere) throws InvalidMidiDataException {

        if(nume == null || nume.trim().isEmpty()) {
            throw new InvalidMidiDataException("Nume Invalid");
        }

        if(ora == null || ora.trim().isEmpty()) {
            throw new InvalidMidiDataException("Ora Invalid");
        }

        if(zi == null || zi.trim().isEmpty()) {
            throw new InvalidMidiDataException("Zi Invalid");
        }
        if(data_examen == null || data_examen.trim().isEmpty()) {
            throw new InvalidMidiDataException("Data examen Invalid");
        }
        if(ora_examen == null || ora_examen.trim().isEmpty()) {
            throw new InvalidMidiDataException("Ora examen Invalid");
        }
        if(sala_examen == null || sala_examen.trim().isEmpty()) {
            throw new InvalidMidiDataException("Sala examen Invalid");
        }
        if(pondere == null || pondere.trim().isEmpty()) {
            throw new InvalidMidiDataException("Pondere Invalid");
        }
        Examen colocviu = new Examen(data_examen,ora_examen,sala_examen);
        Seminar seminar =new Seminar(nume,ora,zi,colocviu,pondere);
        seminarRepo.add(seminar);

    }
    @Override
    public void read() throws IOException {
        String line = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader("files/seminar.csv"));
            while((line = br.readLine()) != null){
                String[] values = line.split(",");
                Examen examen =new Examen(values[3],values[4],values[5]);
                Seminar seminar =new Seminar(values[0],values[1],values[2],examen,values[6]);
                seminarRepo.add(seminar);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void write(Seminar seminar) throws IOException {
        try{
            FileWriter fw = new FileWriter("files/seminar.csv",true);
            fw.write("\n" + seminar.getNume() + "," + seminar.getOra() + ","
                    + seminar.getZi() + "," + seminar.getExamen().getData_examen()
                    + "," + seminar.getExamen().getOra_examen() + ","
                    + seminar.getExamen().getSala() + "," + seminar.getPondere());
            fw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void printAllSeminar(){
        for(int i=0;i< seminarRepo.getSize();i++)
            System.out.println(seminarRepo.get(i));
    }
}
