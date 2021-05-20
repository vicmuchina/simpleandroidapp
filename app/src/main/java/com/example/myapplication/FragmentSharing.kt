package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class FragmentSharing : AppCompatActivity() , Communicator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_sharing)

        //load up a default fragment so that the view is not empty

        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer,FragSharingA()).commit()
    }

    override fun passData(editText: String) {

        val bundle = Bundle()
        //save the string info
        bundle.putString("sharedData" , editText)

        //tag for transaction of fragments
        val transaction=this.supportFragmentManager.beginTransaction()

        //set up a tag reference for second fragment
        val fragB = FragSharingB()

        //set the arguments for fragmentB ,by using the arguments function inside Fragment.java
        fragB.arguments = bundle

        //begin transaction
        transaction.replace(R.id.fragmentContainer, fragB)

        transaction.commit()


    }
}