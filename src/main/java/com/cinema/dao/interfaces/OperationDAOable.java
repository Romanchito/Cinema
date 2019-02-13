package com.cinema.dao.interfaces;
import com.cinema.entities.Session;

public interface OperationDAOable<T> extends DAOable<T> {

    boolean checkOrder(int row , int place , Session session);

}
