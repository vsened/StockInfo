package com.vsened.stockinfo.presentation.company_info

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.vsened.stockinfo.domain.repository.StockRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CompanyInfoViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: StockRepository
): ViewModel() {

}