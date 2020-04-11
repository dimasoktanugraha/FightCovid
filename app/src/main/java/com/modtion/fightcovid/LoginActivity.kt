package com.modtion.fightcovid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.datepicker.MaterialDatePicker
import kotlinx.android.synthetic.main.activity_login.*
import java.text.SimpleDateFormat
import java.util.*

class LoginActivity : AppCompatActivity() {

    private var age: Int = 0
    private var isRegister: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_move.setOnClickListener {
            if (isRegister) uiLogin() else uiRegister()
        }

        login_edt_date.setOnClickListener {
            showDate()
        }

        login_btn_executer.setOnClickListener {
            executeAuth(isRegister)
        }
    }

    private fun executeAuth(inRegister: Boolean) {
        val username = login_name.editText!!.text.toString().trim()
        val email = login_email.editText!!.text.toString().trim()
        val password = login_password.editText!!.text.toString().trim()
        val date = login_date.editText!!.text.toString().trim()

        when{
            email.isEmpty() -> {
                login_email.error = "Require your email"
                return
            }
            username.isEmpty() -> {
                if (inRegister){
                    login_name.error = "Require username"
                    return
                }
            }
            password.isEmpty() -> {
                login_password.error = "Require password"
                return
            }
            date.isEmpty() -> {
                if (inRegister){
                    login_date.error = "Require your birthday"
                    return
                }
            }
            else ->{
                if (inRegister){
                    register(username, email, password)
                }else{
                    login(email, password)
                }
            }
        }
    }

    private fun register(username: String, email: String, password: String) {

    }

    private fun login(email: String, password: String) {

    }

    private fun showDate() {
        val builder : MaterialDatePicker.Builder<*> = MaterialDatePicker.Builder.datePicker()
        builder.setTitleText("Set Your Birthday")
        val picker : MaterialDatePicker<*> = builder.build()
        picker.show(supportFragmentManager, picker.toString())

        picker.addOnPositiveButtonClickListener {
            val sdf = SimpleDateFormat("MM/dd/yyyy")
            val netDate = Date(it.toString().toLong())

            val calBirth = Calendar.getInstance()
            calBirth.time = netDate

            val calToday = Calendar.getInstance()
            age = calToday.get(Calendar.YEAR) - calBirth.get(Calendar.YEAR)
            if (calToday.get(Calendar.DAY_OF_YEAR) < calBirth.get(Calendar.DAY_OF_YEAR))
                age--

            login_edt_date.setText(sdf.format(netDate).toString())
            Toast.makeText(this, age.toString(), Toast.LENGTH_SHORT).show()
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
