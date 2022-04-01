package com.company.persistance;
import com.company.domain.Curs;

import java.util.ArrayList;

public class CursRepo implements GenericRepo<Curs>{
    private ArrayList<Curs> curs =new ArrayList<>();

    @Override
    public void add(Curs entity) {
        curs.add(entity);
    }

    @Override
    public Curs get(int id) {
        return curs.get(id);
    }

    @Override
    public void update(int index, Curs entity) {
        curs.set(index, entity);
    }

    @Override
    public void delete(int index) {
        curs.remove(index);
    }

    @Override
    public int getSize() {
        return curs.size();
    }
}
