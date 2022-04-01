package com.practica.mispequeossaltamontes

class DbUtils {

    companion object {
        // Campos de la tabla
        val REG_TABLENAME: String = "registros"
        val MAT_TABLENAME: String = "materias"
        // Campos de la base de datos
        val DOC: String = "documento"
        val NAME: String = "nombre"
        val TEL: String = "telefono"
        val DIR: String = "direccion"
        val AGE: String = "edad"
        val QUAL: String = "nota"

        fun createTableRegisters(): String {
            return "CREATE TABLE $REG_TABLENAME($DOC TEXT, $NAME TEXT, $TEL TEXT, $DIR TEXT, $AGE INTEGER)"
        }

        fun createTableMaterias(): String {
            return "CREATE TABLE $MAT_TABLENAME($NAME TEXT, $QUAL REAL)"
        }

        fun dropTable(tablename: String): String {
            return "DROP TABLE IF EXISTS $tablename"
        }
    }
}