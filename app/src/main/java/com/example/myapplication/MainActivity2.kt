package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {

    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //refer the textview to give it an action
        textView=findViewById(R.id.textView)
        //set onclick listener
        textView.setOnClickListener(View.OnClickListener {
            //concepts intents
            val intents= Intent(this,Linearlayout::class.java)
            startActivity(intents)
        })

    }
}