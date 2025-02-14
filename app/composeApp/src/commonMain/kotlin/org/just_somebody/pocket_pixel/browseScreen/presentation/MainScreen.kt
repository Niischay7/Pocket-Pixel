package org.just_somebody.pocket_pixel.browseScreen.presentation

import NavBar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.just_somebody.pocket_pixel.core.Screens
import org.just_somebody.pocket_pixel.core.isLandscape
import org.just_somebody.pocket_pixel.core.theme.GameBoyColors
import org.just_somebody.pocket_pixel.depInj.getMenuItems
import org.just_somebody.pocket_pixel.depInj.getNavController
import org.just_somebody.pocket_pixel.splashScreen.presentation.SplashScreen


fun navigate(SCREEN : Int, NAV_CONTROLLER : NavController)
{
  println("Navigating");
  when (SCREEN)
  {
    1 -> NAV_CONTROLLER.navigate(Screens.MePage);
    2 -> NAV_CONTROLLER.navigate(Screens.SearchPage);
    3 -> NAV_CONTROLLER.navigate(Screens.FavoritesPage);
    4 -> NAV_CONTROLLER.navigate(Screens.DownloadsPage);
    5 -> NAV_CONTROLLER.navigate(Screens.ExplorePage);
  }
}


@Composable
fun MainScreen(
  MODIFIER  : Modifier = Modifier)
{
  var selectedIndex by remember { mutableStateOf(0) }
  val navController = rememberNavController()

  Scaffold(
    bottomBar =
    {
      if (!isLandscape())
      {
        NavBar(
          ITEMS           = getMenuItems(),
          SELECTED_INDEX  = selectedIndex,
          ON_NAVIGATE     = { selectedIndex = it; navigate(it, navController) },
          MODIFIER        = Modifier.fillMaxWidth()
        )
      }
    },
    content =
    { paddingValues ->
      Row(
        modifier = Modifier
          .fillMaxSize()
          .background(GameBoyColors.DarkGreen)
          .padding(paddingValues)
      )
      {
        if (isLandscape())
        {
          NavBar(
            ITEMS           = getMenuItems(),
            SELECTED_INDEX  = selectedIndex,
            ON_NAVIGATE     = { selectedIndex = it; navigate(it, navController) },
            MODIFIER        = Modifier.fillMaxHeight()
          )
        }
        Column(
          modifier            = Modifier.fillMaxSize(),
          verticalArrangement = Arrangement.Center,
          horizontalAlignment = Alignment.CenterHorizontally
        )
        {
          NavHost(
            navController     = navController,
            startDestination  = Screens.ExplorePage
          )
          {
            composable<Screens.MePage>            {     temp();     }
            composable<Screens.ExplorePage>       {     SplashScreen()     }
            composable<Screens.FavoritesPage>     {     temp();     }
            composable<Screens.SearchPage>        {     temp();     }
            composable<Screens.DownloadsPage>     {     temp();     }
          }
        }
      }
    }
  )
}
