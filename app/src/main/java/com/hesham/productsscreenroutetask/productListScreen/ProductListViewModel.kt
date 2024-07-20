package com.hesham.productsscreenroutetask.productListScreen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hesham.domain.entity.ProductItemDTO
import com.hesham.domain.usecases.GetAllProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(private val getAllProductsUseCase: GetAllProductsUseCase) :
    ViewModel() {
    val productsList = mutableStateListOf<ProductItemDTO>()
    var editTextSearchValue by mutableStateOf("")

    fun getAllProducts() {
        viewModelScope.launch {
            try {
                val response = getAllProductsUseCase()
                productsList.clear()
                productsList.addAll(response)
            } catch (e: Exception) {
                Log.e("TAG", "getAllProducts: this is an occurred exception $e")
            }
        }
    }
}