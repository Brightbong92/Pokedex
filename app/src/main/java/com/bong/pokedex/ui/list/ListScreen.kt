package com.bong.pokedex.ui.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bong.pokedex.R
import com.bong.pokedex.ui.components.CustomDialog
import com.bong.pokedex.ui.components.PokemonCard
import com.bong.pokedex.ui.components.SearchBar
import com.bong.pokedex.ui.components.SortButton
import com.bong.pokedex.ui.components.SortCard
import com.bong.pokedex.ui.theme.Primary

@Composable
fun ListScreen(viewModel: ListViewModel, onCardClick: (String) -> Unit) {
    if (viewModel.isSortCardOpen) {
        CustomDialog(onDismissRequest = {
            viewModel.onSortCardClose()
        }) {
            SortCard(viewModel.selectedOption) {
                viewModel.onSortCardSelected(it)
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Primary)
            .padding(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(start = 12.dp, top = 12.dp, end = 12.dp)
        ) {
            Column(modifier = Modifier.fillMaxHeight(0.15f)) {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.height(32.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.pokeball),
                        contentDescription = "pokeball",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )

                    Text(
                        text = "Pokédex",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }

                Row(
                    modifier = Modifier
                        .padding(top = 8.dp, end = 12.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    SearchBar(containerWidth = 280.dp, searchBarWidth = 228.dp)
                    SortButton(
                        iconName = viewModel.selectedOption,
                        onOpen = { viewModel.onSortCardOpen() })
                }
            }

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(1f),
                color = Color.White,
                shape = RoundedCornerShape(10.dp)

            ) {
                LazyVerticalGrid(
                    modifier = Modifier.padding(
                        top = 24.dp, start = 12.dp, end = 12.dp
                    ),
                    columns = GridCells.Fixed(3),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(viewModel.pokemonList.size) { index ->
                        if (index + 1 === viewModel.pokemonList.size) {
                            viewModel.loadPokemonList()
                        }
                        val pokemon = viewModel.pokemonList[index]
                        PokemonCard(
                            imgUrl = pokemon.img_url,
                            name = pokemon.name,
                            number = pokemon.id,
                            onCardClick = onCardClick
                        )
                    }
                }
            }
        }
    }
}

