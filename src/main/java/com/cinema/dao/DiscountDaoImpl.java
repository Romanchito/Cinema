package com.cinema.dao;

import com.cinema.dao.interfaces.DAOable;
import com.cinema.entities.Discount;
import com.cinema.services.UserDetailsServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class DiscountDaoImpl implements DAOable<Discount> {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Discount element) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(element);
    }

    @Override
    public void update(Discount element) {
        Session session = sessionFactory.getCurrentSession();
        session.update(element);
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Discount discount =  session.get(Discount.class, id);
        if(discount!=null) session.delete(discount);
    }

    @Override
    public Discount getElementById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Discount.class, id);
    }

    @Override
    public List<Discount> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Discount ").list();
    }
}
