package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class FragSharingA : Fragment() {
    //set up a tag for our communicator interface
    private lateinit var communicator: Communicator
    lateinit var editText: EditText
    lateinit var button: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_frag_sharing_a, container, false)

        //view identification
        editText=view.findViewById(R.id.editText)
        button=view.findViewById(R.id.click)

        //initializing the communicator interface
        communicator = activity as Communicator

        //set event on button click
        button.setOnClickListener {
            communicator.passData(editText.text.toString())
        }

        return view


    }


}