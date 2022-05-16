package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView


class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.NameViewHolder>() {
    private val dataList = mutableListOf<NameData>()
    lateinit var onItemClickListener:OnItemClickListener
    lateinit var onItemLongClickListener:OnItemLongClickListener

    inner class NameViewHolder(nameView:View):RecyclerView.ViewHolder(nameView){
        private val name=nameView.findViewById<TextView>(R.id.item_list)
        fun bind(nameData: NameData){
            name.text=nameData.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item,parent,false)
        return NameViewHolder(view)
    }

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
    fun addData(data:NameData){
        dataList.add(data)
        notifyDataSetChanged()
    }
    fun removeData(position: Int){
        dataList.removeAt(position)
        notifyDataSetChanged()
    }
    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }
    interface OnItemLongClickListener{
        fun onItemLongClick(position: Int)
    }
    inline fun setOnItemClickListener(crossinline onItemClick:(Int)->Unit){
        onItemClickListener=object :OnItemClickListener{
            override fun onItemClick(position: Int) {
                onItemClick(position)
            }
        }
    }
    inline fun setOnItemLongClickListener(crossinline onItemLongClick:(Int)->Unit){
        onItemLongClickListener=object :OnItemLongClickListener{
            override fun onItemLongClick(position: Int) {
                onItemLongClick(position)
            }
        }
    }
}