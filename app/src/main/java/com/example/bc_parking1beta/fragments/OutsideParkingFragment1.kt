package com.example.bc_parking1beta.fragments


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

class OutsideParkingFragment1 : Fragment() {

    private var _binding: OutsideParking1Binding? = null
    private val binding: OutsideParking1Binding
        get() = _binding ?: throw RuntimeException("OutsideParking1Binding == null")

    private lateinit var viewModel: MainViewModel
    private lateinit var rvOutsideParking11Adapter: ItemAdapter
//    private lateinit var rvOutsideParking12Adapter: ItemAdapter
//    private lateinit var rvOutsideParking13Adapter: ItemAdapter
//    private lateinit var rvOutsideParking14Adapter: ItemAdapter
//    private lateinit var rvOutsideParking141Adapter: ItemAdapter
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
            rvOutsideParking11Adapter.submitList(it)
        }
//          Get item position in List with fun .currentList
//          val item = ItemAdapter.currentList[viewHolder.adapterPosition]
    }

    private fun setupRecyclerView() {
        val rvOutside1List = binding.rvOutsideParking11
        rvOutsideParking11Adapter = ItemAdapter()
        rvOutside1List.adapter = rvOutsideParking11Adapter

//        REALISE Invoke method from Adapter HERE
        rvOutsideParking11Adapter.onParkItemLongClickListener = {
            viewModel.changeEnableState(it)
        }
        rvOutsideParking11Adapter.onParkItemClickListener = {
//        "Intent to ParkItemFragment"
            launchParkItemFragment()
            Toast.makeText(this.requireContext(), "CLICK", Toast.LENGTH_SHORT).show()
            Log.d("PARK", it.toString())
        }

//   SETUP MAX POOL SIZE of elements in rv. Must be Deleted    !!!

        rvOutside1List.recycledViewPool.setMaxRecycledViews(
            ItemAdapter.VIEW_TYPE_ENABLED,
            ItemAdapter.MAX_POOL_SIZE
        )
        rvOutside1List.recycledViewPool.setMaxRecycledViews(
            ItemAdapter.VIEW_TYPE_DISABLED,
            ItemAdapter.MAX_POOL_SIZE
        )
    }

//    override fun onEditingFinished() {
//        TODO("Not yet implemented")
//    }


    private fun launchParkItemFragment() {
        findNavController().navigate(R.id.action_outsideParkingFragment1_to_parkItemFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}