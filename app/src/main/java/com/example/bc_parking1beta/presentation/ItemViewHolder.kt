package com.example.bc_parking1beta.presentation

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bc_parking.R

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//    val binding = ItemParkBinding.bind(itemView)

    val tv_name: TextView = itemView.findViewById(R.id.tv_name)
//    val tv_firm: TextView = itemView.findViewById<TextView>(R.id.tv_firm)
//    val tv_date_from: TextView = itemView.findViewById<TextView>(R.id.tv_date_from)
    val tv_date_to: TextView = itemView.findViewById(R.id.tv_date_to_main)
    val tvCount: TextView = itemView.findViewById(R.id.num1)
//    val llDateTo: LinearLayout = itemView.findViewById(R.id.llDateTo)
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