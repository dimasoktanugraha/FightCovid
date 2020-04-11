package com.modtion.fightcovid.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.modtion.fightcovid.R

class HomeFragment: Fragment() {

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

//        Glide.with(this)
//            .load("https://upload.wikimedia.org/wikipedia/commons/8/87/Ahmad_Dahlan.jpg")
//            .placeholder(R.drawable.bg_circle_gray)
//            .error(R.drawable.bg_circle_gray)
//            .fallback(R.drawable.bg_circle_gray)
//            .circleCrop()
//            .into(img)
    }
}