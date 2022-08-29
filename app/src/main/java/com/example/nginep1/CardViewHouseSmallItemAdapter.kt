package com.example.nginep1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CardViewHouseSmallItemAdapter(private var listHousesSmallItem: ArrayList<House>): RecyclerView.Adapter<CardViewHouseSmallItemAdapter.CardViewViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback : CardViewHouseAdapter.OnItemClickCallback {
        override fun onItemClicked(data: House)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.name_house)
        var tvPrice: TextView = itemView.findViewById(R.id.price_house)
        var tvAddress: TextView = itemView.findViewById(R.id.address_house)
        var imgHouse: ImageView = itemView.findViewById(R.id.house_layout_rv)

        fun initialize (item: House, action: CardViewHouseAdapter.OnItemClickCallback){
            tvName.text = item.name
            tvPrice.text = item.price
            tvAddress.text = item.address
            imgHouse.setImageResource(item.photo)

            itemView.setOnClickListener{
                action.onItemClicked(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.house_small_item, parent, false)
        return CardViewViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        val house = listHousesSmallItem[position]
        Glide.with(holder.itemView.context)
            .load(house.photo)
            .apply(RequestOptions().override(55,55))
            .into(holder.imgHouse)
        holder.tvName.text = house.name
        holder.tvPrice.text = house.price
        holder.tvAddress.text = house.address

        holder.initialize(listHousesSmallItem[position], onItemClickCallback)

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listHousesSmallItem[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int {
        return listHousesSmallItem.size
    }

    fun updateList(listSmallItem : MutableList<House>) {
        listHousesSmallItem = listSmallItem as ArrayList<House>
        notifyDataSetChanged()
    }
}