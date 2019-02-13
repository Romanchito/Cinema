package com.cinema.services;


import com.cinema.dao.UserDaoImpl;
import com.cinema.entities.User;
import com.cinema.services.interfaces.FunctionServicable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements FunctionServicable<User> {

    @Autowired
    private UserDaoImpl userDao;


    @Override
    @Transactional
    public void add(User element) {
        userDao.add(element);
    }

    @Override
    @Transactional
    public void update(User element) {
        userDao.update(element);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    @Transactional
    public User getElementById(int id) {
        return userDao.getElementById(id);
    }

    @Override
    @Transactional
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Transactional
    @Override
    public User findByName(String name) {
        return userDao.findByName(name);
    }
}
