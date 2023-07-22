package com.example.pizzatask.ui.screen

/**
 * Created by Aziza Helmy on 7/22/2023.
 */
interface PizzaInteractionsListener {
    fun updatePizzaSize(size: PizzaSize)
    fun updateToppings(type: Topping, isSelected: Boolean)
    fun updateCurrentPizza(index: Int)
}