package com.yyx.e_signature;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.yyx.e_signature.view.LinePathView;

import java.io.IOException;


import butterknife.ButterKnife;

public class LandscapeActivity extends Activity {
    LinePathView pathView;
    Button mClear;
    Button mSave;
    LinearLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hand_write);
        ButterKnife.bind(this);
        setResult(50);

        pathView = (LinePathView) findViewById(R.id.view);
        mClear = (Button) findViewById(R.id.clear1);
        mSave = (Button) findViewById(R.id.save1);
        ll = (LinearLayout) findViewById(R.id.ll);

        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (pathView.getTouched())
            {
                try {
                    pathView.save(MainActivity.path1,false,10);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                setResult(101);
                finish();
            }else
            {
                Toast.makeText(LandscapeActivity.this,"您没有签名~",Toast.LENGTH_SHORT).show();
            }
        }});
        mClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pathView.clear();
            }
        });
    }



}
