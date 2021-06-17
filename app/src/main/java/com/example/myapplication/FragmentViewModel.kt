package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText


class FragmentViewModel : Fragment() {

    //tag for our view model class
    lateinit var model: SharedViewModel

    //tag for our editText and button
   lateinit var textData: TextInputEditText
   lateinit var btnShare: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_model, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //view referencing
        textData = view.findViewById(R.id.textEd)
        btnShare = view.findViewById(R.id.submit)

        //using view model to share data
        model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        btnShare.setOnClickListener {

            //capture input
            //variable to store input from user
            var messageInput  = textData.text.toString()
            model.sendMessage(messageInput)



        }



    }


}