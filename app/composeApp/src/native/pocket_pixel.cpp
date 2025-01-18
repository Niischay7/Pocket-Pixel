#include <jni.h>
#include <string>
#ifdef ANDROID
  #include <android/log.h>
#endif

#include "ForgeLib/include/logger.h"

extern "C"
JNIEXPORT jstring JNICALL
Java_org_just_1somebody_pocket_1pixel_MainActivityKt_getCppGreeting(JNIEnv *env, jclass clazz)
{
  static int occurrences = 0;
  occurrences++;
  FORGE_LOG_TRACE("Total calls : %d", occurrences);

  const char* message = "Hello Kotlin, this is C++";
  return env->NewStringUTF(message);
}