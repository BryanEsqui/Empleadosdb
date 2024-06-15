package com.example.exerciseempleados

import android.content.Intent
import android.graphics.Region
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class form_empleados : AppCompatActivity() {
    lateinit var apellido_empleado: EditText
    lateinit var nombre_empleado: EditText
    lateinit var cargo_empleado: EditText
    lateinit var tratamiento: EditText
    lateinit var fecha_nacimiento: EditText
    lateinit var fecha_contratacion: EditText
    lateinit var direccion: EditText
    lateinit var ciudad: EditText
    lateinit var region: EditText
    lateinit var codigo_postal: EditText
    lateinit var pais: EditText
    lateinit var numero_telefono: EditText
    lateinit var extension: EditText
    lateinit var notas: EditText
    lateinit var jefe: EditText
    lateinit var btn_registrar: Button
    lateinit var conexion: uConexion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_form_empleados)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        apellido_empleado = findViewById(R.id.campo_apellido)
        nombre_empleado = findViewById(R.id.campo_nombres)
        cargo_empleado = findViewById(R.id.campo_cargo)
        tratamiento = findViewById(R.id.campo_tratamiento)
        fecha_nacimiento = findViewById(R.id.campo_fechaNacimiento)
        fecha_contratacion = findViewById(R.id.campo_fechaContratacion)
        direccion = findViewById(R.id.campo_direccion)
        ciudad = findViewById(R.id.campo_ciudad)
        region = findViewById(R.id.campo_region)
        codigo_postal = findViewById(R.id.campo_codPostal)
        pais = findViewById(R.id.campo_pais)
        numero_telefono = findViewById(R.id.campo_telefono)
        extension = findViewById(R.id.campo_extension)
        notas = findViewById(R.id.campo_notas)
        jefe = findViewById(R.id.campo_jefe)
        btn_registrar = findViewById(R.id.btn_registrar)
        conexion = uConexion(this)

        btn_registrar.setOnClickListener {
            val peticion = conexion.writableDatabase
            peticion.execSQL("INSERT INTO Empleados VALUES(null,'"+
                    apellido_empleado.text + "','"+
                    nombre_empleado.text + "','"+
                    cargo_empleado.text + "','"+
                    tratamiento.text + "','"+
                    fecha_nacimiento.text.toString().toInt() + "','"+
                    fecha_contratacion.text.toString().toInt() + "','"+
                    direccion.text + "','"+
                    ciudad.text + "','"+
                    region.text + "','"+
                    codigo_postal.text.toString().toInt() + "','"+
                    pais.text + "','"+
                    numero_telefono.text.toString().toInt() + "','"+
                    extension.text.toString().toInt() + "','"+
                    notas.text + "','"+
                    jefe.text+"')")

            Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show()
            val traslado = Intent(this, MainActivity::class.java)
            startActivity(traslado)
        }
    }
}