package com.hesham.productsscreenroutetask.mainScreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hesham.productsscreenroutetask.ui.theme.ProductsScreenRouteTaskTheme
import com.hesham.productsscreenroutetask.utils.CustomAppBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProductsScreenRouteTaskTheme {
                Scaffold(modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxSize(), topBar = {
                        CustomAppBar(onSearchIconClick = { /*TODO*/ }) {

                        }
                }) { paddingValues ->
                    paddingValues

                }
            }
        }
    }
}



