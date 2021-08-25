package codetest.anvesh.ui.detail.di

import dagger.Module
import dagger.Provides
import codetest.anvesh.app.di.ActivityScope
import codetest.anvesh.ui.detail.DetailActivity
import codetest.anvesh.ui.detail.DetailContract
import codetest.anvesh.ui.detail.DetailPresenter
import codetest.anvesh.ui.detail.DetailRouter

@Module
class DetailModule {

    @Provides
    @ActivityScope
    fun router(activity: DetailActivity): DetailContract.Router = DetailRouter(activity)

    @Provides
    @ActivityScope
    fun presenter(router: DetailContract.Router) = DetailPresenter(router)
}