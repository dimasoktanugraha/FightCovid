package com.modtion.fightcovid.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.modtion.fightcovid.R
import com.modtion.fightcovid.activity.LoginActivity
import com.modtion.fightcovid.model.Users
import com.modtion.fightcovid.response.StatusResponse
import com.modtion.fightcovid.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment: Fragment() {

    var refUser: DatabaseReference? = null
    var firebaseUser: FirebaseUser? = null
    private lateinit var viewModel: HomeViewModel

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

        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[HomeViewModel::class.java]
        home_progress.visibility = View.VISIBLE
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
            run {
                if (data != null) {
                    when (data.status) {
                        StatusResponse.LOADING -> {

                        }
                        StatusResponse.SUCCESS -> {
                            val indoData = data.body!![0]
                            indo_death.text = indoData.meninggal
                            indo_heal.text = indoData.sembuh
                            indo_positif.text = indoData.positif
                            val total = indoData.meninggal.toInt()+indoData.sembuh.toInt()+indoData.positif.toInt()
                            indo_total.text = total.toString()

                            getDataGlobal()
                        }
                        StatusResponse.EMPTY -> {

                        }
                        StatusResponse.ERROR -> {

                        }
                    }
                }
            }
        })
    }

    private fun getDataGlobal() {
        viewModel.getPositif().observe(requireActivity(), Observer { data ->
            run {
                if (data != null) {
                    when (data.status) {
                        StatusResponse.LOADING -> {

                        }
                        StatusResponse.SUCCESS -> {
                            global_positif.text = data.body!!.value
                        }
                        StatusResponse.EMPTY -> {

                        }
                        StatusResponse.ERROR -> {

                        }
                    }
                }
            }
        })

        viewModel.getRecovered().observe(requireActivity(), Observer { data ->
            run {
                if (data != null) {
                    when (data.status) {
                        StatusResponse.LOADING -> {

                        }
                        StatusResponse.SUCCESS -> {
                            global_heal.text = data.body!!.value
                        }
                        StatusResponse.EMPTY -> {

                        }
                        StatusResponse.ERROR -> {

                        }
                    }
                }
            }
        })

        viewModel.getDied().observe(requireActivity(), Observer { data ->
            run {
                if (data != null) {
                    when (data.status) {
                        StatusResponse.LOADING -> {

                        }
                        StatusResponse.SUCCESS -> {
                            global_death.text = data.body!!.value
                        }
                        StatusResponse.EMPTY -> {

                        }
                        StatusResponse.ERROR -> {

                        }
                    }
                }
            }
        })
    }
}