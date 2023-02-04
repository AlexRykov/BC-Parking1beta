package com.example.bc_parking1beta

import androidx.recyclerview.widget.DiffUtil
import com.example.bc_parking1beta.domain.ParkItem

class ParkItemDiffCallback : DiffUtil.ItemCallback<ParkItem>() {

    override fun areItemsTheSame(oldItem: ParkItem, newItem: ParkItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ParkItem, newItem: ParkItem): Boolean {
        return oldItem == newItem
    }
}