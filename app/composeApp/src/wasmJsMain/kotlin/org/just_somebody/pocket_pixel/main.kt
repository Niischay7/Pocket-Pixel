@file:Suppress("OPT_IN_USAGE")

import kotlin.wasm.WasmExport
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import org.just_somebody.pocket_pixel.App

@OptIn(ExperimentalComposeUiApi::class)
@WasmExport
fun main()
{
    ComposeViewport(document.body!!)
    {
        App()
    }
}