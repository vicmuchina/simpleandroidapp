package com.example.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context,
    DATABASE_NAME, null, DATABASE_VERSION) {

    //define our variables
    companion object{
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "UserDatabase"
        private val TABLE_USERS = "UserTable"
        private val KEY_ID = "id"
        private val KEY_NAME = "name"
        private val KEY_EMAIL = "email"
     }

    override fun onCreate(db: SQLiteDatabase?) {
        //define our query
         val CREATE_CONTACTS_TABLE = ("CREATE TABLE IF NOT EXISTS " + TABLE_USERS + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT," + KEY_EMAIL + " TEXT" + ")")

        //execute the query
        db?.execSQL(CREATE_CONTACTS_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        db!!.execSQL("DROP TABLE IF EXISTS" + TABLE_USERS)
        onCreate(db)

    }

    //save data
    fun addUsers(sqlLiteModel: SqlLiteModel): Long {

        //telling the db what to do
        val db = this.writableDatabase

        //define and place content
        val contentValues = ContentValues()
        //put data to the respective fields
        contentValues.put(KEY_ID,sqlLiteModel.userId)
        contentValues.put(KEY_NAME,sqlLiteModel.userName)
        contentValues.put(KEY_EMAIL,sqlLiteModel.userEmail)

        //query to insert to db
        val success = db.insert(TABLE_USERS, null,contentValues)
        //close the db connection
        db.close()

        //return to output of the method
        return success


    }

    //function to view details
    fun readData() : List<SqlLiteModel>{
        //get a resizable array
        val userArray : ArrayList<SqlLiteModel> = ArrayList<SqlLiteModel>()
        //define our fetch query
        val selectQuery  = "SELECT * FROM $TABLE_USERS"

        //DEFINE WHAT THE SQLlITE SHOULD DO
        val db = this.readableDatabase

        // reading our data
        var cursor: Cursor? = null
        //declare a try and catch in case the data is not there or
        //the database undergoes an upgrade we need to prevent the crush

        try {
            cursor = db.rawQuery(selectQuery, null)

        }catch (e: SQLiteException){

            db.execSQL(selectQuery)
            return ArrayList()
        }
        //iterate over record in db and store them in model class

        var userId: Int
        var UserName: String
        var UserEmail: String

        //using cursor to pick records
        if (cursor != null && cursor.moveToFirst()){
            cursor.moveToFirst()
            //create a loop for fetching process
            do{

                userId = cursor.getInt(cursor.getColumnIndex("id"))
                UserName = cursor.getString(cursor.getColumnIndex("Name"))
                UserEmail = cursor.getString(cursor.getColumnIndex("email"))

                //taking the data to the model class
                val users = SqlLiteModel(userId = userId , userName = UserName ,userEmail = UserEmail)

                userArray.add(users)

            }while (cursor.moveToNext())
        }

        cursor.close()
        return userArray

    }


}