package codetest.anvesh.ui.main

import io.reactivex.Single
import codetest.anvesh.app.model.Weather

interface MainContract {
    interface View {
        fun publishData(data: List<Weather>)
        fun showMessage(msg: String)
    }

    interface Presenter {

        fun bindView(view: MainContract.View)

        fun unbindView()

        fun onViewCreated()

        fun onItemClicked(weather: Weather)

        fun onBackClicked()
    }

    interface Interactor {
        fun getCities(): ArrayList<Weather>
    }

    interface Router {
        fun finish()
        fun openCityWeather(weather: Weather)
    }

    interface Repo {
        fun getCities(): Single<List<Weather>>
    }
}