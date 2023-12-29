package com.bong.pokedex.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bong.pokedex.ui.theme.GrayScaleMedium

@Composable
fun PokemonType(typeName: String? = "", bgColor: Color) {
    Box(
        modifier = Modifier
            .width(IntrinsicSize.Min)
            .height(20.dp)
            .background(bgColor, RoundedCornerShape(10.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
            text = typeName ?: "Type",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 10.sp,
            color = Color.White
        )
    }
}