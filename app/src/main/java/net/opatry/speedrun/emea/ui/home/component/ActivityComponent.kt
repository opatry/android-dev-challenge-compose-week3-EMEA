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

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.opatry.speedrun.emea.R
import net.opatry.speedrun.emea.data.mySootheMindActivities
import net.opatry.speedrun.emea.model.MySootheActivity
import net.opatry.speedrun.emea.ui.theme.MySootheTheme
import net.opatry.speedrun.emea.ui.theme.typography

@Composable
fun Activities(
    title: String,
    activities: List<MySootheActivity>,
    modifier: Modifier = Modifier
) {
    Column(Modifier.fillMaxWidth()) {
        SectionTitle(title, modifier)
        LazyRow(
            Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp)
        ) {
            items(activities) { activity ->
                ActivityComponent(
                    stringResource(activity.name),
                    painterResource(activity.picture)
                )
                Spacer(Modifier.width(8.dp))
            }
        }
    }
}

@Composable
fun ActivityComponent(name: String, picture: Painter) {
    Column(
        Modifier
            .clickable(
                enabled = true,
                role = Role.Button,
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(bounded = false)
            ) { },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            picture,
            null,
            Modifier
                .width(88.dp)
                .aspectRatio(1f)
                .clip(CircleShape),
            contentScale = ContentScale.FillBounds
        )
        Text(
            name,
            Modifier.paddingFromBaseline(top = 24.dp),
            style = typography.h3,
            textAlign = TextAlign.Center
        )
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
private fun ActivitiesLightPreview() {
    MySootheTheme {
        Activities(stringResource(R.string.align_your_mind), mySootheMindActivities)
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
private fun ActivitiesDarkPreview() {
    MySootheTheme(darkTheme = true) {
        Activities(stringResource(R.string.align_your_mind), mySootheMindActivities)
    }
}
