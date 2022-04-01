package com.practica.mispequeossaltamontes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterRegistroNotas(private val listaRegistroNotas: ArrayList<RegistroNotas>) : RecyclerView.Adapter<AdapterRegistroNotas.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val nombre = view.findViewById<TextView>(R.id.tvNombre)
        private val nota = view.findViewById<TextView>(R.id.tvNota)
        private val documento = view.findViewById<TextView>(R.id.tvDocumento)

        fun asignarDatos(registro: RegistroNotas) {
            nombre.text = registro.construirNombre()
            nota.text = registro.obtenerPromedio().toString()
            documento.text = registro.documento
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.asignarDatos(listaRegistroNotas[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_register, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listaRegistroNotas.size
    }

}
