package com.example.diary

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper (context: Context) :
    SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

        companion object {
            private const val DB_NAME = "diary.sqlite"
            private const val DB_VERSION = 1
        }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.let{
            it.execSQL("CREATE TABLE items("
                + "diary_date TEXT PRIMARY KEY, diary_text TEXT)")

            it.execSQL("INSERT INTO items(diary_date, diary_text)"
                + " VALUES('2025/02/10', '음악이나 듣자')")

            it.execSQL("INSERT INTO items(diary_date, diary_text)"
                    + " VALUES('2025/02/11', '영화나 듣자')")

        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }


}