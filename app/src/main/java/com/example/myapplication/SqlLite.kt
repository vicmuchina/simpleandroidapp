package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sql_lite.*

class SqlLite : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sql_lite)
    }
    fun saveData(view: View){
        //capture users data
        val id = editId.text.toString()
        val name = editName.text.toString()
        val email = editEmail.text.toString()

        //instance of Databasehelper class
        val databaseHelper = DatabaseHelper(this)

        //validation
        if(id.trim() != "" && name.trim() != "" && email.trim() != ""){
            //if its not equal to blank we can write to db
            val status = databaseHelper.addUsers(SqlLiteModel(Integer.valueOf(id),name,email))

            if(status > -1){
                Toast.makeText(applicationContext, "Record saved", Toast.LENGTH_LONG).show()

                //clear inputs
                editId.text?.clear()
                editName.text?.clear()
                editEmail.text?.clear()
            }else{
                Toast.makeText(applicationContext, "Something went wrong,try again", Toast.LENGTH_LONG).show()

            }

        }else{
            Toast.makeText(applicationContext, "Fields cannot be empty", Toast.LENGTH_LONG).show()


        }

    }

    fun viewData(view: View){
        //define instance of the database helper class
        val databaseHelper = DatabaseHelper(this)
        //make ref to the read data method
        val viewData: List<SqlLiteModel> = databaseHelper.readData()

        //define array variable to store each record detail
        var arrayId = Array<String>(viewData.size){"0"}
        var arrayName = Array<String>(viewData.size){"null"}
        var arrayEmail = Array<String>(viewData.size){"0"}

        var index = 0
        for (e in viewData){
            arrayId[index] =e.userId.toString()
            arrayName[index] = e.userName
            arrayEmail[index] = e.userEmail

            index++

        }
        //create details for adapter and also set the adapter to the list view
        val myAdapter = SqliteAdapter(this,arrayId,arrayName,arrayEmail)

        List_view.adapter = myAdapter

    }


}