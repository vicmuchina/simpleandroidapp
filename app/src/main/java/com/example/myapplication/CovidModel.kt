package com.example.myapplication

data class CovidModel(val id: String, val countryName: String,
                      val countryNewCases: Int, val countryTotalCases: Int,
                      val countryNewRec: Int,val countryTotalRec: Int,
                      val countryNewDeath: Int,val countryTotalDeath: Int,
                      val updateDate: String
                      ) {
}