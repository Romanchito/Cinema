package com.cinema.services;

import com.cinema.dao.SessionDaoImpl;
import com.cinema.entities.Session;
import com.cinema.services.interfaces.Servicable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SessionServiceImpl implements Servicable<Session> {

    @Autowired
    private SessionDaoImpl sessionDao;

    @Override
    @Transactional
    public void add(Session element) {
        sessionDao.add(element);
    }

    @Override
    @Transactional
    public void update(Session element) {
        sessionDao.update(element);
    }

    @Override
    @Transactional
    public void delete(int id) {
        sessionDao.delete(id);
    }

    @Override
    @Transactional
    public Session getElementById(int id) {
        return sessionDao.getElementById(id);
    }

    @Override
    @Transactional
    public List<Session> getAll() {
        return sessionDao.getAll();
    }
}
