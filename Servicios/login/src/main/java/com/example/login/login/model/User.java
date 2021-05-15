package com.example.login.login.model;

import javax.persistence.*;

@Entity
@Table(name = "usertb", schema = "cruddish")
public class User {

    @Id
    @Column(name = "iduser")
    private int idUser;

    @Column(name = "name", length = 45, nullable = false)
    private String name;

    @Column(name = "firstname", length = 45, nullable = false)
    private String firstName;

    @Column(name = "lastname", length = 45, nullable = false)
    private String lastName;

    @Column(name = "email", length = 45, nullable = false)
    private String email;

    @Column(name = "password", length = 45, nullable = false)
    private String password;

    @Column(name = "leader")
    private int leader;

    @Column(name = "username", length = 45, nullable = false)
    private String userName;

    @Column(name = "activo")
    private int activo;

    public User() {
    }

    public User(String userName, String password) {

        this.userName = userName;
        this.password = password;
    }

    public User(int idUser, String name, String firstName, String lastName, String email, String password, int leader, String userName, int activo) {
        this.idUser = idUser;
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.leader = leader;
        this.userName = userName;
        this.activo = activo;
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int isActivo() {
        return activo;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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


    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", pass='" + password + '\'' +
                ", leader=" + leader +
                ", userName='" + userName + '\'' +
                ", activo=" + activo +
                '}';
    }
}
