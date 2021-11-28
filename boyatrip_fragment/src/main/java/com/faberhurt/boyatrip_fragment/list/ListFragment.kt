package com.faberhurt.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.faberhurt.boyatrip_fragment.databinding.FragmentListBinding
import com.faberhurt.boyatrip_fragment.list.LugaresInteresAdapter
import com.faberhurt.boyatrip_fragment.model.SitiosInteres
import com.faberhurt.boyatrip_fragment.model.SitiosInteresItem
import com.google.gson.Gson


class ListFragment : Fragment() {

    private lateinit var listaLugares: ArrayList<SitiosInteresItem>
    private lateinit var ListBinding: FragmentListBinding
    private lateinit var lugaresInteresAdapter: LugaresInteresAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        ListBinding = FragmentListBinding.inflate(inflater, container, false)
        return ListBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listaLugares = LoadMockListaLugaresFromJson()
        lugaresInteresAdapter = LugaresInteresAdapter(listaLugares, onItemClicked = { onSiteClicked(it) } )
        ListBinding.lugaresRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = lugaresInteresAdapter
            setHasFixedSize(false)
        }
        }


    private fun onSiteClicked(sitioTuristico: SitiosInteresItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(sitioTuristico))


    }

    private fun LoadMockListaLugaresFromJson(): ArrayList<SitiosInteresItem> {
        val sitiosInteresString: String =
            context?.assets?.open("sitiosInteres.json")?.bufferedReader()
                .use { it!!.readText() }
        val gson = Gson()
        val listaSitiosInteres = gson.fromJson(sitiosInteresString, SitiosInteres::class.java)
        return listaSitiosInteres
    }

}