package com.example.pc1_programacionmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Preg1Activity extends AppCompatActivity {

    TextView resultado;
    Button saludar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preg1);

        saludar = findViewById(R.id.btnSaludar);
        resultado = findViewById(R.id.textViewResultado);

        saludar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultado.setText("Bienvenido Bravo Paul");
            }
        });
    }
}