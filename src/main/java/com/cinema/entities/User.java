package com.cinema.entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS_OF_CINEMA")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq")
    @SequenceGenerator(name="seq", sequenceName="SEQ_DISCOUNT", allocationSize=1)
    private int id;
    private String email;
    private String password;
    private String name;
    private String surname;
    private String patronymic;
    @Column (name = "USER_TYPE")
    private String role;
    @OneToMany(mappedBy = "user" , cascade = CascadeType.REFRESH , fetch = FetchType.LAZY , orphanRemoval = true)
    private List<HoldersOfDiscount> holdersList ;
    @OneToMany(mappedBy = "cashier" , cascade = CascadeType.REFRESH , fetch = FetchType.LAZY , orphanRemoval = true)
    private List<OperationOfCinema> cahierList ;
    @OneToMany(mappedBy = "buyer" , cascade = CascadeType.REFRESH , fetch = FetchType.LAZY , orphanRemoval = true)
    private List<OperationOfCinema> buyerList ;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public List<HoldersOfDiscount> getHoldersList() {
        return holdersList;
    }

    public void setHoldersList(List<HoldersOfDiscount> holdersList) {
        this.holdersList = holdersList;
    }

    public void clean(){
        holdersList.clear();
    }

    public List<OperationOfCinema> getCahierList() {
        return cahierList;
    }

    public void setCahierList(List<OperationOfCinema> cahierList) {
        this.cahierList = cahierList;
    }

    public List<OperationOfCinema> getBuyerList() {
        return buyerList;
    }

    public void setBuyerList(List<OperationOfCinema> buyerList) {
        this.buyerList = buyerList;
    }
}
