package com.example.myapplication

import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationListener
import com.google.android.gms.location.LocationRequest

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, LocationListener, GoogleApiClient.ConnectionCallbacks,GoogleApiClient.OnConnectionFailedListener {

    private lateinit var mMap: GoogleMap //responsible for capturing users gms location
    private lateinit var mLastLocation: Location //capture users actual location
    private lateinit var mLocationResult: LocationRequest //methods to implement when location is attained
    private lateinit var mLocationCallback: LocationCallback //interface to show where the user is position
    private lateinit var mCurrentLocationMarker: Marker // connection to google map services
    private lateinit var mGoogleApiClient: GoogleApiClient //to seek permission to get map services
    private lateinit var mLocationRequest: LocationRequest //to seek permission to get users actual location
    private lateinit var mFusedLocationProviderClient: FusedLocationProviderClient  //monitor any changes in location by users

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap




//        // Add a marker in Sydney and move the camera
//        val sydney = LatLng(-34.0, 151.0)
//        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

    override fun onLocationChanged(p0: Location) {
        TODO("Not yet implemented")
    }

    override fun onConnected(p0: Bundle?) {
        TODO("Not yet implemented")
    }

    override fun onConnectionSuspended(p0: Int) {
        TODO("Not yet implemented")
    }

    override fun onConnectionFailed(p0: ConnectionResult) {
        TODO("Not yet implemented")
    }
}