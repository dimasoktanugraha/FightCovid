package com.modtion.fightcovid.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.modtion.fightcovid.R
import com.modtion.fightcovid.model.ProvinceAttribut
import com.modtion.fightcovid.model.ProvinceData
import com.modtion.fightcovid.response.StatusResponse
import com.modtion.fightcovid.viewmodel.MapViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_map.*

class MapFragment: Fragment() {

    private lateinit var viewModel: MapViewModel
    private var provinceList: MutableList<ProvinceData> = mutableListOf()
    private var dataSize = 0
    private var dataCount = 0
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
                        progress_map.visibility = View.VISIBLE
                    }
                    StatusResponse.SUCCESS -> {
                        progress_map.visibility = View.GONE
                        if(data.body!=null){
                            initData(data.body)
                        }
                    }
                    StatusResponse.EMPTY -> {
                        progress_map.visibility = View.GONE
                    }
                    StatusResponse.ERROR -> {
                        progress_map.visibility = View.GONE
                        Toast.makeText(activity, data.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })

        map_previous.setOnClickListener {
            dataCount--
            if (dataCount==-1){
                dataCount=dataSize-1
            }
            setData()
        }

        map_next.setOnClickListener {
            dataCount++
            if (dataCount==dataSize){
                dataCount=0
            }
            setData()
        }
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

        dataSize = provinceList.size
        setData()
    }

    private fun setData() {
        map_top.setImageResource(provinceList[dataCount].mapFull)
        map_detail.setImageResource(provinceList[dataCount].mapDetail)
        map_name.text = provinceList[dataCount].name
        province_heal.text = provinceList[dataCount].recovered.toString()
        province_positif.text = provinceList[dataCount].positif.toString()
        province_died.text = provinceList[dataCount].died.toString()
    }
}