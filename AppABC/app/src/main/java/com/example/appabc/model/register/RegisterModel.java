package com.example.appabc.model.register;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterModel {


    @SerializedName("sub")
    @Expose
    private String sub;

    @SerializedName("iat")
    @Expose
    private String iat;

    @SerializedName("exp")
    @Expose
    private String exp;

    @SerializedName("iduser")
    @Expose
    private String iduser;

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("lastname")
    @Expose
    private String lastname;

    @SerializedName("firstname")
    @Expose
    private String firstname;

    @SerializedName("activo")
    @Expose
    private String activo;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("leader")
    @Expose
    private String leader;

    @SerializedName("registerStatus")
    @Expose
    private String registerStatus;

    @SerializedName("registerMsg")
    @Expose
    private String registerMsg;

    @SerializedName("timestamp")
    @Expose
    private String timestamp;


    public RegisterModel() {
    }

    public RegisterModel(String sub, String iat, String exp, String iduser, String username, String password, String name, String lastname, String firstname, String activo, String email, String leader, String registerStatus, String registerMsg, String timestamp) {
        this.sub = sub;
        this.iat = iat;
        this.exp = exp;
        this.iduser = iduser;
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.firstname = firstname;
        this.activo = activo;
        this.email = email;
        this.leader = leader;
        this.registerStatus = registerStatus;
        this.registerMsg = registerMsg;
        this.timestamp = timestamp;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getIat() {
        return iat;
    }

    public void setIat(String iat) {
        this.iat = iat;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getRegisterStatus() {
        return registerStatus;
    }

    public void setRegisterStatus(String registerStatus) {
        this.registerStatus = registerStatus;
    }

    public String getRegisterMsg() {
        return registerMsg;
    }

    public void setRegisterMsg(String registerMsg) {
        this.registerMsg = registerMsg;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
