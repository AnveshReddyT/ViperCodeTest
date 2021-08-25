package codetest.anvesh.ui.main.api

import io.reactivex.Single
import codetest.anvesh.app.model.Weather
import retrofit2.http.GET

interface MainApi {

    @GET("api/random")
    fun getData(): Single<List<Weather>>
}