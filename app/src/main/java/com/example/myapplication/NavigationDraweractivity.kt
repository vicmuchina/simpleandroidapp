package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class NavigationDraweractivity : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawer:DrawerLayout//variable to hold reference to the Drawer layout
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    private lateinit var navView:NavigationView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_draweractivity)

        //find DrawerLayout
        drawer=findViewById(R.id.drawerLayout)

        //find toolbar
        toolbar=findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)//setting action bar as toolbar

        //Find Navigaton view
        navView=findViewById(R.id.navView)
        navView.setNavigationItemSelectedListener(this)

        //new instance of the ActionBarToggle class so that we can get the Hamburger icon
        val toggle:ActionBarDrawerToggle

        toggle=ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close)

        //attach to the drawer a listener for the toggle effect
        drawer.addDrawerListener(toggle)

        //sync state
        toggle.syncState()

        //check if fragment is null
        if(savedInstanceState == null){
            //this line attaches a fragment to the view
            supportFragmentManager.beginTransaction().replace(R.id.fragmentcontainer,FragmentA()).commit()
            navView.setCheckedItem(R.id.FragmentA)
        }



    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.Relative -> {
                val intent = Intent(this@NavigationDraweractivity, Relativelayout::class.java)
                startActivity(intent)
            }
            R.id.Linear -> {
                val intent = Intent(this@NavigationDraweractivity, Linearlayout::class.java)
                startActivity(intent)
            }
            R.id.constraint -> {
                val intent = Intent(this@NavigationDraweractivity, Constraintlayout::class.java)
                startActivity(intent)
            }
            R.id.bottom_navigation -> {
                val intent = Intent(this@NavigationDraweractivity, BottomNavigation::class.java)
                startActivity(intent)
            }
            R.id.random -> {
                //this is how you do a toast
                Toast.makeText(this, " The navigation Drawer works", Toast.LENGTH_LONG).show()

            }
            //getting users location
            R.id.location -> {
                //location
                val intent = Intent(this@NavigationDraweractivity, Location::class.java)
                startActivity(intent)
            }
            //maps
            R.id.maps -> {
                //location
                val intent = Intent(this@NavigationDraweractivity, MapsActivity::class.java)
                startActivity(intent)
            }
            //intent sharing activity
            R.id.intent -> {
                val intent = Intent(this@NavigationDraweractivity, intentSharingA::class.java)
                startActivity(intent)
            }
            //fragment sharing activity
            R.id.fragment_sharing -> {
                val intent = Intent(this@NavigationDraweractivity, FragmentSharing::class.java)
                startActivity(intent)
            }
            //fragment sharing activity
            R.id.frag_view_model -> {
                val intent = Intent(this@NavigationDraweractivity, FragmentSharingViewModel::class.java)
                startActivity(intent)
            }
            //shared preferences
            R.id.sharedPreferences -> {
                val intent = Intent(this@NavigationDraweractivity, SharedPreferences::class.java)
                startActivity(intent)
            }
            //Post update delete
            R.id.post_update_delete -> {
                val intent = Intent(this@NavigationDraweractivity, PostUpdateDelete::class.java)
                startActivity(intent)
            }
            //sqlLite
            R.id.sqlLite -> {
                val intent = Intent(this@NavigationDraweractivity, SqlLite::class.java)
                startActivity(intent)
            }

            //list view activity
            R.id.listing -> {
                val intent = Intent(this@NavigationDraweractivity, ListView::class.java)
                startActivity(intent)
            }
            //volley android networking
            R.id.android_networking -> {
                val intent = Intent(this@NavigationDraweractivity, AndroidNetworking::class.java)
                startActivity(intent)
            }
            R.id.recyclerViewer -> {
                val intent = Intent(this@NavigationDraweractivity, RecyclerView::class.java)
                startActivity(intent)
            }
            R.id.autoCompleteText -> {
                val intent = Intent(this@NavigationDraweractivity, AutoCompleteTextView::class.java)
                startActivity(intent)
            }
            R.id.horizontalScroll -> {
                val intent = Intent(this@NavigationDraweractivity, HorizontolScrollView::class.java)
                startActivity(intent)
            }
            R.id.radiobutton -> {
                val intent = Intent(this@NavigationDraweractivity, RadioButton::class.java)
                startActivity(intent)
            }
            R.id.tableLayout -> {
                val intent = Intent(this@NavigationDraweractivity, TableLayout::class.java)
                startActivity(intent)
            }
            R.id.progress_bar -> {
                val intent = Intent(this@NavigationDraweractivity, ProgressBar::class.java)
                startActivity(intent)
            }
            R.id.ratingBar -> {
                val intent = Intent(this@NavigationDraweractivity, RatingBar::class.java)
                startActivity(intent)
            }
            R.id.seek_bar -> {
                val intent = Intent(this@NavigationDraweractivity, SeekBar::class.java)
                startActivity(intent)
            }
            R.id.spinner -> {
                val intent = Intent(this@NavigationDraweractivity, Spinner::class.java)
                startActivity(intent)
            }
            R.id.dynamic_spinner -> {
                val intent = Intent(this@NavigationDraweractivity, DynamicSpinner::class.java)
                startActivity(intent)
            }


            R.id.FragmentA->{
                supportFragmentManager.beginTransaction().replace(R.id.fragmentcontainer,FragmentA()).commit()
            }
            R.id.FragmentB->{
                supportFragmentManager.beginTransaction().replace(R.id.fragmentcontainer,FragmentB()).commit()
            }
        }
        return true

    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START)
        }
        else{
            super.onBackPressed()
        }
    }

}