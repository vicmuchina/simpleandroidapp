package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class CustomListView : AppCompatActivity() {

    val titles : Array<String> = arrayOf("Tone Deaf","Alfred's theme","Lose yourself","till i collapse" ," Godzilla", "Mocking Bird","Rap God","without me")
    val images : Array<Int> = arrayOf(R.drawable.emi,R.drawable.alfredstheme,R.drawable.loseyourself,R.drawable.collapse,R.drawable.godzilla,R.drawable.mockingbird,R.drawable.rapgod,R.drawable.withoutme, )


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_list_view)

        //creating reference to adapter
        val customListViewAdapter = CustomListViewAdapter(this,titles,images)
        //set the listView to use the adapter
        val listView : ListView =findViewById(R.id.CustomList)

        listView.adapter = customListViewAdapter

        //setting item click listener
        listView.setOnItemClickListener { parent, view, position, id ->

            when (position) {
                0 -> {
                    //intent for web
                    val url = "https://www.youtube.com/watch?v=qleJpzB4q7A"
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(url)

                }
                1 -> {
                    //intent for web
                    val url = "https://www.youtube.com/watch?v=RkZQzzNkcXo"
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(url)
                    startActivity(intent)
                }
                2 -> {
                    //intent for web
                    val url = "https://www.youtube.com/watch?v=_Yhyp-_hX2s"
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(url)
                    startActivity(intent)
                }
                3 -> {
                    //intent for web
                    val url = "https://www.youtube.com/watch?v=ytQ5CYE1VZw&t=34s"
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(url)
                    startActivity(intent)

                }
                4 -> {
                    //intent for web
                    val url = "https://www.youtube.com/watch?v=49OY0kV0n_M"
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(url)
                    startActivity(intent)

                }
                5 -> {
                    //intent for web
                    val url = "https://www.youtube.com/watch?v=S9bCLPwzSC0"
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(url)
                    startActivity(intent)

                }
                6 -> {
                    //intent for web
                    val url = "https://www.youtube.com/watch?v=XbGs_qK2PQA"
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(url)
                    startActivity(intent)

                }
                7 -> {
                    //intent for web
                    val url = "https://www.youtube.com/watch?v=SnwPNIDXLDQ"
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(url)
                    startActivity(intent)

                }
            }


        }

    }
}