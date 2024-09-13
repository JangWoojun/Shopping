package com.seogaemo.data.db.converter

import androidx.room.TypeConverter
import com.google.gson.GsonBuilder
import com.seogaemo.domain.model.Category
import com.seogaemo.domain.model.Price
import com.seogaemo.domain.model.Shop

class LikeConverter {
    private val gson = GsonBuilder().create()

    @TypeConverter
    fun fromPrice(value: Price): String {
        return gson.toJson(value)
    }
    @TypeConverter
    fun toPrice(value: String): Price {
        return gson.fromJson(value, Price::class.java)
    }

    @TypeConverter
    fun fromCategory(value: Category): String {
        return gson.toJson(value)
    }
    @TypeConverter
    fun toCategory(value: String): Category {
        return gson.fromJson(value, Category::class.java)
    }

    @TypeConverter
    fun fromShop(value: Shop): String {
        return gson.toJson(value)
    }
    @TypeConverter
    fun toShop(value: String): Shop {
        return gson.fromJson(value, Shop::class.java)
    }
}