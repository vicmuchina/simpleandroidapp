package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.covid_item.view.*

class CovidAdapter(private val context: Context,private val covidList: List<CovidModel>) : RecyclerView.Adapter<CovidAdapter.CovidViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CovidViewHolder {
     val inflater = LayoutInflater.from(parent.context).inflate(
         R.layout.covid_item,parent,false

     )
        return CovidAdapter.CovidViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: CovidViewHolder, position: Int) {
      //tag to reference the position based off the model
        val items = covidList[position]
        //bind or set data
        holder.country.text = "Country: " + items.countryName
        holder.c_newDeath.text = "New Deaths: " + items.countryNewDeath
        holder.c_totalDeath.text = "Total Deaths: " + items.countryTotalDeath
        holder.c_newRec.text = "New Recoveries: " + items.countryNewRec
        holder.c_totalRec.text = "Total Recoveries: " + items.countryNewRec
        holder.c_newcases.text = "New Cases: " + items.countryNewCases
        holder.c_totalcases.text = "Total Cases: " + items.countryTotalCases
        holder.infoDate.text = "Update Time: " + items.updateDate
    }

    override fun getItemCount() = covidList.size
    //define the viewholder

    class  CovidViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val country: TextView =view.coronaCountry
        val c_newcases: TextView = view.newcases
        val c_totalcases: TextView = view.totalcases
        val c_newRec: TextView = view.newrecoveries
        val c_totalRec: TextView = view.totalrecoveries
        val c_newDeath: TextView = view.newdeaths
        val c_totalDeath: TextView = view.totaldeaths
        val infoDate : TextView = view.updateTime
    }
}