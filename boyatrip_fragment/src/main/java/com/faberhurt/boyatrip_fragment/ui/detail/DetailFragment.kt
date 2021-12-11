package com.faberhurt.boyatrip_fragment.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.faberhurt.boyatrip_fragment.R
import com.faberhurt.boyatrip_fragment.databinding.FragmentDetailBinding
import com.faberhurt.boyatrip_fragment.model.SitiosInteresItem
import com.faberhurt.boyatrip_fragment.ui.main.MainActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.squareup.picasso.Picasso


class DetailFragment : Fragment() {

    private lateinit var  sitio : SitiosInteresItem
    private lateinit var detailBinding: FragmentDetailBinding
    private val detailViewModel : DetailViewModel by viewModels()
    private val args: DetailFragmentArgs by navArgs()

    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */

        val posSitio = LatLng(sitio.latitud.toDouble(), sitio.longitud.toDouble())
        googleMap.addMarker(
            MarkerOptions()
                .position(posSitio)
                .title(sitio.nombre)
                .snippet(sitio.nombre)
        )
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(posSitio,10F))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity?)?.showIcon()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)
        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sitio=args.sitio

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)

        with(detailBinding){
            nombreTextView.text=sitio.nombre
            descripcionTextView.text=sitio.descripcion
            calificacionTextView.text= sitio.puntuacion.toString()
            Picasso.get().load(sitio.urlpicture).into(pictureImageView)

            /*mapButton.setOnClickListener {
                findNavController().navigate(DetailFragmentDirections.actionNavigationDetailToMapsFragment())
            }*/
        }
    }


}