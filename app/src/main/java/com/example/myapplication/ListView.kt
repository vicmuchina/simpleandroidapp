package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class ListView : AppCompatActivity() {
    //Tag to the  listView widget
    lateinit var listView:ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        //view identification
        listView=findViewById(R.id.listViewDefault)

        //reference to our item
        val technologyList : Array<String> = resources.getStringArray(R.array.technology_list)
        //reference to the array adapter class which will enable us to set up our items on a list display
        val arrayAdapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,technologyList)

        //map items to list view
        listView.adapter = arrayAdapter

        //set a click listener on the items
        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->

        //control flows for item clicks

            if (position == 0){
                //intent for email
                val address = "vicmuchina1234@gmail.com"
                val subject = "the app is awesome"
                val intent = Intent(Intent.ACTION_SENDTO)

                intent.data = Uri.parse("mailto:")//only mail apps should handle this
                intent.putExtra(Intent.EXTRA_EMAIL, address)
                intent.putExtra(Intent.EXTRA_SUBJECT, subject)


                if (intent.resolveActivity(packageManager)  != null){
                    startActivity(intent)
                    Log.d("email",""+subject)
                }


            }else if (position == 1){
                //intent for phone
                val dialIntent = Intent(Intent.ACTION_DIAL)
                dialIntent.data = Uri.parse("tel:" + "0797389366")
                startActivity(dialIntent)


            }else if (position == 2){
                //intent for web
                val url = "https://www.youtube.com/watch?v=KrMh5bFNwbQ"
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(url)

                startActivity(intent)

            }else if (position == 3){
                //intent for toast
                Toast.makeText(this,"list view clicks works",Toast.LENGTH_LONG).show()

            }else if (position == 4){
                //custom list View
                val intent = Intent(this@ListView,CustomListView::class.java)
                startActivity(intent)
            }

        }

    }
}