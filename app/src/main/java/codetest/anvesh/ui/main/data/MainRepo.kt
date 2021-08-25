package codetest.anvesh.ui.main.data

import io.reactivex.Single
import codetest.anvesh.app.model.Weather
import codetest.anvesh.ui.main.MainContract
import codetest.anvesh.ui.main.api.MainApi

class MainRepo(private val api: MainApi) : MainContract.Repo {

    override fun getCities(): Single<List<Weather>> = api.getData()
}