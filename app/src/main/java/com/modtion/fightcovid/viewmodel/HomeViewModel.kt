package com.modtion.fightcovid.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.modtion.fightcovid.model.BaseResponse
import com.modtion.fightcovid.model.IndonesiaCase
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

    fun getDataIndonesia(): LiveData<ApiResponse<List<IndonesiaCase>>> {
        val data = MutableLiveData<ApiResponse<List<IndonesiaCase>>>()
        data.value = ApiResponse.loading(null)
        compositeDisposable.add(
            RetrofitClient.getClient().create(ApiService::class.java)
                .dataIndonesia
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ value ->
                    data.value = ApiResponse.loading(value)
                    if (value!=null) {
                        data.setValue(ApiResponse.success(value))
                    } else {
                        data.setValue(ApiResponse.empty("null", value))
                    }
                }, { throwable -> data.setValue(ApiResponse.error(throwable.localizedMessage)) })
        )
        return data
    }

    fun getPositif(): LiveData<ApiResponse<BaseResponse>> {
        val data = MutableLiveData<ApiResponse<BaseResponse>>()
        data.value = ApiResponse.loading(null)
        compositeDisposable.add(
            RetrofitClient.getClient().create(ApiService::class.java)
                .globalPositif
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ value ->
                    data.value = ApiResponse.loading(value)
                    if (value!=null) {
                        data.setValue(ApiResponse.success(value))
                    } else {
                        data.setValue(ApiResponse.empty("null", value))
                    }
                }, { throwable -> data.setValue(ApiResponse.error(throwable.localizedMessage)) })
        )
        return data
    }

    fun getRecovered(): LiveData<ApiResponse<BaseResponse>> {
        val data = MutableLiveData<ApiResponse<BaseResponse>>()
        data.value = ApiResponse.loading(null)
        compositeDisposable.add(
            RetrofitClient.getClient().create(ApiService::class.java)
                .globalRecover
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ value ->
                    data.value = ApiResponse.loading(value)
                    if (value!=null) {
                        data.setValue(ApiResponse.success(value))
                    } else {
                        data.setValue(ApiResponse.empty("null", value))
                    }
                }, { throwable -> data.setValue(ApiResponse.error(throwable.localizedMessage)) })
        )
        return data
    }

    fun getDied(): LiveData<ApiResponse<BaseResponse>> {
        val data = MutableLiveData<ApiResponse<BaseResponse>>()
        data.value = ApiResponse.loading(null)
        compositeDisposable.add(
            RetrofitClient.getClient().create(ApiService::class.java)
                .globalDied
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ value ->
                    data.value = ApiResponse.loading(value)
                    if (value!=null) {
                        data.setValue(ApiResponse.success(value))
                    } else {
                        data.setValue(ApiResponse.empty("null", value))
                    }
                }, { throwable -> data.setValue(ApiResponse.error(throwable.localizedMessage)) })
        )
        return data
    }
}