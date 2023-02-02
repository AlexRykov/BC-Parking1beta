package com.example.bc_parking1beta

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bc_parking.R
import com.example.bc_parking.databinding.ItemParkBinding

class ItemAdapter (private val itemModel: List<Int>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_park,parent,false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.binding.apply {
            num1.text = itemModel[position].toString()



//          HERE I CAN SET CARDViEW CLICK LISTENER !!!
            var tick = 0
            cvMain.setOnClickListener{
                num1.setBackgroundColor(Color.BLACK)

                if ((tick)%2 == 0){
                    num1.background.setTint(Color.RED)
                    tick ++
                } else {
                    num1.background.setTint(Color.parseColor("#00C853"))
                    tick ++
                }
            }
        }
    }

    override fun getItemCount() =itemModel.size


    inner class ItemViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val binding = ItemParkBinding.bind(itemView)


    }

}