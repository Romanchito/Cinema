package com.cinema.dao;

import com.cinema.entities.HoldersOfDiscount;
import com.cinema.services.interfaces.Servicable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HoldersOfDiscountDaoImpl implements Servicable<HoldersOfDiscount> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(HoldersOfDiscount element) {
        Session session = sessionFactory.getCurrentSession();
        session.save(element);
    }

    @Override
    public void update(HoldersOfDiscount element) {
        Session session = sessionFactory.getCurrentSession();
        session.update(element);
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        HoldersOfDiscount holder =  session.get(HoldersOfDiscount.class, id);
        if(holder!=null) session.delete(holder);
    }

    @Override
    public HoldersOfDiscount getElementById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(HoldersOfDiscount.class, id);
    }

    @Override
    public List<HoldersOfDiscount> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<HoldersOfDiscount> holders = session.createQuery("from HoldersOfDiscount ").list();
        return holders;
    }
}
