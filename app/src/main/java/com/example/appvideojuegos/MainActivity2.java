package com.example.appvideojuegos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TextView txtResultado;
    private EditText etValoracion;
    private Button btnSelec;
    private double rdnVal = Math.random()*(5-0); //Numero aleatorio entre 0 y 5
    private String msgValoracion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        inicializarVistas();
        msgValoracion = String.format("%.2f",rdnVal);
        txtResultado.setText(msgValoracion);
        btnSelec.setOnClickListener(view->{
            calcularVal();
        });
    }
    private void calcularVal() {
        double val1 = rdnVal;
        double val2 = Double.parseDouble(String.valueOf(etValoracion.getText()));
        double valFinal;
        valFinal = Math.round((val1+val2)/2);
        msgValoracion +=String.format("/%.2f",valFinal);
        txtResultado.setText(msgValoracion);
    }

    private void inicializarVistas() {
        txtResultado = findViewById(R.id.txtResulValoracion);
        etValoracion = findViewById(R.id.etValoracion);
        btnSelec = findViewById(R.id.btnSelec);
    }
}