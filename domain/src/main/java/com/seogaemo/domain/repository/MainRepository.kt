package com.seogaemo.domain.repository

import com.seogaemo.domain.model.Product

interface MainRepository {
    fun getProductList(): List<Product>
}