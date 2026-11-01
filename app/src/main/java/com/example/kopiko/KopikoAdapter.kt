package com.example.kopiko

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.kopiko.databinding.ItemKopiBinding
import com.google.android.material.snackbar.Snackbar

class KopikoAdapter(
    context: Context,
    private val datalist: List<KopiModel>
) : ArrayAdapter<KopiModel>(context, 0, datalist) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ItemKopiBinding.inflate(LayoutInflater.from(context), parent, false)
        val view = binding.root
        val data = datalist[position]

        binding.textNama.text = data.nama
        binding.textJenisUsaha.text = "${data.jenis} • ${data.suhu}"
        binding.textDeskripsi.text = data.deskripsi
        binding.textTarif.text = data.tarif

        view.setOnClickListener {
            Toast.makeText(context, "${data.nama} - ${data.tarif}", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}