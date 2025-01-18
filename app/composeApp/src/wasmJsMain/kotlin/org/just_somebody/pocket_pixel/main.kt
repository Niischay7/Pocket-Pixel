@file:Suppress("OPT_IN_USAGE")

import kotlin.wasm.WasmExport

// Define a JavaScript function using `@JsFun`
@JsFun("function(msg) { alert(msg); }")
external fun showAlert(message: String)

@JsName("sum")  // Matches the JavaScript function name
external fun sum(a: Int, b: Int): Int

@JsName("helloFromCpp")
external fun helloFromCpp() : String

// Define a main function exported to JavaScript
@WasmExport
fun main() {
    showAlert(helloFromCpp())
}
