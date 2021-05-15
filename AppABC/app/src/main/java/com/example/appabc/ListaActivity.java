package com.example.appabc;

import android.content.Intent;
import android.os.Bundle;

import com.example.appabc.model.project.ProjectModel;
import com.example.appabc.service.UserInterface;
import com.example.appabc.utils.Utils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @Autor Alan
 * @version 1.0
 */

public class ListaActivity extends AppCompatActivity {

    UserInterface pService;
    List<ProjectModel> listProjectModel = new ArrayList<>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = (ListView) findViewById(R.id.listView);

            listProjects();

        Button fab = findViewById(R.id.btnOpciones);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaActivity.this, ProjectActivity.class);
                intent.putExtra("ID", "");
                intent.putExtra("nameProject", "");
                intent.putExtra("projectManager", "");
                intent.putExtra("description", "");
                intent.putExtra("developers", "");
                startActivity(intent);
            }
        });
    }


    public void listProjects(){
        pService = Utils.getProjectsService();
        Call<List<ProjectModel>> call = pService.getProject();
        call.enqueue(new Callback<List<ProjectModel>>() {
            @Override
            public void onResponse(Call<List<ProjectModel>> call, Response<List<ProjectModel>> response) {
                if (response.isSuccessful()) {
                    listProjectModel = response.body();
                    listView.setAdapter(new ProjectAdapter(ListaActivity.this, R.layout.content_main, listProjectModel));
                }
            }

            @Override
            public void onFailure(Call<List<ProjectModel>> call, Throwable t) {
                Log.e("Error:", t.getMessage());
            }
        });
    }

    public void screenActualizar(View view){
        Intent intent= new Intent (ListaActivity.this, ListaActivity.class);
        startActivity(intent);
        finish();
    }

}