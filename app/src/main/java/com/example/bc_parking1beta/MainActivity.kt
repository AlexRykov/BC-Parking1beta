package com.example.bc_parking1beta

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bc_parking.R
import com.example.bc_parking.databinding.ActivityMainBinding
import com.example.bc_parking.databinding.ItemParkBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var binding1: ItemParkBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        binding1 = ItemParkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            rvMain1.adapter=ItemAdapter(listOf(1,2,3,4,5,6,7,8,9,10,11,12,13))
            rvMain2.adapter=ItemAdapter(listOf(1,2,3,4,5,6,7,8,9,10,11,12,13))
            rvMain3.adapter=ItemAdapter(listOf(1,2,3,4,5,6,7,8,9,10,11,12,13))
            rvMain4.adapter=ItemAdapter(listOf(1,2,3))
            rvMain41.adapter=ItemAdapter(listOf(1,2,3,4))
        }
    }
}