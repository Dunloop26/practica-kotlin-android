package com.practica.mispequeossaltamontes

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.P)
class DbConnection(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(DbUtils.createTableRegisters())
        db?.execSQL(DbUtils.createTableMaterias())
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldversion: Int, newversion: Int) {
        db?.execSQL(DbUtils.dropTable(DbUtils.MAT_TABLENAME))
        db?.execSQL(DbUtils.dropTable(DbUtils.REG_TABLENAME))
        db?.execSQL(DbUtils.createTableRegisters())
        db?.execSQL(DbUtils.createTableMaterias())
    }


}