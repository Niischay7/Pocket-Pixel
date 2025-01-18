// Load and initialize the WebAssembly module
Module.onRuntimeInitialized = () => {
    // Export functions for use
    window.helloFromCpp = () => Module.ccall('helloFromCpp', 'string');
};
