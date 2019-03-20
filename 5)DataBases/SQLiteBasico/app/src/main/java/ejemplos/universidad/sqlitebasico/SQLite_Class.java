package ejemplos.universidad.sqlitebasico;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

public class SQLite_Class extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "Agenda.db";

    private static final String CREA_TABLA_CLIENTES =
            "CREATE TABLE IF NOT EXISTS Clientes (id INTEGER PRIMARY KEY AUTOINCREMENT ," +
                    "nombre TEXT, telefono TEXT )";

    public SQLite_Class(Context context, String name,
                        SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, DB_VERSION);
    }//Fin Constructor  =======================

    public SQLite_Class(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }//Fin Constructor  =======================

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREA_TABLA_CLIENTES);
    }//Fin onCreate  =======================

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Borra las tablas si existen (Es un requisito)
        db.execSQL("DROP TABLE IF EXISTS Clientes");
        onCreate(db);// Crea las tablas otra vez
    }//Fin onUpgrade =======================

    public void EliminaTablas(String laTabla){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + laTabla);
        onCreate(db);// Crea la tabla otra vez
    }//Fin BorraTodoCliente =======================

    public int CuentaFilas(String Tabla){
        int CantElementos = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery =  "SELECT Count(id) as Cantidad FROM "+Tabla;
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                CantElementos = cursor.getInt(cursor.getColumnIndex("Cantidad"));
            } while (cursor.moveToNext());
        }//if
        cursor.close();
        db.close();
        return CantElementos;
    }//Fin CuentaFilas =======================

    public int InsertaCliente(Clientes_Class persona) {
        ContentValues values = new ContentValues();
        values.put("nombre", persona.nombre);
        values.put("telefono", persona.telefono);

        SQLiteDatabase db = this.getWritableDatabase();
        long Cliente_Id = db.insert("Clientes", null, values);
        db.close();// Cierra la conexión con la BD
        return (int) Cliente_Id;
    }// Fin InsertaCliente =======================

    public ArrayList<String> ConsultaClientes() {
    String Nombre = "";
    String Telefono = "";
    ArrayList<String> ListaPersonas = new ArrayList<String>();
    SQLiteDatabase db = this.getReadableDatabase();
    Cursor elCursor = db.rawQuery("SELECT * FROM Clientes", null);
    while(elCursor.moveToNext())
    {
        Telefono = elCursor.getString(elCursor.getColumnIndex("telefono"));
        Nombre = elCursor.getString(elCursor.getColumnIndex("nombre"));
        ListaPersonas.add(Telefono + ", " + Nombre);
    }//Fin while
    elCursor.close();
    db.close();
    return ListaPersonas;
    } //Fin ConsultaClientes =======================

    public Clientes_Class BuscaClientes(int Id){
        Clientes_Class elCliente = new Clientes_Class();
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery =  "SELECT id, nombre, telefono FROM Clientes WHERE id=?";
        Cursor cursor = db.rawQuery(selectQuery, new String[]{String.valueOf(Id)});
        if (cursor.moveToFirst()) {
            do {
                elCliente.nombre =cursor.getString(cursor.getColumnIndex("nombre"));
                elCliente.telefono =cursor.getString(cursor.getColumnIndex("telefono"));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return elCliente;
    }// Fin BuscaClientes =======================

}// Fin SQLite_Class
