package com.dkgtech.sqlitedatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dbHelper = MyDBHelper(this)

        dbHelper.addStudent("Dipesh", "12th", "A ")
        dbHelper.addStudent("Sachin", "10th", "B")

//        var arrStudents = dbHelper.getAllStudent()
//
//        Log.d("Name", arrStudents[0].name)

    }
}