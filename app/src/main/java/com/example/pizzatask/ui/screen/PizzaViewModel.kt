package com.example.pizzatask.ui.screen

import androidx.lifecycle.ViewModel
import com.example.pizzatask.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * Created by Aziza Helmy on 7/10/2023.
 */

class PizzaViewModel : ViewModel() {

    private val _state = MutableStateFlow(FoodUiState())
    val state = _state.asStateFlow()

    init {
        getPizzaType()
        getPizzaSize()
        getPizzaIngredient()
    }

    private fun getPizzaType() {
        _state.update {
            it.copy(
                pizza = listOf(
                    PizzaUiState(image = R.drawable.bread_1),
                    PizzaUiState(image = R.drawable.bread_2),
                    PizzaUiState(image = R.drawable.bread_3),
                    PizzaUiState(image = R.drawable.bread_4),
                    PizzaUiState(image = R.drawable.bread_5),
                )
            )
        }
    }

    private fun getPizzaIngredient() {
        _state.update { foodUiState ->
            foodUiState.copy(pizza = foodUiState.pizza.map {
                it.copy(
                    pizzaIngredients = listOf(
                        IngredientUiState(id = 0, image = R.drawable.onion_1),
                        IngredientUiState(id = 0, image = R.drawable.broccoli_1),
                        IngredientUiState(id = 0, image = R.drawable.mushroom_1),
                        IngredientUiState(id = 0, image = R.drawable.sausage_1),
                        IngredientUiState(id = 0, image = R.drawable.basil_3),
                    )
                )
            })
        }
    }

    private fun getPizzaSize() {
        _state.update {
            it.copy(
                pizzaSizes = listOf(
                    PizzaSizeUiState(size = "S", isSelected = false),
                    PizzaSizeUiState(size = "M", isSelected = false),
                    PizzaSizeUiState(size = "L", isSelected = true),
                )
            )
        }
    }
}