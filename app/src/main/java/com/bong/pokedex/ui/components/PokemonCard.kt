package com.bong.pokedex.ui.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import coil.compose.AsyncImage
import com.bong.pokedex.R
import com.bong.pokedex.ui.theme.GrayScaleBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonCard(
    imgUrl: String? = "",
    number: Int? = -1,
    name: String? = "",
    onCardClick: (String) -> Unit,
) {
    Card(colors = CardDefaults.cardColors(
        containerColor = Color.White
    ),
        modifier = Modifier.size(104.dp, 108.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        onClick = { onCardClick(name!!) }) {
        Box(
            contentAlignment = Alignment.TopEnd,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp, end = 8.dp)
        ) {
            Text(text = "${"#" + number.toString()}", fontSize = 10.sp)
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
                if (imgUrl.isNullOrEmpty()) {
                    Loader()
                } else {
                    AsyncImage(
                        model = imgUrl,
                        contentDescription = null,
                        modifier = Modifier
                            .size(72.dp)
                            .offset(y = (-10).dp),
                    )
                }
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
                    .zIndex(1f), contentAlignment = Alignment.BottomCenter
            ) {
                val pokemonName =
                    name?.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
                Text(pokemonName ?: "", fontSize = 10.sp)
            }
        }
    }
}