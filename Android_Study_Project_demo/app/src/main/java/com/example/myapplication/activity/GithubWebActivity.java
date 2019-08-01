package com.example.myapplication.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.myapplication.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

/*
 * @Author: Luke
 * @Date: 2019-08-01 14:06
 * @Sign: Cherish life and keep away from bugs!
 * @Project: Android_Study_Project_demo
 */

/*
* WebView 的基础用法
* 注意：
*       1.要添加网络权限 <android.permission.INTERNET>
*       2.setWebViewClient
*       3.setWebChromeClient/ Google 浏览器 但是会跳转到谷歌浏览器打开网页而不是在app内打开
*       4."ERR_UNKNOWN_URL_SCHEME" 遇到 这种问题就是网页的协议，需要添加匹配的网络协议
*       5.在app打开页面的时候，使用Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
* */
public class GithubWebActivity extends AppCompatActivity {

    @BindView(R.id.web_view)
    WebView webView;
    String githubUrl = "https://github.com/yang448189597";
//    String githubUrl = "https://www.baidu.com";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.github_activity_layout);
        ButterKnife.bind(this);

        initWebView();
    }

    private void initWebView() {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setBuiltInZoomControls(true);
        webView.loadUrl(githubUrl);
//        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new MyWebViewClient());
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack(); //goBack()表示返回WebView的上一页面
            return true;
        }
        finish();//结束退出程序
        return false;
    }

    //Web视图
    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url.startsWith("http:") || url.startsWith("https:")) {
                view.loadUrl(url);
                return false;
            } else {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
                return true;
            }
        }
    }
}
