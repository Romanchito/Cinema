package com.cinema.entities;

import javax.persistence.*;

@Entity
@Table(name = "PLACES")
public class Place {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    @SequenceGenerator(name="seq", sequenceName="SEQ_DISCOUNT", allocationSize=1)
    private int id;
    @Column(name = "NUMBER_OF_PLACE")
    private int number;
    @Column(name = "ROW_OF_PLACE")
    private int row;
    private String status;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CINEMA_HALL_ID")
    private CinemaHall cinemaHall;

    public Place(){}
    public Place(int row , int number ,  String status ,CinemaHall cinemaHall){
        this.row = row;
        this.number = number;
        this.cinemaHall = cinemaHall;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public CinemaHall getCinemaHall() {
        return cinemaHall;
    }

    public void setCinemaHall(CinemaHall cinemaHall) {
        this.cinemaHall = cinemaHall;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
