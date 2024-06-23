package io.tbib.compose_qr_code_example

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.tbib.composeqrcode.views.ReadQrCode

@Composable
fun QrCodeReader() {

    var code by remember { mutableStateOf("") }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 20.dp)
        ) {
            Box(Modifier.height(520.dp)) {
                ReadQrCode(
                    onQrCodeDetected = { qrCode ->
                        code = qrCode
                    }
                )
            }
            Spacer(modifier = Modifier.height(80.dp))
            Text(text = "Code: $code")
        }

    }
}