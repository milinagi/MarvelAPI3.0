package com.example.marvelapi30.components

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextOverflow
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.marvelapi30.R
import com.example.marvelapi30.model.Comics

@Composable
fun ComicCardView(comic: List<Comics>) {
    val context = LocalContext.current
    LazyVerticalGrid(columns = GridCells.Fixed(2),
        content = {
            items(comic.size) {
                val SuperHeroComics = comic[it]
                BodyCardView(comic = SuperHeroComics, modifier = Modifier.clickable {
                    Toast.makeText(context, comic[it].name, Toast.LENGTH_SHORT).show()
                })
            }
        } )
}

@OptIn(ExperimentalGlideComposeApi::class, ExperimentalMaterialApi::class)
@Composable
fun BodyCardView(comic: Comics, modifier: Modifier) {
    Column(modifier = Modifier) {
        ListItem(
            text = {
                Text(text = comic.name,
                style = MaterialTheme.typography.h6,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis)
            },
        secondaryText = {
                Text(text = comic.description,
                style = MaterialTheme.typography.subtitle2,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis)
        },
            singleLineSecondaryText = false,
            icon = {
                GlideImage(model = comic.photoUrl,
                    contentDescription = "Comic image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.list_item_img_size))
                        .border(
                            BorderStroke(
                                width = dimensionResource(id = R.dimen.list_item_img_stroke),
                                color = Color.Black
                            )
                        ))
            }
        )
    }
}