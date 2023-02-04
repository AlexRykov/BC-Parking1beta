package com.example.bc_parking1beta.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bc_parking.R
import com.example.bc_parking.databinding.FragmentParking2ndLvlBinding
import com.example.bc_parking1beta.ItemAdapter

class Parking2ndLvlFragment : Fragment(){

    private var _binding: FragmentParking2ndLvlBinding? = null
    private val binding: FragmentParking2ndLvlBinding
        get() = _binding ?: throw RuntimeException("FragmentParking2ndLvlBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentParking2ndLvlBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.apply {
//            rvParking2ndLvl11.adapter = ItemAdapter(listOf(221))
//            rvParking2ndLvl12.adapter =
//                ItemAdapter(listOf(220,219))
//            rvParking2ndLvl13.adapter =
//                ItemAdapter(listOf(218,217))
//            rvParking2ndLvl14.adapter = ItemAdapter(listOf(216,215))
//            rvParking2ndLvl15.adapter = ItemAdapter(listOf(214,213))
//            rvParking2ndLvl21.adapter = ItemAdapter(listOf(201,202))
//            rvParking2ndLvl22.adapter = ItemAdapter(listOf(222,223))
//            rvParking2ndLvl23.adapter = ItemAdapter(listOf(212,211))
//            rvParking2ndLvl31.adapter = ItemAdapter(listOf(203,204))
//            rvParking2ndLvl41.adapter = ItemAdapter(listOf(205,206))
//            rvParking2ndLvl42.adapter = ItemAdapter(listOf(207))
//            rvParking2ndLvl43.adapter = ItemAdapter(listOf(208,209))
//            rvParking2ndLvl44.adapter = ItemAdapter(listOf(210))
////            llParking2lvl.setBackgroundColor(R.drawable.parking2lvl)
//        }

    }
//    private fun launchChooseLevelFragment() {
//        findNavController().navigate(R.id.)
//    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}