package com.cinema.dao.interfaces;

import java.util.List;

public interface DAOable<T> {
    public void add(T element);
    public void update(T element);
    public void delete(int id);
    public T getElementById(int id);
    public List<T> getAll();
}
