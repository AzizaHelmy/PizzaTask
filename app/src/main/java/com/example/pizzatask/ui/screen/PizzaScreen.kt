package com.example.pizzatask.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pizzatask.R

/**
 * Created by Aziza Helmy on 7/10/2023.
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PizzaScreen(viewModel: PizzaViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    val pagerState = rememberPagerState(initialPage = 1)

    PizzaContent(FoodUiState(), PizzaUiState(), pagerState = pagerState)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun PizzaContent(state: FoodUiState, fake: PizzaUiState, pagerState: PagerState) {

    Column(
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        toolBar()
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.plate),
                contentDescription = "plate image",
                alignment = Alignment.TopCenter,
                modifier = Modifier.size(220.dp)
            )
            ViewPager(
                images = listOf(
                    R.drawable.bread_1,
                    R.drawable.bread_2,
                    R.drawable.bread_3,
                    R.drawable.bread_4,
                    R.drawable.bread_5,
                ),
                pagerState = pagerState
            )
        }
        Text(
            text = "$16",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(24.dp)
        )

        Text(
            text = "CUSTOMIZE YOUR PIZZA",
            modifier = Modifier
                .padding(top = 64.dp, start = 16.dp)
                .align(alignment = Alignment.Start)
        )
        LazyRow() {
            itemsIndexed(fake.pizzaIngredients) { index, item ->
                IngredientItem(state = item)
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        ButtonDefault(
            modifier = Modifier.Companion
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 16.dp)
        )
    }
}


@Composable
fun PizzaScaffold(
    header: (@Composable () -> Unit)? = null,
    content: @Composable (paddingValues: PaddingValues) -> Unit
) {
    header?.invoke()
    content(PaddingValues(top = 0.dp))

}

@Preview(showSystemUi = true)
@Composable
fun PreviewPizzaScreen() {
    PizzaScreen()
}
