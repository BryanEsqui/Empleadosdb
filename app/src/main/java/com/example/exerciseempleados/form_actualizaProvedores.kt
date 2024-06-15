package com.example.exerciseempleados

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class form_actualizaProvedores : AppCompatActivity() {
    lateinit var editaNombreEmpleado: EditText
    lateinit var detallesTextV: TextView
    lateinit var btn_buscar: Button
    lateinit var btn_borrar: Button
    lateinit var conexion: uConexion


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_form_actualiza_provedores)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        editaNombreEmpleado = findViewById(R.id.campo_identificaEmpleado)
        detallesTextV = findViewById(R.id.detalles_textView)
        btn_buscar = findViewById(R.id.btn_buscar)
        btn_borrar = findViewById(R.id.btn_borrar)
        conexion = uConexion(this)

        btn_buscar.setOnClickListener {
            val nombreEmpleado = editaNombreEmpleado.text.toString()
            if (nombreEmpleado.isNotEmpty()) {
                val db = conexion.readableDatabase
                val cursor = db.rawQuery("SELECT * FROM Empleados WHERE Nombres = ?", arrayOf(nombreEmpleado))
                if (cursor.moveToFirst()) {
                    val detalles = """
                        Nombres: ${cursor.getString(cursor.getColumnIndex("Nombres"))}
                        Apellido: ${cursor.getString(cursor.getColumnIndex("Apellido"))}
                        Tratamiento ${cursor.getString(cursor.getColumnIndex("Tratamiento"))}
                        FechaNacimiento: ${cursor.getString(cursor.getColumnIndex("FechaNacimiento"))}
                        FechaContratacion: ${cursor.getString(cursor.getColumnIndex("FechaContratacion"))}
                        Direccion: ${cursor.getString(cursor.getColumnIndex("Direccion"))}
                        Ciudad: ${cursor.getString(cursor.getColumnIndex("Ciudad"))}
                        Region: ${cursor.getString(cursor.getColumnIndex("Region"))}
                        CodigoPostal: ${cursor.getString(cursor.getColumnIndex("CodigoPostal"))}
                        Pais: ${cursor.getString(cursor.getColumnIndex("Pais"))}
                        Telefono: ${cursor.getString(cursor.getColumnIndex("Telefono"))}
                        Extension: ${cursor.getString(cursor.getColumnIndex("Extension"))}
                        Foto: ${cursor.getString(cursor.getColumnIndex("Foto"))}
                        Notas: ${cursor.getString(cursor.getColumnIndex("Notas"))}
                        Jefe: ${cursor.getString(cursor.getColumnIndex("Jefe"))}
                        """.trimIndent()
                    detallesTextV.text = detalles
                } else {
                    detallesTextV.text = "No se encontró al empleado"
                }
                cursor.close()
                db.close()
            } else{
                Toast.makeText(this, "Por favor ingrese el nombre del empleado para buscar", Toast.LENGTH_LONG).show()
            }
        }
        btn_borrar.setOnClickListener {
            val nombreEmpleado = editaNombreEmpleado.text.toString()
            if (nombreEmpleado.isNotEmpty()) {
                val db = conexion.writableDatabase
                //val cursor = db.rawQuery("SELECT * FROM Empleados WHERE Nombres = ?", arrayOf(nombreEmpleado))
                val resultado = db.delete("Empleados", "Nombres = ?", arrayOf(nombreEmpleado))
                db.close()
                if (resultado !=0){
                    Toast.makeText(this, "Se elimino al empleado", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Error al eliminar al empleado", Toast.LENGTH_LONG).show()
                }
            }
             else{
                 Toast.makeText(this, "Por favor ingrese el nombre del empleado para borrar", Toast.LENGTH_LONG).show()
            }
            val retorno = Intent(this, MainActivity::class.java)
            startActivity(retorno)
            }
        }

    }
