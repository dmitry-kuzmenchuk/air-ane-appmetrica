package com.menu4me.ane.appmetrica;

import android.content.Context;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Extension implements FREExtension {
    public static FREContext context = null;

    @Override
    public FREContext createContext(String contextType) {
        Log.d(Constants.TAG_EXTENSION, "createContext()");
        return context = new ExtensionContext();
    }

    @Override
    public void initialize() {
        Log.d(Constants.TAG_EXTENSION, "initialize()");
    }

    @Override
    public void dispose() {
        Log.d(Constants.TAG_EXTENSION, "dispose()");
    }

    public static AppData readAppData(Context context) throws IOException {
        Log.d(Constants.TAG_EXTENSION, "readAppData()");
        File dataFile = new File(context.getFilesDir(), Constants.DATA_FILE);
        if (!dataFile.exists()) {
            Log.d(Constants.TAG_EXTENSION, "readAppData(): AppData file is not exists, returning new instance of AppData");
            return new AppData();
        }
        BufferedReader br = new BufferedReader(new FileReader(dataFile));
        String readResult = br.readLine();
        br.close();
        return new Gson().fromJson(readResult, AppData.class);
    }

    public static void saveAppData(Context context, AppData appData) throws IOException {
        Log.d(Constants.TAG_EXTENSION, "saveAppData()");
        File dataFile = new File(context.getFilesDir(), Constants.DATA_FILE);
        BufferedWriter bw = new BufferedWriter(new FileWriter(dataFile));
        bw.write(new Gson().toJson(appData, AppData.class));
        bw.close();
    }
}
