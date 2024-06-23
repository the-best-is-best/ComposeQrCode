package io.tbib.composeqrcode.analyzer

import android.graphics.ImageFormat
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.google.zxing.BinaryBitmap
import com.google.zxing.MultiFormatReader
import com.google.zxing.PlanarYUVLuminanceSource
import com.google.zxing.common.HybridBinarizer

class QrCodeAnalyzer(private val onQrCodeDetected: (String) -> Unit) : ImageAnalysis.Analyzer {

    private val supportedImageFormats = listOf(
        ImageFormat.YUV_420_888,
    )

    override fun analyze(image: ImageProxy) {
        if (image.format in supportedImageFormats) {
            val buffer = image.planes[0].buffer
            val data = ByteArray(buffer.remaining())
            buffer.get(data)

            val width = image.width
            val height = image.height

            // Use HybridBinarizer for better performance with QR codes
            val source = PlanarYUVLuminanceSource(data, width, height, 0, 0, width, height, false)
            val bitmap = BinaryBitmap(HybridBinarizer(source))

            try {
                val result = MultiFormatReader().decode(bitmap)
                onQrCodeDetected(result.text)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                image.close()
            }
        }
    }
}
