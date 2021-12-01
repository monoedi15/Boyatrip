package com.orange.boyatrip.detalle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.orange.boyatrip.databinding.ActivityDetalleBinding
import com.orange.boyatrip.model.SitiosInteresItem
import com.squareup.picasso.Picasso
import java.io.Serializable

class DetalleActivity : AppCompatActivity() {

    private lateinit var  detalleBinding: ActivityDetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detalleBinding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(detalleBinding.root)

        val sitioInteres: SitiosInteresItem = intent.extras?.getSerializable("sitioInteres") as SitiosInteresItem
        with(detalleBinding){
            nombreTextView.text=sitioInteres.nombre
            descripcionTextView.text=sitioInteres.descripcion
            calificacionTextView.text= sitioInteres.puntuacion.toString()
            Picasso.get().load(sitioInteres.urlpicture).into(pictureImageView)

        }


    }
}
// config