package com.example.toy

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rv_item.view.*

class MainAdapter(val context: Context, val dataList: ArrayList<Data>) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        return MainAdapter.ViewHolder(v)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
        val data = dataList[position]
        val listener = View.OnClickListener { it ->
            Toast.makeText(it.context, "체크박스 테스트", Toast.LENGTH_SHORT).show()
        }
        holder.apply {
            bind(listener, data)
            itemView.tag = data
        }

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var view: View = itemView

        fun bind(listener: View.OnClickListener, data: Data) {
            view.checkbox.setOnCheckedChangeListener { buttonView, isChecked ->

            }
            view.text.text = data.text
        }
    }

    fun add(dataList: ArrayList<Data>) {
        this.dataList.addAll(dataList)
        notifyDataSetChanged()
    }
}