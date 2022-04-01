package com.company.persistance;


public interface GenericRepo<T> {
    public void add(T entity);

    public T get(int id);

    public void update(int index, T entity);

    public void delete(int index);

    public int getSize();
}
