package com.example.bc_parking1beta

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bc_parking.R
import com.example.bc_parking.databinding.ParentItemBinding

class MainAdapter(private val collection: List<MainModel>) : RecyclerView.Adapter<MainAdapter.CollectionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.parent_item, parent, false)
        return CollectionViewHolder(view)
    }

    override fun onBindViewHolder(holder: CollectionViewHolder, position: Int) {
        holder.binding.apply {
            val collection = collection[position]
            val itemAdapter = ItemAdapter(collection.itemModels)
            rvParentItem1.adapter = ItemAdapter(listOf(1,2,3,4,5,6,7,8))
            rvParentItem2.adapter = ItemAdapter(listOf(1,2,3,4,5,6,7,8))
            rvParentItem3.adapter = ItemAdapter(listOf(1,2,3,4,5,6,7,8))
            rvParentItem41.adapter = ItemAdapter(listOf(1,2,3))
            rvParentItem42.adapter = ItemAdapter(listOf(1,2,3,4))
        }
    }

    override fun getItemCount(): Int = collection.size

    inner class CollectionViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding = ParentItemBinding.bind(itemView)
    }
}