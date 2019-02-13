package com.cinema.dao;

import com.cinema.dao.interfaces.DAOable;
import com.cinema.dao.interfaces.PlaceDAOable;
import com.cinema.entities.CinemaHall;
import com.cinema.entities.Place;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlaceDaoImpl implements PlaceDAOable<Place> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Place element) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(element);
    }

    @Override
    public void update(Place element) {
        Session session = sessionFactory.getCurrentSession();
        session.update(element);
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Place place =  session.get(Place.class, id);
        if(place!=null) session.delete(place);
    }

    @Override
    public Place getElementById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Place.class, id);
    }

    @Override
    public List<Place> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Place ").list();
    }

    @Override
    public Place findPlace(int row, int number, CinemaHall cinemaHall) {
        org.hibernate.Session ses = sessionFactory.getCurrentSession();
        Query query = ses.createQuery("FROM Place WHERE row = :paramRow AND number = :paramNumber " +
                "AND cinemaHall = :paramCinimaHall");
        query.setParameter("paramRow", row);
        query.setParameter("paramNumber", number);
        query.setParameter("paramCinimaHall", cinemaHall);
        List<Place> list = query.list();
        return list.get(0);
    }
}
