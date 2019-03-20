package com.example.universidad.basedatossqlite;

public class Articulos_Class {
    public String nombre;
    public String Precio;

    public Articulos_Class() { } //Constructor #1

    public Articulos_Class(String elnombre, String elPrecio) { //Constructor #2
        this.nombre = elnombre;
        this.Precio = elPrecio;
    }

    public void setNombre(String elnombre) {
        this.nombre = elnombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setPrecio(String elPrecio) {
        this.Precio = elPrecio;
    }

    public String getPrecio() {
        return this.Precio;
    }

}//End PersonaClass