package com.example.odev7.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.odev7.data.entity.Yapilacaklar
import com.example.odev7.data.repo.YapilacaklarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor(var yrepo:YapilacaklarRepository) : ViewModel(){
    var yapilacaklarListesi = MutableLiveData<List<Yapilacaklar>>()

    init {
        yapilacaklarListele()
    }

    fun yapilacaklarSil(yapilacak_id:Int){
        CoroutineScope(Dispatchers.Main).launch {
            yrepo.yapilacaklarSil(yapilacak_id)
            yapilacaklarListele()
        }
    }

    fun yapilacaklarListele(){
        CoroutineScope(Dispatchers.Main).launch {
            yapilacaklarListesi.value = yrepo.yapilacaklarListele()
        }
    }

    fun yapilacaklarAra(aramaKelimesi:String){
        CoroutineScope(Dispatchers.Main).launch {
            yapilacaklarListesi.value = yrepo.yapilacaklarAra(aramaKelimesi)
        }
    }
}