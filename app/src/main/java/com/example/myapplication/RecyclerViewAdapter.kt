package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import android.widget.EditText

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.NameViewHolder>() {
    private val context:Context = TODO()
    private val dataList = mutableListOf<NameData>()
    lateinit var onItemClickListener:OnItemClickListener
    lateinit var onItemLongClickListener:OnItemLongClickListener

    inner class NameViewHolder(nameView:View):RecyclerView.ViewHolder(nameView){
        private val name=nameView.findViewById<TextView>(R.id.item_list)
        fun bind(nameData: NameData,context:Context){
            name.text=nameData.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.recycler_view_item,parent,false)
        return NameViewHolder(view)
    }

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        holder.bind(dataList[position],context)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
    fun addData(data:NameData){
        dataList.add(data)
    }
    fun removeData(position: Int){
        dataList.removeAt(position)
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