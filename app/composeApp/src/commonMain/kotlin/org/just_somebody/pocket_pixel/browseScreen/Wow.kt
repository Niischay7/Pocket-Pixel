package org.just_somebody.pocket_pixel.browseScreen

import NavBar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.AccountBox
import androidx.compose.material.icons.sharp.AccountCircle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.just_somebody.pocket_pixel.browseScreen.presentation.navBar.NavItem
import org.just_somebody.pocket_pixel.core.isLandscape
import org.just_somebody.pocket_pixel.core.theme.GameBoyColors

@Composable
fun WowScreen(MODIFIER: Modifier = Modifier, TEXT: String) {
  var selectedIndex by remember { mutableStateOf(0) }

  val items = listOf(
    NavItem(
      title = "Me",
      unselectedIcon = Icons.Sharp.AccountBox,
      selectedIcon = Icons.Sharp.AccountCircle,
      badgeCount = null,
      hasNews = true
    ),
    NavItem(
      title = "You",
      unselectedIcon = Icons.Sharp.AccountBox,
      selectedIcon = Icons.Sharp.AccountCircle,
      badgeCount = 3,
      hasNews = true
    ),
    NavItem(
      title = "Someone",
      unselectedIcon = Icons.Sharp.AccountBox,
      selectedIcon = Icons.Sharp.AccountCircle,
      badgeCount = null,
      hasNews = false
    )
  )

  Scaffold(
    bottomBar = {
      if (!isLandscape()) {
        NavBar(
          ITEMS = items,
          SELECTED_INDEX = selectedIndex,
          ON_NAVIGATE = { selectedIndex = it },
          MODIFIER = Modifier.fillMaxWidth()
        )
      }
    },
    content = { paddingValues ->
      Row(
        modifier = Modifier
          .fillMaxSize()
          .background(GameBoyColors.DarkGreen)
          .padding(paddingValues)
      ) {
        if (isLandscape()) {
          NavBar(
            ITEMS = items,
            SELECTED_INDEX = selectedIndex,
            ON_NAVIGATE = { selectedIndex = it },
            MODIFIER = Modifier.fillMaxHeight()
          )
        }
        Column(
          modifier = Modifier.fillMaxSize(),
          verticalArrangement = Arrangement.Center,
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Text(TEXT)
        }
      }
    }
  )
}
