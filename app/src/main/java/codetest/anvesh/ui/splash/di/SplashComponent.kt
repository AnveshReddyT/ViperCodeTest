package codetest.anvesh.ui.splash.di

import dagger.BindsInstance
import dagger.Component
import codetest.anvesh.app.di.ActivityScope
import codetest.anvesh.app.di.AppComponent
import codetest.anvesh.ui.splash.SplashActivity

@ActivityScope
@Component(modules = [SplashModule::class], dependencies = [AppComponent::class])
interface SplashComponent {

    fun inject(target: SplashActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun activity(activity: SplashActivity): Builder

        fun appComponent(component: AppComponent): Builder

        fun plus(module: SplashModule): Builder

        fun build(): SplashComponent
    }
}