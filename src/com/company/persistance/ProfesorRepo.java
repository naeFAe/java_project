package com.company.persistance;

import com.company.domain.Profesor;


import java.util.ArrayList;


public class ProfesorRepo implements GenericRepo<Profesor>{
    private ArrayList <Profesor> profesor = new ArrayList<>();

    @Override
    public void add(Profesor entity) {
        profesor.add(entity);
    }

    @Override
    public Profesor get(int id) {
        return profesor.get(id);
    }

    @Override
    public void update(int index, Profesor entity) {
        profesor.set(index, entity);
    }

    @Override
    public void delete(int index) {
        profesor.remove(index);
    }

    @Override
    public int getSize() {
        return profesor.size();
    }
}
