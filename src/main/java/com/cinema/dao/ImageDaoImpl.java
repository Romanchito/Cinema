package com.cinema.dao;

import com.cinema.dao.interfaces.DAOable;
import com.cinema.entities.Images;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ImageDaoImpl implements DAOable<Images> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Images element) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(element);
    }

    @Override
    public void update(Images element) {
        Session session = sessionFactory.getCurrentSession();
        session.update(element);
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Images image =  session.get(Images.class, id);
        if(image!=null) session.delete(image);
    }

    @Override
    public Images getElementById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Images.class, id);
    }

    @Override
    public List<Images> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Images ").list();
    }
}
