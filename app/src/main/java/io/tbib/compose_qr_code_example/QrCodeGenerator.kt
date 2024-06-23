package io.tbib.compose_qr_code_example

import androidx.compose.runtime.Composable
import io.tbib.composeqrcode.views.QRCodeGenerator

@Composable
fun QrCodeGenerator() {

    QRCodeGenerator(content = "121", logo = R.drawable.logo_qr)
}