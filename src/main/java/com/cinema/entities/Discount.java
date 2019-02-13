package com.cinema.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DISCOUNTS")
public class Discount {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    @SequenceGenerator(name="seq", sequenceName="SEQ_DISCOUNT", allocationSize=1)
    private int id;
    @Column(name = "PERCENT_OF_DISCONT")
    private float percent;
    @Column(name = "DATE_OF_END")
    private Date endDate;
    @OneToMany(mappedBy = "discount" , cascade = CascadeType.REFRESH , fetch = FetchType.EAGER , orphanRemoval = true)
    private List<HoldersOfDiscount> holdersList ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float persent) {
        this.percent = persent;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<HoldersOfDiscount> getHoldersList() {
        return holdersList;
    }

    public void setHoldersList(List<HoldersOfDiscount> holdersList) {
        this.holdersList = holdersList;
    }
}