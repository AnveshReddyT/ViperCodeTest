package codetest.anvesh.ui.main

import codetest.anvesh.app.model.Weather
import codetest.anvesh.ui.detail.DetailActivity

class MainRouter(private val activity: MainActivity) : MainContract.Router {
    override fun finish() {
        activity.finish()
    }

    override fun openCityWeather(data: Weather) {
        DetailActivity.launch(activity, data)
    }
}