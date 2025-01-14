#include <jni.h>
#include <string>
#include <android/log.h>


extern "C"
JNIEXPORT jstring JNICALL
Java_org_just_1somebody_pocket_1pixel_MainActivityKt_getCppGreeting(
    JNIEnv* JVM,
    jclass JAVA_CLASS)
{
  return jstring("Hello from C++");
}


extern "C"
JNIEXPORT void JNICALL
Java_org_just_1somebody_pocket_1pixel_MainActivityKt_callCpp(
    JNIEnv *env,
    jclass clazz)
{
  int a = 3;
  a++;
  return;
}
extern "C"
JNIEXPORT jint JNICALL
Java_org_just_1somebody_pocket_1pixel_MainActivityKt_getCppInt(JNIEnv *env, jclass clazz)
{
  return jint(3);
}