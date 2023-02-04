package com.example.bc_parking1beta.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
            rvOutsideParking11Adapter.parkList = it
        }

    }

    private fun setupRecyclerView() {
        val rvOutside1List = binding.rvOutsideParking11
        rvOutsideParking11Adapter = ItemAdapter()
        rvOutside1List.adapter = rvOutsideParking11Adapter
    }

//    override fun onEditingFinished() {
//        TODO("Not yet implemented")
//    }


    fun launchParkItemFragment() {
        findNavController().navigate(R.id.action_outsideParkingFragment1_to_parkItemFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}