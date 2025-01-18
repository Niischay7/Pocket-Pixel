#include "GameBoyDisplay.h"

void getFrame(u8* BUFFER, u64 SIZE)
{
  for (u64 i = 0; i < SIZE; ++i)
  {
    BUFFER[i] = 0b11001100; // - - - temp
  }
}
