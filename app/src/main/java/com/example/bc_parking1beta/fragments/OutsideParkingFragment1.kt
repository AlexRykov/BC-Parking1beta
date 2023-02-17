package com.example.bc_parking1beta.fragments


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.bc_parking.R
import com.example.bc_parking.databinding.OutsideParking1Binding
import com.example.bc_parking1beta.ItemAdapter
import com.example.bc_parking1beta.MainViewModel
import com.example.bc_parking1beta.domain.ParkItem
import com.example.bc_parking1beta.presentation.ParkItemActivity
import com.example.bc_parking1beta.presentation.ParkItemFragment

class OutsideParkingFragment1 : Fragment() {

    private var _binding: OutsideParking1Binding? = null
    private val binding: OutsideParking1Binding
        get() = _binding ?: throw RuntimeException("OutsideParking1Binding == null")

    private lateinit var viewModel: MainViewModel
    private lateinit var rvOutsideParking11Adapter: ItemAdapter
    private lateinit var rvOutsideParking12Adapter: ItemAdapter
    private lateinit var rvOutsideParking13Adapter: ItemAdapter
//    private lateinit var rvOutsideParking12Adapter: ItemAdapter
//    private lateinit var rvOutsideParking13Adapter: ItemAdapter
    private lateinit var rvOutsideParking14Adapter: ItemAdapter
    private lateinit var rvOutsideParking141Adapter: ItemAdapter
//    private var parkItemContainer: FragmentContainerView? = null

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
        binding.image11.setImageResource(R.drawable.podval)
        setupRecyclerView()
        viewModel = ViewModelProvider(this@OutsideParkingFragment1)[MainViewModel::class.java]
        viewModel.parkList.observe(viewLifecycleOwner) {
//            give list of items to Adapter

            rvOutsideParking11Adapter.submitList(it.subList(0,13))
            rvOutsideParking12Adapter.submitList(it.subList(13,27))
            rvOutsideParking13Adapter.submitList(it.subList(27,41))
            rvOutsideParking14Adapter.submitList(it.subList(41,44))
            rvOutsideParking141Adapter.submitList(it.subList(44,46))
        }
//          Get item position in List with fun .currentList
//          val item = ItemAdapter.currentList[viewHolder.adapterPosition]
    }

    private fun setupRecyclerView() {
//        1

        val rvOutside1List = binding.rvOutsideParking11
        rvOutsideParking11Adapter = ItemAdapter()
        rvOutside1List.adapter = rvOutsideParking11Adapter

//        REALISE Invoke method from Adapter HERE
        rvOutsideParking11Adapter.onParkItemLongClickListener = {
            viewModel.changeEnableState(it)
        }
        rvOutsideParking11Adapter.onParkItemClickListener = {
//        "Intent to ParkItemFragment"
//            launchParkItemFragment()
            val intent = this@OutsideParkingFragment1.context?.let { it1 ->
                ParkItemActivity.newIntentEditItem(it1, it.id)
            }
            startActivity(intent)
        }
//        2

        val rvOutside12List = binding.rvOutsideParking12
        rvOutsideParking12Adapter = ItemAdapter()
        rvOutside12List.adapter = rvOutsideParking12Adapter

//        REALISE Invoke method from Adapter HERE
        rvOutsideParking12Adapter.onParkItemLongClickListener = {
            viewModel.changeEnableState(it)
        }
        rvOutsideParking12Adapter.onParkItemClickListener = {
//        "Intent to ParkItemFragment"
//            launchParkItemFragment()
            val intent = this@OutsideParkingFragment1.context?.let { it1 ->
                ParkItemActivity.newIntentEditItem(it1, it.id)
            }
            startActivity(intent)
        }
        //        3

        val rvOutside13List = binding.rvOutsideParking13
        rvOutsideParking13Adapter = ItemAdapter()
        rvOutside13List.adapter = rvOutsideParking13Adapter

//        REALISE Invoke method from Adapter HERE
        rvOutsideParking13Adapter.onParkItemLongClickListener = {
            viewModel.changeEnableState(it)
        }
        rvOutsideParking13Adapter.onParkItemClickListener = {
//        "Intent to ParkItemFragment"
//            launchParkItemFragment()
            val intent = this@OutsideParkingFragment1.context?.let { it1 ->
                ParkItemActivity.newIntentEditItem(it1, it.id)
            }
            startActivity(intent)
        }
        //        4

        val rvOutside14List = binding.rvOutsideParking14
        rvOutsideParking14Adapter = ItemAdapter()
        rvOutside14List.adapter = rvOutsideParking14Adapter

//        REALISE Invoke method from Adapter HERE
        rvOutsideParking14Adapter.onParkItemLongClickListener = {
            viewModel.changeEnableState(it)
        }
        rvOutsideParking14Adapter.onParkItemClickListener = {
//        "Intent to ParkItemFragment"
//            launchParkItemFragment()
            val intent = this@OutsideParkingFragment1.context?.let { it1 ->
                ParkItemActivity.newIntentEditItem(it1, it.id)
            }
            startActivity(intent)
        }
        //        41

        val rvOutside141List = binding.rvOutsideParking141
        rvOutsideParking141Adapter = ItemAdapter()
        rvOutside141List.adapter = rvOutsideParking141Adapter

//        REALISE Invoke method from Adapter HERE
        rvOutsideParking141Adapter.onParkItemLongClickListener = {
            viewModel.changeEnableState(it)
        }
        rvOutsideParking141Adapter.onParkItemClickListener = {
//        "Intent to ParkItemFragment"
//            launchParkItemFragment()
            val intent = this@OutsideParkingFragment1.context?.let { it1 ->
                ParkItemActivity.newIntentEditItem(it1, it.id)
            }
            startActivity(intent)
        }
    }

//    override fun onEditingFinished() {
//
//    }


    private fun launchParkItemFragment() {
        findNavController().navigate(R.id.action_outsideParkingFragment1_to_parkItemFragment)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}