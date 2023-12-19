package com.bong.pokedex.ui.detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.bong.pokedex.R
import com.bong.pokedex.ui.components.PokemonType
import com.bong.pokedex.ui.theme.PokemonTypeGrass

@Composable
fun DetailScreen(name: String, onClickBack: () -> Unit) {

    val paddingTop =
        with(LocalDensity.current) { dimensionResource(id = R.dimen.padding_top_value) }
    val paddingEnd =
        with(LocalDensity.current) { dimensionResource(id = R.dimen.padding_end_value) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(PokemonTypeGrass),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, end = 20.dp, bottom = 0.dp, start = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(modifier = Modifier.size(32.dp), onClick = { onClickBack() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.arrow_back),
                            contentDescription = "arrow_back",
                            tint = Color.White
                        )
                    }
                    Text(
                        text = name,
                        color = Color.White,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 24.sp,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
                Text(
                    text = "#001",
                    color = Color.White,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 12.sp
                )
            }

            Box(
                modifier = Modifier
                    .wrapContentSize()
                    .align(Alignment.TopEnd)
                    .padding(top = paddingTop, end = paddingEnd)
                    .zIndex(0f)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.pokeball),
                    contentDescription = "poke_ball",
                    modifier = Modifier
                        .size(208.dp)
                        .alpha(0.1f),
                    tint = Color.White,
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.73f)
                .padding(4.dp)
                .background(Color.White, RoundedCornerShape(8.dp))
                .align(Alignment.BottomCenter),
        ) {
            Box(
                modifier = Modifier
                    .offset(y = (-150).dp)
                    .align(Alignment.TopCenter)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.bulbasaur),
                    contentDescription = "bulbasaur",
                    modifier = Modifier.size(200.dp),
                )
            }

            Box(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .offset(y = 56.dp)
            ) {
                Column(
                    modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Red),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        PokemonType(typeName = "Grass")
                        Spacer(modifier = Modifier.width(16.dp))
                        PokemonType(typeName = "Poison")
                    }

                    Text(
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .fillMaxWidth()
                            .background(Color.Blue),
                        text = "About",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Cyan)
                            .padding(top = 16.dp), horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .background(Color.Yellow)
                                .padding(top = 8.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .height(32.dp)
                                    .background(Color.Red),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.weight),
                                    contentDescription = "weight",
                                    modifier = Modifier.size(16.dp)
                                )
                                Text(
                                    text = "6,9 kg",
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 10.sp
                                )
                            }
                            Text(
                                modifier = Modifier.padding(top = 4.dp),
                                text = "Weight",
                                fontWeight = FontWeight.Normal,
                                fontSize = 8.sp
                            )
                        }

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .background(Color.Yellow)
                                .padding(top = 8.dp)
                                .border(
                                    BorderStroke(5.dp, Color.Red),
                                    shape = RectangleShape,
                                    // 왼쪽과 오른쪽 방향에만 테두리 적용
                                    borderStart = BorderSide(color = Color.Red, width = 5.dp),
                                    borderEnd = BorderSide(color = Color.Red, width = 5.dp)
                                )
//                                .drawBehind {
//                                    val borderSize = 2.dp.toPx()
//                                    drawLine(
//                                        color = Color.Black,
//                                        start = Offset(0f, size.height),
//
//                                        end = Offset(size.width, size.height),
//                                        strokeWidth = borderSize
//                                    )
//                                }
                        ) {
                            Row(
                                modifier = Modifier
                                    .height(32.dp)
                                    .background(Color.Red),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.straighten),
                                    contentDescription = "straighten",
                                    modifier = Modifier
                                        .size(16.dp)
                                        .rotate(90f)
                                )
                                Text(
                                    text = "0,7 m", fontWeight = FontWeight.Normal, fontSize = 10.sp
                                )
                            }
                            Text(
                                modifier = Modifier.padding(top = 4.dp),
                                text = "Height",
                                fontWeight = FontWeight.Normal,
                                fontSize = 8.sp
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .background(Color.Yellow)
                                .padding(top = 8.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .height(32.dp)
                                    .background(Color.Red)
                            ) {
                                Text(
                                    text = "Chlorophyll",
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 10.sp,
                                    lineHeight = 12.sp,

                                    )
                                Text(
                                    text = "Overgrow",
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 10.sp,
                                    lineHeight = 12.sp,

                                    )
                            }
                            Text(
                                modifier = Modifier.padding(top = 4.dp),
                                text = "Moves",
                                fontWeight = FontWeight.Normal,
                                fontSize = 8.sp
                            )
                        }
                    }

                }
            }
        }
    }
}