package com.company.service;

import com.company.domain.Student;
import com.company.exceptions.InvalidDataException;
import com.company.persistance.StudentRepo;

import javax.sound.midi.InvalidMidiDataException;
import java.io.*;

public class StudentService implements GenericCSV<Student> {
    private StudentRepo studentRepo = new StudentRepo();

    public void printAllStudenti(){
        for(int i=0;i< studentRepo.getSize();i++)
            System.out.println(studentRepo.get(i));
    }

    public  void sortElevi(){
        for(int i = 0; i < studentRepo.getSize()-1; i++){
            for(int j = i+1; j < studentRepo.getSize(); j++)
            {
                Student studentTemp = new Student(null,null,null,null,null);
                if(studentRepo.get(i).getNume().compareTo(studentRepo.get(j).getNume()) > 0 )
                {
                    studentTemp = studentRepo.get(i);
                    studentRepo.update(i, studentRepo.get(j));
                    studentRepo.update(j, studentTemp);
                }
            }
        }
    }

    public void addStudent(Student student){
       studentRepo.add(student);
    }
    public void registerNewStudent(String prenume, String nume, String clasa, String grupa, String an ) throws InvalidDataException {
        if(prenume == null || prenume.trim().isEmpty()){
            throw new InvalidDataException("Prenume Invalid");

        }
        if(nume == null || nume.trim().isEmpty()) {
            throw new InvalidDataException("Nume Invalid");
        }

        if(clasa == null || clasa.trim().isEmpty()) {
            throw new InvalidDataException("Clasa Invalid");
        }

        if(grupa == null || grupa.trim().isEmpty()) {
            throw new InvalidDataException("Grupa Invalid");
        }

        if(an == null || an.trim().isEmpty()){
            throw new InvalidDataException("An invalid");
        }

        Student student = new Student(prenume, nume, clasa, grupa, an);
        studentRepo.add(student);

    }

    @Override
    public void read() throws IOException {
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("files/student.csv"));
            while((line = br.readLine()) != null){
                String[] values = line.split(",");
                Student student =new Student(values[0],values[1],values[2],values[3],values[4]);
                studentRepo.add(student);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }



    @Override
    public void write(Student student) throws IOException {
        try{
            FileWriter fw = new FileWriter("files/student.csv",true);
            fw.write("\n" + student.getPrenume() + "," + student.getNume() + "," + student.getGrupa() + "," + student.getClasa() + "," + student.getAn() + ",");
            fw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
