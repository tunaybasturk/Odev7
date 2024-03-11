package com.example.odev7.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.odev7.databinding.FragmentYapilacakKayitBinding
import com.example.odev7.ui.viewmodel.YapilacakKayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class YapilacakKayitFragment : Fragment() {
    private lateinit var binding: FragmentYapilacakKayitBinding
    private lateinit var viewModel: YapilacakKayitViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentYapilacakKayitBinding.inflate(inflater, container, false)

        binding.buttonKaydet.setOnClickListener {
            val yapilacak_ad = binding.editTextYapilacakAd.text.toString()
            viewModel.yapilacaklarKaydet(yapilacak_ad)
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:YapilacakKayitViewModel by viewModels()
        viewModel = tempViewModel
    }
}