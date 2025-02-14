package org.just_somebody.pocket_pixel.depInj

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.AccountBox
import androidx.compose.material.icons.sharp.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.just_somebody.pocket_pixel.browseScreen.presentation.MainScreen
import org.just_somebody.pocket_pixel.browseScreen.presentation.navBar.NavItem
import org.just_somebody.pocket_pixel.browseScreen.presentation.temp
import org.just_somebody.pocket_pixel.core.Screens
import org.just_somebody.pocket_pixel.core.isLandscape
import org.just_somebody.pocket_pixel.splashScreen.data.SplashScreenNetworkCalls
import org.just_somebody.pocket_pixel.splashScreen.presentation.SplashScreen

private val splashNetCalls : SplashScreenNetworkCalls = SplashScreenNetworkCalls();
private var navController  : NavHostController?       = null;
private val items          : List<NavItem>            = listOf(
  NavItem(
    title           = "Me",
    unselectedIcon  = Icons.Sharp.AccountBox,
    selectedIcon    = Icons.Sharp.AccountCircle,
    badgeCount      = null,
  ),
  NavItem(
    title           = "Explore",
    unselectedIcon  = Icons.Sharp.AccountBox,
    selectedIcon    = Icons.Sharp.AccountCircle,
    badgeCount      = 3,
  ),
  NavItem(
    title           = "Favorites",
    unselectedIcon  = Icons.Sharp.AccountBox,
    selectedIcon    = Icons.Sharp.AccountCircle,
    badgeCount      = null,
  ),
  NavItem(
    title           = "Search",
    unselectedIcon  = Icons.Sharp.AccountBox,
    selectedIcon    = Icons.Sharp.AccountCircle,
    badgeCount      = null,
  ),
  NavItem(
    title           = "Downloads",
    unselectedIcon  = Icons.Sharp.AccountBox,
    selectedIcon    = Icons.Sharp.AccountCircle,
    badgeCount      = null,
  )
);

fun getSplashNetworkCalls() : SplashScreenNetworkCalls
{
  return splashNetCalls;
}

@Composable
fun getNavController()  : NavHostController
{
  if (navController == null) navController = rememberNavController()
  return navController as NavHostController;
}

@Composable
fun getMenuItems()      : List<NavItem>
{
  return items.subList(
    fromIndex = 0,
    toIndex   =
        if (isLandscape())  items.size - 2;
        else                items.size - 1
  )
}