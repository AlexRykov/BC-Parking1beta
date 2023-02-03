package com.example.bc_parking1beta.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.bc_parking.R
import com.example.bc_parking.databinding.OutsideParking2Binding
import com.example.bc_parking1beta.ItemAdapter

class OutsideParkingFragment2 : Fragment() {

    private var _binding: OutsideParking2Binding? = null
    private val binding: OutsideParking2Binding
        get() = _binding ?: throw RuntimeException("FragmentOutsideParking2Binding == null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = OutsideParking2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            rvOutsideParking211.adapter = ItemAdapter(listOf(1))
            rvOutsideParking212.adapter =
                ItemAdapter(listOf(1))
            rvOutsideParking213.adapter =
                ItemAdapter(listOf(1))
            rvOutsideParking22.adapter = ItemAdapter(listOf(44, 43, 42))
            rvOutsideParking231.adapter = ItemAdapter(listOf(41))
            rvOutsideParking232.adapter = ItemAdapter(listOf(41))
            rvOutsideParking233.adapter = ItemAdapter(listOf(4))
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