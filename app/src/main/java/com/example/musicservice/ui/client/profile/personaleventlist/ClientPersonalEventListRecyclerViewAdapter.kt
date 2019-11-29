package com.example.musicservice.ui.client.profile.personaleventlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.musicservice.R
import com.example.musicservice.model.Event
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.layout_listitem_client_personalevents.view.*



class ClientPersonalEventListRecyclerViewAdapter(private val eventNames: MutableList<Event?>, private val images : MutableList<String>, private val context : Context)
    : RecyclerView.Adapter<ClientPersonalEventListRecyclerViewAdapter.ClientPersonalEventsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientPersonalEventsViewHolder {
        println("ADAPTER ON CREATE VIEW HOLDER")
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.layout_listitem_client_personalevents,parent, false)
        return ClientPersonalEventsViewHolder(view)
    }

    override fun getItemCount(): Int {
        println("ADAPTER GET ITEM COUNT")
        return eventNames.size
    }

    override fun onBindViewHolder(holder: ClientPersonalEventsViewHolder, position: Int) {
        println("ADAPTER ON BIND VIEW HOLDER")
        holder.textViewEvent.text = eventNames[position]?.eventName
        holder.myRelativeLayout.setOnClickListener{
            Toast.makeText(context, "Position : ${eventNames[position]}", Toast.LENGTH_SHORT)
        }

    }

    class ClientPersonalEventsViewHolder(private val myItemView : View) : RecyclerView.ViewHolder(myItemView){
        val myRelativeLayout : RelativeLayout
        val textViewEvent : TextView
        val circleImageView : CircleImageView

        init {
            myRelativeLayout =  myItemView.client_personal_events_parent_relativelayout
            textViewEvent = myItemView.client_personal_events_eventnametextview
            circleImageView = myItemView.client_event_list_circleimage
        }
    }
}