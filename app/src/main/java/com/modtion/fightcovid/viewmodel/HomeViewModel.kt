package com.modtion.fightcovid.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.modtion.fightcovid.network.ApiService
import com.modtion.fightcovid.network.RetrofitClient
import com.modtion.fightcovid.response.ApiResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.*

class HomeViewModel: ViewModel() {

//    private var loginData: MutableLiveData<ApiResponse<LoginResponse>>? = null
    private val compositeDisposable = CompositeDisposable()

    fun getHome():String ="lalala"

//    fun login(body: HashMap<String?, String?>?): LiveData<ApiResponse<LoginResponse>>? {
//        loginData = MutableLiveData<ApiResponse<LoginResponse>>()
//        loginData!!.setValue(ApiResponse.loading(null))
//        compositeDisposable.add(
//            RetrofitClient.getClient().create(ApiService::class.java)
//                .login(body)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({ signIn ->
//                    loginData!!.setValue(ApiResponse.loading(signIn))
//                    if (signIn.isStatus()) {
//                        loginData!!.setValue(ApiResponse.success(signIn))
//                    } else {
//                        loginData!!.setValue(ApiResponse.empty(signIn.getMessage(), signIn))
//                    }
//                }, { throwable -> loginData!!.setValue(ApiResponse.error(throwable.getMessage())) })
//        )
//        return loginData
//    }
}