package com.example.bc_parking1beta.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.bc_parking.R
import com.example.bc_parking.databinding.FragmentWelcomeBinding

class WelcomeFragment: Fragment() {

    private var _binding: FragmentWelcomeBinding? = null
    private val binding: FragmentWelcomeBinding
        get() = _binding ?: throw RuntimeException("FragmentWelcomeBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWelcomeBinding.inflate(inflater, container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonOutsidePark1.setOnClickListener {
//            Toast.makeText(context, "HIGHGUI", Toast.LENGTH_LONG).show()
            launchOutsideParking1Fragment()
        }
        binding.buttonOutsidePark2.setOnClickListener {
            launchOutsideParking2Fragment()
        }
        binding.buttonParking1stLvl.setOnClickListener {
            launchParking1stLvlFragment()
        }
        binding.buttonParking2ndLvl.setOnClickListener {
            launchParking2ndLvlFragment()
        }
    }
    private fun launchOutsideParking1Fragment() {
        findNavController().navigate(R.id.action_welcomeFragment_to_outsideParkingFragment)
    }

    private fun launchOutsideParking2Fragment() {
        findNavController().navigate(R.id.action_welcomeFragment_to_outsideParkingFragment2)
    }

    private fun launchParking1stLvlFragment() {
        findNavController().navigate(R.id.action_welcomeFragment_to_parking1stLvlFragment)
    }

    private fun launchParking2ndLvlFragment() {
        findNavController().navigate(R.id.action_welcomeFragment_to_parking2ndLvlFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}