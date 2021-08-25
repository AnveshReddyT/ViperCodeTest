package codetest.anvesh.ui.main

import io.reactivex.disposables.CompositeDisposable
import codetest.anvesh.app.model.Weather
import codetest.anvesh.ui.main.data.MainRepo


class MainInteractor(private val repo: MainRepo) : MainContract.Interactor {

    private val compositeDisposable = CompositeDisposable()

//    override fun getCities1(onSuccess: (List<Weather>) -> Unit, onError: (Throwable) -> Unit) {
//        val arrayListOfCities = arrayListOf(
//            Weather("Dallas", "desc1"),
//            Weather("Miami", "desc2"),
//            Weather("San Francisco", "desc3"),
//            Weather("Seattle", "desc4"),
//            Weather("Detroit", "desc5"),
//            Weather("Anchorage", "desc6"),
//            Weather("New York", "desc7")
//        )
//        val disposable = Observable.fromArray(arrayListOfCities).single(arrayListOfCities)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .doOnError(onError)
//            .doOnSuccess(onSuccess)
//            .subscribe()
//
//        compositeDisposable.add(disposable)
//    }

    override fun getCities(): ArrayList<Weather> {
        return arrayListOf(
            Weather("Dallas", "desc1"),
            Weather("Miami", "desc2"),
            Weather("San Francisco", "desc3"),
            Weather("Seattle", "desc4"),
            Weather("Detroit", "desc5"),
            Weather("Anchorage", "desc6"),
            Weather("New York", "desc7")
        )
//        val disposable = Observable.fromArray(arrayListOfCities).single(arrayListOfCities)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .doOnError(onError)
//            .doOnSuccess(onSuccess)
//            .subscribe()
//
//        compositeDisposable.add(disposable)
    }

    fun dispose() = compositeDisposable.dispose()
}