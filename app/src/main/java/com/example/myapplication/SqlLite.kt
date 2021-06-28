package com.example.myapplication

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_sql_lite.*
import kotlinx.android.synthetic.main.delete_dialogue.*

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
            arrayId[index] = e.userId.toString()
            arrayName[index] = e.userName
            arrayEmail[index] = e.userEmail

            index++

        }

        //create details for adapter and also set the adapter to the list view
        val myAdapter = SqliteAdapter(this,arrayId,arrayName,arrayEmail)

        List_view.adapter = myAdapter

    }

    //update method
    fun updateData(view: View){
        //set up a dialogue
        val dialogueBuilder = AlertDialog.Builder(this)

        //inflate our layout
        val inflater = this.layoutInflater
        val dialogView = inflater.inflate(R.layout.update_dialogue,null)
        dialogueBuilder.setView(dialogView)

        //reference the views inside the custom dialog
        val update_id = dialogView.findViewById<EditText>(R.id.updateId)
        val update_name = dialogView.findViewById<EditText>(R.id.updateUsername)
        val update_email = dialogView.findViewById<EditText>(R.id.updateEmail)

        //customize the box
        dialogueBuilder.setTitle("Update data")
        dialogueBuilder.setMessage("Enter an existing id  to update a specific record")

        //set up a positive button
        dialogueBuilder.setPositiveButton(
            "Update" , DialogInterface.OnClickListener { dialog, which ->
                //capture the users details
                val updateId = update_id.text.toString()
                val updateName = update_name.text.toString()
                val updateEmail = update_email.text.toString()

                //validate data
                if(updateId.trim() != ""  && updateName.trim() != "" && updateEmail.trim() != "" ){
                    //update the data

                    //instance of the data base helper class
                    val databaseHelper = DatabaseHelper(this)

                    val status = databaseHelper.update(SqlLiteModel(

                            Integer.valueOf(updateId),updateName,updateEmail

                    ))
                    //monitor the process
                    if (status > -1){
                        Toast.makeText(applicationContext,"update successful",Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(applicationContext,"something went wrong",Toast.LENGTH_LONG).show()
                    }

                }else{
                    Toast.makeText(applicationContext,"fields cannot be empty",Toast.LENGTH_LONG).show()
                }


            })

        dialogueBuilder.setNegativeButton("Cancel" , DialogInterface.OnClickListener { dialog, which ->

            dialog.dismiss()

        })
        dialogueBuilder.setNeutralButton("Help" , DialogInterface.OnClickListener { dialog, which ->

            Toast.makeText(applicationContext, "Enter id to delete data",Toast.LENGTH_LONG).show()
        })


        //create and show the dialogue
        val b = dialogueBuilder.create()
        b.show()

    }
    //delete method
    fun delete(view: View){
        //set up a dialogue
        val dialogueBuilder = AlertDialog.Builder(this)

        //inflate our layout
        val inflater = this.layoutInflater
        val dialogView = inflater.inflate(R.layout.delete_dialogue,null)
        dialogueBuilder.setView(dialogView)

        //view identification
        val deletedContacts = dialogView.findViewById<EditText>(R.id.deleteId)
        //customize
        dialogueBuilder.setTitle("Delete data")
        dialogueBuilder.setMessage("Enter id Delete Data")
        dialogueBuilder.setIcon(R.drawable.ic_baseline_low_priority_24)

        dialogueBuilder.setPositiveButton("Delete" , DialogInterface.OnClickListener { dialog, which ->
            //delete data

            val input_id = deletedContacts.text.toString()



            //instance of the data base helper class
            val databaseHelper = DatabaseHelper(this)

            if(input_id.trim() != ""){

                val status = databaseHelper.deleteData(SqlLiteModel(

                    Integer.valueOf(input_id),"",""

                ))
                //monitor the process
                if (status > -1){
                    Toast.makeText(applicationContext,"Delete successful",Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(applicationContext,"something went wrong",Toast.LENGTH_LONG).show()
                }

            }else{
                Toast.makeText(applicationContext,"Fields cannot be empty",Toast.LENGTH_LONG).show()
            }


        })
        dialogueBuilder.setNegativeButton("Cancel" , DialogInterface.OnClickListener { dialog, which ->

            dialog.dismiss()

        })
        dialogueBuilder.setNeutralButton("Help" , DialogInterface.OnClickListener { dialog, which ->

            Toast.makeText(applicationContext, "Enter id to delete data",Toast.LENGTH_LONG).show()
        })

        val b = dialogueBuilder.create()
        b.show()

    }

}