package com.example.pizzatask.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
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
fun IngredientItem(
    state: IngredientUiState,
    isSelected: Boolean = true,
    onClick: () -> Unit = {}
) {
    Box(modifier = Modifier
        .size(64.dp)
        .clip(CircleShape)
        .clickable { onClick() }
        .background(if (isSelected) Color.Green.copy(alpha = 0.1f) else Color.Transparent)
        .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.size(32.dp),
            painter = painterResource(id = state.image),
            contentDescription = "ingredients"
        )
    }
}

@Preview
@Composable
fun PreviewIngredientItem() {
    IngredientItem(state = IngredientUiState())
}