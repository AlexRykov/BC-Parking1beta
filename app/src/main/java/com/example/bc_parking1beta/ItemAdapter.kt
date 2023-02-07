package com.example.bc_parking1beta

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.bc_parking.R
import com.example.bc_parking.databinding.ItemParkBinding
import com.example.bc_parking1beta.domain.ParkItem

class ItemAdapter: RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){

    var parkList = listOf<ParkItem>()
        set(value) {
            field = value
            notifyDataSetChanged()

        }
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
        val parkItem = parkList[position]

//         CREATE invoke method that can be Realised in Fragment in SetupRecyclerView
        viewHolder.itemView.setOnLongClickListener {
            onParkItemLongClickListener?.invoke(parkItem)
            true
        }
        viewHolder.itemView.setOnClickListener {
            onParkItemClickListener?.invoke(parkItem)
        }
        viewHolder.tv_name.text =parkItem.name
        viewHolder.tvCount.text = parkItem.count

    }

    override fun getItemCount(): Int {
        return  parkList.size
    }

    override fun getItemViewType(position: Int): Int {
        val item = parkList[position]
        return if (item.enabled){
            VIEW_TYPE_ENABLED
        } else{
            VIEW_TYPE_DISABLED
        }
    }

    override fun onViewRecycled(viewHolder: ItemViewHolder) {
        super.onViewRecycled(viewHolder)
        viewHolder.tv_name.text = ""
        viewHolder.tvCount.text = ""
        viewHolder.tv_name.setTextColor(ContextCompat.getColor(viewHolder.itemView.context, android.R.color.white))
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemParkBinding.bind(itemView)

        val tv_name: TextView = itemView.findViewById<TextView>(R.id.tv_name)
        val tv_firm: TextView = itemView.findViewById<TextView>(R.id.tv_firm)
        val tv_date_from: TextView = itemView.findViewById<TextView>(R.id.tv_date_from)
        val tv_date_to: TextView = itemView.findViewById<TextView>(R.id.tv_date_to)
        val tvCount: TextView = itemView.findViewById<TextView>(R.id.num1)
//        init {
//            binding.num1.text = tvCount.text
//            binding.tvName.text = tv_name.text
//            binding.tvFirm.text = tv_firm.text
//            binding.tvDateFrom.text = tv_date_from.text
//            binding.tvDateTo.text = tv_date_to.text
//            itemView.setOnClickListener {
//                onParkItemClickListener?.invoke(itemModels[adapterPosition])
//            }
//        }
    }

    companion object {

        const val VIEW_TYPE_ENABLED = 100
        const val VIEW_TYPE_DISABLED = 101
        const val MAX_POOL_SIZE = 5
    }

    interface OnParkItemLongClickListener {
        fun onParkItemLongClick(parkItem: ParkItem)
    }
}