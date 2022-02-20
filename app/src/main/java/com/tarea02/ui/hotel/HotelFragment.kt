package com.tarea02.ui.hotel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.tarea02.R
import com.tarea02.databinding.FragmentHotelBinding
import com.tarea02.viewmodel.HotelViewModel

class HotelFragment : Fragment() {

    private lateinit var hotelViewModel: HotelViewModel
    private var _binding: FragmentHotelBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        hotelViewModel =
            ViewModelProvider(this).get(HotelViewModel::class.java)

        _binding = FragmentHotelBinding.inflate(inflater, container, false)

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_nav_hotel_to_addHotelFragment1)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}