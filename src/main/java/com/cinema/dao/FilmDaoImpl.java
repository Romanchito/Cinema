package com.cinema.dao;

import com.cinema.dao.interfaces.FunctionDAOable;
import com.cinema.entities.Film;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FilmDaoImpl implements FunctionDAOable<Film> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Film element) {
        Session session = sessionFactory.getCurrentSession();
        session.save(element);

    }
    @Override
    public void update(Film element) {
        Session session = sessionFactory.getCurrentSession();
        session.update(element);
    }
    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Film film =  session.get(Film.class, id);
        if(film!=null) session.delete(film);
    }
    @Override
    public Film getElementById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Film.class, id);
    }
    @Override
    public List<Film> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Film").list();
    }

    @Override
    public Film findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Film where name = :paramName");
        query.setParameter("paramName", name);
        List<Film> list = query.list();
        Film film = list.get(0);
        return film;
    }
}
