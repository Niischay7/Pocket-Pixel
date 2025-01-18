#include <jni.h>
#include <string>
#ifdef ANDROID
  #include <android/log.h>
#endif

extern "C"
JNIEXPORT jstring JNICALL
Java_org_just_1somebody_pocket_1pixel_MainActivityKt_getCppGreeting(JNIEnv *env, jclass clazz) {
  const char* message = "Hello Kotlin, this is C++";
  return env->NewStringUTF(message);
}