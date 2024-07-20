package com.hesham.productsscreenroutetask.productListScreen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hesham.productsscreenroutetask.utils.ItemProduct

@Composable
fun ProductListScreen(
    paddingValues: PaddingValues,
    productListViewModel: ProductListViewModel

) {


    LazyVerticalGrid(
        columns = GridCells.Fixed(2), modifier = Modifier
            .padding(
                top = paddingValues.calculateTopPadding() + 24.dp,
                bottom = paddingValues.calculateBottomPadding()
            )
            .fillMaxSize()
    ) {
        items(productListViewModel.productsList.size) { position ->
            ItemProduct(
                productItem =productListViewModel.productsList[position],
                index =position,
                onProductItemClick = { /*TODO*/ },
                onAddToWishListClick = { /*TODO*/ }) {

            }

        }
    }

}