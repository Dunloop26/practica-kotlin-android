package com.practica.mispequeossaltamontes

import android.app.Application
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.FrameLayout
import android.widget.ImageButton
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RegistroActivity : AppCompatActivity() {

    private val listaRegistroNotas = arrayListOf<RegistroNotas>()
    private val adapter: AdapterRegistroNotas? = null

    private var emptyFrame: FrameLayout? = null
    private var floatingButtonAdd: ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val notas = arrayListOf<Materia>(
            Materia("Matematicas", 3.0f),
            Materia("Matematicas", 3.0f),
            Materia("Matematicas", 3.0f),
            Materia("Matematicas", 3.0f),
            Materia("Matematicas", 3.0f),
        )

        listaRegistroNotas.add(RegistroNotas("1096040574", "James", 10, "3154891245", "La tebaida", notas.toTypedArray()))
        listaRegistroNotas.add(RegistroNotas("1096040574", "James", 10, "3154891245", "La tebaida", notas.toTypedArray()))
        listaRegistroNotas.add(RegistroNotas("1096040574", "James", 10, "3154891245", "La tebaida", notas.toTypedArray()))
        listaRegistroNotas.add(RegistroNotas("1096040574", "James", 10, "3154891245", "La tebaida", notas.toTypedArray()))
        listaRegistroNotas.add(RegistroNotas("1096040574", "James", 10, "3154891245", "La tebaida", notas.toTypedArray()))
        listaRegistroNotas.add(RegistroNotas("1096040574", "James", 10, "3154891245", "La tebaida", notas.toTypedArray()))


        emptyFrame = findViewById(R.id.emptyFrame)
        floatingButtonAdd = findViewById(R.id.floating_button_add)
        val context = this;
        floatingButtonAdd?.setOnClickListener{ it: View ->
            val intent = Intent(context, CreateRegisterActivity::class.java);
            startActivity(intent)
        }
        val rvMainContainer = findViewById<RecyclerView>(R.id.rv_main_container)
        val adapter = AdapterRegistroNotas(listaRegistroNotas)
        rvMainContainer.adapter = adapter
        rvMainContainer.layoutManager= LinearLayoutManager(this)
        evaluarContenedorVacio()
    }

    @RequiresApi(Build.VERSION_CODES.P)
    private fun addToDb() {
        var conn: DbConnection = DbConnection(applicationContext, DbUtils.REG_TABLENAME, null, 1)
        var db = conn.writableDatabase
    }

    private fun evaluarContenedorVacio() {
        if (emptyFrame == null) return
        val state = if (listaRegistroNotas.isEmpty()) View.VISIBLE else View.GONE
        emptyFrame?.visibility = state
    }

    override fun onActivityReenter(resultCode: Int, data: Intent?) {
        super.onActivityReenter(resultCode, data)
        adapter?.notifyDataSetChanged()
    }
}