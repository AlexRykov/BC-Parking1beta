package com.example.bc_parking1beta

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bc_parking.R
import com.example.bc_parking.databinding.ItemParkBinding
import com.example.bc_parking1beta.domain.ParkItem

class ItemAdapter(private val itemModel: List<ParkItem>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    var onParkItemClickListener: ((ParkItem) -> Unit)? = null
    var itemModels: List<ParkItem> = emptyList()
//    List<ParkItem>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_park, parent, false)


        return ItemViewHolder(view)

    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
//        val items = itemModels[position]
        holder.binding.apply {
            num1.text = itemModel[position].toString()

            val viewHolder = ItemViewHolder(holder.itemView)
//            viewHolder.itemView.setOnClickListener{
//                onParkItemClickListener?.invoke(getItemViewType(R.layout.item_park)(viewHolder.adapterPosition)
//            }
//          HERE I CAN SET CARDViEW CLICK LISTENER !!!
            var tick = 0
//            cvMain.setOnClickListener {
//                num1.setBackgroundColor(Color.BLACK)
//                //
////                if ((tick)%2 == 0){
////                    num1.background.setTint(Color.RED)
////                    tick ++
////                } else {
////                    num1.background.setTint(Color.parseColor("#00C853"))
////                    tick ++
////                }
////                launchParking2ndLvlFragment()
//            }
        }
    }

    override fun getItemCount() = itemModel.size
//    private fun launchParking2ndLvlFragment() {
//        findNavController().navigate(R.id.action_welcomeFragment_to_parking2ndLvlFragment)
//    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemParkBinding.bind(itemView)

        val tv_name: TextView = itemView.findViewById<TextView>(R.id.tv_name)
        val tv_firm: TextView = itemView.findViewById<TextView>(R.id.tv_firm)
        val tv_date_from: TextView = itemView.findViewById<TextView>(R.id.tv_date_from)
        val tv_date_to: TextView = itemView.findViewById<TextView>(R.id.tv_date_to)
        val tvCount: TextView = itemView.findViewById<TextView>(R.id.num1)
        init {
            binding.num1.text = tvCount.text
            binding.tvName.text = tv_name.text
            binding.tvFirm.text = tv_firm.text
            binding.tvDateFrom.text = tv_date_from.text
            binding.tvDateTo.text = tv_date_to.text
            itemView.setOnClickListener {
                onParkItemClickListener?.invoke(itemModels[adapterPosition])
            }
        }
    }

}