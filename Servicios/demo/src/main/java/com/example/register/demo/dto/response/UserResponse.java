package com.example.register.demo.dto.response;

import java.sql.Timestamp;

public class UserResponse {

    private int idUser;
    private String name;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private int leader;
    private String username;
    private int activo;
    private boolean registerStatus;
    private String registerMsg;
    Timestamp timestamp;

    public UserResponse() {
    }

    public UserResponse(int idUser, String name, String firstname, String lastname, String email, String password, int leader, String username, int activo, boolean registerStatus, String registerMsg, Timestamp timestamp) {        this.idUser = idUser;
        this.name = name;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.leader = leader;
        this.username = username;
        this.activo = activo;
        this.registerStatus = registerStatus;
        this.registerMsg = registerMsg;
        this.timestamp = timestamp;
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

    public boolean isRegisterStatus() {
        return registerStatus;
    }

    public void setRegisterStatus(boolean registerStatus) {
        this.registerStatus = registerStatus;
    }

    public String getRegisterMsg() {
        return registerMsg;
    }

    public void setRegisterMsg(String registerMsg) {
        this.registerMsg = registerMsg;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}

