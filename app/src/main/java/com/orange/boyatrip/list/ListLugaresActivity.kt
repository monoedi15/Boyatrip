package com.orange.boyatrip.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.orange.boyatrip.R
import com.orange.boyatrip.detalle.DetalleActivity
import com.orange.boyatrip.model.SitiosInteres
import com.orange.boyatrip.model.SitiosInteresItem

class ListLugaresActivity : AppCompatActivity() {

    private lateinit var listaLugares: ArrayList<SitiosInteresItem>
    private lateinit var lugaresInteresAdapter: LugaresInteresAdapter
    private lateinit var lugaresInteresRecyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_lugares)

        lugaresInteresRecyclerView = findViewById(R.id.lugares_recycler_view)


        listaLugares = LoadMockListaLugaresFromJson()
        lugaresInteresAdapter = LugaresInteresAdapter(listaLugares,onItemClicked = { onSiteClicked(it) } )

        lugaresInteresRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = lugaresInteresAdapter
            setHasFixedSize(false)
        }

    }

    private fun onSiteClicked(sitioInteres: SitiosInteresItem) {
        val intent = Intent(this, DetalleActivity::class.java)
        intent.putExtra("sitioInteres",sitioInteres)
        startActivity(intent)

    }


    private fun LoadMockListaLugaresFromJson(): ArrayList<SitiosInteresItem> {
        val sitiosInteresString: String =
            applicationContext.assets.open("sitiosInteres.json").bufferedReader()
                .use { it.readText() }
        val gson = Gson()
        val data = gson.fromJson(sitiosInteresString, SitiosInteres::class.java)
        return data
    }
}