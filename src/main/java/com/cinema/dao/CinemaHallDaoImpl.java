package com.cinema.dao;

import com.cinema.dao.interfaces.DAOable;
import com.cinema.entities.CinemaHall;
import com.cinema.services.interfaces.FunctionServicable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CinemaHallDaoImpl implements FunctionServicable<CinemaHall> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(CinemaHall element) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(element);
    }

    @Override
    public void update(CinemaHall element) {
        Session session = sessionFactory.getCurrentSession();
        session.update(element);
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        CinemaHall cinemaHall =  session.get(CinemaHall.class, id);
        if(cinemaHall!=null) session.delete(cinemaHall);
    }

    @Override
    public CinemaHall getElementById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(CinemaHall.class, id);
    }

    @Override
    public List<CinemaHall> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from CinemaHall ").list();
    }

    @Override
    public CinemaHall findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM CinemaHall where name = :paramName");
        query.setParameter("paramName", name);
        List<CinemaHall> list = query.list();
        CinemaHall cinemaHall = list.get(0);
        return cinemaHall;
    }
}
