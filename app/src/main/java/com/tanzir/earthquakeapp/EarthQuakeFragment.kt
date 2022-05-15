package com.tanzir.earthquakeapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.tanzir.earthquakeapp.adapter.EarthquakeAdapter
import com.tanzir.earthquakeapp.databinding.FragmentEarthQuakeBinding
import com.tanzir.earthquakeapp.viewmodels.EarthquakeViewModel
import java.lang.Exception

class EarthQuakeFragment :Fragment(){


    private lateinit var binding:FragmentEarthQuakeBinding
    private  val earthquakeViewModel: EarthquakeViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



//        try {
//            Log.d("EarthFragment", earthquakeViewModel.fetchData().toString())
//
//        }catch (e:Exception){
//            Log.d("EarthFragment",  e.localizedMessage)
//        }

        binding= FragmentEarthQuakeBinding.inflate(inflater,container,false)

        val adapter = EarthquakeAdapter()
        val value=earthquakeViewModel.fetchData()
        binding.recyclerViewId.layoutManager=
            LinearLayoutManager(requireActivity()).apply {
                orientation=LinearLayoutManager.VERTICAL
            }
        binding.recyclerViewId.adapter=adapter
        earthquakeViewModel.earthquakeLiveData.observe(viewLifecycleOwner){
            adapter.submitList(it.features)
        }


        return binding.root
    }


}