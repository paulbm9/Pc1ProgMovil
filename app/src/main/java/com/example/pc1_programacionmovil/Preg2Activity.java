package com.example.pc1_programacionmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Preg2Activity extends AppCompatActivity {

    EditText edtUsuario;
    EditText edtContrasenia;
    Button btniniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preg2);

        edtUsuario = findViewById(R.id.editTextUser);
        edtContrasenia = findViewById(R.id.editTextPassword);
        btniniciar = findViewById(R.id.btn_iniciar_sesion);

    }

    public void InicioSesionExitoso(View view) {
        String user = edtUsuario.getText().toString();
        String pass = edtContrasenia.getText().toString();

        Toast.makeText(this, "Usuario: " + user + "\nContrasenia: " + pass, Toast.LENGTH_SHORT).show();
    }
}