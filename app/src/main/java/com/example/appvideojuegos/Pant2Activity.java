package com.example.appvideojuegos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class Pant2Activity extends AppCompatActivity {
    private TextView txtDatos;
    private Spinner spOpciones1;
    private Button btnSelec;
    private Videojuego objVideojuego;
    private ArrayList<String> opciones;
    private int opcionSelecionada;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pant2);
        inicializarVistas();
        formarObjeto();
        mostrarDatos();
        popularSpinner();

        btnSelec.setOnClickListener(view->{
            evaluarOpcion();
        });
    }

    private void evaluarOpcion() {
        Intent i = new Intent(this, PantValoracionActivity.class);
        opcionSelecionada = spOpciones1.getSelectedItemPosition();
        switch(opcionSelecionada)
        {
            case 0:
                MainActivity main = new MainActivity();
                main.finish();
                startActivity(i);
                break;
            case 1:
                Toast.makeText(this,"No disponible aún", Toast.LENGTH_LONG).show();
                break;
            default:
                Toast.makeText(this,"Error", Toast.LENGTH_LONG).show();
                break;
        }
    }

    private void inicializarVistas() {
        txtDatos = findViewById(R.id.txtDatos);
        spOpciones1 = findViewById(R.id.spOpcion);
        btnSelec = findViewById(R.id.btnSelec);
    }

    private void popularSpinner() {
        opciones = new ArrayList<>(Arrays.asList("Valoración Media","Comprar"));
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                opciones);
        spOpciones1.setAdapter(adaptador);
    }

    private void mostrarDatos() {
        txtDatos.setText(objVideojuego.toString());
    }

    private void formarObjeto() {
        objVideojuego = (Videojuego) this.getIntent().getExtras().getSerializable("videojuego_objeto");
    }
}
