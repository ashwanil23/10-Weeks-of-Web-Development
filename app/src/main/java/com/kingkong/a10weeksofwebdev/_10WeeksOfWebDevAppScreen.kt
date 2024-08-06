package com.kingkong.a10weeksofwebdev

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kingkong.a10weeksofwebdev.model._10WeeksOfWebDev
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun _10WeeksOfWebDevList(
    tipsList: List<_10WeeksOfWebDev>,
    modifier: Modifier= Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){
    val visibleState = remember {
        MutableTransitionState(false).apply {
            targetState = true
        }
    }
    AnimatedVisibility(visibleState = visibleState,
        enter = fadeIn(
                animationSpec = spring(dampingRatio = Spring.DampingRatioNoBouncy)
        ),
        exit = shrinkOut(),
        modifier = Modifier
    ) {
        LazyColumn(
            contentPadding = contentPadding
        ) {
            itemsIndexed(tipsList){index, item ->
                _10WeeksOfWebDevListItem(
                    dataClassObject = item,
                    modifier = Modifier.
                    animateEnterExit(
                        enter = slideInHorizontally(
                            animationSpec = spring(
                                stiffness = Spring.StiffnessMediumLow,
                                dampingRatio = Spring.DampingRatioLowBouncy
                            )
                        )
                    )
                )
            }
        }
    }


}
@Composable
fun _10WeeksOfWebDevListItem(dataClassObject: _10WeeksOfWebDev,
           modifier: Modifier
){
    Card (elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier.padding(
        vertical = 8.dp,
        horizontal = 16.dp),
        ){
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp)
            ) {
            Spacer(modifier = Modifier.padding(vertical = 8.dp))
            Text(
                text = stringResource(id = dataClassObject.weekRes),
                style = MaterialTheme.typography.titleLarge,

            )
            Text(
                text = stringResource(id = dataClassObject.titleRes),
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.padding(vertical = 8.dp))
            Box(modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp)),
                contentAlignment = Alignment.Center
                ){
                Image(painter = painterResource(
                    id = dataClassObject.imageRes),
                    contentDescription =null ,
                    alignment = Alignment.Center,
                    contentScale = ContentScale.FillWidth
                )
            }
            Spacer(modifier = Modifier.padding(vertical = 8.dp))

            Text(
                text = stringResource(id = dataClassObject.descriptionRes),
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.padding(vertical = 8.dp))

        }
    }
}