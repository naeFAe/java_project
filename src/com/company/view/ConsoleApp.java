package com.company.view;

import com.company.service.*;
import com.company.domain.*;

import javax.sound.midi.InvalidMidiDataException;
import java.io.IOException;
import java.util.Scanner;
public class ConsoleApp {

    private Scanner s = new Scanner(System.in);
    private ProfesorService profesorService = ProfesorService.getInstance();
    private StudentService studentService = new StudentService();

    private CursService cursService =new CursService();
    private ExamenService examenService = new ExamenService();

    private Audit audit = new Audit();

    private void loadCSVfiles() {
        //profesor
        try {
            profesorService.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //student
        try {
            studentService.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //curs
        try {
            cursService.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //examen
        try {
            examenService.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String args[]) {
        ConsoleApp app = new ConsoleApp();
        app.loadCSVfiles();
        while (true) {
            app.showMenu();
            int option;
            option = app.readOption();
            app.execute(option);
        }
    }

    private int readOption(){
        int option = readInt();
        if (option >= 1 && option <= 9)
            return option;

        System.out.println("Invalid option. Try again");
        return readOption();
    }

    private void showMenu(){
        System.out.println("\n -------------MENiU-------------");
        System.out.println("What do u want to do ?");
        System.out.println("1. adauga student");
        System.out.println("2. adauga profesor");
        System.out.println("3. ordoneaza crescator studentii");
        System.out.println("4. ordoneaza crescator profesorii");
        System.out.println("5. afiseaza toti stidentii ");
        System.out.println("6. afiseaza toti profesorii");
        System.out.println("7.adauga curs");
        System.out.println("8.afiseaza toate cursurile");
        System.out.println("9. exit");
    }

    private int readInt() {
        String line = s.nextLine();
        return Integer.parseInt(line);
    }
    private void execute(int option){
        switch (option){
            case 1:
                try {
                    studentService.write(readStudent());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                audit.add("adaugat student");
                break;
            case 2:
                try {
                    profesorService.write(readProfesor());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                audit.add("adaugat profesor");
                break;
            case 3:
                studentService.sortElevi();
                audit.add("sortat studenti");
                break;
            case 4:
                profesorService.sortProfesori();
                audit.add("sortat profesori");
                break;
            case 5:
                studentService.printAllStudenti();
                audit.add("afisat studenti");
                break;
            case 6:
                profesorService.printAllProf();
                audit.add("afisat profesori");
                break;
            case 7:
                try {
                    cursService.write(readCurs());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                audit.add("adaugat curs");
                break;
            case 8:
                cursService.printAllCurs();
                audit.add("afisat cursuri");
            case 9:
                audit.add("exit");
                System.exit(0);
        }
    }

    Student readStudent(){
        System.out.println("Prenume: ");
        String firstName = s.nextLine();
        System.out.println("Nume: ");
        String lastName = s.nextLine();
        System.out.println("Clasa: ");
        String clasa = s.nextLine();
        System.out.println("Grupa: ");
        String group = s.nextLine();
        System.out.println("An: ");
        String an =s.nextLine();
        Student student = new Student(firstName,lastName,clasa,group,an);
        try {
            studentService.registerNewStudent(firstName,lastName,clasa,group,an);
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
        return student;
    }
    Profesor readProfesor(){
        System.out.println("Prenume: ");
        String firstName = s.nextLine();
        System.out.println("Nume: ");
        String lastName = s.nextLine();
        System.out.println("Nume curs: ");
        String nume_curs = s.nextLine();
        System.out.println("Ora curs: ");
        String ora_curs = s.nextLine();
        System.out.println("Zi curs: ");
        String zi_curs = s.nextLine();
        System.out.println("Data examen: ");
        String data_examen = s.nextLine();
        System.out.println("Ora examen: ");
        String ora_examen = s.nextLine();
        System.out.println("Sala: ");
        String sala = s.nextLine();

        Examen examen = new Examen(data_examen,ora_examen,sala);
        Curs curs = new Curs(nume_curs,ora_curs,zi_curs,examen);
        Profesor profesor = new Profesor(firstName,lastName,curs);
        try {
            profesorService.registerNewProfesor(firstName,lastName,nume_curs,ora_curs,zi_curs,data_examen,ora_examen,sala);
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
        return profesor;
    }

    Curs readCurs(){
        System.out.println("Nume curs: ");
        String nume = s.nextLine();
        System.out.println("Ora curs: ");
        String ora_curs = s.nextLine();
        System.out.println("Ziua cursului: ");
        String ziua_curs = s.nextLine();
        System.out.println("Data examen: ");
        String data_examen = s.nextLine();
        System.out.println("Ora examen: ");
        String ora_examen = s.nextLine();
        System.out.println("Sala : ");
        String sala = s.nextLine();

        Examen examen = new Examen(data_examen,ora_examen,sala);
        Curs curs = new Curs(nume,ora_curs,ziua_curs,examen);
        try{
            cursService.registerNewCurs(nume,ora_curs,ziua_curs,data_examen,ora_examen,sala);
        }catch (InvalidMidiDataException e){
            e.printStackTrace();
        }
        return curs;
    }



}
