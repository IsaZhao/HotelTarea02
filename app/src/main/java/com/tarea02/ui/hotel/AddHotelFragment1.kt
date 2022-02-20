package com.tarea02.ui.hotel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.tarea02.R
import com.tarea02.databinding.FragmentAddHotel1Binding
import com.tarea02.model.Hotel
import com.tarea02.viewmodel.HotelViewModel

class AddHotelFragment1 : Fragment() {
    private lateinit var hotelViewModel: HotelViewModel
    private var _binding: FragmentAddHotel1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        hotelViewModel = ViewModelProvider(this).get(HotelViewModel::class.java)

        _binding = FragmentAddHotel1Binding.inflate(inflater, container, false)

        binding.btAddHotel.setOnClickListener {
            agregarHotel()
        }

        return binding.root
    }

    private fun agregarHotel() {
        val nombre= binding.etNombre.text.toString()
        if (nombre.isNotEmpty()){
            val correo= binding.etCorreo.text.toString()
            val telefono= binding.etTelefono.text.toString()
            val web= binding.etWeb.text.toString()
            val hotel= Hotel(0 ,nombre, correo,telefono,web,0.0, 0.0, 0.0, "","")
            hotelViewModel.addHotel(hotel)
            Toast.makeText(requireContext(),
                getString(R.string.msg_hotel_add),
                Toast.LENGTH_SHORT
            ).show()
            findNavController().navigate(R.id.action_addHotelFragment1_to_nav_hotel)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}