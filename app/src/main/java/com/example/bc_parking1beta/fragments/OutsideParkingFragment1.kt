package com.example.bc_parking1beta.fragments

import android.content.ClipData.Item
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bc_parking.R
import com.example.bc_parking.databinding.FragmentWelcomeBinding
import com.example.bc_parking.databinding.OutsideParking1Binding
import com.example.bc_parking1beta.ItemAdapter
import com.example.bc_parking1beta.domain.ParkItem

class OutsideParkingFragment1 : Fragment() {

    private var _binding: OutsideParking1Binding? = null
    private val binding: OutsideParking1Binding
        get() = _binding ?: throw RuntimeException("OutsideParking1Binding == null")


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = OutsideParking1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            rvOutsideParking11.adapter = ItemAdapter(
                listOf(
                    ParkItem("", "","", "", "13"),
                    ParkItem("", "","", "", "12"),
                    ParkItem("", "","", "", "11"),
                    ParkItem("", "","", "", "10"),
                    ParkItem("", "","", "", "9"),
                    ParkItem("", "","", "", "8"),
                    ParkItem("", "","", "", "7"),
                    ParkItem("", "","", "", "6"),
                    ParkItem("", "","", "", "5"),
                    ParkItem("", "","", "", "4"),
                    ParkItem("", "","", "", "3"),
                    ParkItem("", "","", "", "2"),
                    ParkItem("", "","", "", "1")
                )
            )
            rvOutsideParking12.adapter =
                ItemAdapter(
                    listOf(
                        ParkItem("", "","", "13", "14a"),
                        ParkItem("", "","", "13", "14"),
                        ParkItem("", "","", "13", "16"),
                        ParkItem("", "","", "13", "18"),
                        ParkItem("", "","", "13", "20"),
                        ParkItem("", "","", "13", "22"),
                        ParkItem("", "","", "13", "24"),
                        ParkItem("", "","", "13", "26"),
                        ParkItem("", "","", "13", "28"),
                        ParkItem("", "","", "13", "30"),
                        ParkItem("", "","", "13", "32"),
                        ParkItem("", "","", "13", "34"),
                        ParkItem("", "","", "13", "36"),
                        ParkItem("", "","", "13", "38")
                    )
                )
            rvOutsideParking13.adapter =
                ItemAdapter(
                    listOf(
                        ParkItem("", "","", "", "15a"),
                        ParkItem("", "","", "", "15"),
                        ParkItem("", "","", "", "17"),
                        ParkItem("", "","", "", "19"),
                        ParkItem("", "","", "", "21"),
                        ParkItem("", "","", "", "23"),
                        ParkItem("", "","", "", "25"),
                        ParkItem("", "","", "", "27"),
                        ParkItem("", "","", "", "29"),
                        ParkItem("", "","", "", "31"),
                        ParkItem("", "","", "", "33"),
                        ParkItem("", "","", "", "35"),
                        ParkItem("", "","", "", "37"),
                        ParkItem("", "","", "", "39")
                    )
                )
            rvOutsideParking14.adapter = ItemAdapter(
                listOf(

                    ParkItem("", "","", "", "44"),
                    ParkItem("", "","", "", "43"),
                    ParkItem("", "","", "", "42")
                )
            )
            rvOutsideParking141.adapter = ItemAdapter(
                listOf(
                    ParkItem("", "","", "", "41"),
                    ParkItem("", "","", "", "40")
                )
            )
            image.setImageResource(R.drawable.podval)
            rvOutsideParking11.setOnClickListener {

            }
            setupRecyclerAdapter()
        }


    }

    fun launchParkItemFragment() {
        findNavController().navigate(R.id.action_outsideParkingFragment1_to_parkItemFragment)
    }

    fun setupRecyclerAdapter() {
//        val recyclerView = RecyclerView(layoutInflater.context)
//        recyclerView.adapter = ItemAdapter(listOf(1,2,3,4,5,6,7,8,9,10,11,12,13).reversed())
//        recyclerView.layoutManager = LinearLayoutManager(layoutInflater.context)

        ItemAdapter(
            listOf(
                ParkItem("", "","", "", "13"),
                ParkItem("", "","", "", "12"),
                ParkItem("", "","", "", "11"),
                ParkItem("", "","", "", "10"),
                ParkItem("", "","", "", "9"),
                ParkItem("", "","", "", "8"),
                ParkItem("", "","", "", "7"),
                ParkItem("", "","", "", "6"),
                ParkItem("", "","", "", "5"),
                ParkItem("", "","", "", "4"),
                ParkItem("", "","", "", "3"),
                ParkItem("", "","", "", "2"),
                ParkItem("", "","", "", "1")
            )
        ).onParkItemClickListener = {
            // do something with your item
            launchParkItemFragment()

        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}