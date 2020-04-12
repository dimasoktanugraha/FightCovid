package com.modtion.fightcovid.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.modtion.fightcovid.model.IndonesiaCase
import com.modtion.fightcovid.model.ProvinceAttribut
import com.modtion.fightcovid.network.ApiService
import com.modtion.fightcovid.network.RetrofitClient
import com.modtion.fightcovid.response.ApiResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MapViewModel: ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    fun getDataProvince(): LiveData<ApiResponse<List<ProvinceAttribut>>> {
        val data = MutableLiveData<ApiResponse<List<ProvinceAttribut>>>()
        data.value = ApiResponse.loading(null)
        compositeDisposable.add(
            RetrofitClient.getClient().create(ApiService::class.java)
                .provinceIndonesia
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ value ->
                    data.value = ApiResponse.loading(value)
                    if (value!=null) {
                        data.setValue(ApiResponse.success(value))
                    } else {
                        data.setValue(ApiResponse.empty("null"))
                    }
                }, { throwable -> data.setValue(ApiResponse.error(throwable.localizedMessage)) })
        )
        return data
    }
}