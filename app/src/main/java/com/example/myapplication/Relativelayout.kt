package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Relativelayout : AppCompatActivity() {
    //initialize ur widget
    private lateinit var constraint:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.relativelayout)

        //refer the textview to give it an action
        constraint=findViewById(R.id.buttonconst)

        //set onclick listener
        constraint.setOnClickListener {

            var  intents= Intent(this,Constraintlayout::class.java)
            startActivity(intents)
        }


    }
}