package codetest.anvesh.ui.main.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_weather.view.*
import codetest.anvesh.R
import codetest.anvesh.app.model.Weather

class MainAdapter(private val weathers: List<Weather>, private val listener: WeatherListener) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_weather, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.name.text = weathers[position].name?.uppercase()
        when(weathers[position].name) {
            "Dallas" -> holder.constraintLayout.setBackgroundResource(R.drawable.dallas)
            "Miami" -> holder.constraintLayout.setBackgroundResource(R.drawable.miami)
            "San Francisco" -> holder.constraintLayout.setBackgroundResource(R.drawable.sfo)
            "Seattle" -> holder.constraintLayout.setBackgroundResource(R.drawable.seattle)
            "Detroit" -> holder.constraintLayout.setBackgroundResource(R.drawable.detroit)
            "Anchorage" -> holder.constraintLayout.setBackgroundResource(R.drawable.anchorage)
            "New York" -> holder.constraintLayout.setBackgroundResource(R.drawable.newyork)
        }

        holder.itemView.setOnClickListener { listener.onItemClick(weathers[position]) }
    }

    override fun getItemCount(): Int {
        return weathers.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.name!!
        val desc = itemView.desc!!
        val constraintLayout = itemView.constraintLayout!!
    }

    interface WeatherListener {
        fun onItemClick(weather: Weather)
    }
}
