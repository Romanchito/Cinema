package com.cinema.dao;


import com.cinema.dao.interfaces.OperationDAOable;
import com.cinema.entities.OperationOfCinema;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OperationOfCinemaDaoImpl implements OperationDAOable<OperationOfCinema> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(OperationOfCinema element) {
        Session session = sessionFactory.getCurrentSession();
        session.save(element);
    }

    @Override
    public void update(OperationOfCinema element) {
        Session session = sessionFactory.getCurrentSession();
        session.update(element);
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        OperationOfCinema operation = session.get(OperationOfCinema.class , id);
        if(operation !=null) session.delete(operation);
    }

    @Override
    public OperationOfCinema getElementById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(OperationOfCinema.class , id);
    }

    @Override
    public List<OperationOfCinema> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from OperationOfCinema ").list();
    }

    @Override
    public boolean checkOrder(int row, int place, com.cinema.entities.Session session) {

        org.hibernate.Session ses = sessionFactory.getCurrentSession();
        Query query = ses.createQuery("FROM OperationOfCinema WHERE row = :paramRow AND place = :paramPlace " +
                "AND session = :paramSession");
        query.setParameter("paramRow", row);
        query.setParameter("paramPlace", place);
        query.setParameter("paramSession", session);
        List<OperationOfCinema> list = query.list();
        if(list.size() > 0){
            return false;
        }
        return true;
    }
}
