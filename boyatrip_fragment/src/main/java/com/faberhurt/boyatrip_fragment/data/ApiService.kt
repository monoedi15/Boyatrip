package com.faberhurt.boyatrip_fragment.data

import com.faberhurt.boyatrip_fragment.model.SitiosInteres
import retrofit2.http.GET

interface ApiService {

    @GET("monoedi15/Boyatrip/sitiosInteres")
    suspend fun getSitiosinteres(): SitiosInteres
}