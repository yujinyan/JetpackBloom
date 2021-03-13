package com.example.androiddevchallenge

import androidx.annotation.DrawableRes
import androidx.cardview.widget.CardView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

private val screenPadding = Modifier.padding(horizontal = 16.dp)

val themes = listOf(
    "Desert chic" to R.drawable.desert_chic,
    "Tiny terrariums" to R.drawable.tiny_terrariums,
    "Jungle vibes" to R.drawable.jungle_vibes,
    "Easy care" to R.drawable.easy_care,
    "Statements" to R.drawable.statements
)

val plants = listOf(
    "Monstera" to R.drawable.montstera,
    "Aglaonema" to R.drawable.aglaonema,
    "Peace lily" to R.drawable.peace_lily,
    "Fiddle leaf tree" to R.drawable.fiddle_leaf,
    "Snake plant" to R.drawable.snake_plant,
    "Pothos" to R.drawable.pothos
)

@Composable
fun HomeScreen() = Scaffold(
    bottomBar = {
        BottomNavigation(
            elevation = 16.dp
        ) {
            BottomNavigationItem(selected = false, onClick = { /*TODO*/ }, icon = {
                Icon(Icons.Default.Home, "home")
            }, label = { Text(text = "Home") })
            BottomNavigationItem(selected = false, onClick = { /*TODO*/ }, icon = {
                Icon(Icons.Default.FavoriteBorder, "favorite")
            }, label = { Text(text = "Favorites") })

            BottomNavigationItem(selected = false, onClick = { /*TODO*/ }, icon = {
                Icon(Icons.Default.AccountCircle, "profile")
            }, label = { Text(text = "Profile") })
            BottomNavigationItem(selected = false, onClick = { /*TODO*/ }, icon = {
                Icon(Icons.Default.ShoppingCart, "cart")
            }, label = { Text(text = "Cart") })
        }
    },
) {
    Column(
        Modifier
            .padding(it)
            .fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.size(40.dp))
        OutlinedTextField(
            value = "", onValueChange = { /*TODO*/ }, placeholder = {
                Text(text = "Search")
            },
            modifier = screenPadding.fillMaxWidth(),
            leadingIcon = {
                Icon(
                    Icons.Default.Search,
                    contentDescription = "Search",
                    modifier = Modifier.size(18.dp)
                )
            }
        )
        Text(
            text = "Browse themes",
            style = MaterialTheme.typography.h1,
            modifier = Modifier
                .paddingFromBaseline(32.dp, 16.dp)
                .padding(horizontal = 16.dp)
        )
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp, 0.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(themes) {
                ThemeCard(theme = it.first, cover = it.second)
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Design your home garden",
                style = MaterialTheme.typography.h1,
                modifier = Modifier
                    .paddingFromBaseline(40.dp, 16.dp)
            )
            Icon(
                Icons.Default.FilterList,
                "filter",
                modifier = Modifier.paddingFromBaseline(40.dp, 16.dp)
            )
        }
        LazyColumn(
            Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
        ) {
            items(plants) {
                PlantRow2(title = it.first, cover = it.second)
                Spacer(modifier = Modifier.size(8.dp))
            }
        }
    }
}

@Composable
fun ThemeCard(
    theme: String,
    @DrawableRes cover: Int

) = Card(
    modifier = Modifier
        .height(136.dp)
        .width(8.dp * 17),
    elevation = 1.dp,
    shape = MaterialTheme.shapes.medium
) {

    Column(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = cover),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.height(96.dp)
        )
    }
    Text(
        text = theme, style = MaterialTheme.typography.h2,
        modifier = Modifier
            .paddingFromBaseline(top = 24.dp, bottom = 16.dp)
            .padding(horizontal = 16.dp)

    )
}

@Composable
fun PlantRow2(
    title: String,
    @DrawableRes cover: Int,
) = ConstraintLayout(Modifier.fillMaxWidth()) {

    val (thumb, middle, checkbox, hr) = createRefs()
    Box(Modifier
        .constrainAs(thumb) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
        }
        .clip(RoundedCornerShape(2.dp))
    ) {
        Image(
            painter = painterResource(id = cover),
            contentDescription = title,
            modifier = Modifier.size(64.dp),
            contentScale = ContentScale.Crop,
        )
    }

    Box(modifier = Modifier.constrainAs(middle) {
        top.linkTo(parent.top)
        start.linkTo(thumb.end, 16.dp)
    }) {
        Text(
            text = title,
            style = MaterialTheme.typography.h2,
            modifier = Modifier.paddingFromBaseline(24.dp)
        )
        Text(
            text = "This is a description",
            style = MaterialTheme.typography.body1,
            modifier = Modifier.paddingFromBaseline(40.dp)
        )
    }

    Checkbox(
        modifier = Modifier
            .constrainAs(checkbox) {
                top.linkTo(parent.top, 16.dp)
                end.linkTo(parent.end)
            }
            .size(24.dp),
        checked = false,
        onCheckedChange = { /*TODO*/ })

    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(MaterialTheme.colors.onBackground)
            .constrainAs(hr) {
                bottom.linkTo(parent.bottom)
                start.linkTo(middle.start)
            }
    )

}


@Preview(widthDp = 360, heightDp = 640)
@Composable
fun HomeScreenPreview() = BloomApp {
    HomeScreen()
}

//@Preview(widthDp = 360, heightDp = 640)
@Composable
fun ThemeCardPreview() = BloomApp {
    val data = themes.first()
    ThemeCard(data.first, data.second)
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun PlantRowPreview() = BloomApp {
    val data = plants.first()
    PlantRow2(data.first, data.second)
}

