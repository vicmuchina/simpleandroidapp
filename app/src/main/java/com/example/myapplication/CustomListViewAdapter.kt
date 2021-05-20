package com.example.myapplication

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomListViewAdapter (private val context: Activity,private val title:Array<String>,private val image:Array<Int>)
    : ArrayAdapter<String>(context,R.layout.custom_list_item,title){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // ref to inflater class
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.custom_list_item,null,true)

        //reference the view inside the custom list item
        val textTitle : TextView = rowView.findViewById(R.id.text)
        val images : ImageView = rowView.findViewById(R.id.image)

        //setting the text passed to our constructor to the view
        textTitle.text = title[position]
        images.setImageResource(image[position])

        return rowView

     }
}