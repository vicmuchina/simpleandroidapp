package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Toast

class AutoCompleteTextView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auto_complete_text_view)

        val autoTextView =findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView)
        val languages = resources.getStringArray(R.array.Languages)

        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, languages)
        //set adapter
        autoTextView.setAdapter(adapter)

        findViewById<Button>(R.id.submit)?.setOnClickListener(View.OnClickListener {
            val enteredText = getString(R.string.submitted_lang) + " " + autoTextView.getText()
            Toast.makeText(this@AutoCompleteTextView, enteredText, Toast.LENGTH_SHORT).show()
        })



    }
}