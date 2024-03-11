package com.example.odev7.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.odev7.data.entity.Yapilacaklar

@Dao
interface YapilacaklarDao {
    @Query("SELECT * FROM toDos")
    suspend fun yapilacaklarListele() : List<Yapilacaklar>

    @Insert
    suspend fun yapilacaklarKaydet(yapilacak:Yapilacaklar)

    @Update
    suspend fun yapilacaklariGuncelle(yapilacak:Yapilacaklar)

    @Delete
    suspend fun yapilacaklarSil(yapilacak: Yapilacaklar)

    @Query("SELECT * FROM toDos WHERE name like '%' || :aramaKelimesi || '%'")
    suspend fun yapilacaklarAra(aramaKelimesi:String) : List<Yapilacaklar>
}