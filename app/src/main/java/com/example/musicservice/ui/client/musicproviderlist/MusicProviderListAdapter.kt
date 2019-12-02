package com.example.musicservice.ui.client.musicproviderlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.musicservice.R
import com.example.musicservice.model.MusicProvider
import kotlinx.android.synthetic.main.layout_listitem_client_personalevents.view.*
import kotlinx.android.synthetic.main.layout_listitem_music_providers.view.*
import org.w3c.dom.Text

class MusicProviderListAdapter(private val musicProviderList: MutableList<MusicProvider?>,
                               private val context : Context
) : RecyclerView.Adapter<MusicProviderListAdapter.MusicProviderListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicProviderListViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_listitem_music_providers, parent, false)
        val viewHolder: MusicProviderListViewHolder = MusicProviderListViewHolder(view)
        return viewHolder
    }

    override fun getItemCount(): Int {
        return musicProviderList.size
    }

    //TODO separate sorter class
    override fun onBindViewHolder(holder: MusicProviderListViewHolder, position: Int) {

        holder.mpName.text = musicProviderList[position]?.name
        holder.mpType.text = musicProviderList[position]?.musicProviderType
        holder.mpId = musicProviderList[position]?.id
        holder.mpCity.text = musicProviderList[position]?.city
        holder.mActive.visibility = ImageView.GONE
        if(musicProviderList[position]!!.active){
            holder.mActive.visibility = ImageView.VISIBLE
        }
        println("--------------------------------------------------- RATING ${musicProviderList[position]?.rating!!.toFloat()}")
        holder.starsRating.rating = musicProviderList[position]?.rating!!.toFloat()


    }



    class MusicProviderListViewHolder(private val myItemView: View) :
        RecyclerView.ViewHolder(myItemView) {

        val constraintLayout: ConstraintLayout
        val mpName: TextView
        val mpType: TextView
        val mpCity : TextView
        val mActive : ImageView
        val starsRating : RatingBar
        var mpId : String?


        init {
            constraintLayout = myItemView.music_providers_row
            mpName = myItemView.music_provider_name
            mpType = myItemView.music_provider_type
            mpCity = myItemView.city_text
            mpId = "Error!"
            mActive = myItemView.activeimage
            starsRating = myItemView.stars_rating
        }
    }
}