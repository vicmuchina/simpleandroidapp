package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_shared_preferences.*

class SharedPreferences : AppCompatActivity() {

    //reference to our interface and preference manager class
    //here we lazy load our preference manager class: will only be loaded at
    //runtime when its operation is met

    private val  preferenceHelper: IPreferenceHelper
    by lazy { PreferenceManager(applicationContext) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)

        text_under.text = "User id -> ${preferenceHelper.getUserId()}" +
                "\n API KEY IS -> ${preferenceHelper.getApiKey()}"


        appCompatButton.setOnClickListener {
            //capture text and use preference manager to save details Shared Preferences
            preferenceHelper.setApiKey(apiKey.text.toString())
            preferenceHelper.setUserId(userId.text.toString())

            //display text

            text_under.text = "User id -> ${preferenceHelper.getUserId()}" +
                    "\n API KEY IS -> ${preferenceHelper.getApiKey()}"
        }
    }
}