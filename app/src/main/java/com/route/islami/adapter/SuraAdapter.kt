package com.route.islami.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.route.islami.R


/**
 * Created by Mohamed Nabil Mohamed on 2/7/2020.
 * m.nabil.fci2015@gmail.com
 */
class SuraAdapter(val items: List<String>) : RecyclerView.Adapter<SuraAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.sura_item, parent, false);
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items.get(position)
        holder.suraName.setText(item )
        if (onItemClickListener != null)
            holder.itemView.setOnClickListener({
                onItemClickListener?.onItemClick(position, item)
            }
            )
    }

    var onItemClickListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(pos: Int, item: String)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var suraName: TextView;

        init {
            suraName = itemView.findViewById(R.id.sura_name);
        }
    }
}