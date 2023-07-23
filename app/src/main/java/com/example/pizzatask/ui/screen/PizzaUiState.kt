package com.example.pizzatask.ui.screen

import androidx.annotation.DrawableRes
import com.example.pizzatask.R
import java.util.Collections.emptyList

/**
 * Created by Aziza Helmy on 7/10/2023.
 */

data class FoodUiState(
    val pizzas: List<PizzaUiState> = emptyList(),
    val currentPizzaIndex: Int = 0,
)

data class PizzaUiState(
    @DrawableRes val bread: Int = R.drawable.bread_1,
    val price: String = "",
    val pizzaToppings: List<ToppingUiState> = emptyList(),
    val pizzaSizes: List<PizzaSizeUiState> = emptyList(),
    val size: PizzaSize = PizzaSize.Medium,
    val selectedPizzaSize: String = "M"
)

data class ToppingUiState(
    val type: Topping,
    @DrawableRes val singleToppingImage: Int = R.drawable.broccoli_1,
    @DrawableRes val multiToppingImages: Int = R.drawable.broccoli,
    val isSelected: Boolean = false
)

data class PizzaSizeUiState(val size: String = "L", val isSelected: Boolean = false)
