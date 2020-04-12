package com.modtion.fightcovid.model

data class ProvinceData (
    val name: String,
    val mapFull: Int,
    val mapDetail: Int,
    val positif: Int,
    val recovered: Int,
    val died: Int
)