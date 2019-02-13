package com.cinema.dao.interfaces;

import com.cinema.dao.interfaces.DAOable;
import com.cinema.entities.User;

public interface FunctionDAOable<T> extends DAOable<T> {

    T findByName(String name);
}
