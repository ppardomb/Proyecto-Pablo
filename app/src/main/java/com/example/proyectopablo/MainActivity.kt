package com.example.proyectopablo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obtén una referencia al botón
        val btnCredit: Button = findViewById(R.id.btnCredit)
        val etUsername = findViewById<EditText>(R.id.etUsername)
        //val username = etUsername.text.toString()
        val intent = Intent(this, CreditActivity::class.java)



        // Establece un Listener para el clic en el botón
        btnCredit.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                // Define la intención de pasar a la actividad CreditActivity
                //val intent = Intent(this@MainActivity, CreditActivity::class.java)

                intent.putExtra("ETUSERNAME", etUsername.text.toString())
                // Inicia la actividad CreditActivity
                startActivity(intent)
            }
        })
    }
}