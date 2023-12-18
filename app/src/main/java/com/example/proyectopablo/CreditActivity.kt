package com.example.proyectopablo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CreditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credit)

        // Obtener el nombre del usuario desde la actividad principal
        val userName = intent.getStringExtra("ETUSERNAME")

        val informacion = findViewById<TextView>(R.id.tvVersionInfo)
        informacion.apply {
            text= getString(R.string.titulo, userName)

        }

        // Configurar el botón "Contactar"
        val btnContact = findViewById<Button>(R.id.btnContact)
        btnContact.setOnClickListener {
            // Lanzar un intent implícito para enviar un correo electrónico
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:") // Solo aplicaciones de correo electrónico deben manejar esto
            val nombreApp ="PulseTech"
            // Especificar la dirección de correo electrónico y el asunto
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("pabloparrenodominguez@gmail.com"))
            intent.putExtra(Intent.EXTRA_SUBJECT, "Consulta de la app $nombreApp")

            // Verificar si hay aplicaciones que pueden manejar el intent
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Log.e("Correo", "No hay aplicaciones de correo electrónico instaladas")
            }
        }
    }
}
