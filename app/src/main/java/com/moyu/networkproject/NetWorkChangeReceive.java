package com.moyu.networkproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import static android.content.Context.CONNECTIVITY_SERVICE;
import static android.net.ConnectivityManager.TYPE_MOBILE;
import static android.net.ConnectivityManager.TYPE_WIFI;

/**
 * Created by 墨羽 on 2018/6/27.
 */

public class NetWorkChangeReceive extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isAvailable()){
            switch (networkInfo.getType()){
                case TYPE_MOBILE:
                    Toast.makeText(context,"正在使用2G/3G/4G网络",Toast.LENGTH_SHORT).show();
                    break;
                case TYPE_WIFI:
                    Toast.makeText(context,"正在使用WIFI网络",Toast.LENGTH_SHORT).show();
                     break;
                default:

                    break;
            }
        }else{
            Toast.makeText(context,"当前无网络连接",Toast.LENGTH_SHORT).show();
        }
    }
}
