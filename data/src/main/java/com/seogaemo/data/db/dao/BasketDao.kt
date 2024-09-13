package com.seogaemo.data.db.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.seogaemo.data.db.entity.BasketProductEntity

interface BasketDao {
    @Query("select * from basket")
    suspend fun getAll(): List<BasketProductEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: BasketProductEntity)

    @Query("delete from basket where productId=:id")
    fun delete(id: String)
}