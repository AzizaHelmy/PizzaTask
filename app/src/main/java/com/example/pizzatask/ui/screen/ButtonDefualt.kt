package com.example.pizzatask.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pizzatask.R
import com.example.pizzatask.ui.theme.Brown

/**
 * Created by Aziza Helmy on 7/20/2023.
 */

@Composable
fun ButtonDefault(modifier: Modifier = Modifier) {
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(Brown),
        shape = RoundedCornerShape(8.dp),
        onClick = {}
    ) {
        Icon(
            modifier = Modifier.padding(end = 4.dp),
            painter = painterResource(id = R.drawable.icon_shopping_cart),
            contentDescription = "shopping icon"
        )
        Text(text = stringResource(R.string.add_to_cart))
    }
}

@Preview
@Composable

fun PreviewButton() {
    ButtonDefault()
}
