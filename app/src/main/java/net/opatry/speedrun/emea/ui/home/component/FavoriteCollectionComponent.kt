/*
 * Copyright (c) 2021 Olivier Patry
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the Software
 * is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
 * CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package net.opatry.speedrun.emea.ui.home.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.opatry.speedrun.emea.R
import net.opatry.speedrun.emea.data.mySootheCollections
import net.opatry.speedrun.emea.model.MySootheCollection
import net.opatry.speedrun.emea.ui.theme.MySootheTheme
import net.opatry.speedrun.emea.ui.theme.typography

@ExperimentalFoundationApi
@Composable
fun FavoriteCollections(collections: List<MySootheCollection>, modifier: Modifier = Modifier) {
    Column(Modifier.fillMaxWidth()) {
        SectionTitle(stringResource(R.string.favorite_collections), modifier)
        // FIXME Using a grid?
        // LazyVerticalGrid(GridCells.Adaptive(192.dp),Modifier.fillMaxWidth()) {
        //     items(collections) { collection ->
        //         CollectionCard(stringResource(collection.name), painterResource(collection.picture))
        //     }
        // }
        LazyRow(
            Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp)
        ) {
            items(collections.chunked(2)) { column ->
                val first = column.first()
                val second = column.last()
                Column {
                    CollectionCard(
                        stringResource(first.name),
                        painterResource(first.picture),
                        Modifier
                            .width(192.dp)
                            .height(56.dp)
                    )
                    Spacer(Modifier.height(8.dp))
                    CollectionCard(
                        stringResource(second.name),
                        painterResource(second.picture),
                        Modifier
                            .width(192.dp)
                            .height(56.dp)
                    )
                }
                Spacer(Modifier.width(8.dp))
            }
        }
    }
}

@Composable
private fun CollectionCard(name: String, picture: Painter, modifier: Modifier = Modifier) {
    Card(
        modifier,
        elevation = 0.dp,
        shape = MaterialTheme.shapes.small
    ) {
        Row(
            Modifier.clickable { },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                picture,
                null,
                Modifier
                    .fillMaxHeight()
                    .aspectRatio(1f, true),
                contentScale = ContentScale.FillBounds
            )
            Text(
                name,
                Modifier.padding(horizontal = 16.dp),
                style = typography.h3,
                color = MaterialTheme.colors.onSurface
            )
        }
    }
}

@ExperimentalFoundationApi
@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun CollectionsLightPreview() {
    MySootheTheme {
        FavoriteCollections(mySootheCollections, Modifier.padding(horizontal = 16.dp))
    }
}

@ExperimentalFoundationApi
@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun CollectionsDarkPreview() {
    MySootheTheme(darkTheme = true) {
        FavoriteCollections(mySootheCollections, Modifier.padding(horizontal = 16.dp))
    }
}
