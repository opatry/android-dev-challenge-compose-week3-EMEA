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
package net.opatry.speedrun.emea

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.opatry.speedrun.emea.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MySootheApp()
            }
        }
    }
}

private enum class MainTabs(
    @StringRes val titleRes: Int,
    val icon: ImageVector
) {
    Home(R.string.nav_home, Icons.Default.Spa),
    // FIXME FAB
    Run(R.string.nav_run, Icons.Default.PlayArrow),
    Profile(R.string.nav_profile, Icons.Default.AccountCircle)
}

@Composable
fun MySootheApp(signedIn: Boolean = true) {
    if (!signedIn) {
        LoginScreen()
    } else {
        MainScreen()
    }
}

@Composable
fun LoginScreen() {
    Text("TODO LOGIN")
}

@Composable
fun MainScreen() {

    val (selectedTab, setSelectedTab) = remember { mutableStateOf(MainTabs.Home) }
    val tabs = MainTabs.values()

    Surface(color = MaterialTheme.colors.background) {
        Scaffold(
            topBar = {},
            bottomBar = {
                BottomNavigation(
                    backgroundColor = MaterialTheme.colors.background,
                    elevation = 8.dp
                ) {
                    tabs.forEach { navItem ->
                        BottomNavigationItem(
                            icon = { Icon(navItem.icon, null) },
                            label = { Text(stringResource(navItem.titleRes)) },
                            selected = selectedTab == navItem,
                            selectedContentColor = MaterialTheme.colors.onBackground,
                            unselectedContentColor = MaterialTheme.colors.onBackground.copy(alpha = ContentAlpha.medium),
                            onClick = { setSelectedTab(navItem) }
                        )
                    }
                }
            }
        ) {
            Card(Modifier.padding(24.dp)) {
                Column {
                    Icon(Icons.Default.Search, null)
                    Icon(Icons.Default.Spa, null)
                    Icon(Icons.Default.AccountCircle, null)
                    Icon(Icons.Default.PlayArrow, null)
                }
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MySootheApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MySootheApp()
    }
}
