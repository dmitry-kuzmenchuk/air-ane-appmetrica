package com.menu4me.ane.appmetrica;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

public class InstallReferrerReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(Constants.TAG_RECEIVER, intent.toString());
        Bundle extras = intent.getExtras();
        String result = "";
        for (String key : extras.keySet()) {
            Object value = extras.get(key);
            result += value.toString();
        }
        try {
            AppData appData = Extension.readAppData(context);
            appData.installReferrer = result;
            Extension.saveAppData(context, appData);
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}
