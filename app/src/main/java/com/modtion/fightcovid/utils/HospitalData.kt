package com.modtion.fightcovid.utils

import com.modtion.fightcovid.model.Hospital
import java.util.*
import kotlin.collections.ArrayList

class HospitalData {

    fun getHistoryList(city:String) : List<Hospital>{
        val list =  ArrayList<Hospital> ()

        when(city) {
            "Aceh" -> {
                list.add(Hospital("Rumkit Tk II Banda Aceh","Alamat Jl. T. Angkasa Bendahara, Kuta Alam, Kec. Kuta Alam, Kota Banda Aceh, Aceh 24415","Telepon (0651) 24712"))
                list.add(Hospital("RSU Dr. Zainoel Abidin Banda Aceh","Alamat Jl. Tgk. Daud Beureuh No. 108, Banda Aceh","Telepon (0651) 34562"))
                list.add(Hospital("Rumkit TK IV Meulaboh","Alamat Suwak Indrapuri, Johan Pahlawan, Kabupaten Aceh Barat, Aceh 23681", ""))
                list.add(Hospital("Rumkit Tk. IV LHokseumawe","Alamat JL. Samudera, Hagu Sel., Banda Sakti, Kota Lhokseumawe, Aceh","Telepon (0645) 40300"))
                list.add(Hospital("RSU Cut Meutia Lhokseumawe","Alamat Jl. Banda Aceh Medan KM 5 Buket Rata, Lhokseumawe","Telepon (0645) 46334"))
            }
            "Sumatera Utara" -> {

            }
        }

        return list
    }
}