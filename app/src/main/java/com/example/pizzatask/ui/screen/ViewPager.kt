package com.example.pizzatask.ui.screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

/**
 * Created by Aziza Helmy on 7/6/2023.
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ViewPager(
    images: List<Int>,
    modifier: Modifier = Modifier,
    onClickImage: () -> Unit = {},
    pagerState: PagerState
) {
    HorizontalPager(
        modifier = modifier,
        pageCount = images.size,
        state = pagerState,
        contentPadding = PaddingValues(horizontal = 32.dp),
    ) { currentPage ->


        val animatedScale by animateFloatAsState(
            targetValue = if (currentPage == pagerState.currentPage) 1f else 0.9f,
            animationSpec = tween(durationMillis = 200)
        )

        Image(
            painter = painterResource(id = images[currentPage]),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .scale(animatedScale)
                .size(200.dp)
                .clickable { onClickImage() }
        )
    }
}