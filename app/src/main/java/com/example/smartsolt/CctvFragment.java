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


public class CctvFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cctv, container, false);

        // cctv 웹뷰 ===============================================================================================
        WebView wv2 = view.findViewById(R.id.wv2);

        // webView에 원하는 웹페이지 띄우기
        // 1. 주소 지정
        // 1-1. SharedPreference 에서 값 가져오기
        SharedPreferences spf = getActivity().getSharedPreferences("mySPF", Context.MODE_PRIVATE);

        // 1-2. spf에서 값 가져오기
        String address =spf.getString("adress", "http://169.254.80.8:8081/");
        // key:의 url를 가져오고 만약, 없으면 defValue 주소값을 가져와라
        // 169.254.80.8

        // 2. 설정 변경 (JavaScript 사용가능)
        WebSettings ws = wv2.getSettings();

        ws.setJavaScriptEnabled(true);

        // 3. WebView에 client 설정
        wv2.setWebViewClient(new WebViewClient());

        // 4. 주소 설정
        wv2.loadUrl(address);

 // =================================================================================================================

        return view;
    }
}