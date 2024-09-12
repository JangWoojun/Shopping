package com.seogaemo.domain.repository

import com.seogaemo.domain.model.TempModel

interface TempRepository {
    fun getTempModel(): TempModel
}