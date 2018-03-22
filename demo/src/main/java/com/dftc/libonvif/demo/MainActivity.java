package com.dftc.libonvif.demo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.dftc.libonvif.OnvifUtil;
import com.dftc.libonvif.model.CameraInfomation;
import com.dftc.libonvif.model.ControlMessage;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Onvif";

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "888888";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread() {
                    @Override
                    public void run() {
                        testOnvif();
                    }
                }.start();
            }
        });
    }

    private void testOnvif() {
        OnvifUtil mOnvifUtil = new OnvifUtil();
        ControlMessage mControlMessage = new ControlMessage(USERNAME, PASSWORD, 5);

        final List<CameraInfomation> cameraList = mOnvifUtil.scanForCamera(mControlMessage);
        Log.d(TAG, "find : " + (cameraList == null ? 0 : cameraList.size()));
        if (cameraList != null) {
            for (CameraInfomation info : cameraList) {
                if (info != null) {
                    Log.d(TAG, "rtspAddrMain : " + info.rtspAddrMain);
                    Log.d(TAG, "rtspAddrSub : " + info.rtspAddrSub);
                    Log.d(TAG, "deviceAddr : " + info.deviceAddr);
                    mOnvifUtil.setCameraTime(info, mControlMessage, /* noused */null);
                }
            }
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this,
                        "find : " + (cameraList == null ? 0 : cameraList.size()),
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
