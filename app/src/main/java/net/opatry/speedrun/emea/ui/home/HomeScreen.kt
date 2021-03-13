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
package net.opatry.speedrun.emea.ui.home

import androidx.annotation.StringRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.chrisbanes.accompanist.insets.navigationBarsHeight
import dev.chrisbanes.accompanist.insets.navigationBarsPadding
import net.opatry.speedrun.emea.R
import net.opatry.speedrun.emea.data.mySootheBodyActivities
import net.opatry.speedrun.emea.data.mySootheCollections
import net.opatry.speedrun.emea.data.mySootheMindActivities
import net.opatry.speedrun.emea.ui.component.SearchComponent
import net.opatry.speedrun.emea.ui.home.component.Activities
import net.opatry.speedrun.emea.ui.home.component.FavoriteCollections
import net.opatry.speedrun.emea.ui.theme.MySootheTheme

private enum class HomeTabs(
    @StringRes val titleRes: Int,
    val icon: ImageVector
) {
    Home(R.string.nav_home, Icons.Default.Spa),
    Profile(R.string.nav_profile, Icons.Default.AccountCircle)
}

@ExperimentalFoundationApi
@Composable
fun HomeScreen() {
    val (selectedTab, setSelectedTab) = remember { mutableStateOf(HomeTabs.Home) }
    val tabs = HomeTabs.values()

    Scaffold(
        backgroundColor = MaterialTheme.colors.background,
        topBar = {},
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(
                    Icons.Default.PlayArrow,
                    stringResource(R.string.start),
                    Modifier.size(24.dp)
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        bottomBar = {
            BottomNavigation(
                Modifier.navigationBarsHeight(additional = 56.dp),
                backgroundColor = MaterialTheme.colors.background,
                elevation = 8.dp
            ) {
                tabs.forEach { navItem ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                navItem.icon,
                                null,
                                Modifier.size(18.dp) // .navigationBarsPadding()
                            )
                        },
                        label = { Text(stringResource(navItem.titleRes).toUpperCase()) },
                        selected = selectedTab == navItem,
                        selectedContentColor = MaterialTheme.colors.onBackground,
                        unselectedContentColor = MaterialTheme.colors.onBackground.copy(alpha = ContentAlpha.medium),
                        modifier = Modifier.navigationBarsPadding(),
                        onClick = { /*setSelectedTab(navItem)*/ }
                    )
                }
            }
        }
    ) {
        Column(Modifier.verticalScroll(rememberScrollState())) {
            SearchComponent(Modifier.padding(top = 56.dp, start = 16.dp, end = 16.dp))
            FavoriteCollections(
                mySootheCollections,
                Modifier.padding(horizontal = 16.dp)
            )
            Spacer(Modifier.height(8.dp))
            Activities(
                stringResource(R.string.align_your_body),
                mySootheBodyActivities,
                Modifier.padding(horizontal = 16.dp)
            )
            Spacer(Modifier.height(8.dp))
            Activities(
                stringResource(R.string.align_your_mind),
                mySootheMindActivities,
                Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@ExperimentalFoundationApi
@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
private fun HomeLightPreview() {
    MySootheTheme {
        HomeScreen()
    }
}

@ExperimentalFoundationApi
@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
private fun HomeDarkPreview() {
    MySootheTheme(darkTheme = true) {
        HomeScreen()
    }
}
