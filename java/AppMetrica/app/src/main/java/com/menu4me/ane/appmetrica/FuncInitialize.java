package com.menu4me.ane.appmetrica;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;
import com.google.gson.Gson;
import com.yandex.metrica.YandexMetrica;
import com.yandex.metrica.YandexMetricaConfig;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FuncInitialize implements FREFunction {

    @Override
    public FREObject call(FREContext context, FREObject[] args) {
        Log.d(Constants.TAG_EXTENSION, "initialize()");
        Context appContext = context.getActivity().getApplicationContext();
        Application application = context.getActivity().getApplication();
        try {
            AppData appData = Extension.readAppData(appContext);
            if (args.length > 0) {
                String apiKey = args[0].getAsString();
                if (apiKey != "") {
                    appData.apiKey = apiKey;
                    YandexMetricaConfig.Builder configBuilder = YandexMetricaConfig.newConfigBuilder(appData.apiKey);
                    if (appData.isFirstLaunch) {
                        configBuilder.handleFirstActivationAsUpdate(true);
                        appData.isFirstLaunch = false;
                    }
                    YandexMetricaConfig extendedConfig = configBuilder.build();
                    YandexMetrica.activate(appContext, extendedConfig);
                    YandexMetrica.enableActivityAutoTracking(application);
                    Extension.saveAppData(appContext, appData);
                    context.dispatchStatusEventAsync(Constants.EVENT_METRICA_INITIALIZED, Constants.MSG_METRICA_INITIALIZED);
                }
                else {
                    context.dispatchStatusEventAsync(Constants.EVENT_API_KEY_IS_NOT_VALID, Constants.ERR_API_KEY_CANNOT_BE_NULL);
                }
            }
        }
        catch (IOException exc) {
            context.dispatchStatusEventAsync(Constants.EVENT_UNEXPECTED_EXCEPTION, Constants.ERR_UNEXPECTED_EXCEPTION);
            exc.printStackTrace();
        }
        catch (FRETypeMismatchException exc) {
            context.dispatchStatusEventAsync(Constants.EVENT_UNEXPECTED_EXCEPTION, Constants.ERR_UNEXPECTED_EXCEPTION);
            exc.printStackTrace();
        }
        catch (FREInvalidObjectException exc) {
            context.dispatchStatusEventAsync(Constants.EVENT_UNEXPECTED_EXCEPTION, Constants.ERR_UNEXPECTED_EXCEPTION);
            exc.printStackTrace();
        }
        catch (FREWrongThreadException exc) {
            context.dispatchStatusEventAsync(Constants.EVENT_UNEXPECTED_EXCEPTION, Constants.ERR_UNEXPECTED_EXCEPTION);
            exc.printStackTrace();
        }
        return null;
    }
}
