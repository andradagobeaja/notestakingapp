package com.example.notetakingapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notetakingapp.data.Note

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var notesList = emptyList<Note>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val titleView: TextView = itemView.findViewById(R.id.textTitle)
        val contentView: TextView = itemView.findViewById(R.id.textContent)
        val dateView: TextView = itemView.findViewById(R.id.textDate)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context). inflate(R.layout.row, parent, false))
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = notesList[position]
        holder.titleView.text = currentItem.title
        holder.contentView.text = currentItem.description
        holder.dateView.text = currentItem.date
    }

    fun setData(note: List<Note>){
        this.notesList = note
        notifyDataSetChanged()
    }
}