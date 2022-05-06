package com.company.service;

import com.company.domain.Curs;
import com.company.domain.Examen;
import com.company.persistance.ExamenRepo;
import com.company.persistance.StudentRepo;

import java.io.*;

public class ExamenService implements GenericCSV<Examen>{
    ExamenRepo examenRepo = new ExamenRepo();
    @Override
    public void read() throws IOException {
        String line = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader("files/examen.csv"));
            while((line = br.readLine()) != null){
                String[] values = line.split(",");
                Examen examen = new Examen(values[3],values[4],values[5]);
                examenRepo.add(examen);

            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void write(Examen examen) throws IOException {
        try{
            FileWriter fw = new FileWriter("files/examen.csv",true);
            fw.write("\n" + examen.getData_examen() + "," + examen.getOra_examen() + "," + examen.getSala() + ",");
            fw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
