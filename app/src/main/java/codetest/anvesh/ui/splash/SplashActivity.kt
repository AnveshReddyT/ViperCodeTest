package codetest.anvesh.ui.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import codetest.anvesh.R
import codetest.anvesh.app.App
import codetest.anvesh.ui.splash.di.DaggerSplashComponent
import codetest.anvesh.ui.splash.di.SplashComponent
import codetest.anvesh.ui.splash.di.SplashModule
import javax.inject.Inject

class SplashActivity : AppCompatActivity(), SplashContract.View {

    @Inject
    lateinit var presenter: SplashPresenter

    val component: SplashComponent by lazy {
        DaggerSplashComponent.builder()
            .appComponent((application as App).component)
            .activity(this)
            .plus(SplashModule())
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        component.inject(this)
        presenter.bindView(this)
        presenter.onViewCreated()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unbindView()
    }
}
