package com.example.a10apr_webviewclient;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a10apr_webviewclient.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @SuppressLint({"SetJavaScriptEnabled", "WebViewApiAvailability"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //getSupportActionBar().hide();
        binding.webview2.getSettings().setLoadWithOverviewMode(true);
        binding.webview2.getSettings().setUseWideViewPort(true);
        binding.webview2.getSettings().setJavaScriptEnabled(true);
        binding.webview2.setWebViewClient(new WebViewClient());
        binding.webview2.getSettings().setBuiltInZoomControls(true);
        binding.webview2.getSettings().setDomStorageEnabled(true);
        binding.webview2.getSettings().setDatabaseEnabled(true);
        binding.webview2.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        binding.webview2.setWebChromeClient(new WebChromeClient());
        binding.webview2.loadUrl("http://iotstar.vn");
    }
}