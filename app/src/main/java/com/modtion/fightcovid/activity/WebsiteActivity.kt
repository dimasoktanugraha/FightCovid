package com.modtion.fightcovid.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.modtion.fightcovid.R
import com.modtion.fightcovid.adapter.WebAdapter
import com.modtion.fightcovid.model.WebModel
import kotlinx.android.synthetic.main.fragment_web.*

class WebsiteActivity : AppCompatActivity() {

    private var provinceList: MutableList<WebModel> = mutableListOf()
    private var cityList: MutableList<WebModel> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_website)

        initProvince()
    }

    private fun initProvince() {
        val province = resources.getStringArray(R.array.web_province_name)
        val provWeb = resources.getStringArray(R.array.web_province)
        provinceList.clear()
        for (i in province.indices) {
            provinceList.add(WebModel(province[i], provWeb[i]))
        }

        rv_province.layoutManager = LinearLayoutManager(this)
        rv_province.setHasFixedSize(true)
        rv_province.adapter = WebAdapter(provinceList){

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

        rv_district.layoutManager = LinearLayoutManager(this)
        rv_district.setHasFixedSize(true)
        rv_district.adapter = WebAdapter(provinceList){

        }
    }
}
