package com.dissanayake.assigment_mobileapplicationdevelopment.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dissanayake.assigment_mobileapplicationdevelopment.R
import com.dissanayake.assigment_mobileapplicationdevelopment.post.models.Post
import kotlinx.android.synthetic.main.title_card_view.*
import kotlinx.android.synthetic.main.title_card_view.view.*

class Title_Adapter(val context : Context,val titles: MutableList<Post>) : RecyclerView.Adapter<Title_Adapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.title_card_view, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val title = titles[position]
        holder.setData(title, position)
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(title: Post?, pos: Int) {
            itemView.text_title_id.text = title!!.title
        }
    }
}