package codetest.anvesh.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_detail.*
import codetest.anvesh.BuildConfig
import codetest.anvesh.R
import codetest.anvesh.app.App
import codetest.anvesh.ui.detail.di.DaggerDetailComponent
import codetest.anvesh.ui.detail.di.DetailComponent
import codetest.anvesh.ui.detail.di.DetailModule
import codetest.anvesh.app.model.Weather
import javax.inject.Inject
import kotlin.random.Random

class DetailActivity : AppCompatActivity(), DetailContract.View {

    companion object {
        private const val WEATHER = "${BuildConfig.APPLICATION_ID}_WEATHER"

        fun launch(context: Context, data: Weather) {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(WEATHER, data)
            context.startActivity(intent)
        }
    }

    @Inject
    lateinit var presenter: DetailPresenter

    val component: DetailComponent by lazy {
        DaggerDetailComponent.builder()
            .appComponent((application as App).component)
            .activity(this)
            .plus(DetailModule())
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        component.inject(this)
        presenter.bindView(this)
        if (intent.hasExtra(WEATHER)) {
            intent.getParcelableExtra<Weather>(WEATHER)
            presenter.onViewCreated(intent.getParcelableExtra(WEATHER))
        } else {
            presenter.onEmptyData(R.string.empty_data)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unbindView()
    }

    override fun publishData(weather: Weather?) {
        name.text = "Temp : ${Random.nextInt(60, 90).toString()}"+ "\u00B0"
    }

    override fun showMessage(msg: Int) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

}
