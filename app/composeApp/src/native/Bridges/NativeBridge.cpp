#include  dea "defines.h"
#include "ForgeLib/include/asserts.h"
#include "GameBoyDisplay.h"
#ifdef __cplusplus
extern "C" {
#endif

JNIEXPORT void JNICALL
Java_org_just_1somebody_pocket_1pixel_AndroidNativeBridge_getNativeFrame(
    JNIEnv* JVM,
    jobject THIS,
    jbyteArray BUFFER
)
{
  // - - - Get the length of the Java byte array
  jsize bufferSize = JVM->GetArrayLength(BUFFER);

  // - - - Get a pointer to the Java byte array
  jbyte* buffer = JVM->GetByteArrayElements(BUFFER, NULL);
  FORGE_ASSERT_MESSAGE(buffer != NULL, "Java Buffer is NULL");

  // - - - Fill the buffer with frame data
  getFrame(reinterpret_cast<u8*>(buffer), static_cast<u64>(bufferSize));

  // - - - Release the Java byte array back to the JVM
  JVM->ReleaseByteArrayElements(BUFFER, buffer, 0);
}

#ifdef __cplusplus
}
#endif
