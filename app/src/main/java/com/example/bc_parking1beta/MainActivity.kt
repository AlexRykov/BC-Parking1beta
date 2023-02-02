package com.example.bc_parking1beta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bc_parking.R
import com.example.bc_parking.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            rvMain1.adapter=ItemAdapter(listOf(1,2,3,4,5,6,7,8,9,10,11,12,13).reversed())
            rvMain2.adapter=ItemAdapter(listOf(14,14,16,18,20,22,24,26,28,30,32,34,36,38))
            rvMain3.adapter=ItemAdapter(listOf(15,15,17,19,21,23,25,27,29,31,33,35,37,39))
            rvMain4.adapter=ItemAdapter(listOf(44,43,42))
            rvMain41.adapter=ItemAdapter(listOf(41,40))
            image.setImageResource(R.drawable.podval)
        }
    }
}