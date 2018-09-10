package com.menu4me.ane.appmetrica;

public class Constants {
    public static final String DATA_FILE = "dataFile";

    public static final String TAG_EXTENSION = "AppMetrica: Extension";
    public static final String TAG_RECEIVER = "AppMetrica: Receiver";

    public static final String ERR_API_KEY_CANNOT_BE_NULL = "API-key is not valid, cannot be null";
    public static final String ERR_UNEXPECTED_EXCEPTION = "Unexpected exception was occurred during runtime";
    public static final String ERR_REPORT_EVENT_BLANK_CONTENT = "Event cannot contain blank string";

    public static final String MSG_METRICA_INITIALIZED = "Metrica was initialized successfully";
    public static final String MSG_EVENT_REPORT_SUCCESS = "Event successfully reported";

    public static final String EVENT_METRICA_INITIALIZED = "metricaInitialized";
    public static final String EVENT_API_KEY_IS_NOT_VALID = "apiadb shell am broadcast -a com.android.vending.INSTALL_REFERRER -n air.com.menu4me.food.kamchatka/.com.menu4me.ane.appmetrica.InstallReferrerReceiver --es \"referrer\" \"lolkekcheburek\"  KeyIsNotValid";
    public static final String EVENT_REPORT_SUCCESS = "reportEventSuccess";
    public static final String EVENT_REPORT_FAIL = "reportEventFail";
    public static final String EVENT_UNEXPECTED_EXCEPTION = "unexpectedException";
    public static final String EVENT_FETCH_INSTALL_REFERRER = "fetchInstallReferrer";
}
