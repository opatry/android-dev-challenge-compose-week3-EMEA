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

package net.opatry.speedrun.emea.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.opatry.speedrun.emea.R

@Composable
fun SearchComponent(modifier: Modifier = Modifier) {
    var query by remember { mutableStateOf("") }
    TextField(value = query,
        onValueChange = { query = it },
        modifier.fillMaxWidth(),
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.surface),
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                null,
                Modifier.size(18.dp)
            )
        },
        placeholder = {
            Box(
                Modifier.fillMaxSize(),
                contentAlignment = Alignment.CenterStart
            ) {
                // TODO replicate text style
                Text(stringResource(R.string.search), style = LocalTextStyle.current)
            }
        })
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
private fun SearchComponentLightPreview() {
    SearchComponent()
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
private fun SearchComponentDarkPreview() {
    SearchComponent()
}