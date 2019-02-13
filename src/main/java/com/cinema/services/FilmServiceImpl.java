package com.cinema.services;

import com.cinema.dao.FilmDaoImpl;
import com.cinema.entities.Film;
import com.cinema.services.interfaces.FunctionServicable;
import com.cinema.services.interfaces.Servicable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FilmServiceImpl implements FunctionServicable<Film> {

    @Autowired
    private FilmDaoImpl dao;

    @Override
    @Transactional
    public void add(Film element) {
        dao.add(element);
    }

    @Override
    @Transactional
    public void update(Film element) {
        dao.update(element);
    }

    @Override
    @Transactional
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    @Transactional
    public Film getElementById(int id) {
        return dao.getElementById(id);
    }

    @Override
    @Transactional
    public List<Film> getAll() {
        return dao.getAll();
    }

    @Override
    @Transactional
    public Film findByName(String name) {
        return dao.findByName(name);
    }
}
