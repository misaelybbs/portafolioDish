package com.example.appabc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.example.appabc.model.login.LoginModel;
import com.example.appabc.service.impl.ServicesImpl;
import com.example.appabc.utils.Utils;

/**
 * @Autor Alan
 * @version 1.0
 */


public class LoginActivity extends AppCompatActivity {

    ServicesImpl servicesImpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        servicesImpl = new ServicesImpl(this);
    }

    public void screenPanel(View view) {

        final EditText txtLoginUsuario = (EditText) findViewById(R.id.editTextLoginUsuario);
        final EditText txtLoginPassword = (EditText) findViewById(R.id.editTextLoginPassword);
        String LoginUsuario = txtLoginUsuario.getText().toString().trim();
        String LoginPassword = txtLoginPassword.getText().toString().trim();

        if (!TextUtils.isEmpty(LoginUsuario) && !TextUtils.isEmpty(LoginPassword)) {

            LoginModel loginModel = new LoginModel(LoginUsuario, LoginPassword);
            servicesImpl.login(this, loginModel);



        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
            builder.setTitle("Error")
                    .setMessage("Asegurese de llenar todos los campos correctamente.")
                    .setCancelable(false)
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //Toast.makeText(MainActivity.this,"Selected Option: YES",Toast.LENGTH_SHORT).show();
                        }
                    });

            AlertDialog dialog = builder.create();
            dialog.show();

        }
    }

    public void screenInicioL(View view) {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void registrar(View view) {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
        finish();
    }

}
