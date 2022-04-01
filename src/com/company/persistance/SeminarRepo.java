package com.company.persistance;
import com.company.domain.Seminar;

import java.util.ArrayList;

public class SeminarRepo implements GenericRepo<Seminar>{
    private ArrayList<Seminar> seminar = new ArrayList<>();

    @Override
    public void add(Seminar entity) {
        seminar.add(entity);
    }

    @Override
    public Seminar get(int id) {
        return seminar.get(id);
    }

    @Override
    public void update(int index, Seminar entity) {
        seminar.set(index, entity);
    }

    @Override
    public void delete(int index) {
        seminar.remove(index);
    }

    @Override
    public int getSize() {
        return seminar.size();
    }
}
