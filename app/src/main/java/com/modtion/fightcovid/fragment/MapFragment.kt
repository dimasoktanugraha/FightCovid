package com.modtion.fightcovid.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.modtion.fightcovid.R
import com.modtion.fightcovid.model.Province
import com.modtion.fightcovid.model.ProvinceAttribut
import com.modtion.fightcovid.model.ProvinceData
import com.modtion.fightcovid.response.StatusResponse
import com.modtion.fightcovid.viewmodel.HomeViewModel
import com.modtion.fightcovid.viewmodel.MapViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class MapFragment: Fragment() {

    private lateinit var viewModel: MapViewModel
    private var provinceList: MutableList<ProvinceData> = mutableListOf()
//    private var provinceList: List<ProvinceData> = ArrayList()

    companion object{
        fun newInstance() : MapFragment{
            return MapFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?  = inflater.inflate(R.layout.fragment_map, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MapViewModel::class.java]
        viewModel.getDataProvince().observe(requireActivity(), Observer { data ->
            if (data != null) {
                when (data.status) {
                    StatusResponse.LOADING -> {

                    }
                    StatusResponse.SUCCESS -> {
                        if(data.body!=null){
                            initData(data.body)
                        }
                    }
                    StatusResponse.EMPTY -> {

                    }
                    StatusResponse.ERROR -> {
                        Toast.makeText(activity, data.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }

    private fun initData(body: List<ProvinceAttribut>) {
        provinceList.clear()
        val mapFull = resources.obtainTypedArray(R.array.maps_full)
        val mapDetail = resources.obtainTypedArray(R.array.maps_detail)
        for (i in body.indices){
            provinceList.add(
                ProvinceData(
                    body[i].attributes.Provinsi,
                    mapFull.getResourceId(i,0),
                    mapDetail.getResourceId(i,0),
                    body[i].attributes.Kasus_Posi,
                    body[i].attributes.Kasus_Semb,
                    body[i].attributes.Kasus_Meni))
        }
        mapFull.recycle()
        mapDetail.recycle()
    }
}