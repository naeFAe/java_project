package com.company.service;

import com.company.domain.Student;
import com.company.persistance.StudentRepo;

import javax.sound.midi.InvalidMidiDataException;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private StudentRepo studentRepo = new StudentRepo();

    public void registerNewStudent(String prenume, String nume,String clasa, String grupa, int an ) throws InvalidMidiDataException {
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

        if(an<1) {
            throw new InvalidMidiDataException("An invalid");
        }

        Student student = new Student(prenume, nume, clasa, grupa, an);
        studentRepo.add(student);

    }
    public Student[] getStudentiAn(int an){
        List<Student> result = new ArrayList<>();
        for(int i=0;i< studentRepo.getSize();i++){
            if(studentRepo.get(i) != null && studentRepo.get(i).getAn() == an){
                result.add(studentRepo.get(i));
            }
        }
        return  result.toArray(new Student[0]);
    }
}
