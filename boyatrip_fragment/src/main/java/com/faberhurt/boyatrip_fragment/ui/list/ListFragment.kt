package com.faberhurt.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.faberhurt.boyatrip_fragment.databinding.FragmentListBinding
import com.faberhurt.boyatrip_fragment.ui.list.ListViewModel
import com.faberhurt.boyatrip_fragment.ui.list.LugaresInteresAdapter
import com.faberhurt.boyatrip_fragment.ui.main.MainActivity
import com.faberhurt.boyatrip_fragment.model.SitiosInteresItem

class ListFragment : Fragment() {

    private var listaLugares: ArrayList<SitiosInteresItem> = arrayListOf()
    private lateinit var listBinding: FragmentListBinding
    private lateinit var listViewModel: ListViewModel
    private lateinit var lugaresInteresAdapter: LugaresInteresAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        listViewModel = ViewModelProvider(this )[ListViewModel::class.java]
        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hideIcon()
       // listViewModel.loadMockListaLugaresFromJson(context?.assets?.open("sitiosInteres.json"))

        listViewModel.getSitiosInteresFromServer()
        listViewModel.onListalugaresLoaded.observe(viewLifecycleOwner, { result ->
            onListaLugaresLoadedSubscribe(result)
        })

        lugaresInteresAdapter = LugaresInteresAdapter(listaLugares!!, onItemClicked = { onSiteClicked(it) } )

        listBinding.lugaresRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = lugaresInteresAdapter
            setHasFixedSize(false)
        }
    }

    private fun onListaLugaresLoadedSubscribe(result: ArrayList<SitiosInteresItem>?) {

        result?.let{listaLugares ->
            lugaresInteresAdapter.appendItems(listaLugares)

            /*this.listaLugares = listaLugares
            LugaresInteresAdapter.notifyDataSetChanged()*/

        }
    }


    private fun onSiteClicked(sitioTuristico: SitiosInteresItem) {
        findNavController().navigate(ListFragmentDirections.actionNavigationListToNavigationDetail(sitioTuristico))

    }

}