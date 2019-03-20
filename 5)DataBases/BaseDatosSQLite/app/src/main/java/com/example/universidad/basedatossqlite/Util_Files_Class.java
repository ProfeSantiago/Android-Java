package com.example.universidad.basedatossqlite;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;

//import java.io.FileInputStream;

public class Util_Files_Class {
    private FileOutputStream Archivo_Salida;
    private FilterInputStream Archivo_Entrada;
    File MiArchivo;

    public Util_Files_Class(){}//Constructor de la clase

    public void Crear_Archivo(String Nombre_Archivo){
        try {
            Archivo_Salida = new FileOutputStream(MiArchivo.getAbsolutePath());
        } catch (Exception e) {e.printStackTrace();}
    }//------------------------------------------------

    public void Cerrar_Archivo_Salida(){
        try {
            Archivo_Salida.close();
        } catch (IOException ex) {}
    }//------------------------------------------------

    public void Escribir_Texto(String Texto){
        try {
            Archivo_Salida.write(Texto.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    } //------------------------------------------------

    public String Leer_Texto(){
        String Texto="";
        //Texto = Archivo_Entrada.readUTF();
        return Texto;
    }//------------------------------------------------
    public void Cerrar_Archico_Entrada(){
        try {
            Archivo_Entrada.close();
        } catch (IOException iOException) {}
    }//------------------------------------------------

    public void Abrir_Archivo(String Nombre_Archivo){

        //Archivo_Entrada = new DataInputStream(new FileInputStream(Nombre_Archivo));

    }//------------------------------------------------

}//Fin Util_Files_Class
