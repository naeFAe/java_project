package com.company.service;

import com.company.domain.Student;
import com.company.persistance.StudentRepo;

import javax.sound.midi.InvalidMidiDataException;

public class StudentService {
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
    public void registerNewStudent(String prenume, String nume, String clasa, String grupa, String an ) throws InvalidMidiDataException {
        if(prenume == null || prenume.trim().isEmpty()){
            throw new InvalidMidiDataException("Prenume Invalid");

        }
        if(nume == null || nume.trim().isEmpty()) {
            throw new InvalidMidiDataException("Nume Invalid");
        }

        if(clasa == null || clasa.trim().isEmpty()) {
            throw new InvalidMidiDataException("Clasa Invalid");
        }

        if(grupa == null || grupa.trim().isEmpty()) {
            throw new InvalidMidiDataException("Grupa Invalid");
        }

        Student student = new Student(prenume, nume, clasa, grupa, an);
        studentRepo.add(student);

    }




}
