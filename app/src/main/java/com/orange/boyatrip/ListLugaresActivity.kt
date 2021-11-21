package com.orange.boyatrip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListLugaresActivity : AppCompatActivity() {

    private lateinit var listaLugares: ArrayList<SitioInteres>
    private lateinit var lugaresInteresAdapter: LugaresInteresAdapter
    private lateinit var lugaresInteresRecyclerView: RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_lugares)

        lugaresInteresRecyclerView = findViewById(R.id.lugares_recycler_view)

        listaLugares = createMockLugaresInteres()

        lugaresInteresAdapter = LugaresInteresAdapter(listaLugares)

        //lugaresInteresRecyclerView.addItemDecoration(
            //DividerItemDecoration(
                //this,DividerItemDecoration.VERTICAL
            //)
        //)

        lugaresInteresRecyclerView.apply{
            layoutManager = LinearLayoutManager(context)
            adapter = lugaresInteresAdapter
            setHasFixedSize(false)
        }

    }

    private fun createMockLugaresInteres() : ArrayList<SitioInteres>{
        return arrayListOf(
            SitioInteres(nombre = "CATEDRAL DE DUITAMA",
                descripcion = "templo religioso de culto católico bajo la advocación de San Lorenzo mártir, está ubicada en la zona céntrica de la ciudad de Duitama (Colombia) y pertenece al gran conjunto de templos que se encuentran en el centro de la ciudad; en el caso de la catedral, frente al Parque de los Libertadores.",
                puntuacion = 4,
                foto = 1
            ),
            SitioInteres(nombre = "SENDERO LA ZARZA",
                descripcion = "Es un sendero que parte en un ecosistema de bosque andino bordeando una quebrada de un pequeño río, pasando por una alta cascada rocosa, para finalizar en un ecosistema de páramo.",
                puntuacion = 5,
                foto = 1
            ),
            SitioInteres(nombre = "PARQUE LOS LIBERTADORES",
                descripcion = "Conserva en el centro un árbol que ha sido testigo de desarrollo de la ciudad y que según dicen los historiadores, en él se recostaba a descansar el Cacique Tundama",
                puntuacion = 4,
                foto = 1
            ),
            SitioInteres(nombre = "PUEBLITO BOYACENSE",
                descripcion = "En 1.995, se constituyó en realidad por la creatividad del compositor y periodista José Ricardo Bautista Pamplona, con el apoyo de la administración central",
                puntuacion = 5,
                foto = 1
            ),
            SitioInteres(nombre = "MONUMENTO A LOS LANCEROS",
                descripcion = "Se le considera el monumento más grande de Colombia y en él se destaca la carga de los 14 lanceros al mando del Coronel Juan José Rondón.",
                puntuacion = 3,
                foto = 1
            ),
            SitioInteres(nombre = "PARAMO PAN DE AZUCAR",
                descripcion = " Está a 2850 msnm en inmediaciones de Duitama y Santa Rosa de Viterbo, tiene una laguna que alimenta al río Surba",
                puntuacion = 5,
                foto = 1
            ),
            SitioInteres(nombre = "PARAMO DE LA RUSA",
                descripcion = "Está situado en el lado occidental de la cordillera oriental entre los 3.100 y 4.280 metros sobre el nivel del mar y forma parte de un corredor de extensos páramos y bosques andinos conocido como Guantiva-La Rusia.",
                puntuacion = 4,
                foto = 1
            )
        )
    }
}