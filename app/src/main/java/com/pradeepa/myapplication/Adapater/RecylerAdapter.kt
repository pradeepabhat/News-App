package com.pradeepa.myapplication.Adapater

import android.content.Intent
import android.net.Uri
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pradeepa.myapplication.Api.Article
import com.pradeepa.myapplication.R
import kotlinx.android.synthetic.main.item_layout.*
import kotlinx.android.synthetic.main.item_layout.view.*

class RecyclerAdapter (private val articles:List<Article>):
    RecyclerView.Adapter<RecyclerAdapter.NewsViewHolder>(){
    class NewsViewHolder(val view:View):RecyclerView.ViewHolder(view)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.NewsViewHolder {
        return NewsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return articles.size
    }



    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
       val oneArticle=articles[position]

        holder.view.tv_title.text=oneArticle.title
        holder.view.tv_source.text= oneArticle.source.name
        holder.view.tv_description.text=oneArticle.description
        //Image
        Glide.with(holder.view.iv_image).load(oneArticle.urlToImage).into(holder.view.iv_image)
        //Onclick card
        holder.view.setOnClickListener {
           val intent=Intent(Intent.ACTION_VIEW)
            intent.data= Uri.parse(oneArticle.url)
            startActivity(holder.view.context,intent,null)
        }
    }
}