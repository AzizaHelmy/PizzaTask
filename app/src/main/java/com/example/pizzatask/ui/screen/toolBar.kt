package com.example.pizzatask.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzatask.R

/**
 * Created by Aziza Helmy on 7/20/2023.
 */

@Composable
fun toolBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            painter = painterResource(id = R.drawable.icon_arrow_back),
            contentDescription = "icon arrow back"
        )
        Text(text = "Pizza", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Icon(
            painter = painterResource(id = R.drawable.icon_favorite),
            contentDescription = "icon favorite"
        )
    }
}