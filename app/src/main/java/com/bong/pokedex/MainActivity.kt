package com.bong.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bong.pokedex.ui.components.PokemonCard
import com.bong.pokedex.ui.components.SearchBar
import com.bong.pokedex.ui.theme.PokedexTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        PokemonCard()
                        SearchBar()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
    Box() {
        Image(
            painter = painterResource(id = R.drawable.arrow_back),
            contentDescription = "arrow_back",
            contentScale = ContentScale.FillWidth,
        )
    }

    val colorHex = "#DC0A2D" // Replace this with your desired hex color code
    val color = Color(android.graphics.Color.parseColor(colorHex))

    Box() {
        Image(
            painter = painterResource(id = R.drawable.text_format),
            contentDescription = "text_format",
            contentScale = ContentScale.FillWidth,
            colorFilter = ColorFilter.tint(color),
            modifier = Modifier.padding(start = 25.dp)
        )
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PokedexTheme {
        Greeting("Android")
    }
}