package com.cinema.dao;


import com.cinema.dao.interfaces.DAOable;
import com.cinema.entities.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SessionDaoImpl implements DAOable<Session> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Session element) {
        org.hibernate.Session session = sessionFactory.getCurrentSession();
        session.persist(element);
    }

    @Override
    public void update(Session element) {
        org.hibernate.Session session = sessionFactory.getCurrentSession();
        session.update(element);
    }

    @Override
    public void delete(int id) {
        org.hibernate.Session delSession = sessionFactory.getCurrentSession();
        Session session =  delSession.get(Session.class, id);
        if(session!=null) delSession.delete(session);
    }

    @Override
    public Session getElementById(int id) {
        org.hibernate.Session getSession = sessionFactory.getCurrentSession();
        return getSession.get(Session.class, id);
    }

    @Override
    public List<Session> getAll() {
        org.hibernate.Session getAllSession = sessionFactory.getCurrentSession();
        return getAllSession.createQuery("from Session ").list();

    }
}
