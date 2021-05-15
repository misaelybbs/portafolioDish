package com.example.appabc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

/**
 * La clase principal de la app
 * @Autor Alan
 * @version 1.0
 * Se presentan dos modulos principales Invitado e INterno
 */
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public void screenInvitado(View view){
        Intent intent= new Intent (MainActivity.this, InvitadoActivity.class);
        startActivity(intent);
    }

    public void screenInterno(View view){
        Intent intent= new Intent (MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}