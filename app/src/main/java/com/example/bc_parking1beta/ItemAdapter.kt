package com.example.bc_parking1beta

import android.annotation.SuppressLint
import android.graphics.Color
import android.icu.util.Calendar
import android.icu.util.LocaleData
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.graphics.green
import androidx.core.graphics.red
import androidx.recyclerview.widget.ListAdapter
import com.example.bc_parking.R
import com.example.bc_parking1beta.domain.ParkItem
import com.example.bc_parking1beta.presentation.ItemViewHolder
import java.sql.Time
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime

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


    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(viewHolder: ItemViewHolder, position: Int) {
        val parkItem = getItem(position)

        fun subtractCurrentDate(): Boolean {
            val time = Calendar.getInstance().time
            val formatter = SimpleDateFormat("dd.M.yyyy")
            val current = formatter.format(time)
            return if (parkItem.dateTo.length > 5){
                val year = current.substring(4,8)
                val year1 = parkItem.dateTo.substring(4,8)
                val month = current.substring(2,3)
                val month1 = parkItem.dateTo.substring(2,3)
                viewHolder.tv_name.text = "$year $year1 $month $month1"
                (year == year1 && month == month1)
            } else {
                false
            }
        }

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
//        parkItem.enabled = getItemViewType(position) == VIEW_TYPE_ENABLED
//        if (parkItem.enabled) {
//            viewHolder.tv_date_to.setTextColor(Color.BLUE)
//        } else {
//            viewHolder.tv_date_to.setTextColor(Color.CYAN)
//        }
        if (subtractCurrentDate()) {
            viewHolder.tv_date_to.setTextColor(Color.RED)
        } else {
            viewHolder.tv_date_to.setTextColor(Color.GRAY)
        }

    }


    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return if (item.dateTo == "clear"){
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