package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        //setting my list items for the recycler views

        val listRecycler= generateDummyList()

        //reference the recycler view widget and set the adapter to it
        recyclerView.adapter = RecyclerAdapter(listRecycler)

        //give your recycler items a view group
        recyclerView.layoutManager = LinearLayoutManager(this)

        //set a fixed item size
        recyclerView.setHasFixedSize(true)

    }

    private fun generateDummyList(): List<RecyclerViewModel> {

        //array list is used to store dynamically sized collection of elements
        val list = ArrayList<RecyclerViewModel>()


        list.add(
                RecyclerViewModel(
                        R.drawable.mercedes ,
                        "Mercedes",
                        "Ranks first ,five years in a row"

                )

        )

        list.add(
                RecyclerViewModel(
                      R.mipmap.redbull,
                    "Redbull",
                "Ranks second ,fans favourite"

                )

        )
        list.add(
            RecyclerViewModel(
                R.mipmap.renault,
                "Alpine Renault",
                "Always first runners up,please don't pull out of F1 you make the difference"

            )

        )

        list.add(
                RecyclerViewModel(
                        R.drawable.astonmartin,
                        "Aston Martin",
                        "The beautiful one"

                )

        )

        list.add(
                RecyclerViewModel(
                        R.drawable.honda,
                        "Honda",
                        "Upcoming"

                )

        )

        list.add(
                RecyclerViewModel(
                        R.mipmap.ferrari,
                        "Ferrari",
                        "Lucky,old than gold"

                )

        )
        list.add(
            RecyclerViewModel(
                R.drawable.mclaren,
                "Mclareen",
                "How is this one not on top?"

            )

        )
        list.add(
            RecyclerViewModel(
                R.mipmap.alpharomeo,
                "Alpha Romeo",
                "How can we forget you?"

            )

        )


        //return the list

        return list


    }
}