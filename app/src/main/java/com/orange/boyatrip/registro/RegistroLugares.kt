package com.orange.boyatrip.registro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.orange.boyatrip.R

class RegistroLugares : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_lugares)

        val registrarbutton:Button = findViewById(R.id.registrar_button)
        val nombreEditText: EditText = findViewById(R.id.edit_text_name)
        val infoTextView: TextView = findViewById(R.id.info_text_view)
        val estaturaEdittext:TextInputEditText = findViewById(R.id.estatura_edit_text)


        registrarbutton.setOnClickListener {
            val nombre : String = nombreEditText.text.toString()
            val estatura : Float = estaturaEdittext.text.toString().toFloat()
            infoTextView.text = getString(R.string.info, nombre, estatura)
        }
    }
}


