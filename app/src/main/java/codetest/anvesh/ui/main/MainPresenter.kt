package codetest.anvesh.ui.main

import codetest.anvesh.app.model.Weather

class MainPresenter(private val router: MainContract.Router, private val interactor: MainInteractor) :
    MainContract.Presenter {

    private var view: MainContract.View? = null

    override fun bindView(view: MainContract.View) {
        this.view = view
    }

    override fun unbindView() {
        view = null
        interactor.dispose()
    }

    override fun onViewCreated() {
        view?.publishData(interactor.getCities())
    }

    override fun onItemClicked(weather: Weather) {
        router.openCityWeather(weather)
    }

    override fun onBackClicked() {
        router.finish()
    }
}