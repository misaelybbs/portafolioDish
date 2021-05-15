package com.example.appabc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.appabc.model.project.ProjectModel;
import com.example.appabc.service.UserInterface;
import com.example.appabc.utils.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Autor Alan
 * @version 1.0
 */

public class InvitadoActivity extends AppCompatActivity {

    UserInterface pService;
    List<ProjectModel> listProjectModel = new ArrayList<>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invitado);

        listView = (ListView) findViewById(R.id.listView2);

            listProjects();
    }

    public static final String URL_001 = "http://192.168.1.86:9095/projects/";





    public void listProjects(){


        pService = Utils.getProjectsService();
        Call<List<ProjectModel>> call = pService.getProject();
        call.enqueue(new Callback<List<ProjectModel>>() {
            @Override
            public void onResponse(Call<List<ProjectModel>> call, Response<List<ProjectModel>> response) {
                if (response.isSuccessful()) {
                    listProjectModel = response.body();
                    listView.setAdapter(new SoloView(InvitadoActivity.this, R.layout.content_main, listProjectModel));
                    listView.setClickable(false);
                   // listView.sete
                }
            }

            @Override
            public void onFailure(Call<List<ProjectModel>> call, Throwable t) {
                Log.e("Error:", t.getMessage());
            }
        });
    }
    public void screenInvitadoLogin(View view){
        Intent intent= new Intent (InvitadoActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}