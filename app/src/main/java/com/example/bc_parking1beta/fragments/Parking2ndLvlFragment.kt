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
import com.example.bc_parking.databinding.FragmentParking2ndLvlBinding
import com.example.bc_parking1beta.ItemAdapter
import com.example.bc_parking1beta.MainViewModel
import com.example.bc_parking1beta.presentation.ParkItemActivity

class Parking2ndLvlFragment  : Fragment() {

    private var _binding: FragmentParking2ndLvlBinding? = null
    private val binding: FragmentParking2ndLvlBinding
        get() = _binding ?: throw RuntimeException("FragmentParking2ndLvlBinding == null")

    private lateinit var viewModel: MainViewModel
    private lateinit var rv2ndParking11Adapter: ItemAdapter
    private lateinit var rv2ndParking12Adapter: ItemAdapter
    private lateinit var rv2ndParking13Adapter: ItemAdapter
    private lateinit var rv2ndParking14Adapter: ItemAdapter
    private lateinit var rv2ndParking15Adapter: ItemAdapter
    private lateinit var rv2ndParking21Adapter: ItemAdapter
    private lateinit var rv2ndParking22Adapter: ItemAdapter
    private lateinit var rv2ndParking23Adapter: ItemAdapter
    private lateinit var rv2ndParking31Adapter: ItemAdapter
    private lateinit var rv2ndParking41Adapter: ItemAdapter
    private lateinit var rv2ndParking42Adapter: ItemAdapter
    private lateinit var rv2ndParking43Adapter: ItemAdapter
    private lateinit var rv2ndParking44Adapter: ItemAdapter

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
//        binding.image11.setImageResource(R.drawable.podval)
        setupRecyclerView()
        viewModel = ViewModelProvider(this@Parking2ndLvlFragment)[MainViewModel::class.java]
        viewModel.parkList.observe(viewLifecycleOwner) {
//            give list of items to Adapter

            rv2ndParking11Adapter.submitList(it.subList(71,71))
            rv2ndParking12Adapter.submitList(it.subList(72,73))
            rv2ndParking13Adapter.submitList(it.subList(74,75))
            rv2ndParking14Adapter.submitList(it.subList(76,77))
            rv2ndParking15Adapter.submitList(it.subList(78,79))
            rv2ndParking21Adapter.submitList(it.subList(80,81))
            rv2ndParking22Adapter.submitList(it.subList(82,83))
            rv2ndParking23Adapter.submitList(it.subList(84,85))
            rv2ndParking31Adapter.submitList(it.subList(86,87))
            rv2ndParking41Adapter.submitList(it.subList(88,89))
            rv2ndParking42Adapter.submitList(it.subList(90,90))
            rv2ndParking43Adapter.submitList(it.subList(91,92))
            rv2ndParking44Adapter.submitList(it.subList(93,93))
        }
//          Get item position in List with fun .currentList
//          val item = ItemAdapter.currentList[viewHolder.adapterPosition]
    }

    private fun setupRecyclerView() {
//        1_1

        val rvParking211List = binding.rvParking2ndLvl11
        rv2ndParking11Adapter = ItemAdapter()
        rvParking211List.adapter = rv2ndParking11Adapter

//        REALISE Invoke method from Adapter HERE
        rv2ndParking11Adapter.onParkItemLongClickListener = {
            viewModel.changeEnableState(it)
        }
        rv2ndParking11Adapter.onParkItemClickListener = {
//        "Intent to ParkItemFragment"
//            launchParkItemFragment()
            val intent = this@Parking2ndLvlFragment.context?.let { it1 ->
                ParkItemActivity.newIntentEditItem(it1, it.id)
            }
            startActivity(intent)
        }
        //       1_2

        val rvParking212List = binding.rvParking2ndLvl12
        rv2ndParking12Adapter = ItemAdapter()
        rvParking212List.adapter = rv2ndParking12Adapter

//        REALISE Invoke method from Adapter HERE
        rv2ndParking12Adapter.onParkItemLongClickListener = {
            viewModel.changeEnableState(it)
        }
        rv2ndParking12Adapter.onParkItemClickListener = {
//        "Intent to ParkItemFragment"
//            launchParkItemFragment()
            val intent = this@Parking2ndLvlFragment.context?.let { it1 ->
                ParkItemActivity.newIntentEditItem(it1, it.id)
            }
            startActivity(intent)
        }
        //       1_3

        val rvParking213List = binding.rvParking2ndLvl13
        rv2ndParking13Adapter = ItemAdapter()
        rvParking213List.adapter = rv2ndParking13Adapter

//        REALISE Invoke method from Adapter HERE
        rv2ndParking13Adapter.onParkItemLongClickListener = {
            viewModel.changeEnableState(it)
        }
        rv2ndParking13Adapter.onParkItemClickListener = {
//        "Intent to ParkItemFragment"
//            launchParkItemFragment()
            val intent = this@Parking2ndLvlFragment.context?.let { it1 ->
                ParkItemActivity.newIntentEditItem(it1, it.id)
            }
            startActivity(intent)
        }
        //       1_4

        val rvParking214List = binding.rvParking2ndLvl14
        rv2ndParking14Adapter = ItemAdapter()
        rvParking214List.adapter = rv2ndParking14Adapter

//        REALISE Invoke method from Adapter HERE
        rv2ndParking14Adapter.onParkItemLongClickListener = {
            viewModel.changeEnableState(it)
        }
        rv2ndParking14Adapter.onParkItemClickListener = {
//        "Intent to ParkItemFragment"
//            launchParkItemFragment()
            val intent = this@Parking2ndLvlFragment.context?.let { it1 ->
                ParkItemActivity.newIntentEditItem(it1, it.id)
            }
            startActivity(intent)
        }
        //       1_5

        val rvParking215List = binding.rvParking2ndLvl15
        rv2ndParking15Adapter = ItemAdapter()
        rvParking215List.adapter = rv2ndParking15Adapter

//        REALISE Invoke method from Adapter HERE
        rv2ndParking15Adapter.onParkItemLongClickListener = {
            viewModel.changeEnableState(it)
        }
        rv2ndParking15Adapter.onParkItemClickListener = {
//        "Intent to ParkItemFragment"
//            launchParkItemFragment()
            val intent = this@Parking2ndLvlFragment.context?.let { it1 ->
                ParkItemActivity.newIntentEditItem(it1, it.id)
            }
            startActivity(intent)
        }
        //       2_1

        val rvParking221List = binding.rvParking2ndLvl21
        rv2ndParking21Adapter = ItemAdapter()
        rvParking221List.adapter = rv2ndParking21Adapter

//        REALISE Invoke method from Adapter HERE
        rv2ndParking21Adapter.onParkItemLongClickListener = {
            viewModel.changeEnableState(it)
        }
        rv2ndParking21Adapter.onParkItemClickListener = {
//        "Intent to ParkItemFragment"
//            launchParkItemFragment()
            val intent = this@Parking2ndLvlFragment.context?.let { it1 ->
                ParkItemActivity.newIntentEditItem(it1, it.id)
            }
            startActivity(intent)
        }
        //       2_2

        val rvParking222List = binding.rvParking2ndLvl22
        rv2ndParking22Adapter = ItemAdapter()
        rvParking222List.adapter = rv2ndParking22Adapter

//        REALISE Invoke method from Adapter HERE
        rv2ndParking22Adapter.onParkItemLongClickListener = {
            viewModel.changeEnableState(it)
        }
        rv2ndParking22Adapter.onParkItemClickListener = {
//        "Intent to ParkItemFragment"
//            launchParkItemFragment()
            val intent = this@Parking2ndLvlFragment.context?.let { it1 ->
                ParkItemActivity.newIntentEditItem(it1, it.id)
            }
            startActivity(intent)
        }
        //      2_3

        val rvParking223List = binding.rvParking2ndLvl23
        rv2ndParking23Adapter = ItemAdapter()
        rvParking223List.adapter = rv2ndParking23Adapter

//        REALISE Invoke method from Adapter HERE
        rv2ndParking23Adapter.onParkItemLongClickListener = {
            viewModel.changeEnableState(it)
        }
        rv2ndParking23Adapter.onParkItemClickListener = {
//        "Intent to ParkItemFragment"
//            launchParkItemFragment()
            val intent = this@Parking2ndLvlFragment.context?.let { it1 ->
                ParkItemActivity.newIntentEditItem(it1, it.id)
            }
            startActivity(intent)
        }
        //       3_1

        val rvParking231List = binding.rvParking2ndLvl31
        rv2ndParking31Adapter = ItemAdapter()
        rvParking231List.adapter = rv2ndParking31Adapter

//        REALISE Invoke method from Adapter HERE
        rv2ndParking31Adapter.onParkItemLongClickListener = {
            viewModel.changeEnableState(it)
        }
        rv2ndParking31Adapter.onParkItemClickListener = {
//        "Intent to ParkItemFragment"
//            launchParkItemFragment()
            val intent = this@Parking2ndLvlFragment.context?.let { it1 ->
                ParkItemActivity.newIntentEditItem(it1, it.id)
            }
            startActivity(intent)
        }
        //       4_1

        val rvParking241List = binding.rvParking2ndLvl41
        rv2ndParking41Adapter = ItemAdapter()
        rvParking241List.adapter = rv2ndParking41Adapter

//        REALISE Invoke method from Adapter HERE
        rv2ndParking41Adapter.onParkItemLongClickListener = {
            viewModel.changeEnableState(it)
        }
        rv2ndParking41Adapter.onParkItemClickListener = {
//        "Intent to ParkItemFragment"
//            launchParkItemFragment()
            val intent = this@Parking2ndLvlFragment.context?.let { it1 ->
                ParkItemActivity.newIntentEditItem(it1, it.id)
            }
            startActivity(intent)
        }
        //       4_2

        val rvParking242List = binding.rvParking2ndLvl42
        rv2ndParking42Adapter = ItemAdapter()
        rvParking242List.adapter = rv2ndParking42Adapter

//        REALISE Invoke method from Adapter HERE
        rv2ndParking42Adapter.onParkItemLongClickListener = {
            viewModel.changeEnableState(it)
        }
        rv2ndParking42Adapter.onParkItemClickListener = {
//        "Intent to ParkItemFragment"
//            launchParkItemFragment()
            val intent = this@Parking2ndLvlFragment.context?.let { it1 ->
                ParkItemActivity.newIntentEditItem(it1, it.id)
            }
            startActivity(intent)
        }
        //       4_3

        val rvParking243List = binding.rvParking2ndLvl43
        rv2ndParking43Adapter = ItemAdapter()
        rvParking243List.adapter = rv2ndParking43Adapter

//        REALISE Invoke method from Adapter HERE
        rv2ndParking43Adapter.onParkItemLongClickListener = {
            viewModel.changeEnableState(it)
        }
        rv2ndParking43Adapter.onParkItemClickListener = {
//        "Intent to ParkItemFragment"
//            launchParkItemFragment()
            val intent = this@Parking2ndLvlFragment.context?.let { it1 ->
                ParkItemActivity.newIntentEditItem(it1, it.id)
            }
            startActivity(intent)
        }
        //       4_4

        val rvParking244List = binding.rvParking2ndLvl44
        rv2ndParking44Adapter = ItemAdapter()
        rvParking244List.adapter = rv2ndParking44Adapter

//        REALISE Invoke method from Adapter HERE
        rv2ndParking44Adapter.onParkItemLongClickListener = {
            viewModel.changeEnableState(it)
        }
        rv2ndParking44Adapter.onParkItemClickListener = {
//        "Intent to ParkItemFragment"
//            launchParkItemFragment()
            val intent = this@Parking2ndLvlFragment.context?.let { it1 ->
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