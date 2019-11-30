package com.example.musicservice.ui.client.profile.personaleventlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.musicservice.R
import com.example.musicservice.model.Client
import com.example.musicservice.model.Event
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.layout_listitem_client_personalevents.view.*



class ClientPersonalEventListRecyclerViewAdapter(private val itemClickAction: (view: View, position: Int, type: String?) -> Unit ,
                                                 private val clientUsernameToPersonalEventsMap: MutableMap<String, MutableList<Event?>>,
                                                 private val images : MutableList<String>,
                                                 private val context : Context)
    : RecyclerView.Adapter<ClientPersonalEventListRecyclerViewAdapter.ClientPersonalEventsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientPersonalEventsViewHolder {
        println("ADAPTER ON CREATE VIEW HOLDER")
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.layout_listitem_client_personalevents,parent, false)
        val viewHolder : ClientPersonalEventsViewHolder = ClientPersonalEventsViewHolder(view)
        viewHolder.onClick(itemClickAction)
        return viewHolder
    }

    override fun getItemCount(): Int {
        println("ADAPTER GET ITEM COUNT")
        return clientUsernameToPersonalEventsMap.values.toMutableList()[0].size
    }

    override fun onBindViewHolder(holder: ClientPersonalEventsViewHolder, position: Int) {
        println("ADAPTER ON BIND VIEW HOLDER")
        val findAny = clientUsernameToPersonalEventsMap.keys.find { true }
        println("FIND ANY CLIENT---------- ${findAny}")
        val mutableEventList = clientUsernameToPersonalEventsMap.values.toMutableList()[0]


        holder.textViewEvent.text = mutableEventList[position]?.eventName
        holder.ownerUsername.text = findAny
        holder.eventDate.text = mutableEventList[position]?.date
        holder.eventId = mutableEventList[position]?.eventId

    }
    fun <T : ClientPersonalEventsViewHolder> T.onClick(event: (view: View, position: Int, type: String?) -> Unit): T {
        //TODO why not myItemView
        itemView.setOnClickListener {
            event.invoke(it, getAdapterPosition(), eventId)
        }
        return this
    }


    class ClientPersonalEventsViewHolder(private val myItemView : View ) : RecyclerView.ViewHolder(myItemView){

        val constraintLayout : ConstraintLayout
        val textViewEvent : TextView
        val ownerUsername : TextView
        val eventDate : TextView
        val circleImageView : CircleImageView
        var eventId : String?

        init {
            constraintLayout =  myItemView.client_personal_events_parent_relativelayout
            textViewEvent = myItemView.client_personal_events_eventnametextview
            circleImageView = myItemView.client_event_list_circleimage
            ownerUsername = myItemView.event_holder_ownerusername
            eventDate = myItemView.personal_event_dat
            eventId = "Error!----------------------------------------------------EVENT ID IN VIEW HOLDER NOT INITIALIZED"
        }
    }
}