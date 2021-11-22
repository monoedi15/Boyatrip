package com.orange.boyatrip


import com.google.gson.annotations.SerializedName

data class SitiosInteresItem(
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("puntuacion")
    val puntuacion: Int,
    @SerializedName("urlpicture")
    val urlpicture: String
)