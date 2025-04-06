package com.dimas.productsapp.presentation.product_list

import androidx.lifecycle.ViewModel
import com.dimas.productsapp.domain.ProductUseCases
import com.dimas.productsapp.domain.model.Product
import com.dimas.productsapp.domain.onError
import com.dimas.productsapp.domain.onSuccess
import com.dimas.productsapp.presentation.utils.toUiText
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

class ProductListViewModel(
    private val useCases: ProductUseCases
) : ViewModel(), ContainerHost<ProductListState, ProductListSideEffect> {

    private var cachedProducts = emptyList<Product>()

    override val container =
        container<ProductListState, ProductListSideEffect>(ProductListState()) {
            if (cachedProducts.isEmpty()) {
                getProducts()
            }
        }

    fun onAction(action: ProductListAction) {
        when (action) {
            is ProductListAction.OnProductClick -> handleOnProductClick(action.product)
            ProductListAction.OnTitleClick -> handleOnTitleClick()
            ProductListAction.OnRetryClick -> getProducts()
        }
    }

    private fun handleOnProductClick(product: Product) = intent {
        postSideEffect(ProductListSideEffect.OnProductClick(product))
    }

    private fun handleOnTitleClick() = intent {
        postSideEffect(ProductListSideEffect.OnTitleClick)
    }

    private fun getProducts(): Job = intent {
        container.scope.launch {
            reduce { state.copy(isLoading = true) }
            useCases.getProductsUseCase.invoke()
                .onSuccess { products ->
                    reduce {
                        state.copy(
                            isLoading = false,
                            products = products,
                            errorMessage = null
                        )
                    }
                }
                .onError { error ->
                    reduce {
                        state.copy(
                            isLoading = false,
                            products = emptyList(),
                            errorMessage = error.toUiText()
                        )
                    }
                }
        }
    }
}