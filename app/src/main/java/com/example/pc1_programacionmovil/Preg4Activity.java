package com.example.pc1_programacionmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class Preg4Activity extends AppCompatActivity {

    EditText dato1, dato2, dato3, dato4, dato5;
    Button buttonCalcular, buttonLimpiar;
    TextView txtResultado;
    CheckBox checkBoxResultado;

    double constantecambio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preg4);
        //Enlace a cajitas, botones, checkbox y labels.
        dato1 = findViewById(R.id.editTextTotalPoblacion);
        dato2 = findViewById(R.id.editTextSeguridad);
        dato3 = findViewById(R.id.editTextPorcionEsperada);
        dato4 = findViewById(R.id.editTextPorcionNoEsperada);
        dato5 = findViewById(R.id.editTextPrecision);
        buttonCalcular = findViewById(R.id.buttonCalcular);
        buttonLimpiar = findViewById(R.id.buttonLimpiar);
        checkBoxResultado = findViewById(R.id.checkBoxResultado);
        txtResultado = findViewById(R.id.txtResultado);

    }

    public void CalcularMuestra(View view) {

        checkBoxResultado.setChecked(false);
        double resultado = 0.0;

        double poblacionTotal = Double.parseDouble(dato1.getText().toString());
        double seguridad = Double.parseDouble(dato2.getText().toString());
        double porcionEsperada = Double.parseDouble(dato3.getText().toString());
        double porcionNoEsperada = Double.parseDouble(dato4.getText().toString());
        double precision = Double.parseDouble(dato5.getText().toString());


        if (seguridad <= 90) {
            constantecambio = 1.645;
        } else if (seguridad <= 95) {
            constantecambio = 1.96;
        } else if (seguridad <= 97.5) {
            constantecambio = 2.24;
        } else if (seguridad <= 99) {
            constantecambio = 2.576;
        } else {
            constantecambio = 1;
        }

        resultado = (poblacionTotal * constantecambio * constantecambio * (porcionEsperada / 100.0) * (porcionNoEsperada / 100.0)) / ((precision / 100) * (precision / 100) * (poblacionTotal - 1) + constantecambio * constantecambio * (porcionEsperada / 100.0) * (porcionNoEsperada / 100.0));

        txtResultado.setText(getResultado(resultado));
        checkBoxResultado.setChecked(true);

    }

    public void LimpiarFinal(View view) {
        dato1.setText("");
        dato2.setText("");
        dato3.setText("");
        dato4.setText("");
        dato5.setText("");
        txtResultado.setText("");
    }

    private String getResultado(Object resultado) {
        final String TXT_RESULTADO = "El resultado es: %s";
        return String.format(TXT_RESULTADO, resultado);
    }
}