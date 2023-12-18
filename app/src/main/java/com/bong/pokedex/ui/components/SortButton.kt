package com.bong.pokedex.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bong.pokedex.R
import com.bong.pokedex.ui.modifiers.drawColoredShadow
import com.bong.pokedex.ui.theme.Primary

@Composable
fun SortButton() {

    Column(
        modifier = Modifier
            .wrapContentSize(Alignment.Center)
            .drawColoredShadow(
                color = Color.Gray,
                alpha = 0.2f,
                borderRadius = 0.dp,
                offsetX = 0.dp,
                offsetY = 1.dp
            )
    ) {
        Box(
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape)
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            IconButton(modifier = Modifier.size(16.dp), onClick = {}) {
                Icon(
                    painter = painterResource(id = R.drawable.sort),
                    contentDescription = "sortButton",
                    tint = Primary,
                    modifier = Modifier.clip(RoundedCornerShape(16.dp))

                )
            }
        }
    }


}