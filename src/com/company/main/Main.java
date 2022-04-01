package com.company.main;

import com.company.domain.*;
import com.company.service.Service;

public class Main {
    public static void main(String args[]){
    Collection catalog = new Collection();
    Service service = new Service();
    service.addStudent(new Student("stefan","vlad","11 f","261",2),catalog.getElevi());
    service.addStudent(new Student("popa","nae","12 A","262",2),catalog.getElevi());
    Examen examen1 = new Examen("02.07.2022","18:00","203");
    Examen examen2 = new Examen("05.07.2022","13:00","204");
    Curs curs1 = new Curs("Algebra liniara","18:00","luni",examen1);
    Curs curs2 = new Curs("Baze de date","14:00","marti",examen2);
    Profesor profesor1 = new Profesor("Cocean","Popa",curs1);
    service.addProfesor(profesor1, catalog.getProfesor());
    service.addProfesor(new Profesor("Marcel","Ene",curs2), catalog.getProfesor());
    System.out.println(catalog.getElevi());
    service.sortElevi(catalog.getElevi());
    System.out.println(catalog.getElevi());
    System.out.println(catalog.getProfesor());
    service.sortProfesori(catalog.getProfesor());
    System.out.println(service.getProfesor(catalog.getProfesor()));
    System.out.println(service.getStudent(catalog.getElevi()));
    System.out.println(catalog.getProfesor());
//    catalog.deleteProfesor(profesor1);
    System.out.println(catalog.getProfesor());


    }
}
