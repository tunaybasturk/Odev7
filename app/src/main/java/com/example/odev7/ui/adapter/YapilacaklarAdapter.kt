package com.example.kisileruygulamasi.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.odev7.data.entity.Yapilacaklar
import com.example.odev7.databinding.CardTasarimBinding
import com.example.odev7.ui.fragment.AnasayfaFragmentDirections
import com.example.odev7.ui.viewmodel.AnasayfaViewModel
import com.example.odev7.utils.gecis
import com.google.android.material.snackbar.Snackbar

class YapilacaklarAdapter(var mContext: Context,
                     var YapilacaklarListesi:List<Yapilacaklar>,
                     var viewModel: AnasayfaViewModel
)
    : RecyclerView.Adapter<YapilacaklarAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(var tasarim: CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding = CardTasarimBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardTasarimTutucu(binding)
    }



    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yapilacak = YapilacaklarListesi.get(position)
        val t = holder.tasarim
        t.textViewYapilacakAd.text= yapilacak.yapilacak_ad

        t.cardViewSatir.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.yapilacakDetayGecis(yapilacak = yapilacak)
            Navigation.gecis(it,gecis)
        }

        t.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${yapilacak.yapilacak_ad} silinsin mi?",Snackbar.LENGTH_SHORT)
                .setAction("EVET"){
                    viewModel.yapilacaklarSil(yapilacak.yapilacak_id)
                }.show()
        }

    }

    override fun getItemCount(): Int {
        return YapilacaklarListesi.size
    }


}