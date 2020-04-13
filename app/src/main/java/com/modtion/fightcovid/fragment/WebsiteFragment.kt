package com.modtion.fightcovid.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.modtion.fightcovid.R
import com.modtion.fightcovid.activity.WebsiteActivity
import com.modtion.fightcovid.adapter.WebAdapter
import com.modtion.fightcovid.model.WebModel
import kotlinx.android.synthetic.main.fragment_web.*

class WebsiteFragment: Fragment() {

    private var provinceList: MutableList<WebModel> = mutableListOf()
    private var cityList: MutableList<WebModel> = mutableListOf()

    companion object{
        fun newInstance() : MapFragment{
            return MapFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?  = inflater.inflate(R.layout.fragment_web, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initProvince()
    }

    private fun initProvince() {
        val province = resources.getStringArray(R.array.web_province_name)
        val provWeb = resources.getStringArray(R.array.web_province)
        provinceList.clear()
        for (i in province.indices) {
            provinceList.add(WebModel(province[i], provWeb[i]))
        }

        rv_province.layoutManager = LinearLayoutManager(activity)
        rv_province.setHasFixedSize(true)
        rv_province.adapter = WebAdapter(provinceList){
            startActivity(Intent(activity, WebsiteActivity::class.java).putExtra(WebsiteActivity.WEB_URL, it.website))
        }

        intCity()
    }

    private fun intCity() {
        val city = resources.getStringArray(R.array.web_city_name)
        val cityWeb = resources.getStringArray(R.array.web_city)
        cityList.clear()
        for (i in city.indices) {
            provinceList.add(WebModel(city[i], cityWeb[i]))
        }

        rv_district.layoutManager = LinearLayoutManager(activity)
        rv_district.setHasFixedSize(true)
        rv_district.adapter = WebAdapter(provinceList){
            startActivity(Intent(activity, WebsiteActivity::class.java).putExtra(WebsiteActivity.WEB_URL, it.website))
        }
    }
}