package com.bong.pokedex.ui.components

import android.graphics.Paint.Align
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.bong.pokedex.R
import com.bong.pokedex.ui.theme.GrayScaleBackground
import com.bong.pokedex.ui.theme.GrayScaleDark
import com.bong.pokedex.ui.theme.Primary

@Composable
fun PokemonCard() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier
            .size(104.dp, 108.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
    ) {
        Box(contentAlignment = Alignment.TopEnd, modifier = Modifier.fillMaxWidth().padding(top=4.dp, end = 8.dp)) {
            Text(text = "#999", fontSize = 10.sp)
        }

        Box(
            contentAlignment = Alignment.BottomEnd
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .width(104.dp)
                    .height(98.dp)
                    .zIndex(2f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.poke_mock_image),
                    contentDescription = "poke_mock_image",
                    modifier = Modifier
                        .size(72.dp)
                        .offset(y = (-10).dp),
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(44.dp)
                    .clip(RoundedCornerShape(7.dp))
                    .background(
                        GrayScaleBackground
                    )
                    .padding(bottom = 4.dp)
                    .zIndex(1f),
                contentAlignment = Alignment.BottomCenter
            ) {
                Text("Pokémon Name", fontSize = 10.sp)
            }
        }
    }
}