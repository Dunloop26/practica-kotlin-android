package com.practica.mispequeossaltamontes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class CreateRegisterActivity : AppCompatActivity() {

    var registerMateriasBtn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_register)

        registerMateriasBtn = findViewById(R.id.btn_registrar_materias)
        var context = this
        registerMateriasBtn?.setOnClickListener{it: View ->
            val intent = Intent(this, RegistrarMateriasActivity::class.java)
            startActivity(intent)
        }

    }
}