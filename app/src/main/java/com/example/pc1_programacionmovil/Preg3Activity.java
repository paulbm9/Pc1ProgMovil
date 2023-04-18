package com.example.pc1_programacionmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Preg3Activity extends AppCompatActivity {

    EditText mak, kam;

    Button btnCalcular, btnLimpiar;
    TextView Resultadomak, Resultadokam;
    RadioGroup radioGroupOperacion;


    double resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preg3);
        //Vinculamos las cajitas, labels, botones y radios
        mak = findViewById(R.id.editTextMxK);
        kam = findViewById(R.id.editTextKxM);
        Resultadomak = findViewById(R.id.textViewResultado);
        Resultadokam = findViewById(R.id.textViewResultado2);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        radioGroupOperacion = findViewById(R.id.radioGroupOperacion);
    }

    public void CalcularConversion(View view) {

        String mxk = mak.getText().toString();
        String kxm = kam.getText().toString();

        if (mxk.isEmpty() || kxm.isEmpty()) {
            Resultadomak.setText("Complete 1 campo al menos");
            Resultadokam.setText("Complete 1 campo al menos");
            return;
        }
        double n1 = Double.parseDouble(mxk);
        double n2 = Double.parseDouble(kxm);

        if (radioGroupOperacion.getCheckedRadioButtonId() == R.id.radioButtonKaM) {
            resultado = n2 * 1000;
            Resultadokam.setText(getResultado(resultado));
        } else if (radioGroupOperacion.getCheckedRadioButtonId() == R.id.radioButtonMaK) {
            resultado = n1 / 1000;
            Resultadomak.setText(getResultado(resultado));
        } else {

        }

    }

    public void Limpiar(View view) {
        mak.setText("");
        kam.setText("");
        Resultadomak.setText("Resultado");
        Resultadokam.setText("Resultado");
    }

    private String getResultado(Object resultado) {
        final String TXT_RESULTADO = "El resultado es: %s";
        return String.format(TXT_RESULTADO, resultado);
    }
}