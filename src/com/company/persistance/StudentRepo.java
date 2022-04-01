package com.company.persistance;

import com.company.domain.Student;

import java.util.ArrayList;

public class StudentRepo implements GenericRepo<Student> {
    private ArrayList<Student> elevi = new ArrayList<>();

    @Override
    public void add(Student entity) {
        elevi.add(entity);
    }

    @Override
    public Student get(int id) {
        return elevi.get(id);
    }


    @Override
    public void update(int index, Student entity) {
        elevi.set(index, entity);
    }

    @Override
    public void delete(int index) {
        elevi.remove(index);
    }

    @Override
    public int getSize() {
        return elevi.size();
    }
}
