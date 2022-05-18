package com.example.appvideojuegos;

import java.io.Serializable;

public class Videojuego implements Serializable {
    private int codigo;
    private String categoria;
    private String titulo;
    private String plataforma;
    private double precio;

    public Videojuego(int codigo, String categoria, String titulo, String plataforma, double precio) {
        this.codigo = codigo;
        this.categoria = categoria;
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.precio = precio;
    }

    @Override
    public String toString() {
        /*Forma de clase
        return "Videojuego{" +
                "codigo='" + codigo + '\'' +
                ", categoria='" + categoria + '\'' +
                ", titulo='" + titulo + '\'' +
                ", plataforma=" + plataforma + '\''+
                ", precio="+precio+ '\'' +
                '}';

         */
        //String format
        return String.format("Código: %d\nCategoría: %s\nTítulo: %s\nPlataforma: %s\nPrecio: %.2f Bs",codigo,categoria,titulo,plataforma,precio);
    }
}
