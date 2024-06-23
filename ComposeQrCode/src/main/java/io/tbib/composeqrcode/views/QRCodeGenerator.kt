package io.tbib.composeqrcode.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import io.tbib.composeqrcode.generateQRCode

@Composable
fun QRCodeGenerator(content: String, logo: Int? = null) {
    val context = LocalContext.current

    val bitmap = generateQRCode(context, content, logo)
    Box(modifier = Modifier.padding(16.dp)) {
        Image(
            bitmap = bitmap.asImageBitmap(),
            contentDescription = "QR Code",
            modifier = Modifier.padding(16.dp)
        )
    }
}