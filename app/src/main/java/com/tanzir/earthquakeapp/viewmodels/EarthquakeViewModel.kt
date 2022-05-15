package com.tanzir.earthquakeapp.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tanzir.earthquakeapp.file.NetworkService
import com.tanzir.earthquakeapp.models.EarthquakeModel
import com.tanzir.earthquakeapp.repos.EarthquakeRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class EarthquakeViewModel : ViewModel() {
    val earthquakeLiveData:MutableLiveData<EarthquakeModel> = MutableLiveData()
private val repository = EarthquakeRepository()
    val fromDate=System.currentTimeMillis()
    val toDate=System.currentTimeMillis()
    val magnitute = 3


   fun fetchData()
    {
        viewModelScope.launch {
            try {
             earthquakeLiveData.value =repository.fetchEarthquakeData()
                Log.d("EarthquakeViewModel",repository.fetchEarthquakeData().toString())

            }catch (e:Exception){
                Log.d("EarthquakeViewModel",e.localizedMessage)
            }
        }
    }

}