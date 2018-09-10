package com.menu4me.ane.appmetrica;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;

import java.util.HashMap;
import java.util.Map;

public class ExtensionContext extends FREContext {

    @Override
    public Map<String, FREFunction> getFunctions() {
        Log.d(Constants.TAG_EXTENSION, "getFunctions()");
        Map<String, FREFunction> functionMap = new HashMap<>();
        functionMap.put("initialize", new FuncInitialize());
        functionMap.put("reportEvent", new FuncReportEvent());
        functionMap.put("fetchInstallReferrer", new FuncFetchInstallReferrer());
        return functionMap;
    }

    @Override
    public void dispose() {
        Log.d(Constants.TAG_EXTENSION, "dispose()");
    }
}
