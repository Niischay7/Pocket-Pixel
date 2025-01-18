cmake_minimum_required(VERSION 3.22.1)

project("pocketPixel")

# Option to build with Emscripten for WebAssembly
option(USE_EMSCRIPTEN "Build with Emscripten for WebAssembly" OFF)

# Recursively find all source files
file(GLOB_RECURSE PROJECT_SOURCES
        "${CMAKE_SOURCE_DIR}/*.c"
        "${CMAKE_SOURCE_DIR}/*.cpp"
        "${CMAKE_SOURCE_DIR}/ForgeLib/**/*.c"
        "${CMAKE_SOURCE_DIR}/ForgeLib/**/*.cpp"
)

if (USE_EMSCRIPTEN)
    # Check for Emscripten
    if (NOT EMSCRIPTEN)
        message(FATAL_ERROR "Emscripten toolchain not detected. Please configure with Emscripten's toolchain file.")
    endif()

    # Set output format for WebAssembly
    set(CMAKE_EXECUTABLE_SUFFIX ".wasm")

    # Add the shared library as a WebAssembly package
    add_executable(${CMAKE_PROJECT_NAME} ${PROJECT_SOURCES})

    # Link with Emscripten libraries
    target_link_options(${CMAKE_PROJECT_NAME} PRIVATE
            "-s WASM=1"
            "-s ALLOW_MEMORY_GROWTH=1"
            "-s MODULARIZE=1"
            "-s EXPORT_NAME=\"PocketPixel\""
            "-s EXTRA_EXPORTED_RUNTIME_METHODS=['ccall', 'cwrap']"
    )

else()
    # Default Android build
    add_library(${CMAKE_PROJECT_NAME} SHARED ${PROJECT_SOURCES})

    # Platform-specific settings for Android
    target_link_libraries(${CMAKE_PROJECT_NAME} android log)
endif()
