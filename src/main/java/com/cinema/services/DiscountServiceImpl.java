package com.cinema.services;

import com.cinema.dao.DiscountDaoImpl;
import com.cinema.entities.Discount;
import com.cinema.services.interfaces.Servicable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DiscountServiceImpl implements Servicable<Discount> {

    @Autowired
    private DiscountDaoImpl dao;

    @Override
    @Transactional
    public void add(Discount element) {
        dao.add(element);
    }

    @Override
    @Transactional
    public void update(Discount element) {
        dao.update(element);
    }

    @Override
    @Transactional
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    @Transactional
    public Discount getElementById(int id) {
        return dao.getElementById(id);
    }

    @Override
    @Transactional
    public List<Discount> getAll() {
        return dao.getAll();
    }
}
