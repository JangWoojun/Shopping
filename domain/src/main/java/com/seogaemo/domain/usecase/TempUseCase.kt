package com.seogaemo.domain.usecase

import com.seogaemo.domain.model.TempModel
import com.seogaemo.domain.repository.TempRepository
import javax.inject.Inject

class TempUseCase @Inject constructor(private val repository: TempRepository) {
    fun getTempModel(): TempModel {
        return repository.getTempModel()
    }
}