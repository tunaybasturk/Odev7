package com.example.odev7.data.repo

import com.example.odev7.data.datasource.YapilacaklarDataSource
import com.example.odev7.data.entity.Yapilacaklar

class YapilacaklarRepository(var yds:YapilacaklarDataSource) {

    suspend fun yapilacaklarKaydet(yapilacak_ad:String) = yds.yapilacaklarKaydet(yapilacak_ad)

    suspend fun yapilacaklarGuncelle(yapilacak_id:Int,yapilacak_ad:String) = yds.yapilacaklarGuncelle(yapilacak_id, yapilacak_ad)

    suspend fun yapilacaklarSil(yapilacak_id: Int) = yds.yapilacaklarSil(yapilacak_id)

    suspend fun yapilacaklarListele() : List<Yapilacaklar> = yds.yapilacaklarListele()

    suspend fun yapilacaklarAra(aramaKelimesi:String) : List<Yapilacaklar> = yds.yapilacaklarAra(aramaKelimesi)
}