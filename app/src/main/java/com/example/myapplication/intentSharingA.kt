package com.example.myapplication

import android.content.Intent
import  androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class intentSharingA : AppCompatActivity() {
    //initialize
    lateinit var imagelogo:ImageView
    lateinit var textView: TextView
    lateinit var edit: EditText
    lateinit var buttonClick:Button
    //string
    var text1:String=""
    var text2:String=""
    //digit
    var digit: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_sharing)

         //find the views
        imagelogo=findViewById(R.id.disneyplane)
        textView=findViewById(R.id.disneyplanetext)
        edit=findViewById(R.id.textunder)
        buttonClick=findViewById(R.id.buttonclick)




        //set the onclick for transition
        buttonClick.setOnClickListener {

            //fetch the text from textView
            text1=textView.text as String


            //fetch the text from Edit Text
            text2=edit.text.toString()

            //login info
            Log.d("sharedata","text from textView ${text1}, text from editView${text2}")

            val intentSharingB=Intent(this@intentSharingA,intentSharingB::class.java)

            //sharing data

            //image
            intentSharingB.putExtra("image",R.mipmap.disneyplane)
            //text
            intentSharingB.putExtra("textFromTv",text1)
            intentSharingB.putExtra("textFromET",text2)
            intentSharingB.putExtra("digit","3000")

            startActivity(intentSharingB)
        }





    }
}