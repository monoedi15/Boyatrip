package com.faberhurt.boyatrip_fragment.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.faberhurt.boyatrip_fragment.model.SitiosInteres
import com.faberhurt.boyatrip_fragment.model.SitiosInteresItem
import com.google.gson.Gson
import java.io.InputStream

class ListViewModel: ViewModel(){

    private var lugaresLoad : MutableLiveData<ArrayList<SitiosInteresItem>> = MutableLiveData()
    val onLugaresLoaded : LiveData<ArrayList<SitiosInteresItem>> = lugaresLoad


    fun LoadMockListaLugaresFromJson(lugaresInteresString: InputStream?) {
        val lugarInteresString =lugaresInteresString?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        lugaresLoad.value = gson.fromJson(lugarInteresString, SitiosInteres::class.java)
    }
}