#include <emscripten.h>

extern "C" {
EMSCRIPTEN_KEEPALIVE
const char* helloFromCpp() {
  return "Hello Path bhai, mai hun asher";
}
}
