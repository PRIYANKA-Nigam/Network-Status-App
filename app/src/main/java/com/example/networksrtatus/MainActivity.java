package com.example.networksrtatus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
ImageView imageView; TextView textView; Button button,b1,b2; @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); setContentView(R.layout.activity_main);
        imageView=(ImageView)findViewById(R.id.img); button=(Button)findViewById(R.id.bt);
        b1=(Button)findViewById(R.id.button); b2=(Button)findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() { @Override
            public void onClick(View v) {
                WifiManager wifi=(WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                wifi.setWifiEnabled(true); }});
        b2.setOnClickListener(new View.OnClickListener() { @Override
            public void onClick(View v) {
                WifiManager wifi=(WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                wifi.setWifiEnabled(false); }});
        textView=(TextView)findViewById(R.id.tt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkNetwork();
            }}); }
            private void checkNetwork() { boolean wifi,mob;
        ConnectivityManager connectivityManager=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();if (networkInfo!=null && networkInfo.isConnected()){
            wifi=networkInfo.getType()==ConnectivityManager.TYPE_WIFI;mob=networkInfo.getType()==ConnectivityManager.TYPE_MOBILE;
            if (wifi){ imageView.setImageResource(R.drawable.ic_baseline_wifi_24); textView.setText("Connected with Wifi");
            }else if (mob){ imageView.setImageResource(R.drawable.ic_baseline_signal_cellular_4_bar_24 );
                textView.setText("Connected with Mobile Data Connection"); }
        }else {
                imageView.setImageResource(R.drawable.ic_baseline_block_24);
                textView.setText("No Internet Connected"); } }
}