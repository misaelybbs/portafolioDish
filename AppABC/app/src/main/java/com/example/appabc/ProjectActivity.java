package com.example.appabc;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appabc.model.project.ProjectModel;
import com.example.appabc.service.UserInterface;
import com.example.appabc.utils.Utils;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @Autor Alan
 * @version 1.0
 */

public class ProjectActivity extends AppCompatActivity {
    UserInterface service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

        TextView idproyectos = (TextView) findViewById(R.id.Id);
        EditText txtIdProyectos = (EditText) findViewById(R.id.txtId);
        TextView nombres = (TextView) findViewById(R.id.nombre);
        final EditText txtNombres = (EditText) findViewById(R.id.txtNombre);
        TextView projectmanagers = (TextView) findViewById(R.id.ProjectManager);
        final EditText txtprojectManagers = (EditText) findViewById(R.id.txtProjectManager);
        TextView descripcion = (TextView) findViewById(R.id.textViewDescription);
        final EditText txtDescripcion = (EditText) findViewById(R.id.txtDescription);
        TextView desarrolladores = (TextView) findViewById(R.id.textViewDevelopers);
        final EditText txtDesarrolladores = (EditText) findViewById(R.id.txtDevelopers);

        Button btnSave = (Button) findViewById(R.id.btnSave);
        Button btnVolver = (Button) findViewById(R.id.btnVolver);
        Button btnEliminar = (Button) findViewById(R.id.btnEliminar);

        Bundle bundle = getIntent().getExtras();
        final String id = bundle.getString("ID");
        String nom = bundle.getString("nameProject");
        String pma = bundle.getString("projectManager");
        String des = bundle.getString("description");
        String dev = bundle.getString("developers");

        String id2 = txtIdProyectos.getText().toString().trim();
        String nom2 = txtNombres.getText().toString().trim();
        String pma2 = txtprojectManagers.getText().toString().trim();
        String des2 = txtDescripcion.getText().toString().trim();
        String dev2 = txtDesarrolladores.getText().toString().trim();


        txtIdProyectos.setText(id);
        txtNombres.setText(nom);
        txtprojectManagers.setText(pma);
        txtDescripcion.setText(des);
        txtDesarrolladores.setText(dev);
        if (id.trim().length() == 0 || id.equals("")) {
            idproyectos.setVisibility(View.INVISIBLE);
            txtIdProyectos.setVisibility(View.INVISIBLE);
        }


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProjectModel p = new ProjectModel();
                p.setNameproject(txtNombres.getText().toString());
                p.setProjectmanager(txtprojectManagers.getText().toString());
                p.setDescription(txtDescripcion.getText().toString());
                p.setDevelopers(txtDesarrolladores.getText().toString());
                if (id.trim().length() == 0 || id.equals("")) {

                        addProject(p);

                    if (!TextUtils.isEmpty(nom2) && !TextUtils.isEmpty(pma2) && !TextUtils.isEmpty(des2) && !TextUtils.isEmpty(dev2)) {
                        Intent intent = new Intent(ProjectActivity.this, ListaActivity.class);
                        startActivity(intent);

                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(ProjectActivity.this);
                        builder.setTitle("Error")
                                .setMessage("Asegurese de llenar todos los campos correctamente.")
                                .setCancelable(false)
                                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                    }
                                });

                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }

                } else {
                    updateProject(p, Integer.valueOf(id));
                    Intent intent = new Intent(ProjectActivity.this, ListaActivity.class);
                    startActivity(intent);
                }
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (id.trim().length() != 0 || id.isEmpty()) {

                    deletePersona(Integer.valueOf(id));


                    AlertDialog.Builder builder = new AlertDialog.Builder(ProjectActivity.this);
                    builder.setTitle("Registro")
                            .setMessage("Eliminacion exitosa.")
                            .setCancelable(false)
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            });

                    AlertDialog dialog = builder.create();
                    dialog.show();


                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ProjectActivity.this);
                    builder.setTitle("Error")
                            .setMessage("Asegurese de elegir un proyecto en la lista.")
                            .setCancelable(false)
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            });

                    AlertDialog dialog = builder.create();
                    dialog.show();
                }


                Intent intent = new Intent(ProjectActivity.this, ListaActivity.class);
                startActivity(intent);

            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProjectActivity.this, ListaActivity.class);
                startActivity(intent);
            }
        });

    }

    public void addProject(ProjectModel p){

        final EditText txtNombres = (EditText) findViewById(R.id.txtNombre);
        final EditText txtprojectManagers = (EditText) findViewById(R.id.txtProjectManager);
        final EditText txtDescripcion = (EditText) findViewById(R.id.txtDescription);
        final EditText txtDesarrolladores = (EditText) findViewById(R.id.txtDevelopers);

        String nom2 = txtNombres.getText().toString().trim();
        String pma2 = txtprojectManagers.getText().toString().trim();
        String des2 = txtDescripcion.getText().toString().trim();
        String dev2 = txtDesarrolladores.getText().toString().trim();


        if (!TextUtils.isEmpty(nom2) && !TextUtils.isEmpty(pma2) && !TextUtils.isEmpty(des2) && !TextUtils.isEmpty(dev2)) {


            service = Utils.getProjectsService();
            Call<ProjectModel> call = service.addProject(p);
            call.enqueue(new Callback<ProjectModel>() {
                @Override
                public void onResponse(Call<ProjectModel> call, Response<ProjectModel> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(ProjectActivity.this, "Se agrego conéxito", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<ProjectModel> call, Throwable t) {
                    Log.e("Error:", t.getMessage());
                }
            });
            Intent intent = new Intent(ProjectActivity.this, ListaActivity.class);
            startActivity(intent);

        }


    }

    public void updateProject(ProjectModel p, int id) {
        service = Utils.getProjectsService();

        Call<ProjectModel> call = service.updateProject(p, id);
        call.enqueue(new Callback<ProjectModel>() {
            @Override
            public void onResponse(Call<ProjectModel> call, Response<ProjectModel> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(ProjectActivity.this, "Se Actualizó conéxito", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ProjectModel> call, Throwable t) {
                Log.e("Error:", t.getMessage());
            }
        });
        Intent intent = new Intent(ProjectActivity.this, ListaActivity.class);
        startActivity(intent);
    }

    public void deletePersona(int id) {

        EditText txtIdProyectos = (EditText) findViewById(R.id.txtId);
        String id2 = txtIdProyectos.getText().toString().trim();

        if (!TextUtils.isEmpty(id2)) {

            service = Utils.getProjectsService();
            Call<ProjectModel> call = service.deleteProject(id);
            call.enqueue(new Callback<ProjectModel>() {
                @Override
                public void onResponse(Call<ProjectModel> call, Response<ProjectModel> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(ProjectActivity.this, "Se Elimino el registro", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<ProjectModel> call, Throwable t) {
                    Log.e("Error:", t.getMessage());
                }
            });

        }
    }
}