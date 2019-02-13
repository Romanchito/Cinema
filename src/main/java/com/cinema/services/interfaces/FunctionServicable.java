package com.cinema.services.interfaces;

import com.cinema.entities.User;

public interface FunctionServicable<T> extends Servicable<T> {

    T findByName(String name);

}
