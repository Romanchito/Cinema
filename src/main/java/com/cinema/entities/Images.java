package com.cinema.entities;


import javax.persistence.*;
import java.util.List;

@Entity
public class Images {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq")
    @SequenceGenerator(name="seq", sequenceName="SEQ_DISCOUNT", allocationSize=1)
    private int id;
    private String path;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


}
