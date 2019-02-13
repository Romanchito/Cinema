package com.cinema.entities;


import javax.persistence.*;

@Entity
@Table(name = "HOLDERS_OF_DISCOUNTS")
public class HoldersOfDiscount {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    @SequenceGenerator(name="seq", sequenceName="SEQ_DISCOUNT", allocationSize=1)
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_OF_DISCOUNT")
    private Discount discount;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_OF_USER")
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}
