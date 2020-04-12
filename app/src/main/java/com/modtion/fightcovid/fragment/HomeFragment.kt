package com.modtion.fightcovid.fragment

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.os.Looper
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.google.android.gms.location.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.modtion.fightcovid.R
import com.modtion.fightcovid.activity.LoginActivity
import com.modtion.fightcovid.model.Users
import com.modtion.fightcovid.response.StatusResponse
import com.modtion.fightcovid.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*

class HomeFragment: Fragment() {

    var refUser: DatabaseReference? = null
    var firebaseUser: FirebaseUser? = null
    private lateinit var viewModel: HomeViewModel

    private val permissions = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION)
    private val PERMISSION_ID = 10
    private var lat: Double = 0.0
    private var long: Double = 0.0
    lateinit var mFusedLocationClient: FusedLocationProviderClient

    var positifGlobal = ""
    var sembuhGlobal = ""
    var matiGlobal = ""

    companion object{
        fun newInstance() : HomeFragment{
            return HomeFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())
        getLastLocation()

        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[HomeViewModel::class.java]
        home_progress.visibility = View.VISIBLE
        indo_container.visibility = View.GONE
        all_container.visibility = View.GONE
        home_shimmer.startShimmerAnimation()

        firebaseUser = FirebaseAuth.getInstance().currentUser
        refUser = FirebaseDatabase.getInstance().reference.child("Users").child(firebaseUser!!.uid)
        refUser!!.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                home_progress.visibility = View.GONE
                Toast.makeText(activity, p0.toException().toString()+"/"+p0.message, Toast.LENGTH_SHORT).show()
            }

            override fun onDataChange(p0: DataSnapshot) {
                home_progress.visibility = View.GONE

                if (p0.exists()){
                    val user: Users? = p0.getValue(Users::class.java)

                    home_name.text = user!!.username
                    home_age.text = user.age
                    home_status.text = user.status
                    Glide.with(activity!!)
                        .load(user.image)
                        .placeholder(R.drawable.bg_circle_gray)
                        .error(R.drawable.bg_circle_gray)
                        .fallback(R.drawable.bg_circle_gray)
                        .circleCrop()
                        .into(home_image)
                }

                getData()
            }
        })



        home_logout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(activity, LoginActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK))
            activity!!.finish()
        }
    }

    private fun getData() {
        viewModel.getDataIndonesia().observe(requireActivity(), Observer { data ->
            if (data != null) {
                when (data.status) {
                    StatusResponse.LOADING -> {

                    }
                    StatusResponse.SUCCESS -> {

                        val indoData = data.body!![0]

                        var positif = indoData.positif
                        var sembuh = indoData.sembuh
                        var mati = indoData.meninggal

                        if (positif.contains(",")){
                            positif = positif.replace(",","",false)
                        }
                        if (sembuh.contains(",")){
                            sembuh = sembuh.replace(",","",false)
                        }
                        if (mati.contains(",")){
                            mati = mati.replace(",","",false)
                        }

                        indo_death.text = mati
                        indo_heal.text = sembuh
                        indo_positif.text = positif

                        val total = mati.toInt()+sembuh.toInt()+positif.toInt()
                        indo_total.text = total.toString()

                        getDataGlobalPositif()
                    }
                    StatusResponse.EMPTY -> {

                    }
                    StatusResponse.ERROR -> {
                        Toast.makeText(activity, data.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }

    private fun getDataGlobalPositif() {
        viewModel.getPositif().observe(requireActivity(), Observer { data ->
            if (data != null) {
                when (data.status) {
                    StatusResponse.LOADING -> {

                    }
                    StatusResponse.SUCCESS -> {
                        positifGlobal = data.body!!.value
                        if (positifGlobal.contains(",")){
                            positifGlobal = positifGlobal.replace(",","")
                        }
                        global_positif.text = positifGlobal

                        getDataGlobalRecovered()
                    }
                    StatusResponse.EMPTY -> {

                    }
                    StatusResponse.ERROR -> {
                        Toast.makeText(activity, data.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }

    private fun getDataGlobalRecovered() {
        viewModel.getRecovered().observe(requireActivity(), Observer { data ->
            if (data != null) {
                when (data.status) {
                    StatusResponse.LOADING -> {

                    }
                    StatusResponse.SUCCESS -> {
                        sembuhGlobal = data.body!!.value
                        if (sembuhGlobal.contains(",")){
                            sembuhGlobal = sembuhGlobal.replace(",","")
                        }
                        global_heal.text = sembuhGlobal
                        getDataGlobalDied()
                    }
                    StatusResponse.EMPTY -> {

                    }
                    StatusResponse.ERROR -> {
                        Toast.makeText(activity, data.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }

    private fun getDataGlobalDied() {
        viewModel.getDied().observe(requireActivity(), Observer { data ->
            if (data != null) {
                when (data.status) {
                    StatusResponse.LOADING -> {

                    }
                    StatusResponse.SUCCESS -> {
                        indo_container.visibility = View.VISIBLE
                        all_container.visibility = View.VISIBLE

                        matiGlobal = data.body!!.value
                        if (matiGlobal.contains(",")){
                            matiGlobal = matiGlobal.replace(",","")
                        }
                        global_death.text = matiGlobal

                        val total = matiGlobal.toInt()+sembuhGlobal.toInt()+positifGlobal.toInt()
                        global_total.text = total.toString()

                        home_shimmer.stopShimmerAnimation()
                        home_shimmer.visibility = View.GONE
                    }
                    StatusResponse.EMPTY -> {

                    }
                    StatusResponse.ERROR -> {
                        Toast.makeText(activity, data.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }

    //  LOCATION SECTION CODE
    @SuppressLint("MissingPermission")
    private fun getLastLocation() {
        if (checkPermissions()) {
            if (isLocationEnabled()) {

                mFusedLocationClient.lastLocation.addOnCompleteListener(requireActivity()) { task ->
                    var location: Location? = task.result
                    if (location == null) {
                        requestNewLocationData()
                    } else {
                        lat = location.latitude
                        long = location.longitude
                        getAddress(lat, long)
                    }
                }
            } else {
                Toast.makeText(activity, "Turn on location", Toast.LENGTH_LONG).show()
                val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                startActivity(intent)
            }
        } else {
            requestPermissions()
        }
    }

    override fun onResume() {
        super.onResume()
        getLastLocation()
    }

    @SuppressLint("MissingPermission")
    private fun requestNewLocationData() {
        var mLocationRequest = LocationRequest()
        mLocationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        mLocationRequest.interval = 0
        mLocationRequest.fastestInterval = 0
        mLocationRequest.numUpdates = 1

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())
        mFusedLocationClient.requestLocationUpdates(
            mLocationRequest, mLocationCallback,
            Looper.myLooper()
        )
    }

    private val mLocationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {
            var mLastLocation: Location = locationResult.lastLocation
            lat = mLastLocation.latitude
            long = mLastLocation.longitude
            getAddress(lat, long)
        }
    }

    private fun checkPermissions(): Boolean {
        if (ActivityCompat.checkSelfPermission(requireActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(requireActivity(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            return true
        }
        return false
    }

    private fun requestPermissions() {
        ActivityCompat.requestPermissions(requireActivity(), permissions,PERMISSION_ID)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        if (requestCode == PERMISSION_ID) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                getLastLocation()
            }
        }
    }

    private fun isLocationEnabled(): Boolean {
        var locationManager: LocationManager = requireActivity().getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
            LocationManager.NETWORK_PROVIDER
        )
    }

    private fun getAddress(latitude: Double, longitude: Double) {

        val geocoder = Geocoder(requireActivity(), Locale.getDefault())
        val addresses: List<Address>?
        val address: Address?
        var fulladdress = ""

        addresses = geocoder.getFromLocation(latitude, longitude, 1)
//        Toast.makeText(this, addresses.toString(), Toast.LENGTH_LONG).show()
        if (addresses.isNotEmpty()) {
            address = addresses[0]
            fulladdress = address.getAddressLine(0) // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex
            var city = address.getLocality();
            var state = address.getAdminArea();
            var country = address.getCountryName();
            var postalCode = address.getPostalCode();
            var knownName = address.getFeatureName(); // Only if available else return NULL
            home_loc.text = state + ", " + country
        }else{
            home_loc.text = "Location not found"
        }
    }
}