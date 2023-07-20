package com.example.pizzatask.ui.screen

import com.example.pizzatask.R
import java.util.Collections.emptyList

/**
 * Created by Aziza Helmy on 7/10/2023.
 */

data class FoodUiState(
    val pizza: List<PizzaUiState> = emptyList(),
    val pizzaSizes: List<PizzaSizeUiState> = emptyList(),
    val currentPizza: Int = 0,
    val selectedPizzaSize: String = "M"
)

data class PizzaUiState(
    val image: Int = R.drawable.bread_1,
    val hasIngredient: Boolean = false,
    val pizzaIngredients: List<IngredientUiState> = emptyList(),
)

data class PizzaSizeUiState(val size: String = "L", val isSelected: Boolean = false)

data class IngredientUiState(
    val id: Int = 0,
    val image: Int = R.drawable.broccoli_1,
    val isSelected: Boolean = false
)
