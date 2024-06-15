package com.example.exerciseempleados

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class uConexion (
    context: Context?,
) : SQLiteOpenHelper(context, "EmpleadosTotales.db", null, 1){
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE Empleados(" +
                "IdEmpleado INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Apellido TEXT," +
                "Nombres TEXT," +
                "Tratamiento TEXT," +
                "FechaNacimiento INTEGER," +
                "FechaContratacion INTEGER," +
                "Direccion TEXT," +
                "Ciudad TEXT," +
                "Region TEXT," +
                "CodigoPostal INTEGER," +
                "Pais TEXT," +
                "Telefono TEXT," +
                "Extension INTEGER," +
                "Foto TEXT," +
                "Notas TEXT," +
                "Jefe TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

}