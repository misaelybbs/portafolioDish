package com.example.appabc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.appabc.model.register.RegisterModel;
import com.example.appabc.service.impl.ServicesImpl;


public class RegisterActivity extends AppCompatActivity {

    private RadioButton radioButtonPMNo, radioButtonPMSi, radioButtonInactivo, radioButtonActivo;

    String leaderId, activo1 = null;
    ServicesImpl servicesImpl;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        servicesImpl = new ServicesImpl(this);

        radioButtonPMNo = (RadioButton) findViewById(R.id.simpleRadioButtonPMNo);
        radioButtonPMSi = (RadioButton) findViewById(R.id.simpleRadioButtonPMSi);
        radioButtonInactivo = (RadioButton) findViewById(R.id.simpleRadioButtonInactivo);
        radioButtonActivo = (RadioButton) findViewById(R.id.simpleRadioButtonActivo);
    }

    public void pantallaLogin(View view) {

        //startActivity( Utils.setBundleUser(usuario, this, MainActivity.class));
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

    public void pantallaRegistro(View view) {

        //final Context context = this;
        final EditText txtRegistrarNombre = (EditText) findViewById(R.id.txtRegistrarUsuario);
        final EditText txtRegistrarApellidoP = (EditText) findViewById(R.id.txtRegistrarApellidoP);
        final EditText txtRegistrarApellidoM = (EditText) findViewById(R.id.txtRegistrarApellidoM);
        final EditText txtRegistrarEmail = (EditText) findViewById(R.id.txtRegistrarCorreo);
        final EditText txtRegistrarPassword = (EditText) findViewById(R.id.txtRegistrarPassword);
        final EditText txtRegistrarNickUsuario = (EditText) findViewById(R.id.txtRegistrarNickUsuario);

        RegisterModel registerModel = new RegisterModel();

        if (radioButtonPMNo.isChecked() == true) {
            leaderId = "1";
        } else if (radioButtonPMSi.isChecked() == true) {
            leaderId = "2";
        }

        if (radioButtonInactivo.isChecked() == true) {
            activo1 = "1";
        } else if (radioButtonActivo.isChecked() == true) {
            activo1 = "2";
        }

        String idUser = "0";
        String name = txtRegistrarNombre.getText().toString().trim();
        String lastNameP = txtRegistrarApellidoM.getText().toString().trim();
        String lastNameM = txtRegistrarApellidoP.getText().toString().trim();
        String email = txtRegistrarEmail.getText().toString().trim();
        String password = txtRegistrarPassword.getText().toString().trim();
        String leader = leaderId;
        String userName = txtRegistrarNickUsuario.getText().toString().trim();
        String activo = "1";

        if (!TextUtils.isEmpty(idUser) && !TextUtils.isEmpty(userName) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(name)
                && !TextUtils.isEmpty(lastNameP) && !TextUtils.isEmpty(lastNameM) && !leader.isEmpty() && !activo.isEmpty() && !TextUtils.isEmpty(email)) {

            registerModel.setIduser(idUser);
            registerModel.setName(name);
            registerModel.setFirstname(lastNameP);
            registerModel.setLastname(lastNameM);
            registerModel.setEmail(email);
            registerModel.setPassword(password);
            registerModel.setLeader(leader);
            registerModel.setUsername(userName);
            registerModel.setActivo(activo);

            servicesImpl.sendRegistro(registerModel, this);

        } else {

            AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
            builder.setTitle("Error");
            builder.setMessage("Asegurese de llenar todos los campos.");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            /*
            builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            */
            AlertDialog dialog = builder.create();
            dialog.show();
        }
        //startActivity( Utils.setBundleUser(usuario, this, MainActivity.class));
    }

    public void screenRegisterCancelar(View view) {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

}
