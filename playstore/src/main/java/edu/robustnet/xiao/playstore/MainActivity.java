package edu.robustnet.xiao.playstore;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.WatchViewStub;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.concurrent.TimeUnit;

public class MainActivity extends WearableActivity {

    private TextView mTextView;
    private static final String TAG="PlayStore";
    private String apkName;
    private String apkListPath = "/sdcard/apkList.txt";
    private BufferedReader apkList;
    private static final long LOG_TIME = TimeUnit.MINUTES.toMillis(60);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mTextView = (TextView) stub.findViewById(R.id.text);
            }
        });
        /*
        try{
            apkList = new BufferedReader(new FileReader(apkListPath));
            Log.d(TAG, "apkList opened.");
        }
        catch (Exception e){
        }

        long startTime = System.currentTimeMillis();
        while(System.currentTimeMillis() - startTime < LOG_TIME){
            try{
                apkName = apkList.readLine();
                if(apkName==null){
                    break;
                }
                String appUrl = "market://details?id="+apkName;
                gotoApp(appUrl);
                SystemClock.sleep(10000);
            }
            catch (Exception e){
            }
        }*/
        gotoApp("market://details?id=org.telegram.messenger");
    }

    public void gotoApp(String url){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);

    }

}
