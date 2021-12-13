package com.faberhurt.boyatrip_fragment.data

class  SitiosInteresRepository {

    suspend fun getSitiosInteres() = ApiFactory.retrofit.getSitiosinteres()
}