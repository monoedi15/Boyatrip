package com.faberhurt.boyatrip_fragment.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.faberhurt.boyatrip_fragment.model.SitiosInteres
import com.faberhurt.boyatrip_fragment.model.SitiosInteresItem
import com.google.gson.Gson
import java.io.InputStream

class ListViewModel : ViewModel() {

    private var listaLugaresLoad : MutableLiveData<ArrayList<SitiosInteresItem>> = MutableLiveData()
    val onListalugaresLoaded : LiveData<ArrayList<SitiosInteresItem>> = listaLugaresLoad

    fun loadMockListaLugaresFromJson(sitiosInteresString: InputStream?) {
        val listaLugaresString = sitiosInteresString?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        listaLugaresLoad.value = gson.fromJson(listaLugaresString, SitiosInteres::class.java)

    }
}