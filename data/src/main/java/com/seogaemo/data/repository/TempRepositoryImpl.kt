package com.seogaemo.data.repository

import com.seogaemo.data.datasource.TempDataSource
import com.seogaemo.domain.model.TempModel
import com.seogaemo.domain.repository.TempRepository
import javax.inject.Inject

class TempRepositoryImpl @Inject constructor(private val dataSource: TempDataSource): TempRepository {
    override fun getTempModel(): TempModel {
        return dataSource.getTempModel()
    }
}