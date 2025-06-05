package com.example.chuong_6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Broad extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (Intent.ACTION_BATTERY_CHANGED.equals(action)) {
            Toast.makeText(context, "Pin đang thay đổi!", Toast.LENGTH_SHORT).show();
        }
    }

}
