package com.example.recyclerview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.data_classes.Student
import com.example.recyclerview.interfaces.OnItemClick

class CustomAdapterMain(private var studentList: ArrayList<Student>, private val onItemClick: OnItemClick) :
    RecyclerView.Adapter<CustomAdapterMain.CustomViewHolderMain>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolderMain {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_main, parent, false)
        return CustomViewHolderMain(view, onItemClick)
    }

    override fun onBindViewHolder(holder: CustomViewHolderMain, position: Int) {
        val student = studentList[position]
        with(student) {
            holder.apply {
                tvName.text = username
                tvRollNo.text = rollNo.toString()
            }
        }
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    class CustomViewHolderMain(itemView: View, onItemClick: OnItemClick) :
        RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tv_name_List_Item_Main)
        val tvRollNo: TextView = itemView.findViewById(R.id.tv_rollNo_List_Item_Main)

        init {
            itemView.setOnLongClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION)
                    onItemClick.onItemClick(adapterPosition)
                return@setOnLongClickListener true
            }
        }
    }
}