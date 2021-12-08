package com.faberhurt.boyatrip_fragment.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.faberhurt.boyatrip_fragment.databinding.FragmentDetailBinding
import com.faberhurt.boyatrip_fragment.list.ListViewModel
import com.faberhurt.boyatrip_fragment.main.MainActivity
import com.squareup.picasso.Picasso


class DetailFragment : Fragment() {

    private lateinit var detailBinding: FragmentDetailBinding
    private val detailViewModel : DetailViewModel by viewModels()
    private val args: DetailFragmentArgs by navArgs()

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
        val sitioturistico = args.sitioTuristico

        with(detailBinding){
            nombreTextView.text=sitioturistico.nombre
            descripcionTextView.text=sitioturistico.descripcion
            calificacionTextView.text= sitioturistico.puntuacion.toString()
            Picasso.get().load(sitioturistico.urlpicture).into(pictureImageView)
                }


    }

}
//TODO