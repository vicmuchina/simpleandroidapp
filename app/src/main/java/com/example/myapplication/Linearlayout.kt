package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class Linearlayout : AppCompatActivity() {
    lateinit var button: Button
    lateinit var button2: Button
    lateinit var toaster: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.linearlayout)

        //refer the textview to give it an action
        button=findViewById(R.id.button1)
        button2=findViewById(R.id.button2)
        toaster=findViewById(R.id.toaster)

        //set the on click listeners

        button.setOnClickListener {
            //concept intent
            val intents= Intent(this,Relativelayout::class.java)
            startActivity(intents)

        }

        button2.setOnClickListener {
            //concept intent
            val intents= Intent(this,Constraintlayout::class.java)
            startActivity(intents)

        }

        toaster.setOnClickListener{


          //this is how you do a toast
          Toast.makeText(this,"Thank you for clicking me,love uuuuu",Toast.LENGTH_LONG).show()

      }





    }
}