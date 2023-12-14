package com.bong.pokedex.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.unit.dp
import com.bong.pokedex.R
import com.bong.pokedex.ui.theme.GrayScaleBackground
import com.bong.pokedex.ui.theme.Primary

@Composable
fun PokemonCard() {

//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(104.dp)
//            .clip(RoundedCornerShape(7.dp))
//            .background(
//                GrayScaleBackground
//            )
//
//    ) {
//
//    }

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
        Text("#999")

        Image(
            painter = painterResource(id = R.drawable.poke_mock_image),
            contentDescription = "poke_mock_image",
            modifier = Modifier
                .size(400.dp),
            alignment = Alignment.CenterStart
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(104.dp)
                .clip(RoundedCornerShape(7.dp))
                .background(
                    GrayScaleBackground
                )
                .align(Alignment.CenterEnd)
        ) {
            Text("Pokémon Name")
        }
    }
}