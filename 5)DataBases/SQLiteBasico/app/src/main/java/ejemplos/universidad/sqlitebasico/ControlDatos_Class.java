package ejemplos.universidad.sqlitebasico;

import android.content.Context;
import java.util.ArrayList;

public class ControlDatos_Class {

    Context miContexto;
    private SQLite_Class controlDB;

    public ControlDatos_Class(Context elContexto){
        miContexto = elContexto;
        controlDB = new SQLite_Class(miContexto);
    }//Fin Constructor  =======================

    public void InsertaCliente(Clientes_Class Persona){
        controlDB.InsertaCliente(Persona);
    }//Fin InsertaCliente  =======================

    public void GuardaCliente(String elnombre, String eltelefono){
        Clientes_Class Persona = new Clientes_Class();
        Persona.telefono= eltelefono;
        Persona.nombre=elnombre;
        controlDB.InsertaCliente(Persona);
    }//Fin GuardaCliente  =======================

    public void EliminaClientes(){
        controlDB.EliminaTablas("Clientes");
    }//EliminaClientes =======================

    public ArrayList<String> ConsultaClientes(){
        if (controlDB.CuentaFilas("Clientes") <= 0){
            GuardaCliente("Cliente Contado", "0000-0000");
        }
        return controlDB.ConsultaClientes();
    }//ConsultaClientes =======================

    public Clientes_Class BuscaClientes(int id){
        Clientes_Class elCliente = controlDB.BuscaClientes(id);
        return elCliente;
    }//ConsultaClientes =======================

}//Fin ControlDatos_Class
