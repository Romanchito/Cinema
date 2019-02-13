package com.cinema.services.interfaces;
import com.cinema.entities.Session;

public interface OperationServicable<T> extends Servicable<T> {

    boolean checkOrder(int row, int place, Session session);

}
