package com.orange.boyatrip

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LugaresInteresAdapter (private val lugarisinteresList: ArrayList<SitioInteres>) : RecyclerView.Adapter<LugaresInteresAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_list_lugares,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sitiosInteres = lugarisinteresList[position]
        holder.bind(sitiosInteres)
    }

    override fun getItemCount(): Int {
        return lugarisinteresList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private var tituloPOTextView : TextView = itemView.findViewById<>(R.id.tituloPO_text_view)
        private var puntuacionPOTextview : TextView = itemView.findViewById<>(R.id.puntuacionPO_text_view)
        private var descripcionPOTextview : TextView = itemView.findViewById<>(R.id.descripcionPO_text_view)
        private var pictureImageView: ImageView = itemView.findViewById<>(R.id.picture_image_view)
        fun bind(sitiosInteres:SitioInteres){
            tituloPOTextView.text = sitiosInteres.nombre
            puntuacionPOTextview = sitiosInteres.puntuacion
            descripcionPOTextview.text = sitiosInteres.descripcion
            //picture

        }

    }
}