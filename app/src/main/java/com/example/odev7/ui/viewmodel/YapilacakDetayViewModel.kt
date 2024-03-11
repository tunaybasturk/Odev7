package com.example.odev7.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.odev7.data.repo.YapilacaklarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class YapilacakDetayViewModel @Inject constructor(var yrepo: YapilacaklarRepository) : ViewModel() {

    fun yapilacaklarGuncelle(yapilacak_id: Int, yapilacak_ad: String) {
        CoroutineScope(Dispatchers.Main).launch {
            yrepo.yapilacaklarGuncelle(yapilacak_id,yapilacak_ad)
        }
    }
}