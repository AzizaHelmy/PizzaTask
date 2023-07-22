package com.example.pizzatask.ui.screen

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Created by Aziza Helmy on 7/20/2023.
 */

@Composable
fun ToppingItem(
    state: ToppingUiState,
    updateTopping: (type: Topping, isSelected: Boolean) -> Unit,
) {

    val toppingAnimationColor =
        animateColorAsState(targetValue = if (state.isSelected) Color.Green.copy(alpha = 0.1f) else Color.Transparent)

    Box(modifier = Modifier
        .size(64.dp)
        .clip(CircleShape)
        .clickable(
            indication = null,
            interactionSource = remember { MutableInteractionSource() }) {
            updateTopping(
                state.type,
                !state.isSelected
            )
        }
        .background(toppingAnimationColor.value)
        .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.size(40.dp),
            painter = painterResource(id = state.singleToppingImage),
            contentDescription = "ingredients"
        )
    }
}

@Preview
@Composable
fun PreviewIngredientItem() {
    // IngredientItem(state = ToppingUiState())
}