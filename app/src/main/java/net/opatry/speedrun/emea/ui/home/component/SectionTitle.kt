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

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.opatry.speedrun.emea.R
import net.opatry.speedrun.emea.ui.theme.typography

@Composable
fun SectionTitle(title: String, modifier: Modifier = Modifier) {
    Text(
        title.toUpperCase(),
        Modifier
            .fillMaxWidth()
            .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
            .then(modifier),
        style = typography.h2
    )
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
private fun SectionTitleLightPreview() {
    SectionTitle(stringResource(R.string.align_your_body), Modifier.padding(horizontal = 16.dp))
}