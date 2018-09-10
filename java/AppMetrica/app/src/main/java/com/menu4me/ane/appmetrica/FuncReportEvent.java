package com.menu4me.ane.appmetrica;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;
import com.yandex.metrica.YandexMetrica;

public class FuncReportEvent implements FREFunction {

    @Override
    public FREObject call(FREContext context, FREObject[] args) {
        Log.d(Constants.TAG_EXTENSION, "reportEvent()");
        try {
            if (args.length > 0) {
                String result = args[0].getAsString();
                if (result != "") {
                    YandexMetrica.reportEvent(result);
                    context.dispatchStatusEventAsync(Constants.EVENT_REPORT_SUCCESS, Constants.MSG_EVENT_REPORT_SUCCESS);
                }
                else {
                    context.dispatchStatusEventAsync(Constants.EVENT_REPORT_FAIL, Constants.ERR_REPORT_EVENT_BLANK_CONTENT);
                }
            }
        }
        catch (FRETypeMismatchException exc) {
            context.dispatchStatusEventAsync(Constants.EVENT_UNEXPECTED_EXCEPTION, Constants.ERR_UNEXPECTED_EXCEPTION);
            exc.printStackTrace();
        }
        catch (FREWrongThreadException exc) {
            context.dispatchStatusEventAsync(Constants.EVENT_UNEXPECTED_EXCEPTION, Constants.ERR_UNEXPECTED_EXCEPTION);
            exc.printStackTrace();
        }
        catch (FREInvalidObjectException exc) {
            context.dispatchStatusEventAsync(Constants.EVENT_UNEXPECTED_EXCEPTION, Constants.ERR_UNEXPECTED_EXCEPTION);
            exc.printStackTrace();
        }
        return null;
    }
}
