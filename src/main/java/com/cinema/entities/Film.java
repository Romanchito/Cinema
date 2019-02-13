package com.cinema.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "FILMS")
public class Film {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    @SequenceGenerator(name="seq", sequenceName="SEQ_DISCOUNT", allocationSize=1)
    private int id;
    private String name;
    private String description;
    private int duration;
    @Column(name = "AGE_CATEGORY")
    private int age_category;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IMAGE_ID")
    private Images image;
    @OneToMany(mappedBy = "film" , cascade = CascadeType.REFRESH , fetch = FetchType.EAGER , orphanRemoval = true)
    private Set<Session> sessionList ;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getAge_category() {
        return age_category;
    }

    public void setAge_category(int age_category) {
        this.age_category = age_category;
    }

    public Set<Session> getSessionList() {
        return sessionList;
    }

    public void setSessionList(Set<Session> sessionList) {
        this.sessionList = sessionList;
    }

    public Images getImage() {
        return image;
    }

    public void setImage(Images image) {
        this.image = image;
    }
}
