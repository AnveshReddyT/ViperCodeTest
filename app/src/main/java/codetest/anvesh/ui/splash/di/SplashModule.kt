package codetest.anvesh.ui.splash.di

import dagger.Module
import dagger.Provides
import codetest.anvesh.app.di.ActivityScope
import codetest.anvesh.ui.splash.SplashActivity
import codetest.anvesh.ui.splash.SplashContract
import codetest.anvesh.ui.splash.SplashPresenter
import codetest.anvesh.ui.splash.SplashRouter

@Module
class SplashModule {

    @Provides
    @ActivityScope
    fun router(activity: SplashActivity): SplashContract.Router = SplashRouter(activity)

    @Provides
    @ActivityScope
    fun presenter(router: SplashContract.Router) = SplashPresenter(router)
}