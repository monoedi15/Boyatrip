package com.faberhurt.boyatrip_fragment.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SitiosInteresItem(
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("puntuacion")
    val puntuacion: Int,
    @SerializedName("urlpicture")
    val urlpicture: String
):Serializable
//TODO