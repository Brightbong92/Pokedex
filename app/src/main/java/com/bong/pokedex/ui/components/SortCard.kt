package com.bong.pokedex.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.bong.pokedex.ui.theme.Primary

@Composable
fun SortCard(selectedOption: String = "", onSelected: (String) -> Unit) {
    val radioOptions = listOf("Number", "Name")
    // selectedOption 상태를 Composable 내에서 사용하기 위해 rememberSaveable로 정의
    var localSelectedOption by rememberSaveable {
        mutableStateOf(selectedOption)
    }

    Card(
        modifier = Modifier.size(113.dp, 132.dp), colors = CardDefaults.cardColors(
            containerColor = Primary
        ), shape = RoundedCornerShape(12.dp)
    ) {
        Column(modifier = Modifier.padding(start = 4.dp, end = 4.dp)) {
            Text(
                text = "Sort by:",
                color = Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 16.dp, horizontal = 20.dp)
            )

            Column(
                modifier = Modifier
                    .width(105.dp)
                    .height(80.dp)
                    .background(Color.White, shape = RoundedCornerShape(8.dp)),
                verticalArrangement = Arrangement.Center
            ) {

                radioOptions.forEach { option ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = (localSelectedOption == option),
                            onClick = {
                                localSelectedOption = option
                                onSelected(option)
                            },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Primary,
                                unselectedColor = Primary,
                            ),
                        )
                        Text(
                            color = Color.Black,
                            fontSize = 10.sp,
                            text = option,
                            modifier = Modifier.padding(start = 8.dp)

                        )
                    }
                }
            }

        }
    }
}