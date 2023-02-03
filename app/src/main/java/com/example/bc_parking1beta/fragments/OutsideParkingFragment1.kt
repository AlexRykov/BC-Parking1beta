package com.example.bc_parking1beta.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.bc_parking.R
import com.example.bc_parking.databinding.OutsideParking1Binding
import com.example.bc_parking1beta.ItemAdapter

class OutsideParkingFragment1: Fragment() {

    private var _binding: OutsideParking1Binding? = null
    private val binding: OutsideParking1Binding
        get() = _binding ?: throw RuntimeException("FragmentOutsideParking1Binding == null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = OutsideParking1Binding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            rvOutsideParking11.adapter= ItemAdapter(listOf(1,2,3,4,5,6,7,8,9,10,11,12,13).reversed())
            rvOutsideParking12.adapter= ItemAdapter(listOf(14,14,16,18,20,22,24,26,28,30,32,34,36,38))
            rvOutsideParking13.adapter= ItemAdapter(listOf(15,15,17,19,21,23,25,27,29,31,33,35,37,39))
            rvOutsideParking14.adapter= ItemAdapter(listOf(44,43,42))
            rvOutsideParking141.adapter= ItemAdapter(listOf(41,40))
            image.setImageResource(R.drawable.podval)
        }

    }
//    private fun launchChooseLevelFragment() {
//        findNavController().navigate(R.id.)
//    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}