package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.bmi.databinding.ActivityWhatIsBmiBinding

class what_is_bmi : AppCompatActivity() {
          private lateinit var binding: ActivityWhatIsBmiBinding
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityWhatIsBmiBinding.inflate(layoutInflater)
            supportActionBar?.hide()
            setContentView(binding.root)
            binding.webview.webViewClient = MyWebViewClient()
            binding.webview.loadUrl("https://www.google.com/")

        }

        inner class MyWebViewClient : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                binding.progressbar.visibility = View.GONE
            }

            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                return super.shouldOverrideUrlLoading(view, request)
            }

        }

    }