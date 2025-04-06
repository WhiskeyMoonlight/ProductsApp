package com.dimas.productsapp.presentation.app

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.dimas.productsapp.presentation.app.Route.ProductList
import com.dimas.productsapp.presentation.product_list.ProductListScreenRoot
import com.dimas.productsapp.presentation.product_list.ProductListViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Route.ProductGraph
    ) {
        navigation<Route.ProductGraph>(
            startDestination = ProductList
        ) {
            composable<ProductList> {
                val viewModel = koinViewModel<ProductListViewModel>()

                val context = LocalContext.current
                ProductListScreenRoot(
                    viewModel = viewModel,
                    onProductClick = { product ->
                        Toast
                            .makeText(context, product.title, Toast.LENGTH_SHORT)
                            .show()
                    }
                )
            }

            composable<Route.ProductDetails> { }
        }
    }
}