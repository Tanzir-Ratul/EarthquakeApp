package com.tanzir.earthquakeapp.file

import com.tanzir.earthquakeapp.models.EarthquakeModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url
import java.text.SimpleDateFormat
import java.util.*

val magnitude= arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

const val base_url = "https://earthquake.usgs.gov/fdsnws/event/1/"

fun getFormattedDate(dt:Long,pattern:String): String {
    return SimpleDateFormat(pattern).format(Date(dt*1000))
}

val retrofit = Retrofit.Builder()
    .baseUrl(base_url)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface EarthquakeServiceApi {

    @GET
    suspend fun getEarthquake(@Url endUrl: String): EarthquakeModel


}

object NetworkService {
    val earthServiceApi: EarthquakeServiceApi by lazy {
        retrofit.create(EarthquakeServiceApi::class.java)
    }
}