package com.example.appvideojuegos;
import androidx.appcompat.app.AppCompatActivity;
import java.lang.Thread;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Interfaz/Vistas
    private EditText etCod,etCat,etTitulo,etPlataforma,etPrecio;
    private Button btnRegistrar;
    private Videojuego objVideojuego;
    //Variables de validación
    private int cod;
    private String cat,tit,plat;
    private double prec;
    private boolean inputsValidos = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarVistas();
        btnRegistrar.setOnClickListener(view-> {
            obtenerDatos();
            inputsValidos = validacion();
            if(inputsValidos)
            {
                pasarDatos();
            }
            else
            {
                Toast.makeText(this,"Algún dato no esta llenado",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void pasarDatos() {
        Intent intencion = new Intent(this, Pant2Activity.class);
        Bundle archivo = new Bundle();
        archivo.putSerializable("videojuego_objeto",objVideojuego);
        intencion.putExtras(archivo);
        startActivity(intencion);
    }

    private void obtenerDatos() {
        validacion();
        objVideojuego = new Videojuego(cod,cat,tit,plat,prec);
    }

    public boolean validacion() {
        if("".equals(etCod.getText().toString()))
        {
            etCod.setError("Introduce un código, por ejemplo: 3345678"); //Mensaje de error para validar campos
            etCod.requestFocus(); //Enfocar sobre el editText
            return false;
        }
        else if("".equals(etCat.getText().toString()))
        {
            etCat.setError("Introduce una categoría, por ejemplo: Terror");
            etCat.requestFocus();
            return false;
        }
        else if("".equals(etTitulo.getText().toString()))
        {
            etTitulo.setError("Introduce un título, por ejemplo: Resident Evil 4");
            etTitulo.requestFocus();
            return false;
        }
        else if("".equals(etPlataforma.getText().toString()))
        {
            etPlataforma.setError("Introduce un plataforma, por ejemplo: Windows");
            etPlataforma.requestFocus();
            return false;
        }
        else if("".equals(etPrecio.getText().toString()))
        {
            etPrecio.setError("Introduce un precio, por ejemplo: 15.0 Bs");
            etPrecio.requestFocus();
            return false;
        }
        else
        {
            cod = Integer.parseInt(etCod.getText().toString());
            cat = etCat.getText().toString();
            tit = etTitulo.getText().toString();
            plat = etPlataforma.getText().toString();
            prec = Double.parseDouble(etPrecio.getText().toString());
            return true;
        }
    }

    private void inicializarVistas() {
        etCod = findViewById(R.id.etCodigo);
        etCat = findViewById(R.id.etCategoria);
        etTitulo = findViewById(R.id.etTitulo);
        etPlataforma = findViewById(R.id.etPlataforma);
        etPrecio = findViewById(R.id.etPrecio);
        btnRegistrar = findViewById(R.id.btnRegistrar);
    }
}