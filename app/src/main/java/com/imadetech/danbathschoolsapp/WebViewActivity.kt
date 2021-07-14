package com.imadetech.danbathschoolsapp

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.net.http.SslError
import android.os.Build
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.webkit.*
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat


class WebViewActivity : AppCompatActivity() {

    var activityurl = ""
    private var webviewLoad: Boolean = false
    private var refreshno = 0
    private val webView: WebView? = null
    private var controlOn: Boolean = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)



        val category = intent.extras!!["category"].toString()
        activityurl = intent.extras!!["activityurl"].toString()



        val Refresh: ImageView = findViewById(R.id.refresh)
        val Back: ImageView = findViewById(R.id.webView_back)
        val Home: ImageView = findViewById(R.id.home)
        val options: ImageView = findViewById(R.id.options)
        val controls: androidx.constraintlayout.widget.ConstraintLayout = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.controls)


         val webView = findViewById<WebView>(R.id.webview)
        val progressBar: ProgressBar = findViewById(R.id.progress)

        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true
        webSettings.loadWithOverviewMode = true
        webSettings.useWideViewPort = true


        webView.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                setProgressBarVisibility(progressBar,View.VISIBLE)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                setProgressBarVisibility(progressBar,View.GONE)
            }


            override fun onReceivedSslError(
                view: WebView?,
                handler: SslErrorHandler,
                error: SslError?
            ) {
                handler.proceed()
            }
            /*
            override fun onReceivedError(
                view: WebView?,
                request: WebResourceRequest?,
                error: WebResourceError?
            ) {
                super.onReceivedError(view, request, error)
                val htmlData =
                    "<html><body><div align=\"center\" style=\"font-size:5vw;color:blue;\">Connection Error! Click on the refresh button below to reload App content or Check your Internet Connection</div></body></html>"
                webView.loadDataWithBaseURL(null, htmlData, "text/html", "UTF-8", null)
                webView.invalidate()
                setProgressBarVisibility(progressBar,View.GONE)
                refreshno = 1
            }

             */
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                return handleUri(url)
            }

            @RequiresApi(Build.VERSION_CODES.N)
            override fun shouldOverrideUrlLoading(
                view: WebView,
                request: WebResourceRequest
            ): Boolean {
                val uri = request.url
                val url = uri.toString()
                return handleUri(url)
            }


            private fun handleUri(url: String): Boolean {

                if (url.contains(activityurl)&&(!activityurl.equals(""))) {
                    // This is my web site, so do not override; let my WebView load the page
                    return false
                }
                    //webView.reload()
                // Otherwise, the link is not for a page on my site, so launch another Activity that handles URLs
                return true



            }

            override fun onReceivedError(
                view: WebView?,
                errorCode: Int,
                description: String?,
                failingUrl: String?
            ) {
                super.onReceivedError(view, errorCode, description, failingUrl)
                Toast.makeText(
                    baseContext,
                    "Connection to server failed please check your internet connection and try again",
                    Toast.LENGTH_SHORT
                ).show()
                val htmlData =
                    "<html><body><div align=\"center\" style=\"font-size:5vw;color:blue;margin:150px 5px;\">Connection Error! Click on the refresh button below to reload App content or Check your Internet Connection</div></body></html>"
                webView.loadDataWithBaseURL(null, htmlData, "text/html", "UTF-8", null)
                webView.invalidate()
                setProgressBarVisibility(progressBar,View.GONE)
                refreshno = 1

            }
        }


        webView.loadUrl(activityurl)

        webView.setDownloadListener(DownloadListener { url, userAgent, contentDisposition, mimetype, contentLength ->
            customtab(url)

        })


        Home.setOnClickListener {
           finish()
           val i = Intent(baseContext, Main2Activity::class.java)
           startActivity(i) }

        options.setOnClickListener {
            if (!controlOn){
                options.setImageResource(R.drawable.ic_baseline_close_24)
                controls.visibility = View.VISIBLE
                controlOn = true
            }else{
                options.setImageResource(R.drawable.ic_baseline_more_vert_24)
            controls.visibility = View.GONE
                controlOn = false
            }
         }

       Refresh.setOnClickListener {
            if (refreshno == 0) {
                webView.reload()
            } else {
                if (webView.canGoBack()) {
                    webView.goBack()
                    refreshno = 0
                }
            }
        }


       Back.setOnClickListener {
            if (webView.canGoBack()) {
                webView.goBack()
            }else{
                finish()
            }
        }


    }

    private fun setProgressBarVisibility(progressBar: ProgressBar, visible: Int) {
        if (progressBar != null) {
            progressBar.setVisibility(visible)
        }
    }


    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        // Check if the key event was the Back button and if there's history
        if (webView != null) {
            if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
                    webView.goBack()

                return true
            }
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event)
    }


    private fun customtab(url: String) {
        val builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        try {
            customTabsIntent.intent.setPackage("com.android.chrome")
            customTabsIntent.launchUrl(this, Uri.parse(url))
            builder.setToolbarColor(ContextCompat.getColor(this, R.color.colorPrimary))
        } catch (e: Exception) {
            try {
                customTabsIntent.intent.setPackage("com.opera.browser")
                customTabsIntent.launchUrl(this, Uri.parse(url))
                builder.setToolbarColor(ContextCompat.getColor(this, R.color.colorPrimary))
            } catch (f: Exception) {
                try {
                    customTabsIntent.intent.setPackage("com.UCMobile.intl")
                    customTabsIntent.launchUrl(this, Uri.parse(url))
                    builder.setToolbarColor(ContextCompat.getColor(this, R.color.colorPrimary))
                } catch (g: Exception) {
                    customTabsIntent.intent.setPackage(null)
                    customTabsIntent.launchUrl(this, Uri.parse(url))
                    builder.setToolbarColor(ContextCompat.getColor(this, R.color.colorPrimary))
                }
            }
        }
    }
}