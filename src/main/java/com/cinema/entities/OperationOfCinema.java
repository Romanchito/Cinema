package com.cinema.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "OPERATIONS_OF_CINEMA")
public class OperationOfCinema {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq")
    @SequenceGenerator(name="seq", sequenceName="SEQ_DISCOUNT", allocationSize=1)
    private int id;
    private String status;
    @Column(name = "DATE_OF_OPERATION")
    private Date date;
    @Column(name = "SPECIAL_CODE")
    private String code;
    @Column(name = "ROW_NUMBER")
    private int row;
    @Column(name = "PLACE_NUMBER")
    private int place;
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "SESSION_ID")
    private Session session;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CASHIER_ID")
    private User cashier;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "BUYER_ID")
    private User buyer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public User getCashier() {
        return cashier;
    }

    public void setCashier(User cashier) {
        this.cashier = cashier;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }
}

