package com.company.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.company.domain.*;

public class Service {

    public  void sortElevi(ArrayList<Student> elevi){
        for(int i = 0; i < elevi.size()-1; i++){
            for(int j = i+1; j < elevi.size(); j++)
            {
                Student studentTemp = new Student(null,null,null,null,0);
                if(elevi.get(i).getNume().compareTo(elevi.get(j).getNume()) > 0 )
                {
                    studentTemp = elevi.get(i);
                    elevi.set(i, elevi.get(j));
                    elevi.set(j, studentTemp);
                }
            }
        }
    }

    public  void sortProfesori(ArrayList<Profesor> profesor){
        for(int i = 0; i < profesor.size()-1; i++){
            for(int j = i+1; j < profesor.size(); j++)
            {
                Profesor studentTemp = new Profesor(null,null,null);
                if(profesor.get(i).getNume().compareTo(profesor.get(j).getNume()) > 0 )
                {
                    studentTemp = profesor.get(i);
                    profesor.set(i, profesor.get(j));
                    profesor.set(j, studentTemp);
                }
            }
        }
    }

    public  Student getStudent(ArrayList<Student> elevi){
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt(); // pozitia studentului din vector pe care vrem sa-l returnam
        return elevi.get(k);
    }
    public Profesor getProfesor(ArrayList<Profesor> profesor){
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt(); // pozitia studentului din vector pe care vrem sa-l returnam
        return profesor.get(k);
    }

    public void addStudent(Student student, ArrayList<Student> elevi)
    {
        elevi.add(student);
    }

    public void addProfesor(Profesor profesor, ArrayList<Profesor> profesor_){
        profesor_.add(profesor);
    }

    public void deleteStudent(Student student, ArrayList<Student> elevi){
        elevi.remove(student);
    }

    public void deleteProfesor(Profesor profesor_, ArrayList<Profesor> profesor){
        for(int i = 0; i < profesor.size(); i++)
        {
            if( profesor_ == profesor.get(i))
            {
                profesor.remove(i);
                break;
            }
        }
    }

}
