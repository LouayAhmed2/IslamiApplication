package com.route.islami.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.route.islami.Api.RadiosItem
import com.route.islami.R



class RadioChannelAdapter(var items: List<RadiosItem?>?) : RecyclerView.Adapter<RadioChannelAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_radiochannel, parent, false);
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items?.size?:0;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.setText(items?.get(position)?.name)
        val item =items?.get(position)
      if (onPlayClickListener!=null){
          holder.Play.setOnClickListener({
              onPlayClickListener?.onItemClick(position,item)
          })
          if (onStopClickListener!=null){
              holder.Stop.setOnClickListener({
                  onStopClickListener?.onItemClick(position,item)
              })
          }


      }


    }

    var onPlayClickListener: OnItemClickListener? = null
       var onStopClickListener: OnItemClickListener? = null



    interface OnItemClickListener {
        fun onItemClick(pos: Int, item: RadiosItem?)
    }

    fun ChangeData(newList: List<RadiosItem?>?){

        this.items=newList
        notifyDataSetChanged()
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var title: TextView;
        lateinit var Play: ImageView;
        lateinit var Stop: ImageView;


        init {
            title=itemView.findViewById(R.id.radio)
            Play=itemView.findViewById(R.id.play)
            Stop=itemView.findViewById(R.id.stop)
        }
    }
}