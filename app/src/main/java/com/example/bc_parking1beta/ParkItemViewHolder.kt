package com.example.bc_parking1beta

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bc_parking.R

class ParkItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val tvName: TextView = view.findViewById<TextView>(R.id.tv_name)
    val tvFirm: TextView = view.findViewById<TextView>(R.id.tv_firm)
    val tvDateFrom: TextView = view.findViewById<TextView>(R.id.tv_date_from)
    val tvDateTo: TextView = view.findViewById<TextView>(R.id.tv_date_to)
    val tvCount: TextView = view.findViewById<TextView>(R.id.num1)
}