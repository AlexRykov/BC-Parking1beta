package com.example.bc_parking1beta.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.bc_parking.R
import com.example.bc_parking.databinding.FragmentParking1stLvlBinding
import com.example.bc_parking.databinding.OutsideParking2Binding
import com.example.bc_parking1beta.ItemAdapter
import com.example.bc_parking1beta.MainViewModel
import com.example.bc_parking1beta.presentation.ParkItemActivity

class Parking1stLvlFragment : Fragment() {

    private var _binding: FragmentParking1stLvlBinding? = null
    private val binding: FragmentParking1stLvlBinding
        get() = _binding ?: throw RuntimeException("FragmentParking1stLvlBinding == null")

    private lateinit var viewModel: MainViewModel
    private lateinit var rv1stParking11Adapter: ItemAdapter
    private lateinit var rv1stParking21Adapter: ItemAdapter
    private lateinit var rv1stParking22Adapter: ItemAdapter
    private lateinit var rv1stParking23Adapter: ItemAdapter
    private lateinit var rv1stParking31Adapter: ItemAdapter
    private lateinit var rv1stParking32Adapter: ItemAdapter
    private lateinit var rv1stParking41Adapter: ItemAdapter
    private lateinit var rv1stParking51Adapter: ItemAdapter
    private lateinit var rv1stParking52Adapter: ItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentParking1stLvlBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.image11.setImageResource(R.drawable.podval)
        setupRecyclerView()
        viewModel = ViewModelProvider(this@Parking1stLvlFragment)[MainViewModel::class.java]
        viewModel.parkList.observe(viewLifecycleOwner) {
//            give list of items to Adapter

            rv1stParking11Adapter.submitList(it.subList(56,58))
            rv1stParking21Adapter.submitList(it.subList(58,59))
            rv1stParking22Adapter.submitList(it.subList(59,61))
            rv1stParking23Adapter.submitList(it.subList(61,63))
            rv1stParking31Adapter.submitList(it.subList(63,65))
            rv1stParking32Adapter.submitList(it.subList(65,67))
            rv1stParking41Adapter.submitList(it.subList(67,69))
            rv1stParking51Adapter.submitList(it.subList(69,70))
            rv1stParking52Adapter.submitList(it.subList(70,71))
        }
//          Get item position in List with fun .currentList
//          val item = ItemAdapter.currentList[viewHolder.adapterPosition]
    }

    private fun setupRecyclerView() {
//        1_1

        val rvParking11List = binding.rvParking1stLvl11
        rv1stParking11Adapter = ItemAdapter()
        rvParking11List.adapter = rv1stParking11Adapter

//        REALISE Invoke method from Adapter HERE
        rv1stParking11Adapter.onParkItemLongClickListener = {
            viewModel.changeEnableState(it)
        }
        rv1stParking11Adapter.onParkItemClickListener = {
//        "Intent to ParkItemFragment"
//            launchParkItemFragment()
            val intent = this@Parking1stLvlFragment.context?.let { it1 ->
                ParkItemActivity.newIntentEditItem(it1, it.id)
            }
            startActivity(intent)
        }
        //       2_1

        val rvParking21List = binding.rvParking1stLvl21
        rv1stParking21Adapter = ItemAdapter()
        rvParking21List.adapter = rv1stParking21Adapter

//        REALISE Invoke method from Adapter HERE
        rv1stParking21Adapter.onParkItemLongClickListener = {
            viewModel.changeEnableState(it)
        }
        rv1stParking21Adapter.onParkItemClickListener = {
//        "Intent to ParkItemFragment"
//            launchParkItemFragment()
            val intent = this@Parking1stLvlFragment.context?.let { it1 ->
                ParkItemActivity.newIntentEditItem(it1, it.id)
            }
            startActivity(intent)
        }
        //       2_2

        val rvParking22List = binding.rvParking1stLvl22
        rv1stParking22Adapter = ItemAdapter()
        rvParking22List.adapter = rv1stParking22Adapter

//        REALISE Invoke method from Adapter HERE
        rv1stParking22Adapter.onParkItemLongClickListener = {
            viewModel.changeEnableState(it)
        }
        rv1stParking22Adapter.onParkItemClickListener = {
//        "Intent to ParkItemFragment"
//            launchParkItemFragment()
            val intent = this@Parking1stLvlFragment.context?.let { it1 ->
                ParkItemActivity.newIntentEditItem(it1, it.id)
            }
            startActivity(intent)
        }
        //       2_3

        val rvParking23List = binding.rvParking1stLvl23
        rv1stParking23Adapter = ItemAdapter()
        rvParking23List.adapter = rv1stParking23Adapter

//        REALISE Invoke method from Adapter HERE
        rv1stParking23Adapter.onParkItemLongClickListener = {
            viewModel.changeEnableState(it)
        }
        rv1stParking23Adapter.onParkItemClickListener = {
//        "Intent to ParkItemFragment"
//            launchParkItemFragment()
            val intent = this@Parking1stLvlFragment.context?.let { it1 ->
                ParkItemActivity.newIntentEditItem(it1, it.id)
            }
            startActivity(intent)
        }
        //       3_1

        val rvParking31List = binding.rvParking1stLvl31
        rv1stParking31Adapter = ItemAdapter()
        rvParking31List.adapter = rv1stParking31Adapter

//        REALISE Invoke method from Adapter HERE
        rv1stParking31Adapter.onParkItemLongClickListener = {
            viewModel.changeEnableState(it)
        }
        rv1stParking31Adapter.onParkItemClickListener = {
//        "Intent to ParkItemFragment"
//            launchParkItemFragment()
            val intent = this@Parking1stLvlFragment.context?.let { it1 ->
                ParkItemActivity.newIntentEditItem(it1, it.id)
            }
            startActivity(intent)
        }
        //       3_2

        val rvParking32List = binding.rvParking1stLvl32
        rv1stParking32Adapter = ItemAdapter()
        rvParking32List.adapter = rv1stParking32Adapter

//        REALISE Invoke method from Adapter HERE
        rv1stParking32Adapter.onParkItemLongClickListener = {
            viewModel.changeEnableState(it)
        }
        rv1stParking32Adapter.onParkItemClickListener = {
//        "Intent to ParkItemFragment"
//            launchParkItemFragment()
            val intent = this@Parking1stLvlFragment.context?.let { it1 ->
                ParkItemActivity.newIntentEditItem(it1, it.id)
            }
            startActivity(intent)
        }
        //       4_1

        val rvParking41List = binding.rvParking1stLvl41
        rv1stParking41Adapter = ItemAdapter()
        rvParking41List.adapter = rv1stParking41Adapter

//        REALISE Invoke method from Adapter HERE
        rv1stParking41Adapter.onParkItemLongClickListener = {
            viewModel.changeEnableState(it)
        }
        rv1stParking41Adapter.onParkItemClickListener = {
//        "Intent to ParkItemFragment"
//            launchParkItemFragment()
            val intent = this@Parking1stLvlFragment.context?.let { it1 ->
                ParkItemActivity.newIntentEditItem(it1, it.id)
            }
            startActivity(intent)
        }
        //      5_1

        val rvParking51List = binding.rvParking1stLvl51
        rv1stParking51Adapter = ItemAdapter()
        rvParking51List.adapter = rv1stParking51Adapter

//        REALISE Invoke method from Adapter HERE
        rv1stParking51Adapter.onParkItemLongClickListener = {
            viewModel.changeEnableState(it)
        }
        rv1stParking51Adapter.onParkItemClickListener = {
//        "Intent to ParkItemFragment"
//            launchParkItemFragment()
            val intent = this@Parking1stLvlFragment.context?.let { it1 ->
                ParkItemActivity.newIntentEditItem(it1, it.id)
            }
            startActivity(intent)
        }
        //       5_2

        val rvParking52List = binding.rvParking1stLvl52
        rv1stParking52Adapter = ItemAdapter()
        rvParking52List.adapter = rv1stParking52Adapter

//        REALISE Invoke method from Adapter HERE
        rv1stParking52Adapter.onParkItemLongClickListener = {
            viewModel.changeEnableState(it)
        }
        rv1stParking52Adapter.onParkItemClickListener = {
//        "Intent to ParkItemFragment"
//            launchParkItemFragment()
            val intent = this@Parking1stLvlFragment.context?.let { it1 ->
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