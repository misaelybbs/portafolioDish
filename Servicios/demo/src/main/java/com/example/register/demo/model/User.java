package com.example.register.demo.model;

import javax.persistence.*;

@Entity
@Table(name="usertb", schema="cruddish")
public class User {

    @Id
    @Column(name="iduser")
    private int idUser;

    @Column(name="name", length=45, nullable=false)
    private String name;

    @Column(name="firstname", length=45, nullable=false)
    private String firstname;

    @Column(name="lastname", length=45, nullable=false)
    private String lastname;

    @Column(name="email", length=45, nullable=false)
    private String email;

    @Column(name="password", length=45, nullable=false)
    private String password;

    @Column(name="leader", length=45, nullable=false)
    private int leader;

    @Column(name="username", length=45, nullable=false)
    private String username;

    @Column(name="activo", length=45, nullable=false)
    private int activo;


    public User() {
    }

    public User(String userName, String password) {

        this.username = username;
        this.password = password;
    }

    public User(int idUser, String name, String firstname, String lastname, String email, String password, int leader, String username, int activo) {
        this.idUser = idUser;
        this.name = name;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.leader = leader;
        this.username = username;
        this.activo = activo;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public int getLeader() {
        return leader;
    }

    public void setLeader(int leader) {
        this.leader = leader;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", name='" + name + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", leader=" + leader +
                ", username='" + username + '\'' +
                ", activo=" + activo +
                '}';
    }

    public int isLeader() {
        return leader;
    }

    public int isActivo() {
        return activo;
    }
}