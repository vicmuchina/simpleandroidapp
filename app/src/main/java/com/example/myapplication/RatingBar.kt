package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_rating_bar.*

class RatingBar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rating_bar)

        button.setOnClickListener {

            var msg = rBar.rating.toString()

            Toast.makeText(this@RatingBar,"Rating is: $msg",Toast.LENGTH_SHORT).show()

        }

    }
}