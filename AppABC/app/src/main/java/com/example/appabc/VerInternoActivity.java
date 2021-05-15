package com.example.appabc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * @Autor Alan
 * @version 1.0
 */

public class VerInternoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_interno);
    }

    public void screenInicioInv(View view) {
        Intent intent = new Intent(VerInternoActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}