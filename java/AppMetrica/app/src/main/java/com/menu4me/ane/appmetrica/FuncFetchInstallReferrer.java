package com.menu4me.ane.appmetrica;

import android.content.Context;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

import java.io.IOException;

public class FuncFetchInstallReferrer implements FREFunction {

    @Override
    public FREObject call(FREContext context, FREObject[] args) {
        Log.d(Constants.TAG_EXTENSION, "fetchInstallReferrer()");
        Context appContext = context.getActivity().getApplicationContext();
        try {
            AppData appData = Extension.readAppData(appContext);
            context.dispatchStatusEventAsync(Constants.EVENT_FETCH_INSTALL_REFERRER, appData.installReferrer);
        }
        catch (IOException exc) {
            context.dispatchStatusEventAsync(Constants.EVENT_UNEXPECTED_EXCEPTION, Constants.ERR_UNEXPECTED_EXCEPTION);
            exc.printStackTrace();
        }
        return null;
    }
}
