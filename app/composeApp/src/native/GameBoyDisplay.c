#include "GameBoyDisplay.h"

void getFrame(u8* BUFFER, u64 SIZE)
{
  static i32 frameCount = 0;
  u64 width = 160; // Assuming a width of 160 pixels
  for (u64 i = 0; i < SIZE; ++i)
  {
    u64 row = i / width;
    u64 col = i % width;
    BUFFER[i] = ((row / 8 + col / 8 + frameCount / 10) % 2) * 255; // Checkerboard with animation
  }
  frameCount++;
}
