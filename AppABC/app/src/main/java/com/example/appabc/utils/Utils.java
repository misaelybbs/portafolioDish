package com.example.appabc.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import com.example.appabc.MainActivity;
import com.example.appabc.service.UserInterface;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Autor Alan
 * @version 1.0
 */

public class Utils {

    public static final String dir = "http://192.168.1.86:9095/projects/";



    public static String getProperty(String key, Context context) throws IOException {
        try {
            Properties properties = new Properties();
            AssetManager assetManager = context.getAssets();
            InputStream inputStream = assetManager.open("app.properties");
            properties.load(inputStream);
            return properties.getProperty(key);
        } catch (IOException e) {
            e.fillInStackTrace();
        }
        return null;
    }

    public static void registroExitoso(final Context context, Class clazz) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Registro Exitoso");
        builder.setMessage("Proyecto Registrado Exitosamente");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Utils.showPantalla(context, MainActivity.class);
                dialog.cancel();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public static void RegistroUserExitoso(final Context context, Class clazz) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Registro Exitoso");
        builder.setMessage("Usuario Registrado Correctamente");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Utils.showPantalla(context, MainActivity.class);
                dialog.cancel();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    public static Retrofit getClient(String url){
        Retrofit retrofit= new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        return  retrofit;
    }


    public static UserInterface getProjectsService(){
        return  Utils.getClient(dir).create(UserInterface.class);
    }

    public static Object getBuilder(String urlBase, Class clazz) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(urlBase)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        return retrofit.create(clazz);
    }

    public static void showPantalla(Context context, Class clazz) {
        Intent i = new Intent(context, clazz);
        context.startActivity(i);
    }

    public static void registroError(final Context context, Class clazz) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Error");
        builder.setMessage("Nickname ya registrado. \n\nIntente nuevamente");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Utils.showPantalla(context, MainActivity.class);
                dialog.cancel();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public static void loginError(final Context context, Class clazz) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Error");
        builder.setMessage("Usuario o contraseña incorrecta \n\nIntente nuevamente");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Utils.showPantalla(context, MainActivity.class);
                dialog.cancel();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }


}
