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
import com.faberhurt.boyatrip_fragment.list.ListViewModel
import com.faberhurt.boyatrip_fragment.list.LugaresInteresAdapter
import com.faberhurt.boyatrip_fragment.model.SitiosInteresItem


class ListFragment : Fragment() {
    private lateinit var listBinding: FragmentListBinding
    private lateinit var listViewModel: ListViewModel
    private lateinit var lugaresInteresAdapter: LugaresInteresAdapter
    private var listaLugares: ArrayList<SitiosInteresItem> = arrayListOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]
        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // (activity as MainActivity?)?.hideIcon() --- no se usa en el drawer activity
        listViewModel.LoadMockListaLugaresFromJson(context?.assets?.open("sitiosInteres.json"))
        listViewModel.onLugaresLoaded.observe(viewLifecycleOwner,{result -> onLugaresLoadedSubscribe(result)
            })
        lugaresInteresAdapter = LugaresInteresAdapter(listaLugares!!,onItemClicked = {onSiteClicked(it)})

        listBinding.lugaresRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = lugaresInteresAdapter
            setHasFixedSize(false)
        }
        }

    private fun onLugaresLoadedSubscribe(result: ArrayList<SitiosInteresItem>?) {
        result?.let{listaLugares -> lugaresInteresAdapter.appendItems(listaLugares)
        }


    }


    private fun onSiteClicked(sitioTuristico: SitiosInteresItem) {
        findNavController().navigate(ListFragmentDirections.actionNavigationListToNavigationDetail(sitioTuristico))

    }


}//TODO