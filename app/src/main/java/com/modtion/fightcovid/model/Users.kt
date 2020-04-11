package com.modtion.fightcovid.model

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Users(
    var uid: String? = "",
    var username: String? = "",
    var email: String? = "",
    var birth: String? = "",
    var age: String? = "",
    var image: String? = "",
    var status: String? = ""
)
//class Users{
//    private var uid: String = ""
//    private var username: String = ""
//    private var email: String = ""
//    private var birth: String = ""
//    private var age: String = ""
//    private var image: String = ""
//    private var status: String  = ""
//
//    constructor(
//        uid: String,
//        username: String,
//        email: String,
//        birth: String,
//        age: String,
//        image: String,
//        status: String
//    ) {
//        this.uid = uid
//        this.username = username
//        this.email = email
//        this.birth = birth
//        this.age = age
//        this.image = image
//        this.status = status
//    }
//
//    fun setUID(uid: String){
//        this.uid = uid
//    }
//
//    fun getUID(): String? = uid
//
//    fun setUsername(username: String){
//        this.username = username
//    }
//
//    fun getUsername(): String? = username
//
//    fun setEmail(email: String){
//        this.email = email
//    }
//
//    fun getEmail(): String? = email
//
//    fun setBirth(birth: String){
//        this.birth = birth
//    }
//
//    fun getbirth(): String? = birth
//
//    fun setAge(age: String){
//        this.age = age
//    }
//
//    fun getAge(): String? = age
//
//    fun setImage(image: String){
//        this.image = image
//    }
//
//    fun getImage(): String? = image
//
//    fun setStatus(status: String){
//        this.status = status
//    }
//
//    fun getStatus(): String? = status
//}

