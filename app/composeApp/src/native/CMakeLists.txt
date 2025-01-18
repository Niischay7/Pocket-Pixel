cmake_minimum_required(VERSION 3.22.1)

project("pocket_pixel")

# Add the shared library (C++ source files)
add_library(${CMAKE_PROJECT_NAME} SHARED
        pocket_pixel.cpp
)

# Platform-specific settings
target_link_libraries(${CMAKE_PROJECT_NAME} android log)