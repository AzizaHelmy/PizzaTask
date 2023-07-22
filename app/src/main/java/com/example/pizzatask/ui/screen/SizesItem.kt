package com.example.pizzatask.ui.screen

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
    text: String="M",
    onClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .shadow(
                elevation = 2.dp,
                shape = CircleShape)
            .size(50.dp)
            .background(
                color = Color.White)
            .clickable { onClick() }, contentAlignment = Alignment.Center
    ) {
        Text(text =text)
    }
}

@Preview
@Composable
fun PreviewSizesItem() {
    SizesItem(
        onClick = {}
    )
}