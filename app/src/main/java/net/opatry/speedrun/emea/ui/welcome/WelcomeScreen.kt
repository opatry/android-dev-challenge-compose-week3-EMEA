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
package net.opatry.speedrun.emea.ui.welcome

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.opatry.speedrun.emea.R
import net.opatry.speedrun.emea.ui.theme.MySootheTheme
import net.opatry.speedrun.emea.ui.welcome.component.WelcomeButton

@Composable
fun WelcomeScreen(onSignIn: () -> Unit) {
    Surface(color = MaterialTheme.colors.background) {
        Box(
            Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                welcomeBackground(),
                null,
                Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
            Column(
                Modifier.padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // AppTitle(stringResource(R.string.app_name), Modifier.padding(bottom = 32.dp))
                Image(logo(), stringResource(R.string.app_name), Modifier.padding(bottom = 32.dp))
                WelcomeButton(onClick = { }) {
                    Text(stringResource(R.string.welcome_signup).toUpperCase())
                }
                WelcomeButton(onClick = onSignIn, secondary = true) {
                    Text(stringResource(R.string.welcome_login).toUpperCase())
                }
            }
        }
    }
}

@Composable
private fun welcomeBackground() = painterResource(
    when {
        isSystemInDarkTheme() -> R.drawable.dark_welcome
        else -> R.drawable.light_welcome
    }
)

@Composable
private fun logo() = painterResource(
    when {
        isSystemInDarkTheme() -> R.drawable.dark_logo
        else -> R.drawable.light_logo
    }
)

@ExperimentalFoundationApi
@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
private fun WelcomeLightPreview() {
    MySootheTheme {
        WelcomeScreen {}
    }
}

@ExperimentalFoundationApi
@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
private fun WelcomeDarkPreview() {
    MySootheTheme(darkTheme = true) {
        WelcomeScreen {}
    }
}
