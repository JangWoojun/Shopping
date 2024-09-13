package com.seogaemo.data.db.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.seogaemo.data.db.entity.LikeProductEntity

interface LikeDao {
    @Query("select * from `like`")
    suspend fun getAll(): List<LikeProductEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: LikeProductEntity)

    @Query("delete from `like` where productId=:id")
    fun delete(id: String)
}