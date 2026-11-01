package com.example.kopiko

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.kopiko.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!

    private val datalist = listOf(
        KopiModel("Espresso", "Murni", "Panas", "Satu shot ekstraksi pekat dengan crema tebal.", "Rp18.000 / cup"),
        KopiModel("Americano", "Murni", "Panas", "Espresso diencerkan air panas, ringan dan bersih.", "Rp20.000 / cup"),
        KopiModel("Kopi Susu Gula Aren", "Susu", "Dingin", "Espresso, susu segar, dan gula aren yang legit.", "Rp24.000 / cup"),
        KopiModel("Cappuccino", "Susu", "Panas", "Espresso dengan susu panas dan busa tebal.", "Rp26.000 / cup"),
        KopiModel("Es Kopi Vietnam", "Susu", "Dingin", "Kopi pekat dengan susu kental manis di atas es.", "Rp25.000 / cup")
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Menu"

        // --- TAMBAHAN BARU UNTUK MEMUNCULKAN DAFTAR KOPI ---
        val adapter = KopikoAdapter(requireContext(), datalist)
        binding.listFacilityItems.adapter = adapter
    }

    // Membersihkan binding saat fragment tertutup (Mencegah error)
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}