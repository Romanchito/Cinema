package com.cinema.services.interfaces;

import com.cinema.entities.CinemaHall;
import com.cinema.entities.Place;

public interface PlaceServicable<T> extends Servicable<T> {
    Place findPlace(int row, int place, CinemaHall cinemaHall);
}
