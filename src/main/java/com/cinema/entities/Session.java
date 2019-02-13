package com.cinema.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "SESSIONS")
public class Session {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq")
    @SequenceGenerator(name="seq", sequenceName="SEQ_DISCOUNT", allocationSize=1)
    private int id;
    @Column(name = "DATE_OF_SESSION")
    private Date date;
    @Column(name = "COST_OF_SESSION")
    private int cost;
    @OneToMany(mappedBy = "session" , cascade = CascadeType.REFRESH , fetch = FetchType.EAGER , orphanRemoval = true)
    private List<OperationOfCinema> operationList ;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FILM_ID")
    private Film film;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CINEMA_HALL_ID")
    private CinemaHall cinemaHall;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public CinemaHall getHall() {
        return cinemaHall;
    }

    public void setHall(CinemaHall hall) {
        this.cinemaHall = hall;
    }

    public List<OperationOfCinema> getOperationList() {
        return operationList;
    }

    public void setOperationList(List<OperationOfCinema> operationList) {
        this.operationList = operationList;
    }

    public CinemaHall getCinemaHall() {
        return cinemaHall;
    }

    public void setCinemaHall(CinemaHall cinemaHall) {
        this.cinemaHall = cinemaHall;
    }
}
