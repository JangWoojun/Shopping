package com.seogaemo.data.datasource

import com.seogaemo.domain.model.TempModel
import javax.inject.Inject

class TempDataSource @Inject constructor() {
    fun getTempModel(): TempModel {
        return TempModel("testModel")
    }
}