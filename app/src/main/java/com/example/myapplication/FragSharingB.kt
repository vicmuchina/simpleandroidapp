package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class FragSharingB : Fragment() {
    lateinit var texts: TextView

    //variable to store shared data
    var messageShared: String?= ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_fragsharing_b, container, false)

        texts = view.findViewById(R.id.textShared)

        //using the arguments function to get the shared from bundle
        messageShared = arguments?.getString("sharedData")

        //set text for display in second fragment
        texts.text = messageShared

        //return view
        return view
    }


}