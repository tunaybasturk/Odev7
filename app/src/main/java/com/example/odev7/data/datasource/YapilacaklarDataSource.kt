package com.example.odev7.data.datasource

import com.example.odev7.data.entity.Yapilacaklar
import com.example.odev7.room.YapilacaklarDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class YapilacaklarDataSource(var ydao:YapilacaklarDao) {
    suspend fun yapilacaklarKaydet(yapilacak_ad: String){
        val yeniYapilacak = Yapilacaklar(0,yapilacak_ad)
        ydao.yapilacaklarKaydet(yeniYapilacak)
    }

    suspend fun yapilacaklarGuncelle(yapilacak_id: Int,yapilacak_ad:String){
        val guncellenenYapilacak = Yapilacaklar(yapilacak_id,yapilacak_ad)
        ydao.yapilacaklariGuncelle(guncellenenYapilacak)
    }

    suspend fun yapilacaklarSil(yapilacak_id:Int){
        val silinenYapilacak = Yapilacaklar(yapilacak_id,"")
        ydao.yapilacaklarSil(silinenYapilacak)
    }

    suspend fun yapilacaklarListele() : List<Yapilacaklar> = withContext(Dispatchers.IO){
        return@withContext ydao.yapilacaklarListele()
    }

    suspend fun yapilacaklarAra(aramaKelimesi:String) : List<Yapilacaklar> =
        withContext(Dispatchers.IO){
            return@withContext ydao.yapilacaklarAra(aramaKelimesi)
        }
}