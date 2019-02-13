package com.cinema.services;


import com.cinema.dao.OperationOfCinemaDaoImpl;
import com.cinema.entities.OperationOfCinema;
import com.cinema.entities.Session;
import com.cinema.services.interfaces.OperationServicable;
import com.cinema.services.interfaces.Servicable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class OperationOfCinemaServiceImpl implements OperationServicable<OperationOfCinema> {

    @Autowired
    private OperationOfCinemaDaoImpl operation;

    @Override
    @Transactional
    public void add(OperationOfCinema element) {
        operation.add(element);
    }

    @Override
    @Transactional
    public void update(OperationOfCinema element) {
        operation.update(element);
    }

    @Override
    @Transactional
    public void delete(int id) {
        operation.delete(id);
    }

    @Override
    @Transactional
    public OperationOfCinema getElementById(int id) {
        return operation.getElementById(id);
    }

    @Override
    @Transactional
    public List<OperationOfCinema> getAll() {
        return operation.getAll();
    }

    @Override
    @Transactional
    public boolean checkOrder(int row, int place, Session session) {
        return operation.checkOrder(row,place,session);
    }
}

