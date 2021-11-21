package com.orange.boyatrip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class ListLugaresActivity : AppCompatActivity() {

    private lateinit var listaLugares: ArrayList<SitioInteres>
    private lateinit var lugaresInteresAdapter: LugaresInteresAdapter
    private lateinit var lugaresInteresRecyclerView: RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_lugares)

        lugaresInteresRecyclerView = findViewById(R.id.lugares_recycler_view)
    }
}