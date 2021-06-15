package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_progress_bar.*

class ProgressBar : AppCompatActivity() {

    private val handler = Handler()
    var i = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress_bar)

        progress_button.setOnClickListener {

            i= progress_circular!!.progress

            Thread(Runnable {

                while ( i < 100){
                    i += 5
                    // Update the progress bar and display the current value
                    handler.post(Runnable {

                        progress_circular !!.progress = i
                        text1 !!. text = i.toString() +  "/" + progress_circular.max

                    })
                    try {
                        Thread.sleep(100)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }


                }

            }).start()


        }


    }
}