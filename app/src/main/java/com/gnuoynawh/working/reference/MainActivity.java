package com.gnuoynawh.working.reference;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
            dialog  - alert, confirm, datePicker
            lib     - lottie, glide
            network - retrofit, rxjava, interceptor, 쿠키, 헤더
            view    - pageCurl, thumbnail

            ui  - 텍스트뷰     : 사이즈, 폰트
                - 이미지뷰     : 라운드처리, Zoom, Zoom + 이미지맵(크기, 위치조절가능)
                - 에딧텍스트   : inputType, imeOption, UI디자인(입력할때 아래 밑줄빨개지는거, 밑줄밑에 글씨, 밑줄 색 변경, x 버튼...)
                - 뷰페이저     : indicator, NonSwipe
                - 리싸이클러뷰  : 리사이클러뷰, 리사이클러뷰 + 스크롤뷰, 가로스크롤, 그리드, 선택한 아이템 중앙정렬
                - 설정         : 볼륨, 밝기, 언어변경
                - 미디어       : 오디오, 비디오, 비디오 썸네일
         */
    }
}