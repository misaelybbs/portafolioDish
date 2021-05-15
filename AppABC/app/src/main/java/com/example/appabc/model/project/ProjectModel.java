package com.example.appabc.model.project;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @Autor Alan
 * @version 1.0
 */

public class ProjectModel {
    @SerializedName("idproject")
    @Expose
    private int idproject;

    @SerializedName("nameproject")
    @Expose
    private String nameproject;

    @SerializedName("projectmanager")
    @Expose
    private String projectmanager;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("developers")
    @Expose
    private String developers;

    public ProjectModel(){

    }

    public ProjectModel(int idproject, String nameproject, String projectmanager, String description, String developers) {
        this.idproject = idproject;
        this.nameproject = nameproject;
        this.projectmanager = projectmanager;
        this.description = description;
        this.developers = developers;
    }

    public int getIdproject() {
        return idproject;
    }

    public void setIdproject(int idproject) {
        this.idproject = idproject;
    }

    public String getNameproject() {
        return nameproject;
    }

    public void setNameproject(String nameproject) {
        this.nameproject = nameproject;
    }

    public String getProjectmanager() {
        return projectmanager;
    }

    public void setProjectmanager(String projectmanager) {
        this.projectmanager = projectmanager;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDevelopers() {
        return developers;
    }

    public void setDevelopers(String developers) {
        this.developers = developers;
    }
}
