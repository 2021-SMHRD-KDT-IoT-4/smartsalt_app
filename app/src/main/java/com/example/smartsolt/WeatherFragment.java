package com.example.smartsolt;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.fragment.app.Fragment;


public class WeatherFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_weather, container, false);

// 날씨 웹뷰 ===============================================================================================
        WebView wv = view.findViewById(R.id.wv);

        // webView에 원하는 웹페이지 띄우기
        // 1. 주소 지정
        // 1-1. SharedPreference 에서 값 가져오기
        SharedPreferences spf = getActivity().getSharedPreferences("mySPF", Context.MODE_PRIVATE);

        // 1-2. spf에서 값 가져오기
        String address =spf.getString("adress", "http://192.168.0.17:8080/"); // key:의 url를 가져오고 만약, 없으면 defValue 주소값을 가져와라


        // 2. 설정 변경 (JavaScript 사용가능)
        WebSettings ws = wv.getSettings();

        ws.setJavaScriptEnabled(true);

        // 3. WebView에 client 설정
        wv.setWebViewClient(new WebViewClient());

        // 4. 주소 설정
        wv.loadUrl(address);
//
// =================================================================================================================





        return view;

    }
}