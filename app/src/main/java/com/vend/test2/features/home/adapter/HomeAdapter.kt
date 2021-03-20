package com.vend.test2.features.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vend.test2.R
import com.vend.test2.response.home.Caradvetisement
import com.vend.test2.utils.setPriceText
import kotlinx.android.synthetic.main.item_rows.view.*

/**
Created By Syed Ovais Akhtar On 3/20/21 6:10 PM2
 **/
class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private var items = ArrayList<Caradvetisement>()

    fun addAdvertisement(carAdvetisement: ArrayList<Caradvetisement>) {
        this.items = carAdvetisement
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.HomeViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rows, parent, false)
        return HomeViewHolder(view)

    }

    override fun onBindViewHolder(holder: HomeAdapter.HomeViewHolder, position: Int) {
        val items = items[position]
        holder.bind(items)
    }

    override fun getItemCount(): Int = items.size

    inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Caradvetisement) {

            Glide.with(itemView.context).load("https://images.pexels.com/photos/168938/pexels-photo-168938.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500").into(itemView.itemImage)
            itemView.itemName.text = item.city
            itemView.itemPrice.setPriceText(item.price)

        }

    }

}