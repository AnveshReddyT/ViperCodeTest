package codetest.anvesh.app

import android.app.Application
import codetest.anvesh.app.di.AppComponent
import codetest.anvesh.app.di.AppModule
import codetest.anvesh.app.di.DaggerAppComponent

class App : Application() {

    val component: AppComponent by lazy {
        DaggerAppComponent.builder()
            .context(this)
            .plus(AppModule())
            .build()
    }

    override fun onCreate() {
        super.onCreate()

        component.inject(this)
    }
}