package com.example.pizzatask.ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Created by Aziza Helmy on 7/6/2023.
 */
@OptIn(ExperimentalFoundationApi::class, ExperimentalAnimationApi::class)
@Composable
fun ViewPager(
    modifier: Modifier = Modifier,
    updateCurrentPizza: (Int) -> Unit,
    pagerState: PagerState,
    foodUiState: FoodUiState
) {
    val pizzaAnimation = animateFloatAsState(
        targetValue = when (foodUiState.pizzas[foodUiState.currentPizzaIndex].size) {
            PizzaSize.Large -> 0.95f
            PizzaSize.Medium -> 0.75f
            PizzaSize.Small -> 0.6f
        }
    )
    val toppingAnimation = animateFloatAsState(
        targetValue = when (foodUiState.pizzas[foodUiState.currentPizzaIndex].size) {
            PizzaSize.Large -> 0.8f
            PizzaSize.Medium -> 0.7f
            PizzaSize.Small -> 0.5f
        }
    )

    HorizontalPager(
        modifier = modifier,
        pageCount = foodUiState.pizzas.size,
        state = pagerState,
        contentPadding = PaddingValues(horizontal = 16.dp),
    ) { currentPage ->

        updateCurrentPizza(pagerState.currentPage)

        Box(modifier = Modifier.aspectRatio(1f), contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = foodUiState.pizzas[currentPage].bread),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(pizzaAnimation.value)

            )

            if (!pagerState.isScrollInProgress) {
                foodUiState.pizzas[foodUiState.currentPizzaIndex].pizzaToppings.forEach {
                    AnimatedVisibility(
                        visible = it.isSelected && currentPage == pagerState.currentPage,
                        enter = scaleIn(initialScale = 4f) + fadeIn(),
                        exit = fadeOut(animationSpec = tween(10))
                    ) {

                        Image(
                            painter = painterResource(id = it.multiToppingImages),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxSize(toppingAnimation.value)

                        )
                    }
                }

            } else {
                foodUiState.pizzas[currentPage].pizzaToppings.filter { it.isSelected }.forEach {
                    Image(
                        painter = painterResource(id = it.multiToppingImages),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize(toppingAnimation.value)

                    )
                }

            }

        }

    }
}