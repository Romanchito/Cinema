package com.cinema.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "CINEMA_HALLS")
public class CinemaHall {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    @SequenceGenerator(name="seq", sequenceName="SEQ_DISCOUNT", allocationSize=1)
    private int id;
    private String name;
    @Column(name = "COUNT_OF_PLACES")
    private int countOfPlaces;
    @Column(name = "COUNT_OF_ROWS")
    private int countOfRows;
    @OneToMany(mappedBy = "cinemaHall" , cascade = CascadeType.REFRESH , fetch = FetchType.LAZY , orphanRemoval = true)
    private List<Place> plaesList ;
    @OneToMany(mappedBy = "cinemaHall" , cascade = CascadeType.REFRESH , fetch = FetchType.LAZY , orphanRemoval = true)
    private List<Session> sessionList ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountOfPlaces() {
        return countOfPlaces;
    }

    public void setCountOfPlaces(int countOfPlaces) {
        this.countOfPlaces = countOfPlaces;
    }

    public int getCountOfRows() {
        return countOfRows;
    }

    public void setCountOfRows(int countOfRows) {
        this.countOfRows = countOfRows;
    }

    public List<Place> getPlaesList() {
        return plaesList;
    }

    public void setPlaesList(List<Place> plaesList) {
        this.plaesList = plaesList;
    }

    public List<Session> getSessionList() {
        return sessionList;
    }

    public void setSessionList(List<Session> sessionList) {
        this.sessionList = sessionList;
    }
}

