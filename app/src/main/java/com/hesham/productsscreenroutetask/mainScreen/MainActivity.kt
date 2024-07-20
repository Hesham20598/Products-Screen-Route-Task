package com.hesham.productsscreenroutetask.mainScreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hesham.productsscreenroutetask.productListScreen.ProductListScreen
import com.hesham.productsscreenroutetask.productListScreen.ProductListViewModel
import com.hesham.productsscreenroutetask.ui.theme.ProductsScreenRouteTaskTheme
import com.hesham.productsscreenroutetask.utils.CustomAppBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProductsScreenRouteTaskTheme {
                MainScreenContent()
            }
        }
    }
}

@Composable
fun MainScreenContent(productListViewModel: ProductListViewModel = hiltViewModel()) {
    Scaffold(modifier = Modifier
        .padding(top = 20.dp)
        .fillMaxSize(), topBar = {
        CustomAppBar(onSearchIconClick = { /*TODO*/ }) {
        }
    }) { paddingValues ->
        paddingValues
        productListViewModel.getAllProducts()
        ProductListScreen(
            paddingValues = paddingValues,
            productListViewModel = productListViewModel
        )
    }
}



