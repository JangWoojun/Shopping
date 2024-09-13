package com.seogaemo.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.seogaemo.data.db.dao.BasketDao
import com.seogaemo.data.db.dao.LikeDao
import com.seogaemo.data.db.dao.PurchaseDao
import com.seogaemo.data.db.entity.BasketProductEntity
import com.seogaemo.data.db.entity.LikeProductEntity
import com.seogaemo.data.db.entity.PurchaseProductEntity

@Database(
    entities = [
        BasketProductEntity::class,
        LikeProductEntity::class,
        PurchaseProductEntity::class
    ],
    version = 1
)
abstract class ApplicationDatabase: RoomDatabase() {
    companion object {
        const val DB_NAME = "applicationDatabase"
    }
    abstract fun purchaseDao(): PurchaseDao
    abstract fun basketDao(): BasketDao
    abstract fun likeDao(): LikeDao


}