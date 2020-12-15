package com.example.jetpacknavigation.fragment

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import com.example.jetpacknavigation.R
import kotlinx.android.synthetic.main.fragment_browser.*

class BrowserFragment : Fragment() {
    private var urls = mutableListOf<String>()
    private var url = "https://www.google.com/"

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_browser, container, false)
    }

    private fun pageStarted(url: String) {
        this.url = url
        urls.add(url)
        urlField.setText(url)
        backButton.isEnabled = webView.canGoBack()
        forwardButton.isEnabled = webView.canGoForward()
    }

    private fun isLink(url: String): Boolean {
        return url.matches(Regex("https?://(www\\.)?[-a-zA-Z0-9@:%._+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_+.~#?&/=]*)"));
    }

    private fun loadUrl(input: String) {
        url = input
        urlField.setText(url)
        webView.loadUrl(url)
    }

    private fun search(searchString: String) {
        url = "https://www.google.com/search?q=$searchString"
        urlField.setText(url)
        webView.loadUrl(url)
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = MyWebViewClient(this)
        loadUrl(url)

        browseButton.setOnClickListener {
            url = urlField.text.toString()
            if (isLink(url)) {
                loadUrl(url)
            } else {
                search(url)
            }
            urls.add(url)
        }

        backButton.setOnClickListener {
            if (webView.canGoBack()) {
                webView.goBack()
            } else {
                Toast.makeText(context,
                    "No se puede ir atrás",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        forwardButton.setOnClickListener {
            if (webView.canGoForward()) {
                webView.goForward()
            } else {
                Toast.makeText(context,
                        "No se puede avanzar más.",
                        Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    class MyWebViewClient(private val view: BrowserFragment) : WebViewClient() {
        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
            if (url != null) {
                this.view.pageStarted(url)
            }
        }
    }
}