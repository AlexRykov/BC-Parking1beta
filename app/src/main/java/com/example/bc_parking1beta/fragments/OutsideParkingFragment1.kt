package com.example.bc_parking1beta.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.bc_parking.R
import com.example.bc_parking.databinding.OutsideParking1Binding
import com.example.bc_parking1beta.ItemAdapter
import com.example.bc_parking1beta.MainViewModel
import com.example.bc_parking1beta.domain.ParkItem

class OutsideParkingFragment1 : Fragment(), ParkItemFragment.OnEditingFinishedListener {

    private var _binding: OutsideParking1Binding? = null
    private val binding: OutsideParking1Binding
        get() = _binding ?: throw RuntimeException("OutsideParking1Binding == null")

    private lateinit var viewModel: MainViewModel
//    private lateinit var rvOutsideParking11Adapter: ItemAdapter
//    private lateinit var rvOutsideParking12Adapter: ItemAdapter
//    private lateinit var rvOutsideParking13Adapter: ItemAdapter
//    private lateinit var rvOutsideParking14Adapter: ItemAdapter
//    private lateinit var rvOutsideParking141Adapter: ItemAdapter
    private var parkItemContainer: FragmentContainerView? = null

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

            viewModel = ViewModelProvider(this@OutsideParkingFragment1)[MainViewModel::class.java]
            val rvOutsideParking11Adapter = ItemAdapter(
                listOf(
                    ParkItem("", "", "", "", "13"),
                    ParkItem("", "", "", "", "12"),
                    ParkItem("", "", "", "", "11"),
                    ParkItem("", "", "", "", "10"),
                    ParkItem("", "", "", "", "9"),
                    ParkItem("", "", "", "", "8"),
                    ParkItem("", "", "", "", "7"),
                    ParkItem("", "", "", "", "6"),
                    ParkItem("", "", "", "", "5"),
                    ParkItem("", "", "", "", "4"),
                    ParkItem("", "", "", "", "3"),
                    ParkItem("", "", "", "", "2"),
                    ParkItem("", "", "", "", "1")
                )
            )
            rvOutsideParking11.adapter = rvOutsideParking11Adapter

            val rvOutsideParking12Adapter = ItemAdapter(
                listOf(
                    ParkItem("", "", "", "13", "14a"),
                    ParkItem("", "", "", "13", "14"),
                    ParkItem("", "", "", "13", "16"),
                    ParkItem("", "", "", "13", "18"),
                    ParkItem("", "", "", "13", "20"),
                    ParkItem("", "", "", "13", "22"),
                    ParkItem("", "", "", "13", "24"),
                    ParkItem("", "", "", "13", "26"),
                    ParkItem("", "", "", "13", "28"),
                    ParkItem("", "", "", "13", "30"),
                    ParkItem("", "", "", "13", "32"),
                    ParkItem("", "", "", "13", "34"),
                    ParkItem("", "", "", "13", "36"),
                    ParkItem("", "", "", "13", "38")
                )
            )
            rvOutsideParking12.adapter = rvOutsideParking12Adapter

            val rvOutsideParking13Adapter = ItemAdapter(
                listOf(
                    ParkItem("", "", "", "", "15a"),
                    ParkItem("", "", "", "", "15"),
                    ParkItem("", "", "", "", "17"),
                    ParkItem("", "", "", "", "19"),
                    ParkItem("", "", "", "", "21"),
                    ParkItem("", "", "", "", "23"),
                    ParkItem("", "", "", "", "25"),
                    ParkItem("", "", "", "", "27"),
                    ParkItem("", "", "", "", "29"),
                    ParkItem("", "", "", "", "31"),
                    ParkItem("", "", "", "", "33"),
                    ParkItem("", "", "", "", "35"),
                    ParkItem("", "", "", "", "37"),
                    ParkItem("", "", "", "", "39")
                )
            )
            rvOutsideParking13.adapter = rvOutsideParking13Adapter

            val rvOutsideParking14Adapter = ItemAdapter(
                listOf(

                    ParkItem("", "", "", "", "44"),
                    ParkItem("", "", "", "", "43"),
                    ParkItem("", "", "", "", "42")
                )
            )
            rvOutsideParking14.adapter = rvOutsideParking14Adapter

            rvOutsideParking141.adapter  = ItemAdapter(
                listOf(
                    ParkItem("", "", "", "", "41"),
                    ParkItem("", "", "", "", "40")
                )
            )



            viewModel.parkList.observe(viewLifecycleOwner) {
                rvOutsideParking11Adapter.submitList(it)
                rvOutsideParking12Adapter.submitList(it)
                rvOutsideParking13Adapter.submitList(it)
                rvOutsideParking14Adapter.submitList(it)
//                rvOutsideParking141Adapter.submitList(it)
            }

            image11.setImageResource(R.drawable.podval)

        }

//        fun setupRecyclerAdapter() {
//
//            ItemAdapter(
//                listOf(
//                    ParkItem("", "", "", "", "13"),
//                    ParkItem("", "", "", "", "12"),
//                    ParkItem("", "", "", "", "11"),
//                    ParkItem("", "", "", "", "10"),
//                    ParkItem("", "", "", "", "9"),
//                    ParkItem("", "", "", "", "8"),
//                    ParkItem("", "", "", "", "7"),
//                    ParkItem("", "", "", "", "6"),
//                    ParkItem("", "", "", "", "5"),
//                    ParkItem("", "", "", "", "4"),
//                    ParkItem("", "", "", "", "3"),
//                    ParkItem("", "", "", "", "2"),
//                    ParkItem("", "", "", "", "1")
//                )
//            ).onParkItemClickListener = {
//                // do something with your item
//                launchParkItemFragment()
//
//            }
//        }



        }

    override fun onEditingFinished() {
        TODO("Not yet implemented")
    }


    fun launchParkItemFragment() {
        findNavController().navigate(R.id.action_outsideParkingFragment1_to_parkItemFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}