package com.seogaemo.shopping.viewmodel

import androidx.lifecycle.ViewModel
import com.seogaemo.domain.model.TempModel
import com.seogaemo.domain.usecase.TempUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TempViewModel @Inject constructor(private val useCase: TempUseCase): ViewModel() {
    fun getTempModel(): TempModel {
        return useCase.getTempModel()
    }
}