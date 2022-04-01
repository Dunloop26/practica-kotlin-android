package com.practica.mispequeossaltamontes

data class RegistroNotas(var documento: String, var nombre: String, var edad: Int = 0, var telefono: String = "", var direccion: String = "", val materias: Array<Materia>): java.io.Serializable
{
    fun obtenerPromedio(): Float {
        if (materias.isEmpty()) return 0f
        var sumatoria = 0f
        for (materia: Materia in materias) {
            sumatoria = materia.nota
        }
        return sumatoria / materias.size
    }

    fun construirNombre(): String {
        if (nombre.isEmpty()) return ""
        val partes = nombre.split(" ")
        if (partes.isEmpty()) return ""
        if (partes.size > 2) return partes[0] + partes[2]
        return nombre
    }
}