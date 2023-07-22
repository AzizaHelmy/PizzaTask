package com.example.pizzatask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.pizzatask.ui.screen.PizzaScreen
import com.example.pizzatask.ui.theme.PizzaTaskTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                PizzaScreen()
        }
    }
}
