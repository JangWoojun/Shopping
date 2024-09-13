package com.seogaemo.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.seogaemo.data.db.entity.PurchaseProductEntity

@Dao
interface PurchaseDao {
    @Query("select * from purchase")
    suspend fun getAll(): List<PurchaseProductEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: PurchaseProductEntity)

    @Query("delete from purchase where productId=:id")
    fun delete(id: String)
}