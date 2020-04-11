package com.modtion.fightcovid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.modtion.fightcovid.fragment.MapFragment
import com.modtion.fightcovid.fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.elevation = 0.0f

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home ->{
                    loadFragment(savedInstanceState, HomeFragment())
                }
                R.id.nav_map ->{
                    loadFragment(savedInstanceState, MapFragment())
                }
            }
            true
        }
        bottom_navigation.selectedItemId = R.id.nav_home
    }

    private fun loadFragment(savedInstanceState: Bundle?, fragment: Fragment) {
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container,
                    fragment, fragment::class.java.simpleName)
                .commit()
        }
    }
}
