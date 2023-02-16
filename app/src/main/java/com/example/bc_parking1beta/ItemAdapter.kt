package com.example.bc_parking1beta

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.bc_parking.R
import com.example.bc_parking1beta.domain.ParkItem
import com.example.bc_parking1beta.presentation.ItemViewHolder

class ItemAdapter: ListAdapter<ParkItem, ItemViewHolder>(ParkItemDiffCallback()){

    var onParkItemLongClickListener: ((ParkItem) -> Unit)? = null
    var onParkItemClickListener: ((ParkItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layout = when(viewType){
            VIEW_TYPE_ENABLED -> R.layout.item_park
            VIEW_TYPE_DISABLED -> R.layout.item_park_disabled
            else -> throw RuntimeException("Unknown View type $viewType")
        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        val viewHolder = ItemViewHolder(view)

        return viewHolder

    }

    override fun onBindViewHolder(viewHolder: ItemViewHolder, position: Int) {
        val parkItem = getItem(position)

//         CREATE invoke method that can be Realised in Fragment in SetupRecyclerView
        viewHolder.itemView.setOnLongClickListener {
            onParkItemLongClickListener?.invoke(parkItem)
            true
        }
        viewHolder.itemView.setOnClickListener {
            onParkItemClickListener?.invoke(parkItem)
        }
//        IT'S     OUTSIDE     ItemPark    VIEW     !  !  !
        viewHolder.tv_name.text =parkItem.name
        viewHolder.tv_date_to.text =parkItem.dateTo
        viewHolder.tvCount.text = parkItem.id.toString()

    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return if (item.enabled){
            VIEW_TYPE_ENABLED
        } else{
            VIEW_TYPE_DISABLED
        }
    }
//    override fun onViewRecycled(viewHolder: ItemViewHolder) {
//        super.onViewRecycled(viewHolder)
//        viewHolder.tv_name.text = ""
//        viewHolder.tvCount.text = ""
//        viewHolder.tv_name.setTextColor(ContextCompat.getColor(viewHolder.itemView.context, android.R.color.white))
//    }

    companion object {

        const val VIEW_TYPE_ENABLED = 100
        const val VIEW_TYPE_DISABLED = 101
        const val MAX_POOL_SIZE = 5
    }

}