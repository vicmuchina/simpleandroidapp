package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.github.dhaval2404.imagepicker.ImagePicker
import kotlinx.android.synthetic.main.activity_post_update_delete.*
import org.json.JSONException
import org.json.JSONObject
import java.lang.Exception

class PostUpdateDelete : AppCompatActivity() {
    private var imageUri: Uri? = null
    //variables to store users input
    var textA: String =""
    var textB: String =""
    var userId  = "2"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_update_delete)

       val  mRequestQueue = Volley.newRequestQueue(this )

        imageView3.setOnClickListener {

            pickImage()

        }
        post.setOnClickListener {
            postToApi()

        }

        update.setOnClickListener {
            updateApi()

        }

        delete.setOnClickListener {
            deleteToApi()

        }

    }

    private fun deleteToApi() {
        var url = "https://postman-echo.com/delete?" + userId

        val request = StringRequest(Request.Method.DELETE,url,{ response ->

            try {
                Log.d("message" , "Response: $response")

            }catch (e : JSONException){
                Log.d("message" , "Exception : $e")

            }

        }){
            Log.d("message" , "Error: $it")
            Toast.makeText(applicationContext,"Error occured",
                    Toast.LENGTH_LONG).show()
        }
        //volley request policy ,only one time request to avoid duplicate transaction
        request.retryPolicy = DefaultRetryPolicy(
                DefaultRetryPolicy.DEFAULT_TIMEOUT_MS,
                //0 means no retry
                0,//max number of retries will be from volley
                1f //timeout

        )

        //add to request to volley using singleton class
        VolleySingleton.getInstance(this).addToRequestQueue(request)

    }

    private fun updateApi() {
        //capture user input

        textA = text_A.text.toString()
        textB = text_B.text.toString()

        //update using api
        usingApiUpdate(textA,textB,userId)


    }

    private fun usingApiUpdate(textA: String, textB: String, userId: String) {
        var url = "https://postman-echo.com/put?" + userId

        val params = HashMap<String,String>()
        params["foo1"] = textA
        params["foo2"] = textB
        val jsonObject = JSONObject(params as Map<*,*>)
        val request = JsonObjectRequest(Request.Method.PUT,url,jsonObject,
                    Response.Listener {

                          try {
                              Log.d("message" , "Response: $it")
                              Toast.makeText(this,"Update suceesful",
                                      Toast.LENGTH_LONG).show()
                          } catch (e: JSONException){

                              e.printStackTrace()
                          }


                    },Response.ErrorListener {
                    Log.d("message" , "Response: $it")
                    Toast.makeText(this,"Error, try again",
                            Toast.LENGTH_LONG).show()

             })


        //volley request policy ,only one time request to avoid duplicate transaction
        request.retryPolicy = DefaultRetryPolicy(
                DefaultRetryPolicy.DEFAULT_TIMEOUT_MS,
                //0 means no retry
                0,//max number of retries will be from volley
                1f //timeout

        )

        //add to request to volley using singleton class
        VolleySingleton.getInstance(this).addToRequestQueue(request)


    }


    private fun pickImage() {
        //using image picker

        ImagePicker.with(this)
            .crop()
            .compress(2048)//image size will be less than on mb
            .maxResultSize(1080, 1080)//dimensions of image
            .start()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK){

            //picking path of image selected
            imageUri = data?.data
            //set the image selected to imageView container

            imageView3.setImageURI(imageUri)

        }else if(resultCode == ImagePicker.RESULT_ERROR){
          Toast.makeText(this,ImagePicker.getError(data),
          Toast.LENGTH_LONG).show()

        }else{
            Toast.makeText(this,"Task cancelled",
                Toast.LENGTH_LONG).show()

        }

    }

    private fun postToApi() {

        //capture user input
        textA = text_A.text.toString()
        textB = text_B.text.toString()
        //run the actual method to submit to api
        submitToApi(textA,textB,imageUri)


    }

    private fun submitToApi(textA: String, textB: String, imageUri: Uri?) {

        //give uri to pst to
        val url = "https://postman-echo.com/post"

        //using hashmap to post my details

        val params = HashMap<String,String>()

        params["foo1"] = textA
        params["foo2"] = textB

        val jsonObject = JSONObject(params as Map<*,*>)

        val request = JsonObjectRequest(Request.Method.POST,url,jsonObject,Response.Listener {

              //capture sucess
                    try {
                        Log.d("message" , "Response :$it")
                        Toast.makeText(this,"Data posted successfully",
                            Toast.LENGTH_LONG).show()

                    } catch (e: Exception){
                        Log.d("message" , "Exception: $e")

                    }


        }, Response.ErrorListener {
            Log.d("message" , "Error :$it")
            Toast.makeText(this,"Error occured",
                Toast.LENGTH_LONG).show()

        })

        //volley request policy ,
        request.retryPolicy = DefaultRetryPolicy(
                DefaultRetryPolicy.DEFAULT_TIMEOUT_MS,
                //0 means no retry
            0,//max number of retries will be from volley
        1f //timeout

        )

            //add to request to volley using singleton class
        VolleySingleton.getInstance(this).addToRequestQueue(request)
    }

}