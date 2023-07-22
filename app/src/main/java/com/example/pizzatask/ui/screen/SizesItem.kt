package com.example.pizzatask.ui.screen

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Created by Aziza Helmy on 7/21/2023.
 */

@Composable
fun SizesItem(
    modifier: Modifier = Modifier,
    size: String,
    currentSize: String,
    updatePizzaSize: (PizzaSize) -> Unit,
) {
    val itemElevation = animateDpAsState(targetValue = if (currentSize == size) 4.dp else 0.dp)

    Box(
        modifier = modifier
            .size(50.dp)
            .shadow(
                elevation = itemElevation.value,
                shape = CircleShape
            )
            .background(
                color = Color.White
            )
            .clickable {
                when (size) {
                    "S" -> updatePizzaSize(PizzaSize.Small)
                    "M" -> updatePizzaSize(PizzaSize.Medium)
                    "L" -> updatePizzaSize(PizzaSize.Large)
                }
            }, contentAlignment = Alignment.Center
    ) {
        Text(text = size)
    }
}

@Preview
@Composable
fun PreviewSizesItem() {

}