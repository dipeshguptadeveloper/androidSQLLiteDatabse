package com.dkgtech.sqlitedatabase

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBHelper(private val context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        val DATABASE_NAME = "school.db"
        val DATABASE_VERSION = 1

//        for student table

        val STUDENT_TABLE_NAME = "student"
        val COLUMN_STUDENT_ID = "student_id"
        val COLUMN_STUDENT_NAME = "name"
        val COLUMN_STUDENT_CLASS = "class"
        val COLUMN_STUDENT_SEC = "sec"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.let {
            db.execSQL(
                "create table $STUDENT_TABLE_NAME ($COLUMN_STUDENT_ID integer primary key autoincrement," +
                        "$COLUMN_STUDENT_NAME text," +
                        "$COLUMN_STUDENT_CLASS text," +
                        "$COLUMN_STUDENT_SEC text)"
            )
        }
    }

    fun addStudent(name: String, className: String, sec: String) {
        val myDb = writableDatabase

        val cv = ContentValues()
        cv.put("COLUMN_STUDENT_NAME", name)
        cv.put("COLUMN_STUDENT_CLASS", className)
        cv.put("COLUMN_STUDENT_SEC", sec)

//      to insert value
        myDb.insert(STUDENT_TABLE_NAME, null, cv)
    }

    fun getAllStudent(): ArrayList<StudentModel> {
        val myDb = writableDatabase

//        to fetch data
        val cursor = myDb.rawQuery("select * from $STUDENT_TABLE_NAME", null)

        val arrStudents = ArrayList<StudentModel>()

//        to read data
        while (cursor.moveToNext()) {
            val id = cursor.getInt(0)
            val name = cursor.getString(1)
            val className = cursor.getString(2)
            val sec = cursor.getString(3)

            val studentModel = StudentModel(id, name, className, sec)
            arrStudents.add(studentModel)

        }

        return arrStudents
    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

}