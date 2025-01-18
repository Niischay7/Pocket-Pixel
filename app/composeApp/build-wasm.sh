#!/bin/bash

# Check if EMSDK is already sourced
source /home/nadeem/Downloads/emsdk/emsdk_env.sh

# Define directories
BUILD_DIR=build-wasm
SRC_DIR=src/native
OUTPUT_DIR=src/wasmJsMain/resources
SCRIPT_DIR=$(dirname "$0")

# Ensure the script is run from the project root
cd "$SCRIPT_DIR" || { echo "Failed to change directory"; exit 1; }

# Clean and recreate build directories
rm -rf $BUILD_DIR
mkdir -p $BUILD_DIR $OUTPUT_DIR

# Compile using emcc with the original command
emcc $SRC_DIR/WebBridge.cpp -o $BUILD_DIR/pocketPixel.js \
    -s EXPORTED_FUNCTIONS="['_getFrame'']" \
    -s EXPORTED_RUNTIME_METHODS="['ccall','cwrap']" || { echo "Build failed"; exit 1; }

# Move output files to the output directory
cp $BUILD_DIR/*.wasm $BUILD_DIR/*.js $OUTPUT_DIR/

echo "WebAssembly build completed. Files are in $OUTPUT_DIR/"
