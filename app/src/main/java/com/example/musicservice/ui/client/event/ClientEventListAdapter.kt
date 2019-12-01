package com.example.musicservice.ui.client.event

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.musicservice.R
import com.example.musicservice.model.Client
import com.example.musicservice.model.Event
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.layout_listitem_client_personalevents.view.*

class ClientEventListAdapter(private val itemClickAction: (view: View, position: Int, type: String?) -> Unit,
                             private val clientUsernameToPersonalEventsMap: MutableMap<Client?, MutableList<Event?>>,
                             private val images : MutableList<String>,
                             private val context : Context
)
    : RecyclerView.Adapter<ClientEventListAdapter.ClientEventListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientEventListViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.layout_listitem_client_personalevents,parent, false)
        val viewHolder : ClientEventListViewHolder = ClientEventListViewHolder(view)
        viewHolder.onClick(itemClickAction)
        return viewHolder
    }

    override fun getItemCount(): Int {
        return clientUsernameToPersonalEventsMap.values.flatten().size
    }

    override fun onBindViewHolder(holder: ClientEventListViewHolder, position: Int) {
        val mutableEventList = clientUsernameToPersonalEventsMap.values.flatten()

        //TODO Send map of clients
        val client =
            clientUsernameToPersonalEventsMap.keys.filter { clientObject -> clientObject?.id == mutableEventList[position]?.ownerId }
        //TODO client id in client
        holder.textViewEvent.text = mutableEventList[position]?.eventName
        holder.ownerUsername.text = client[0]?.name
        holder.eventDate.text = mutableEventList[position]?.date
        holder.eventId = mutableEventList[position]?.eventId

    }
    fun <T : ClientEventListViewHolder> T.onClick(event: (view: View, position: Int, type: String?) -> Unit): T {
        //TODO why not myItemView
        itemView.setOnClickListener {
            event.invoke(it, getAdapterPosition(), eventId)
        }
        return this
    }


    class ClientEventListViewHolder(private val myItemView : View) : RecyclerView.ViewHolder(myItemView){

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