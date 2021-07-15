package com.example.myapplication

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.PermissionChecker.PERMISSION_GRANTED
import com.google.android.gms.location.*
import kotlinx.android.synthetic.main.activity_location.*
import java.util.*

class Location : AppCompatActivity() {

    val PERMISSION_ID = 10001
    lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    lateinit var locationRequest: LocationRequest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)

        //initializing the location provider
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

        buttonLocation.setOnClickListener {

            Log.d("debug", checkPermission().toString())
            Log.d("debug" , isLocationEnabled().toString())

            requestPermission()

            getLastLocation()
        }
    }

    //getting users last known location
    private fun getLastLocation() {

        if(checkPermission()){

            if (isLocationEnabled()){

                fusedLocationProviderClient.lastLocation
                    .addOnCompleteListener {
                        //picking result
                        var location : Location? = it.result

                        if (location == null){

                            newLocationData()

                        }else{
                            Log.d("Debug", "your location" + location.longitude + location.latitude)
                            textViewLocation.text ="Your location is: lon : "+ location.longitude + " ,lat: " + location.latitude +
                                    "\n" + getCityName(location.latitude,location.longitude)
                        }

                    }

            }else{
                Toast.makeText(applicationContext,"Turn your device location on",Toast.LENGTH_LONG).show()
            }

        }else{
            requestPermission()

        }

    }


    //fetching users new location
    fun newLocationData(){

        var locationRequest = LocationRequest()
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        locationRequest.interval = 9000
        locationRequest.fastestInterval = 0
        locationRequest.numUpdates = 1

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        fusedLocationProviderClient!!.requestLocationUpdates(
            locationRequest,locationCallback, Looper.myLooper()
        )
    }

    private var locationCallback = object : LocationCallback(){

        override fun onLocationResult(locationResult: LocationResult) {

            var lastlocation : Location = locationResult.lastLocation

            Log.d("debug","your last location: " + lastlocation.longitude.toString() + lastlocation.latitude.toString())

            textViewLocation.text ="Your location is: lon : "+ lastlocation.longitude + " ,lat: " + lastlocation.latitude +
                    "\n" + getCityName(lastlocation.latitude,lastlocation.longitude)
        }


    }


    //check permission for location from user
    fun checkPermission():Boolean {

        //true if permission is active,false if not

        if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_COARSE_LOCATION)
            == PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_GRANTED) {

                return true

        }
        return false


    }
    //function to request permission from user
    fun requestPermission() {


        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.ACCESS_FINE_LOCATION),PERMISSION_ID)

    }


    //checking if location is enabled
    fun isLocationEnabled(): Boolean {

        //state of the location services
        //if gps pr network provider is enabled then return if not false

        var locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager

        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
    }


    private fun getCityName(latitude : Double, longitude :Double): String{

        var cityName : String = ""
        var countryName = ""
        var fullAddress = ""

        //initialize GeoCoder reference
        var geoCoder = Geocoder(this, Locale.getDefault())

        //full address
        var address = geoCoder.getFromLocation(latitude,longitude,10)

        cityName = address.get(0).locality
        countryName = address.get(0).countryName
        fullAddress = address?.get(0)?.getAddressLine(0)!!

        Toast.makeText(applicationContext,"Full adress" + fullAddress,Toast.LENGTH_LONG).show()

        return fullAddress


    }
}