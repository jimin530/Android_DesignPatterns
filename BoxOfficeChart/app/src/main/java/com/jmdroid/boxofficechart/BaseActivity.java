package com.jmdroid.boxofficechart;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.jmdroid.boxofficechart.retrofit.RetrofitGenterator;
import com.jmdroid.boxofficechart.util.OtherAppUtil;

public class BaseActivity extends AppCompatActivity {
    OtherAppUtil otherAppUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 레트로핏 초기 설정
        RetrofitGenterator.getInstance().launch_retrofit(getApplicationContext());

        // 마시멜로 이상 버전에서 상태바 색깔 회색으로 변경
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

    }

    public void startCgv(View view) {
        try {
            otherAppUtil = new OtherAppUtil();
            otherAppUtil.startApp(getApplicationContext(), "com.cgv.android.movieapp");
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "FAIL", Toast.LENGTH_SHORT).show();
        }
    }

    public void startLotteCinema(View view) {
        try {
            otherAppUtil = new OtherAppUtil();
            otherAppUtil.startApp(getApplicationContext(), "kr.co.lottecinema.lcm");
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "FAIL", Toast.LENGTH_SHORT).show();
        }
    }

    public void startMegabox(View view) {
        try {
            otherAppUtil = new OtherAppUtil();
            otherAppUtil.startApp(getApplicationContext(), "com.megabox.mop");
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "FAIL", Toast.LENGTH_SHORT).show();
        }
    }
}
