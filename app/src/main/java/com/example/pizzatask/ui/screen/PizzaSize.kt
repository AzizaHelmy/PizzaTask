package com.example.pizzatask.ui.screen

/**
 * Created by Aziza Helmy on 7/22/2023.
 */
sealed class PizzaSize(scale: Float) {
    object Small : PizzaSize(0.6f)
    object Medium : PizzaSize(0.7f)
    object Large : PizzaSize(0.8f)
}
