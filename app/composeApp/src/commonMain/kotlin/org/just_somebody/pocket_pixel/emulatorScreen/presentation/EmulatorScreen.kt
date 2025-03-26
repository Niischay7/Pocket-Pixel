package org.just_somebody.pocket_pixel

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import org.just_somebody.pocket_pixel.emulatorScreen.domain.GameBoy
import org.just_somebody.pocket_pixel.emulatorScreen.presentation.EmulatorViewModel

@Composable
fun EmulatorScreen(
    MODIFIER    : Modifier          = Modifier,
    VIEW_MODEL  : EmulatorViewModel = EmulatorViewModel()
)
{
    val gameBoy     =   VIEW_MODEL.state.gameBoy
    var frame       by remember { mutableStateOf(renderFrame(gameBoy.getFrameBuffer())) }

    LaunchedEffect(Unit)
    {
        while (true)
        {
            frame = renderFrame(gameBoy.getFrameBuffer())
            delay(16L)
        }
    }


    Column(
        modifier            = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        // - - - GameBoy Screen
        Canvas(modifier = Modifier.fillMaxWidth().aspectRatio(160f / 144f)) { drawGameFrame(frame, this) }
        Spacer(modifier = Modifier.height(16.dp))
        GameBoyControls(gameBoy)
    }
}

private fun renderFrame(BUFFER: ByteArray): Array<Array<Color>>
{
    val width   = 160
    val height  = 144
    val colors  = Array(height) { Array(width) { Color.Black } }

    var pixelIndex = 0
    for (byte in BUFFER)
    {
        for (shift in 6 downTo 0 step 2)
        {
            val colorIndex  = (byte.toInt() shr shift) and 0b11
            val row         = pixelIndex / width
            val col         = pixelIndex % width
            colors[row][col] = mapColor(colorIndex)
            pixelIndex++
        }
    }
    return colors
}

private fun mapColor(COLOR_INDEX: Int): Color
{
    return when (COLOR_INDEX)
    {
        0       -> Color.Black
        1       -> Color.DarkGray
        2       -> Color.LightGray
        3       -> Color.White
        else    -> Color.Yellow
    }
}

private fun DrawScope.drawGameFrame(
    FRAME   : Array<Array<Color>>,
    SCOPE   : DrawScope)
{
    val scaleX = size.width / 160f
    val scaleY = size.height / 144f

    FRAME.forEachIndexed()
    { rowIndex, row ->
        row.forEachIndexed()
        { colIndex, color ->
            drawRect(
                color   = color,
                topLeft = Offset(colIndex * scaleX, rowIndex * scaleY),
                size    = androidx.compose.ui.geometry.Size(scaleX, scaleY)
            )
        }
    }
}

@Composable
fun GameBoyControls(GAME_BOY : GameBoy)
{
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier            = Modifier.fillMaxWidth()
    )
    {
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp))
        { GameBoyButton("Up", GameBoy.Buttons.BUTTON_UP, GAME_BOY) }

        Row(horizontalArrangement = Arrangement.spacedBy(16.dp))
        {
            GameBoyButton("Left", GameBoy.Buttons.BUTTON_LEFT, GAME_BOY)
            GameBoyButton("Right", GameBoy.Buttons.BUTTON_RIGHT, GAME_BOY)
        }

        Row(horizontalArrangement = Arrangement.spacedBy(16.dp))
        { GameBoyButton("Down", GameBoy.Buttons.BUTTON_DOWN, GAME_BOY) }


        Row(horizontalArrangement = Arrangement.spacedBy(16.dp))
        {
            GameBoyButton("A", GameBoy.Buttons.BUTTON_A, GAME_BOY)
            GameBoyButton("B", GameBoy.Buttons.BUTTON_B, GAME_BOY)
        }

        Row(horizontalArrangement = Arrangement.spacedBy(16.dp))
        {
            GameBoyButton("Start", GameBoy.Buttons.BUTTON_START, GAME_BOY)
            GameBoyButton("Select", GameBoy.Buttons.BUTTON_SELECT, GAME_BOY)
        }
    }

    GAME_BOY.sendButton(GameBoy.Buttons.BUTTON_SELECT, false)
    GAME_BOY.sendButton(GameBoy.Buttons.BUTTON_START, false)
    GAME_BOY.sendButton(GameBoy.Buttons.BUTTON_A, false)
    GAME_BOY.sendButton(GameBoy.Buttons.BUTTON_B, false)
    GAME_BOY.sendButton(GameBoy.Buttons.BUTTON_UP, false)
    GAME_BOY.sendButton(GameBoy.Buttons.BUTTON_DOWN, false)
    GAME_BOY.sendButton(GameBoy.Buttons.BUTTON_LEFT, false)
    GAME_BOY.sendButton(GameBoy.Buttons.BUTTON_RIGHT, false)
}

@Composable
fun GameBoyButton(
    LABEL   : String,
    BUTTON  : GameBoy.Buttons,
    GAME_BOY: GameBoy)
{
    Button(
        onClick     = { GAME_BOY.sendButton(BUTTON, true) },
        shape       = CircleShape,
        modifier    = Modifier.size(64.dp)
    ) { Text(LABEL) }
}