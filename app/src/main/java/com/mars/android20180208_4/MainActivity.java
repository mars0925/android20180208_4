package com.mars.android20180208_4;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    MyReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        receiver = new MyReceiver();
    }
    //註冊
    public void click1(View v)
    {
        IntentFilter filter = new IntentFilter();
        //"myaction"可以選擇要監聽的事件
        filter.addAction("myaction");
        filter.setPriority(500);
        registerReceiver(receiver,filter);
    }
    //解除註冊/***大衛老師建議：在OnResume註冊、在OnPause反註冊。
    public void click2(View v)
    {
        unregisterReceiver(receiver);
    }
    //
    //傳送一個名為myaction的Broadcast
    public void click3(View v)
    {
        Intent intent = new Intent("myaction");
        sendBroadcast(intent);
    }

}
