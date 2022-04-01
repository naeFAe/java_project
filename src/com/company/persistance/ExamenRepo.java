package com.company.persistance;
import com.company.domain.Examen;

import java.util.ArrayList;

public class ExamenRepo implements GenericRepo<Examen> {
    private ArrayList<Examen> examen = new ArrayList<>();

    @Override
    public void add(Examen entity) {
        examen.add(entity);
    }

    @Override
    public Examen get(int id) {
        return examen.get(id);
    }

    @Override
    public void update(int index, Examen entity) {
        examen.set(index, entity);
    }

    @Override
    public void delete(int index) {
        examen.remove(index);
    }

    @Override
    public int getSize() {
        return examen.size();
    }
}
