package com.tanzir.earthquakeapp.repos

import com.tanzir.earthquakeapp.file.NetworkService
import com.tanzir.earthquakeapp.models.EarthquakeModel

class EarthquakeRepository {
    suspend fun fetchEarthquakeData(

    ): EarthquakeModel {
        val endUrl ="query?format=geojson&starttime=2022-01-20&endtime=2022-01-21&minmagnitude=5"
        return NetworkService.earthServiceApi.getEarthquake(endUrl)
    }
}