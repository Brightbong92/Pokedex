package com.bong.pokedex.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bong.pokedex.R
import com.bong.pokedex.ui.theme.GrayScaleDark
import com.bong.pokedex.ui.theme.GrayScaleMedium
import com.bong.pokedex.ui.theme.Primary

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun SearchBar(containerWidth: Dp? = 200.dp, searchBarWidth: Dp? = 120.dp) {

    var keyword by rememberSaveable { mutableStateOf("") }

    val keyboardController = LocalSoftwareKeyboardController.current

    BasicTextField(
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done // This changes the keyboard Enter key to "Done"
        ),
        keyboardActions = KeyboardActions(onDone = {
            keyboardController?.hide()
        }),
        value = keyword,
        onValueChange = {
            if (keyword.length <= 20) {
                keyword = it
            } else if (it.length < keyword.length) {
                keyword = it
            }
        },
        singleLine = true,
        maxLines = 1,
        modifier = Modifier
            .shadow( // Add shadow effect
                elevation = 2.dp, shape = RoundedCornerShape(16.dp)
            ),
        textStyle = TextStyle(
            fontSize = 10.sp, color = GrayScaleDark
        ),
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .fillMaxWidth(0.85f)
//                    .widthIn(max = containerWidth!!)
//                    .fillMaxWidth()
                    .background(color = Color.White, shape = RoundedCornerShape(size = 16.dp))
                    .padding(all = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box(
                    modifier = Modifier
                        .width(16.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.search),
                        contentDescription = "searchIcon",
                        colorFilter = ColorFilter.tint(Primary),
                        modifier = Modifier.size(16.dp)
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
//                        .width(searchBarWidth!!)
                ) {
                    Box() {
                        if (keyword.isEmpty()) {
                            Text(text = "Search", color = GrayScaleMedium, fontSize = 10.sp)
                        }
                    }
                    Box() {
                        innerTextField()
                    }
                }

                Box(modifier = Modifier
                    .width(16.dp)
                    .clickable {
                        keyword = ""
                    }) {
                    if (keyword.isNotEmpty()) {
                        Image(
                            painter = painterResource(id = R.drawable.close),
                            contentDescription = "searchIcon",
                            colorFilter = ColorFilter.tint(Primary),
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }
        },
    )


}