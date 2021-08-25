package codetest.anvesh.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import codetest.anvesh.R
import codetest.anvesh.app.App
import codetest.anvesh.app.model.Weather
import codetest.anvesh.ui.main.adapter.MainAdapter
import codetest.anvesh.ui.main.di.DaggerMainComponent
import codetest.anvesh.ui.main.di.MainComponent
import codetest.anvesh.ui.main.di.MainModule
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {

    companion object {
        fun launch(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }

    @Inject
    lateinit var presenter: MainPresenter

    val component: MainComponent by lazy {
        DaggerMainComponent.builder()
            .appComponent((application as App).component)
            .activity(this)
            .plus(MainModule())
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        component.inject(this)
        presenter.bindView(this)
        presenter.onViewCreated()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unbindView()
    }

    override fun publishData(data: List<Weather>) {
        val adapter = MainAdapter(data, object : MainAdapter.WeatherListener {
            override fun onItemClick(weather: Weather) {
                presenter.onItemClicked(weather)
            }
        })
        recyclerView.adapter = adapter
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    private fun initView() {
        val manager = LinearLayoutManager(this)
            .apply { orientation = LinearLayoutManager.VERTICAL }
        recyclerView.layoutManager = manager
    }
}
