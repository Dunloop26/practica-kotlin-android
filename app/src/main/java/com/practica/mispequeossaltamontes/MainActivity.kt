package com.practica.mispequeossaltamontes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val registroButton = findViewById<Button>(R.id.registrar_estudiantes);

		val context = this;
		registroButton.setOnClickListener{
			val intent = Intent(context, RegistroActivity::class.java)
			startActivity(intent)
		}

	}
}
