package es.Grupo6.recordatorios;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DataBaseSQL extends SQLiteOpenHelper {
    protected SQLiteDatabase db;
    /**
     * Funcion para crear bases de datos, crea la base de datos "UsuariosRecordatorios"
     * */
    public DataBaseSQL(@Nullable Context context) {
        super(context, "UsuariosRecordatorios", null, 1);//<---Se crea la base de datos
    }

    /**
     * Funcion para crear las tablas Usuarios y Recordatorios
     * */
    @Override
    public void onCreate(SQLiteDatabase db) {
        //-- Tabla Usuarios
        db.execSQL("CREATE TABLE Usuarios ( ID INTEGER PRIMARY KEY AUTOINCREMENT,Nombre CHAR(50) ,Email CHAR(50), Contrasenna CHAR(50) );");

        //-- Tabla Recordatorios
        db.execSQL(" CREATE TABLE Recordatorios ( ID INTEGER PRIMARY KEY AUTOINCREMENT, Fecha DATE, NombreAviso CHAR(50), Info CHAR(255), IDUsuario INTEGER, FOREIGN KEY (IDUsuario) REFERENCES Usuarios(ID) );");

        //mostrarTablas();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { //<---------------------------REVISAR URGENTE

        db.execSQL("DROP TABLE IF EXISTS Usuarios");
        db.execSQL("DROP TABLE IF EXISTS Recordatorios");


    }
    /**
     * En caso de erro usar esta función elimina la base de datos para pdoer actualizarla
     * SOLO USAR CUANDO SE PROGRAMA
     * */
    public void eliminarBaseDeDatos() {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("DROP TABLE IF EXISTS Usuarios");
            db.execSQL("DROP TABLE IF EXISTS Recordatorios");
            onCreate(db); // Vuelve a crear la base de datos después de eliminarla
            db.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * Función para crear los datos de usuario.
     * @param nombre String, es el nombre del usuario
     * @param email String, guarda en la DB el email
     * @param contrasenna String , guarda en la DB el email
     * */
    public void crearUsuario(String nombre,String email,String contrasenna){
        String ordenSQL ="INSERT INTO Usuarios (Nombre, Email, Contrasenna) VALUES ('" + nombre + "', '" + email + "', '" + contrasenna + "')";;

        try {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL(ordenSQL);
            System.out.println("@.-query aceptada");
        } catch (SQLException e) {
            System.out.println("@.-Error 0 "  + e.getMessage() );
            e.printStackTrace(); // Imprime la traza de la excepción
            throw new RuntimeException(e);

        }


    }
    public void borrarTablas() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS Usuarios");
        db.execSQL("DROP TABLE IF EXISTS Recordatorios");
        db.close();
    }
    public void mostrarTablas() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    String tableName = cursor.getString(0);
                    System.out.println("@.-Tabla: " + tableName);
                } while (cursor.moveToNext());
            }
        } finally {
            cursor.close();
        }
        db.close();
    }
    public void mostrarUsuarios() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Usuarios", null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    int id = cursor.getInt(cursor.getColumnIndex("ID"));
                    String nombre = cursor.getString(cursor.getColumnIndex("Nombre"));
                    String email = cursor.getString(cursor.getColumnIndex("Email"));
                    String contrasenna = cursor.getString(cursor.getColumnIndex("Contrasenna"));
                    System.out.println("@.-Usuario: ID=" + id + ", Nombre=" + nombre + ", Email=" + email + ", Contraseña=" + contrasenna);
                } while (cursor.moveToNext());
            }
        } finally {
            cursor.close();
        }
        db.close();
    }

    /**
     * ScorreoExistenteSiNo comprueba que el String dado exista , si NO existe,devuelve false
     * @param imeil String del correo
     * @return existencia o no del correo;
     * */
    public boolean correoExistenteSiNo(String imeil){
        boolean existe;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Usuarios WHERE Email = ?", new String[]{imeil});
        existe = cursor.moveToFirst();
        cursor.close();

        return existe;
    }

}
