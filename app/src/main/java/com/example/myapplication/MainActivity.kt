package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //initialize ur widget
    lateinit var textname:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //refer the textview to give it an action
        textname=findViewById(R.id.click)
        //set onclick listener
        textname.setOnClickListener(View.OnClickListener {
        //concepts intents
            val intents= Intent(this,MainActivity2::class.java)
        startActivity(intents)
        })

    }
}