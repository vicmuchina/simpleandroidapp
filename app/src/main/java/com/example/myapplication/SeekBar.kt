package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_seek_bar.*

class SeekBar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seek_bar)

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {


               // write custom code for progress is changed

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

                // write custom code for progress is started

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

                // write custom code for progress is stopped
                Toast.makeText(this@SeekBar,
                    "Progress is: " + seekBar?.progress + "%",
                    Toast.LENGTH_SHORT).show()
            }


        })






    }
}