package io.tbib.composeqrcode

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.google.zxing.BarcodeFormat
import com.google.zxing.common.BitMatrix
import com.google.zxing.qrcode.QRCodeWriter

internal fun generateQRCode(context: Context, content: String, logoResId: Int? = null): Bitmap {
    val size = 1028 // Size of the QR code
    val qrCodeWriter = QRCodeWriter()
    val bitMatrix: BitMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, size, size)
    val qrCodeBitmap = Bitmap.createBitmap(size, size, Bitmap.Config.RGB_565)

    for (x in 0 until size) {
        for (y in 0 until size) {
            qrCodeBitmap.setPixel(
                x,
                y,
                if (bitMatrix[x, y]) Color.Black.toArgb() else Color.White.toArgb()
            )
        }
    }

    // Combine the QR code and the logo if provided
    if (logoResId != null) {
        val logoBitmap = BitmapFactory.decodeResource(context.resources, logoResId)
        val combinedBitmap = Bitmap.createBitmap(size, size, qrCodeBitmap.config)
        val canvas = Canvas(combinedBitmap)
        canvas.drawBitmap(qrCodeBitmap, 0f, 0f, null)

        val logoSize = size / 8 // Scale logo to fit within the QR code
        val left = (size - logoSize) / 2
        val top = (size - logoSize) / 2
        val right = left + logoSize
        val bottom = top + logoSize
        val dstRect = Rect(left, top, right, bottom)

        canvas.drawBitmap(logoBitmap, null, dstRect, null)

        return combinedBitmap
    }

    return qrCodeBitmap
}
