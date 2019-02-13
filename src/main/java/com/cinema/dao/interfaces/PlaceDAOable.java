package com.cinema.dao.interfaces;

import com.cinema.entities.CinemaHall;
import com.cinema.entities.Place;
import com.cinema.services.interfaces.Servicable;

public interface PlaceDAOable<T> extends DAOable<T> {
    Place findPlace(int row , int place , CinemaHall cinemaHall);
}
