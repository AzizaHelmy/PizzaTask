package com.example.pizzatask.ui.screen

import androidx.lifecycle.ViewModel
import com.example.pizzatask.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * Created by Aziza Helmy on 7/10/2023.
 */

class PizzaViewModel : ViewModel(), PizzaInteractionsListener {

    private val _state = MutableStateFlow(FoodUiState())
    val state = _state.asStateFlow()

    init {
        getPizza()
        getPizzaToppings()
    }

    private fun getPizza() {
        _state.update {
            it.copy(
                pizzas = listOf(
                    PizzaUiState(bread = R.drawable.bread_1),
                    PizzaUiState(bread = R.drawable.bread_2),
                    PizzaUiState(bread = R.drawable.bread_3),
                    PizzaUiState(bread = R.drawable.bread_4),
                    PizzaUiState(bread = R.drawable.bread_5),
                )
            )
        }
    }

    override fun updateCurrentPizza(index: Int) {
        _state.update {
            it.copy(currentPizzaIndex = index)
        }
    }

    override fun updateToppings(type: Topping, isSelected: Boolean) {
        _state.update {
            it.copy(pizzas = it.pizzas.mapIndexed { index, pizzaUiState ->
                if (index == state.value.currentPizzaIndex) {
                    pizzaUiState.copy(pizzaToppings = pizzaUiState.pizzaToppings.map { topping ->
                        if (topping.type == type) {
                            topping.copy(isSelected = isSelected)
                        } else {
                            topping
                        }
                    })
                } else {
                    pizzaUiState
                }
            })
        }
    }

    override fun updatePizzaSize(size: PizzaSize) {
        _state.update {
            it.copy(pizzas = it.pizzas.mapIndexed { index, pizzaUiState ->
                if (index == state.value.currentPizzaIndex) {
                    val currentSize = when (size) {
                        PizzaSize.Large -> "L"
                        PizzaSize.Medium -> "M"
                        PizzaSize.Small -> "S"
                    }
                    pizzaUiState.copy(size = size, selectedPizzaSize = currentSize)
                } else {
                    pizzaUiState
                }
            })
        }
    }

    private fun getPizzaToppings() {
        _state.update { foodUiState ->
            foodUiState.copy(pizzas = foodUiState.pizzas.map {
                it.copy(
                    pizzaToppings = listOf(
                        ToppingUiState(
                            type = Topping.ONION,
                            singleToppingImage = R.drawable.onion_1,
                            multiToppingImages = R.drawable.onion
                        ),
                        ToppingUiState(
                            type = Topping.BROCCOLI,
                            singleToppingImage = R.drawable.broccoli_1,
                            multiToppingImages = R.drawable.broccoli
                        ),
                        ToppingUiState(
                            type = Topping.MUSHROOM,
                            singleToppingImage = R.drawable.mushroom_1,
                            multiToppingImages = R.drawable.mushroom
                        ),
                        ToppingUiState(
                            type = Topping.SAUSAGE,
                            singleToppingImage = R.drawable.sausage_1,
                            multiToppingImages = R.drawable.sausage
                        ),
                        ToppingUiState(
                            type = Topping.BASIL,
                            singleToppingImage = R.drawable.basil_3,
                            multiToppingImages = R.drawable.basil
                        ),
                    )
                )
            })
        }
    }


}