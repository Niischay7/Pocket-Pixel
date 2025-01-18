package org.just_somebody.pocket_pixel

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.dp

class GameBoyDisplay
{
  val bridge      : NativeBridge  = getNativeBridge();
  val frameBuffer : ByteArray     = ByteArray(160 * 144 / 4) // 2 bits per pixel

  private fun renderFrame() : Array<Array<Color>>
  {
    val width  = 160
    val height = 144
    val colors = Array(height) { Array(width) { Color.Black } }

    var pixelIndex = 0
    for (byte in frameBuffer)
    {
      for (shift in 6 downTo 0 step 2)
      {
        val colorIndex = (byte.toInt() shr shift) and 0b11 // Extract 2 bits
        val row = pixelIndex / width
        val col = pixelIndex % width
        colors[row][col] = mapColor(colorIndex)
        pixelIndex++
      }
    }
    return colors;
  }

  private fun mapColor(COLOR_INDEX : Int) : Color
  {
    return when (COLOR_INDEX)
    {
      0     -> Color.Black;
      1     -> Color.DarkGray;
      2     -> Color.LightGray;
      3     -> Color.White;
      else  -> Color.Yellow;
    }
  }

  @Composable
  fun render()
  {
    val frame by remember { mutableStateOf(renderFrame()) }

    Column (
      modifier = Modifier.fillMaxSize(),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
    )
    {
      // GameBoy screen
      Canvas(modifier = Modifier.size(320.dp, 288.dp)) {
        drawGameFrame(frame, this)
      }

      // Controls
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
      ) {
        Button(onClick = { /* Left button logic */ }) {
          Text("Left")
        }
        Button(onClick = { /* Right button logic */ }) {
          Text("Right")
        }
      }
    }
  }

  private fun drawGameFrame(frame: Array<Array<Color>>, drawScope: DrawScope)
  {
    val cellWidth = drawScope.size.width / frame[0].size
    val cellHeight = drawScope.size.height / frame.size

    frame.forEachIndexed ()
    { rowIndex, row ->
      row.forEachIndexed ()
      { colIndex, color ->
        drawScope.drawRect(
          color = color,
          topLeft = androidx.compose.ui.geometry.Offset(
            x = colIndex * cellWidth,
            y = rowIndex * cellHeight
          ),
          size = androidx.compose.ui.geometry.Size(cellWidth, cellHeight)
        )
      }
    }
  }
}