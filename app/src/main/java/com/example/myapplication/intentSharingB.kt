package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_intent_sharing_b.*

class intentSharingB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_sharing_b)

        //pick image shared
        //declare an instance of the bundle class
        val bundle: Bundle? =intent.extras
        val imagePicked:Int=bundle!!.getInt("image")

        Log.d("sharedData","image name ${imagePicked.toString()}")

        //set the image to the image view
        disneyplane.setImageResource(imagePicked)

        val sharedTextTV: String? =intent.getStringExtra("textFromTv")
        val sharedTextET: String? =intent.getStringExtra("textFromET")
        val sharedTextDigit: String? =intent.getStringExtra("digit")

        Log.d("shared","text from textView" + sharedTextTV +"text from edit"+sharedTextET+""+sharedTextDigit)

        //set text to the containers
        disneyplanetext.append("Text from TextView is:"+sharedTextTV+" Text from EditView is:"+sharedTextET +"Digit is:"+sharedTextDigit )

    }
}