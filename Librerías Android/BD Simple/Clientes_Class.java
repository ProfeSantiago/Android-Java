package com.example.universidad.basedatossqlite;

public class Clientes_Class {
    //Esta clase sera nuestro Modelo de Datos

    // Variables miembros de clase
    //public int clienteId;
    public String nombre;
    public String telefono;

    public Clientes_Class() { } //Constructor #1

    public Clientes_Class(String elnombre, String eltelefono) { //Constructor #2
        this.nombre = elnombre;
        this.telefono = eltelefono;
    }

    public void setNombre(String elnombre) {
        this.nombre = elnombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setTelefono(String eltelefono) {
        this.telefono = eltelefono;
    }

    public String getTelefono() {
        return this.telefono;
    }

}//End PersonaClass