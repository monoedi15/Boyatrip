package com.faberhurt.boyatrip_fragment.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.faberhurt.boyatrip_fragment.R
import com.faberhurt.boyatrip_fragment.model.SitiosInteresItem
import com.squareup.picasso.Picasso

class LugaresInteresAdapter (

    private val lugarisinteresList: ArrayList<SitiosInteresItem>,
    private val  onItemClicked: (SitiosInteresItem)->Unit

    ) : RecyclerView.Adapter<LugaresInteresAdapter.LugaresViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LugaresViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_lugar_item,parent,false)
        return LugaresViewHolder(view)
    }

    override fun onBindViewHolder(holder: LugaresViewHolder, position: Int) {
        val sitiosInteres = lugarisinteresList[position]
        holder.itemView.setOnClickListener{onItemClicked(lugarisinteresList[position])}
        holder.bind(sitiosInteres)
    }

    override fun getItemCount(): Int = lugarisinteresList.size

    class LugaresViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private var tituloPOTextView : TextView = itemView.findViewById(R.id.tituloPO_text_view)
        private var puntuacionPOTextview : TextView = itemView.findViewById(R.id.puntuacionPO_text_view)
        private var descripcionPOTextview : TextView = itemView.findViewById(R.id.descripcionPO_text_view)
        private var pictureImageView: ImageView = itemView.findViewById(R.id.picture_image_view)
        fun bind(sitiosInteres: SitiosInteresItem){
            tituloPOTextView.text = sitiosInteres.nombre
            puntuacionPOTextview.text = sitiosInteres.puntuacion.toString()
            descripcionPOTextview.text = sitiosInteres.descripcion
            Picasso.get().load(sitiosInteres.urlpicture).into(pictureImageView)
        }
    }
}//TODO