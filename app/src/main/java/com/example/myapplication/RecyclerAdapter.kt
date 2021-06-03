package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycle_item.view.*

class RecyclerAdapter(private val itemList: List<RecyclerViewModel>): RecyclerView.Adapter<RecyclerAdapter.MyRecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRecyclerViewHolder {

        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.recycle_item , parent ,false)

        return MyRecyclerViewHolder(inflater)
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: RecyclerAdapter.MyRecyclerViewHolder, position: Int) {

        val items = itemList[position]

        //set the data
        holder.image.setImageResource(items.imageResource)
        holder.title.text = items.title
        holder.description.text = items.description

        //functions to the views
//        holder.imageView.setOnClickListener {

//           Toast.makeText(this,"title",Toast.LENGTH_SHORT).show())
//        }

    }


    //creating the view holder class to enable me to reference the views in the recycled item

    class MyRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val image: ImageView = itemView.recyclerImage
        val title: TextView = itemView.title
        val description: TextView = itemView.description
    }
}