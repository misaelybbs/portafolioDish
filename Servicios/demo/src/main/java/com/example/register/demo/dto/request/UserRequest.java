package com.example.register.demo.dto.request;

public class UserRequest {

    private int idUser;
    private String name;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private int leader;
    private String username;
    private int activo;

    public UserRequest() {
    }

    public UserRequest(int idUser, String name, String firstname, String lastname, String email, String password, int leader, String username, int activo) {
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
        return "UserRequest{" +
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
