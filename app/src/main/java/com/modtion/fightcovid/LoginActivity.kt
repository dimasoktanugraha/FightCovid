package com.modtion.fightcovid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.datepicker.MaterialDatePicker
import kotlinx.android.synthetic.main.activity_login.*
import java.text.SimpleDateFormat
import java.util.*

class LoginActivity : AppCompatActivity() {

    private var isRegister: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_move.setOnClickListener {
            if (isRegister){
                uiLogin()
            }else{
                uiRegister()
            }
        }

        login_edt_date.setOnClickListener {
            showDate()
        }
    }

    private fun showDate() {
        val builder : MaterialDatePicker.Builder<*> = MaterialDatePicker.Builder.datePicker()
        builder.setTitleText("Set Your Birthday")
        val picker : MaterialDatePicker<*> = builder.build()
        picker.show(supportFragmentManager, picker.toString())

        picker.addOnPositiveButtonClickListener {
            val sdf = SimpleDateFormat("MM/dd/yyyy")
            val netDate = Date(it.toString().toLong())
            login_edt_date.setText(sdf.format(netDate).toString())
        }
    }

    private fun uiRegister() {
        isRegister = true

        login_name.visibility = View.VISIBLE
        login_date.visibility = View.VISIBLE
        login_move_desc.text = "Already have an account? "
        login_move.text = "Login"
    }

    private fun uiLogin() {
        isRegister = false

        login_name.visibility = View.GONE
        login_date.visibility = View.GONE
        login_move_desc.text = "Don't you have an account? "
        login_move.text = "Register"
    }
}
