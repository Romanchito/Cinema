package com.cinema.services;

import com.cinema.dao.HoldersOfDiscountDaoImpl;
import com.cinema.entities.HoldersOfDiscount;
import com.cinema.services.interfaces.Servicable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HoldersOfDiscountsServiceImpl implements Servicable<HoldersOfDiscount> {

    @Autowired
    private HoldersOfDiscountDaoImpl dao;

    @Override
    @Transactional
    public void add(HoldersOfDiscount element) {
        dao.add(element);
    }

    @Override
    @Transactional
    public void update(HoldersOfDiscount element) {
        dao.update(element);
    }

    @Override
    @Transactional
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    @Transactional
    public HoldersOfDiscount getElementById(int id) {
        return dao.getElementById(id);
    }

    @Override
    @Transactional
    public List<HoldersOfDiscount> getAll() {
        return dao.getAll();
    }
}
