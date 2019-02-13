package com.cinema.services;


import com.cinema.dao.CinemaHallDaoImpl;
import com.cinema.entities.CinemaHall;
import com.cinema.services.interfaces.FunctionServicable;
import com.cinema.services.interfaces.Servicable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CinemaHallServiceImpl implements FunctionServicable<CinemaHall> {

    @Autowired
    private CinemaHallDaoImpl dao;

    @Override
    @Transactional
    public void add(CinemaHall element) {
        dao.add(element);
    }

    @Override
    @Transactional
    public void update(CinemaHall element) {
        dao.update(element);
    }

    @Override
    @Transactional
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    @Transactional
    public CinemaHall getElementById(int id) {
        return dao.getElementById(id);
    }

    @Override
    @Transactional
    public List<CinemaHall> getAll() {
        return dao.getAll();
    }

    @Override
    @Transactional
    public CinemaHall findByName(String name) {
        return dao.findByName(name);
    }
}

