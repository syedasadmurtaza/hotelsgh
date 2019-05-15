package com.amstudios.hotelsgh

import android.graphics.Bitmap
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cc.cloudist.acplibrary.ACProgressConstant
import cc.cloudist.acplibrary.ACProgressPie
import im.delight.android.webview.AdvancedWebView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdvancedWebView.Listener {

    lateinit var dialog : ACProgressPie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webview.setListener(this, this)
        webview.loadUrl("http://hotelsgh.com")

        initializeProgressDialog()
    }

    private fun initializeProgressDialog() {
        dialog = ACProgressPie.Builder(this)
            .ringColor(Color.WHITE)
            .pieColor(Color.WHITE)
            .updateType(ACProgressConstant.PIE_AUTO_UPDATE)
            .build()
    }

    override fun onPause() {
        super.onPause()
        webview.onPause()
    }

    override fun onResume() {
        super.onResume()
        webview.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        webview.onDestroy()
    }

    override fun onPageError(errorCode: Int, description: String?, failingUrl: String?) {

    }

    override fun onDownloadRequested(
        url: String?,
        suggestedFilename: String?,
        mimeType: String?,
        contentLength: Long,
        contentDisposition: String?,
        userAgent: String?
    ) {

    }

    override fun onExternalPageRequest(url: String?) {

    }

    override fun onPageStarted(url: String?, favicon: Bitmap?) {
        dialog.show()
    }

    override fun onPageFinished(url: String?) {
        dialog.hide()
    }
}
