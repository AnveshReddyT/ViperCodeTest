package codetest.anvesh.ui.detail

import codetest.anvesh.app.model.Weather

interface DetailContract {
    interface View {
        fun publishData(weather: Weather?)

        fun showMessage(msg: Int)
    }

    interface Presenter {
        fun bindView(view: DetailContract.View)

        fun unbindView()

        fun onViewCreated(weather: Weather?)

        fun onBackClicked()

        fun onEmptyData(msg: Int)
    }

    interface Router {
        fun finish()
    }
}