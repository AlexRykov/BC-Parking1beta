package com.example.bc_parking1beta.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.bc_parking.R
import com.example.bc_parking.databinding.OutsideParking1Binding
import com.example.bc_parking.databinding.OutsideParking2Binding
import com.example.bc_parking1beta.ItemAdapter
import com.example.bc_parking1beta.MainViewModel
import com.example.bc_parking1beta.presentation.ParkItemActivity

class OutsideParkingFragment2 : Fragment() {

    private var _binding: OutsideParking2Binding? = null
    private val binding: OutsideParking2Binding
        get() = _binding ?: throw RuntimeException("OutsideParking2Binding == null")

    private lateinit var viewModel: MainViewModel
    private lateinit var rvOutsideParking211Adapter: ItemAdapter
    private lateinit var rvOutsideParking212Adapter: ItemAdapter
    private lateinit var rvOutsideParking213Adapter: ItemAdapter
    private lateinit var rvOutsideParking22Adapter: ItemAdapter
    private lateinit var rvOutsideParking231Adapter: ItemAdapter
    private lateinit var rvOutsideParking232Adapter: ItemAdapter
    private lateinit var rvOutsideParking233Adapter: ItemAdapter

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
//        binding.image11.setImageResource(R.drawable.podval)
        setupRecyclerView()
        viewModel = ViewModelProvider(this@OutsideParkingFragment2)[MainViewModel::class.java]
        viewModel.parkList.observe(viewLifecycleOwner) {
//            give list of items to Adapter

            rvOutsideParking211Adapter.submitList(it.subList(50,51))
            rvOutsideParking212Adapter.submitList(it.subList(49,50))
            rvOutsideParking213Adapter.submitList(it.subList(48,49))
            rvOutsideParking22Adapter.submitList(it.subList(44,48).reversed())
            rvOutsideParking231Adapter.submitList(it.subList(53,54))
            rvOutsideParking232Adapter.submitList(it.subList(52,53))
            rvOutsideParking233Adapter.submitList(it.subList(51,52))
        }
//          Get item position in List with fun .currentList
//          val item = ItemAdapter.currentList[viewHolder.adapterPosition]
    }

    private fun setupRecyclerView() {
//        211

        val rvOutside211List = binding.rvOutsideParking211
        rvOutsideParking211Adapter = ItemAdapter()
        rvOutside211List.adapter = rvOutsideParking211Adapter

//        REALISE Invoke method from Adapter HERE
        rvOutsideParking211Adapter.onParkItemLongClickListener = {
            viewModel.changeEnableState(it)
        }
        rvOutsideParking211Adapter.onParkItemClickListener = {
//        "Intent to ParkItemFragment"
//            launchParkItemFragment()
            val intent = this@OutsideParkingFragment2.context?.let { it1 ->
                ParkItemActivity.newIntentEditItem(it1, it.id)
            }
            startActivity(intent)
        }
//        212

        val rvOutside212List = binding.rvOutsideParking212
        rvOutsideParking212Adapter = ItemAdapter()
        rvOutside212List.adapter = rvOutsideParking212Adapter

//        REALISE Invoke method from Adapter HERE
        rvOutsideParking212Adapter.onParkItemLongClickListener = {
            viewModel.changeEnableState(it)
        }
        rvOutsideParking212Adapter.onParkItemClickListener = {
//        "Intent to ParkItemFragment"
//            launchParkItemFragment()
            val intent = this@OutsideParkingFragment2.context?.let { it1 ->
                ParkItemActivity.newIntentEditItem(it1, it.id)
            }
            startActivity(intent)
        }
        //        213

        val rvOutside213List = binding.rvOutsideParking213
        rvOutsideParking213Adapter = ItemAdapter()
        rvOutside213List.adapter = rvOutsideParking213Adapter

//        REALISE Invoke method from Adapter HERE
        rvOutsideParking213Adapter.onParkItemLongClickListener = {
            viewModel.changeEnableState(it)
        }
        rvOutsideParking213Adapter.onParkItemClickListener = {
//        "Intent to ParkItemFragment"
//            launchParkItemFragment()
            val intent = this@OutsideParkingFragment2.context?.let { it1 ->
                ParkItemActivity.newIntentEditItem(it1, it.id)
            }
            startActivity(intent)
        }
        //        22

        val rvOutside22List = binding.rvOutsideParking22
        rvOutsideParking22Adapter = ItemAdapter()
        rvOutside22List.adapter = rvOutsideParking22Adapter

//        REALISE Invoke method from Adapter HERE
        rvOutsideParking22Adapter.onParkItemLongClickListener = {
            viewModel.changeEnableState(it)
        }
        rvOutsideParking22Adapter.onParkItemClickListener = {
//        "Intent to ParkItemFragment"
//            launchParkItemFragment()
            val intent = this@OutsideParkingFragment2.context?.let { it1 ->
                ParkItemActivity.newIntentEditItem(it1, it.id)
            }
            startActivity(intent)
        }
        //        231

        val rvOutside231List = binding.rvOutsideParking231
        rvOutsideParking231Adapter = ItemAdapter()
        rvOutside231List.adapter = rvOutsideParking231Adapter

//        REALISE Invoke method from Adapter HERE
        rvOutsideParking231Adapter.onParkItemLongClickListener = {
            viewModel.changeEnableState(it)
        }
        rvOutsideParking231Adapter.onParkItemClickListener = {
//        "Intent to ParkItemFragment"
//            launchParkItemFragment()
            val intent = this@OutsideParkingFragment2.context?.let { it1 ->
                ParkItemActivity.newIntentEditItem(it1, it.id)
            }
            startActivity(intent)
        }
        //        232

        val rvOutside232List = binding.rvOutsideParking232
        rvOutsideParking232Adapter = ItemAdapter()
        rvOutside232List.adapter = rvOutsideParking232Adapter

//        REALISE Invoke method from Adapter HERE
        rvOutsideParking232Adapter.onParkItemLongClickListener = {
            viewModel.changeEnableState(it)
        }
        rvOutsideParking232Adapter.onParkItemClickListener = {
//        "Intent to ParkItemFragment"
//            launchParkItemFragment()
            val intent = this@OutsideParkingFragment2.context?.let { it1 ->
                ParkItemActivity.newIntentEditItem(it1, it.id)
            }
            startActivity(intent)
        }
        //        233

        val rvOutside233List = binding.rvOutsideParking233
        rvOutsideParking233Adapter = ItemAdapter()
        rvOutside233List.adapter = rvOutsideParking233Adapter

//        REALISE Invoke method from Adapter HERE
        rvOutsideParking233Adapter.onParkItemLongClickListener = {
            viewModel.changeEnableState(it)
        }
        rvOutsideParking233Adapter.onParkItemClickListener = {
//        "Intent to ParkItemFragment"
//            launchParkItemFragment()
            val intent = this@OutsideParkingFragment2.context?.let { it1 ->
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