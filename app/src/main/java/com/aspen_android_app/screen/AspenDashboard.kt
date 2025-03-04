package com.aspen_android_app.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aspen_android_app.R
import com.aspen_android_app.ui.theme.MontserratFontFamily

@Composable
fun AspenDashboard() {
    var selectedIndex by remember { mutableIntStateOf(0) }
    val categories = listOf("Location", "Hotels", "Food", "Adventure", "Activities")
    var selectedCategory by remember { mutableStateOf(categories[0]) }


    Scaffold(bottomBar = {
        AspenDashboardBottomBar(selectedIndex = selectedIndex,
            onItemSelected = { selectedIndex = it })
    }, content = { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 20.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Explore",
                    fontFamily = MontserratFontFamily,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    fontSize = 14.sp,
                    modifier = Modifier.weight(1f)
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(R.drawable.location),
                        contentDescription = "Location",
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "Aspen, USA",
                        fontSize = 12.sp,
                        color = Color(0xFF606060),
                        fontWeight = FontWeight.Normal,
                        fontFamily = MontserratFontFamily
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Image(
                        painter = painterResource(R.drawable.arrow_down),
                        contentDescription = "Arrow Down",
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
            Text(
                text = "Aspen",
                fontSize = 32.sp,
                color = Color.Black,
                fontFamily = MontserratFontFamily,
                fontWeight = FontWeight.Medium
            )
            SearchBar(topPadding = 24.dp)

            CategoryTabs(topPadding = 32.dp,
                categories = categories,
                selectedCategory = selectedCategory,
                onCategorySelected = { selectedCategory = it })

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Popular",
                    fontSize = 18.sp,
                    color = Color(0xFF232323),
                    fontFamily = MontserratFontFamily,
                    fontWeight = FontWeight.SemiBold
                )

                Text(text = "See all",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF176FF2),
                    modifier = Modifier.clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) { })
            }

            val places = listOf(
                Place("Alley Palace", R.drawable.alley_palace, "4.1", false),
                Place("Coeurdes Alpes", R.drawable.coeurdes_alpes, "4.5", true),
                Place("Sunset Valley", R.drawable.explore_aspen, "4.3", false),
                Place("Mountain Retreat", R.drawable.luxurious_aspen, "4.8", true)
            )

            LazyRow(
                contentPadding = PaddingValues(top = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(28.dp)
            ) {
                items(places) { place ->
                    PlaceCard(
                        place = place,
                        onFavoriteClick = { /* Handle favorite toggle */ }
                    )
                }
            }
        }
    })
}

@Composable
fun AspenDashboardBottomBar(
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit,
) {
    val items = listOf(
        painterResource(R.drawable.home),
        painterResource(R.drawable.ticket),
        painterResource(R.drawable.heart_red),
        painterResource(R.drawable.profile)
    )

    val labels = listOf(
        "Home", "Tickets", "Favori" + "tes", "Profile"
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent),
        contentAlignment = Alignment.BottomCenter // Ensures no bottom margin
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            color = Color.White,
            shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
            shadowElevation = 10.dp
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly // Ensures icons are close
            ) {
                items.forEachIndexed { index, icon ->
                    IconButton(onClick = { onItemSelected(index) }) {
                        Icon(
                            painter = icon,
                            contentDescription = labels[index],
                            tint = if (selectedIndex == index) Color.Blue else Color.Gray,
                            modifier = Modifier.size(28.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun SearchBar(topPadding: Dp) {
    var text by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = topPadding)
            .height(56.dp)
            .background(
                Color(0xFFF3F8FE), shape = RoundedCornerShape(24.dp)
            )
            .border(width = 1.dp, color = Color(0xFFA8CCF0), shape = RoundedCornerShape(24.dp)),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.search),
                contentDescription = "Search",
                modifier = Modifier.size(20.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            BasicTextField(
                value = text,
                onValueChange = { text = it },
                singleLine = true,
                textStyle = TextStyle(
                    color = Color.Black, fontSize = 14.sp
                ),
                decorationBox = { innerTextField ->
                    if (text.isEmpty()) {
                        Text(
                            text = "Find things to do",
                            color = Color(0xFFB8B8B8), // Light gray placeholder color
                            fontSize = 14.sp
                        )
                    }
                    innerTextField()
                },
                modifier = Modifier.weight(1f)
            )


        }
    }
}

@Composable
fun CategoryTabs(
    topPadding: Dp,
    categories: List<String>,
    selectedCategory: String,
    onCategorySelected: (String) -> Unit,
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = topPadding),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(categories) { category ->
            val isSelected = category == selectedCategory
            Box(modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(if (isSelected) Color(0xFFEAF2FF) else Color.Transparent)
                .clickable { onCategorySelected(category) }
                .padding(horizontal = 16.dp, vertical = 8.dp)) {
                Text(
                    text = category,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                    color = if (isSelected) Color(0xFF007AFF) else Color.Gray,
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Composable
fun PlaceCard(place: Place, onFavoriteClick: () -> Unit) {
    Card(
        modifier = Modifier
            .width(224.dp)
            .height(240.dp),
        shape = RoundedCornerShape(24.dp),
        elevation = CardDefaults.cardElevation(4.dp),
    ) {
        Box {
            Image(
                painter = painterResource(id = place.imageRes),
                contentDescription = place.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            // Title & Rating
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(8.dp)
            ) {
                Text(
                    text = place.name,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .background(Color(0xFF4D5652), shape = RoundedCornerShape(58.dp))
                        .padding(horizontal = 10.dp, vertical = 4.dp)
                )

                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .background(Color(0xFF4D5652), shape = RoundedCornerShape(58.dp))
                        .padding(horizontal = 16.dp, vertical = 4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Rating",
                        tint = Color(0xFFFFD700),
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = place.rating, color = Color.White, fontSize = 12.sp)
                }
            }

            // Favorite Button
            IconButton(
                onClick = onFavoriteClick,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(8.dp)
                    .background(Color.White, shape = CircleShape)
            ) {
                Icon(
                    imageVector = if (place.isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                    contentDescription = "Favorite",
                    tint = if (place.isFavorite) Color.Red else Color.Gray
                )
            }
        }
    }
}

// Data Model for Place
data class Place(
    val name: String,
    val imageRes: Int,
    val rating: String,
    val isFavorite: Boolean,
)
