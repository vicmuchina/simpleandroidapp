package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider


class FragmentViewModelB : Fragment() {

    //this fragment will receive data from fragment view model B
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_model_b, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        val editText = view.findViewById<TextView>(R.id.sharedText)

        //calling method to observe the changes in the method shared in the shared view model member
        //function
        //message is the variable storing live data

        model.message.observe(viewLifecycleOwner, Observer {

            //it refers to the string/data passed  in the method
            //setting text to text view by use of android extension

            editText.text = it

        })




    }


}