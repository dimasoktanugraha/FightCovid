package com.modtion.fightcovid.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.modtion.fightcovid.R
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash)

        val scaleUp : Animation = AnimationUtils.loadAnimation(applicationContext,
            R.anim.splash_scale_up
        )
        Handler().postDelayed({
            splash_title.startAnimation(scaleUp)
            splash_title.visibility = View.VISIBLE

            Handler().postDelayed({
                startActivity(Intent(this, LoginActivity::class.java))
                overridePendingTransition(
                    R.anim.slide_up_2,
                    R.anim.slide_up
                )
                finish()
            },2000)
        },500)
    }
}
