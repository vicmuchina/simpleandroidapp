package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavigation : AppCompatActivity() , BottomNavigationView.OnNavigationItemSelectedListener {
    //initialize variable to refer to bottom navigation
    private lateinit var bottomNav:BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)

        //view identification
        bottomNav=findViewById(R.id.bottom_navigation)

        //set a listener to it
        bottomNav.setOnNavigationItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
      when(item.itemId){
          R.id.Relative -> {
              val intent = Intent(this@BottomNavigation,Relativelayout::class.java)
              startActivity(intent)
          }
          R.id.Linear -> {
              val intent = Intent(this@BottomNavigation,Linearlayout::class.java)
              startActivity(intent)
          }
          R.id.constraint -> {
              val intent = Intent(this@BottomNavigation,Constraintlayout::class.java)
              startActivity(intent)
          }

      }
        return true
    }
}