package com.cinema.services;

import com.cinema.dao.PlaceDaoImpl;
import com.cinema.entities.CinemaHall;
import com.cinema.entities.Place;
import com.cinema.services.interfaces.PlaceServicable;
import com.cinema.services.interfaces.Servicable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceServicable<Place> {

    @Autowired
    private PlaceDaoImpl dao;

    @Override
    @Transactional
    public void add(Place element) {
        dao.add(element);
    }

    @Override
    @Transactional
    public void update(Place element) {
        dao.update(element);
    }

    @Override
    @Transactional
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    @Transactional
    public Place getElementById(int id) {
        return dao.getElementById(id);
    }

    @Override
    @Transactional
    public List<Place> getAll() {
        return dao.getAll();
    }


    @Override
    @Transactional
    public Place findPlace(int row, int number, CinemaHall cinemaHall) {
        return dao.findPlace(row, number, cinemaHall);
    }
}
