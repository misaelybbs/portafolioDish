package com.example.appabc.service.impl;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appabc.ListaActivity;
import com.example.appabc.RegisterActivity;
import com.example.appabc.model.login.LoginModel;
import com.example.appabc.model.login.LoginUser;
import com.example.appabc.model.register.RegisterModel;
import com.example.appabc.model.register.RegisterUser;
import com.example.appabc.service.UserInterface;
import com.example.appabc.utils.Utils;

import java.io.BufferedReader;
import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @version 1.0
 * @Autor Alan
 */

public class ServicesImpl extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Context context;
    private static String token;
    BufferedReader reader = null;

    public ServicesImpl(Context context) {
        this.context = context;
    }

    public void login(final AppCompatActivity context, LoginModel loginModel) {

        try {
            String p = Utils.getProperty("url.base.services", this.context);
            Log.d("JWT_DECODED", "Body: " + p);
            //p = "http://localhost:8761/api/"
            //http://192.168.1.70:8761/api/login/authenticate
            UserInterface userInterface = (UserInterface) Utils.getBuilder(p, UserInterface.class);
            //LoginActivity loginModel = new LoginActivity("1", "1");
            Call<LoginUser> call = userInterface.login(loginModel);
            call.enqueue(new Callback<LoginUser>() {

                @Override
                public void onResponse(Call<LoginUser> call, Response<LoginUser> response) {
                    if (response.isSuccessful()) {
                        //Toast.makeText(MainActivity.this, response.body().getCode(), Toast.LENGTH_LONG).show();
                        token = response.body().getCode();
                        System.out.println("Println ==" + token);
                        // Toast.makeText(context, token, Toast.LENGTH_SHORT).show();
                        Utils.showPantalla(context, ListaActivity.class);

                    } else {

                        /// Utils.loginError(context, RegistroProyecto.class);
                        Toast.makeText(context, "LoginActivity not correct", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<LoginUser> call, Throwable t) {
                    // Toast.makeText(MainActivity.this, "Error :(", Toast.LENGTH_LONG).show();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void sendRegistro(RegisterModel registerModel, final AppCompatActivity context) {

        try {
            String p = Utils.getProperty("url.base.services", this.context);
            UserInterface userInterface = (UserInterface) Utils.getBuilder(p, UserInterface.class);
            Call<RegisterUser> call = userInterface.savePost(registerModel);
            call.enqueue(new Callback<RegisterUser>() {
                @Override
                public void onResponse(Call<RegisterUser> call, Response<RegisterUser> response) {
                    if (response.isSuccessful()) {
                        Log.i(TAG, "post submitted to API." + response.body().toString());
                        Utils.RegistroUserExitoso(context, RegisterActivity.class);
                        finish();

                    } else {
                        Utils.registroError(context, RegisterActivity.class);
                    }
                }

                @Override
                public void onFailure(Call<RegisterUser> call, Throwable t) {
                    Log.e(TAG, "Unable to submit post to API.");
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

