package com.cinema.services;

import com.cinema.dao.ImageDaoImpl;
import com.cinema.entities.Images;
import com.cinema.services.interfaces.Servicable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImageServiceImpl implements Servicable<Images> {

    @Autowired
    private ImageDaoImpl dao;

    @Override
    @Transactional
    public void add(Images element) {
        dao.add(element);
    }

    @Override
    @Transactional
    public void update(Images element) {
        dao.update(element);
    }

    @Override
    @Transactional
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    @Transactional
    public Images getElementById(int id) {
        return dao.getElementById(id);
    }

    @Override
    @Transactional
    public List<Images> getAll() {
        return dao.getAll();
    }
}
