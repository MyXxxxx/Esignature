package com.yyx.e_signature;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.yyx.e_signature.view.LinePathView;

import java.io.IOException;

import butterknife.ButterKnife;

public class HandWriteActivity extends AppCompatActivity {


    LinePathView mPathView;
    Button mClear;
    LinearLayout ll;
    Button mSave;
    Button mChangeColor;
    Button mChangeWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hand_write);
        ButterKnife.bind(this);
        setResult(50);
        mPathView = (LinePathView) findViewById(R.id.view);
        mClear = (Button) findViewById(R.id.clear1);
        ll = (LinearLayout) findViewById(R.id.ll);
        mSave = (Button) findViewById(R.id.save1);
        mChangeColor = (Button) findViewById(R.id.change);
        mChangeWidth = (Button) findViewById(R.id.changewidth);

        //设置保存监听
        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPathView.getTouched()) {
                    try {
                        mPathView.save("/sdcard/qm.png", true, 10);
                        setResult(100);
                        finish();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {

                    Toast.makeText(HandWriteActivity.this, "您没有签名~", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPathView.clear();
            }
        });
        //修改背景颜色和笔的颜色
        mChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                mPathView.setPenColor(Color.WHITE);
                mPathView.setBackgroundColor(Color.BLACK);
                mPathView.clear();
            }
        });
        //修改笔的宽度
        mChangeWidth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                mPathView.setPaintWidth(20);
                mPathView.clear();
            }
        });
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }
}
