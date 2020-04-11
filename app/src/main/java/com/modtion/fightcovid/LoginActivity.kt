package com.modtion.fightcovid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_login.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashMap

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var refUser: DatabaseReference
    private var firebaseUserID: String = ""

    private var age: Int = 0
    private var date: String = ""
    private var isRegister: Boolean = true

    override fun onStart() {
        super.onStart()
        if (auth.currentUser!=null){
            startActivity(Intent(this, MainActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK))
            finish()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

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

        if (inRegister){
            when{
                email.isEmpty() -> {
                    login_email.error = "Require your email"
                    return
                }
                username.isEmpty() -> {
                    login_name.error = "Require username"
                    return
                }
                password.isEmpty() -> {
                    login_password.error = "Require password"
                    return
                }
                date.isEmpty() -> {
                    login_date.error = "Require your birthday"
                    return
                }
                else ->{
                    clearError()
                    register(username, email, password)
                }
            }
        }else{
            when{
                email.isEmpty() -> {
                    login_email.error = "Require your email"
                    return
                }
                password.isEmpty() -> {
                    login_password.error = "Require password"
                    return
                }
                else ->{
                    clearError()
                    login(email, password)
                }
            }
        }

    }

    private fun clearError(){
        login_email.error = null
        login_name.error = null
        login_password.error = null
        login_date.error = null
    }

    private fun clearData(){
        login_edt_email.setText("")
        login_edt_name.setText("")
        login_edt_password.setText("")
        login_edt_date.setText("")
    }

    private fun showProgress(){
        login_progress.visibility = View.VISIBLE
        login_btn_executer.text = ""
        login_btn_executer.isEnabled = false
    }

    private fun hideProgress(text: String){
        login_progress.visibility = View.GONE
        login_btn_executer.text = text
        login_btn_executer.isEnabled = true
    }

    private fun register(username: String, email: String, password: String) {
        showProgress()
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful){
                    firebaseUserID = auth.currentUser!!.uid

                    refUser = FirebaseDatabase.getInstance().reference.child("Users").child(firebaseUserID)
                    val userHashMap = HashMap<String, Any>()
                    userHashMap["uid"] = firebaseUserID
                    userHashMap["username"] = username
                    userHashMap["email"] = email
                    userHashMap["birth"] = date
                    userHashMap["age"] = age.toString()
                    userHashMap["image"] = "https://firebasestorage.googleapis.com/v0/b/covid-19-dc148.appspot.com/o/profile.png?alt=media&token=04a69209-0ebb-4a48-b27d-01a4e77c53d5"
                    userHashMap["status"] = "no status"

                    refUser.updateChildren(userHashMap)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful){
                                hideProgress("")
                                uiLogin()
                            }else{
                                hideProgress("REGISTER")
                                Toast.makeText(this, "insert failed : "+task.exception!!.message, Toast.LENGTH_SHORT).show()
                            }
                        }

                }else{
                    hideProgress("REGISTER")
                    Toast.makeText(this, "register failed : "+task.exception!!.message, Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun login(email: String, password: String) {
        showProgress()
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful){
                    hideProgress("LOGIN")
                    startActivity(Intent(this, MainActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK))
                    finish()
                }else{
                    hideProgress("LOGIN")
                    Toast.makeText(this, "login failed : "+task.exception!!.message, Toast.LENGTH_SHORT).show()
                }
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

            val calBirth = Calendar.getInstance()
            calBirth.time = netDate

            val calToday = Calendar.getInstance()
            age = calToday.get(Calendar.YEAR) - calBirth.get(Calendar.YEAR)
            if (calToday.get(Calendar.DAY_OF_YEAR) < calBirth.get(Calendar.DAY_OF_YEAR))
                age--

            date = sdf.format(netDate).toString()
            login_edt_date.setText(date)
        }
    }

    private fun uiRegister() {
        isRegister = true
        clearData()
        login_name.visibility = View.VISIBLE
        login_date.visibility = View.VISIBLE
        login_move_desc.text = "Already have an account? "
        login_move.text = "Login"
        login_btn_executer.text = "REGISTER"
    }

    private fun uiLogin() {
        isRegister = false
        clearData()
        login_name.visibility = View.GONE
        login_date.visibility = View.GONE
        login_move_desc.text = "Don't have an account? "
        login_move.text = "Register"
        login_btn_executer.text = "LOGIN"
    }
}
