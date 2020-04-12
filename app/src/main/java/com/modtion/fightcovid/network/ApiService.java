package com.modtion.fightcovid.network;


import com.modtion.fightcovid.model.BaseResponse;
import com.modtion.fightcovid.model.IndonesiaCase;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface ApiService {

    @GET("indonesia")
    Observable<List<IndonesiaCase>> getDataIndonesia();

    @GET("positif")
    Observable<BaseResponse> getGlobalPositif();

    @GET("sembuh")
    Observable<BaseResponse> getGlobalRecover();

    @GET("meninggal")
    Observable<BaseResponse> getGlobalDied();

}

