package codetest.anvesh.ui.detail.di

import dagger.BindsInstance
import dagger.Component
import codetest.anvesh.app.di.ActivityScope
import codetest.anvesh.app.di.AppComponent
import codetest.anvesh.ui.detail.DetailActivity

@ActivityScope
@Component(modules = [DetailModule::class], dependencies = [AppComponent::class])
interface DetailComponent {

    fun inject(target: DetailActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun activity(activity: DetailActivity): Builder

        fun appComponent(component: AppComponent): Builder

        fun plus(module: DetailModule): Builder

        fun build(): DetailComponent
    }
}