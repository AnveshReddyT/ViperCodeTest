package codetest.anvesh.ui.main.di

import dagger.BindsInstance
import dagger.Component
import codetest.anvesh.app.di.ActivityScope
import codetest.anvesh.app.di.AppComponent
import codetest.anvesh.ui.main.MainActivity

@ActivityScope
@Component(modules = [MainModule::class], dependencies = [AppComponent::class])
interface MainComponent {

    fun inject(target: MainActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun activity(activity: MainActivity): Builder

        fun appComponent(component: AppComponent): Builder

        fun plus(module: MainModule): Builder

        fun build(): MainComponent
    }
}