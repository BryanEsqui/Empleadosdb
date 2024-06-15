package com.example.exerciseempleados

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    lateinit var boton_empleados: FloatingActionButton
    lateinit var boton_edicion_empleados: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        boton_empleados = findViewById(R.id.btn_traslado)
        boton_empleados.setOnClickListener {
            val tranform = Intent(this, form_empleados::class.java)
            startActivity(tranform)
        }
        boton_edicion_empleados = findViewById(R.id.btn_modificar)
        boton_edicion_empleados.setOnClickListener {
            val modifcarFormulario = Intent(this, form_actualizaProvedores::class.java)
            startActivity(modifcarFormulario)
        }
    }
}