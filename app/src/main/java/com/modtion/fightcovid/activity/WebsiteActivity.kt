package com.modtion.fightcovid.activity

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.webkit.JsResult
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.modtion.fightcovid.R
import kotlinx.android.synthetic.main.activity_website.*

class WebsiteActivity : AppCompatActivity() {

    private lateinit var url: String

    companion object{
        const val WEB_URL = "WEB_URL"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_website)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        if (intent.extras!=null){
            url = intent.getStringExtra(WEB_URL)
        }

        chat_webview.getSettings().setJavaScriptEnabled(true)
        chat_webview.setWebViewClient(object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                view.loadUrl("javascript:alert('chatbot berhasil dimuat')")
            }
        })
        chat_webview.setWebChromeClient(object : WebChromeClient() {
            override fun onJsAlert(
                view: WebView,
                url: String,
                message: String,
                result: JsResult
            ): Boolean {
                Log.e("WEBVIEW", message)
                result.confirm()
                return true
            }
        })
        chat_webview.loadUrl(url)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
