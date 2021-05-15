package com.example.appabc.service;


import com.example.appabc.model.login.LoginModel;
import com.example.appabc.model.login.LoginUser;
import com.example.appabc.model.project.ProjectModel;
import com.example.appabc.model.register.RegisterModel;
import com.example.appabc.model.register.RegisterUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * @Autor Alan
 * @version 1.0
 */

public interface UserInterface {

    @POST("login/authenticate")
    Call<LoginUser> login(@Body LoginModel loginModel);

    @POST("register/newUser")
    Call<RegisterUser> savePost(@Body RegisterModel registerModel);

    @GET("listar")
    Call<List<ProjectModel>> getProject();

    @POST("agregar")
    Call<ProjectModel>addProject(@Body ProjectModel project);

    @POST("actualizar/{id}")
    Call<ProjectModel>updateProject(@Body ProjectModel project, @Path("id") int id);

    @POST("eliminar/{id}")
    Call<ProjectModel>deleteProject(@Path("id")int id);

}
