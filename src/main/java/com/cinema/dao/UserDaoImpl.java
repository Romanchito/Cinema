package com.cinema.dao;


import com.cinema.dao.interfaces.FunctionDAOable;
import com.cinema.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDaoImpl implements FunctionDAOable<User> {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void add(User element) {
        Session session = sessionFactory.getCurrentSession();
        element.setPassword(bCryptPasswordEncoder.encode(element.getPassword()));
        session.persist(element);
    }

    @Override
    public void update(User element) {
        Session session = sessionFactory.getCurrentSession();
        element.setPassword(bCryptPasswordEncoder.encode(element.getPassword()));
        session.update(element);
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user =  session.get(User.class, id);
        if(user!=null) session.delete(user);
    }

    @Override
    public User getElementById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    @Override
    public List<User> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<User> users = session.createQuery("from User ").list();
        return users;
    }

    @Override

    public User findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM User where name = :paramName");
        query.setParameter("paramName", name);
        List<User> list = query.list();
        User user = list.get(0);
        return user;
    }
}
