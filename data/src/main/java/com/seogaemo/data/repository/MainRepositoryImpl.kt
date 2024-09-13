package com.seogaemo.data.repository

import android.content.Context
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.seogaemo.domain.model.Product
import com.seogaemo.domain.repository.MainRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.InputStreamReader
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context
): MainRepository {
    override fun getProductList(): List<Product> {
        val inputSource = context.assets.open("product_list.json")
        val inputStreamReader = InputStreamReader(inputSource)
        val jsonString = inputStreamReader.readText()
        val type = object : TypeToken<List<Product>>() {}.type

        return GsonBuilder().create().fromJson(jsonString, type)
    }

}