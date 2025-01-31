package org.just_somebody.pocket_pixel.splashScreen.presentation

import CustomButton
import TextInp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.resources.painterResource
import org.just_somebody.pocket_pixel.core.Screens
import org.just_somebody.pocket_pixel.core.isLandscape
import org.just_somebody.pocket_pixel.core.theme.GameBoyColors
import org.just_somebody.pocket_pixel.core.theme.PokeFontFamily
import org.just_somebody.pocket_pixel.depInj.getNavController
import pocketpixel.composeapp.generated.resources.GameBoy
import pocketpixel.composeapp.generated.resources.Res

private var hasAutoLoginDone : Boolean = false;

@Composable
fun SplashScreen(
  MODIFIER     : Modifier         = Modifier,
  VIEW_MODEL   : SplashViewModel  = SplashViewModel()
)
{
  val state   = VIEW_MODEL.state

  if (!hasAutoLoginDone)
  {
    VIEW_MODEL.onAction(SplashActions.AutoLogin)
    hasAutoLoginDone = true;
  }
  Column(
    modifier            = MODIFIER
                          .fillMaxSize()
                          .background(GameBoyColors.DarkGreen),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  )
  {
    // - - - LOGO
    Image(
      painter             = painterResource(Res.drawable.GameBoy),
      contentDescription  = null,
      modifier            = Modifier.size(256.dp)
    )

    // - - - TITLE
    Text(
      text        = "Pocket Pixel",
      color       = GameBoyColors.LightGreen,
      fontSize    = 72.sp,
      fontFamily  = PokeFontFamily(),
    )

    Spacer(modifier = Modifier.size(32.dp))

    if (isLandscape())
    {
      // - - - INPUT BOXES
      Row ()
      {
        VIEW_MODEL.onAction(SplashActions.ChangeName(TextInp(PLACEHOLDER = "GamerTag")))
        VIEW_MODEL.onAction(SplashActions.ChangePass(TextInp(PLACEHOLDER = "Password")))
      }

      // - - - BUTTONS
      Row ()
      {
        CustomButton(
          CONTENT   = {text("Login")},
          MODIFIER  = Modifier.width(256.dp))
        CustomButton(
          CONTENT   = {text("Register")},
          MODIFIER  = Modifier.width(256.dp))
      }
    }

    else
    {
      // - - - INPUT_BOXES
      Column ()
      {
        VIEW_MODEL.onAction(SplashActions.ChangeName(TextInp(PLACEHOLDER = "GamerTag")))
        VIEW_MODEL.onAction(SplashActions.ChangePass(TextInp(PLACEHOLDER = "Password")))
      }

      // - - - BUTTONS
      Column ()
      {
        CustomButton(
          CONTENT   = {text("Login")},
          MODIFIER  = Modifier.width(256.dp))
        CustomButton(
          CONTENT   = {text("Register")},
          MODIFIER  = Modifier.width(256.dp))
      }
    }

    // - - - GUEST BUTTON
    val navController = getNavController();
    Text(
      modifier    = Modifier
                    .padding(16.dp)
                    .clickable(onClick =
                    {
                      navController.navigate(Screens.Wow("Yay"))
                    }),
      text        = "Guest",
      color       = GameBoyColors.LightGreen,
      fontSize    = 32.sp,
      fontFamily  = PokeFontFamily(),
      fontStyle   = FontStyle.Italic
    )
  }
}

@Composable
fun text(TEXT : String)
{
  Text(
    modifier    = Modifier.padding(16.dp),
    text        = TEXT,
    color       = GameBoyColors.LightGreen,
    fontSize    = 32.sp,
    fontFamily  = PokeFontFamily(),
  )
}