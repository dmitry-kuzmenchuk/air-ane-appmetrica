# AIR ANE for Android - Yandex AppMetrica

Adobe AIR Native Extension for Android devices that makes possible to use Yandex AppMetrica in your projects, and also fetch InstallReferrer after app installation.

That's a my old project that is pretty outdated but still can be pretty handy because internet is lack of info about building AIR ANE libraries.
Project structure and building process created just by me from many hours of experiments and now it looks fine to use i think but still hard to understand for novices.

## A little "How-to-use" guide ([also available russian version](https://github.com/dmitry-kuzmenchuk/air-ane-appmetrica/wiki/Russian-How-to-use-guide)):
1) Fetch instance of a AppMetrica extension by using static method `AppMetrica.getInstance()`;

2) Initialize Yandex AppMetrica by using method `myAppMetricaInstance.initialize(myApiKey)`,
where `myAppMetricaInstance` is result of `AppMetrica.getInstance()` and 
`myApiKey` is a application key of Yandex AppMetrica;

3) Extension by itself fetches a InstallReferrer link (if it's exists) and send an event to the Yandex AppMetrica Servers, but only if in AndroidManifest specified BroadcastReceiver (MetricaEventHandler);

4) If you as need to send a event to the Yandex AppMetrica Servers - use `instance.reportEvent(event)`, where event is a string that represents your event.

## Permissions:

`<uses-permission android:name="android.permission.INTERNET"/>`

`<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>`

## Also add into Android Manifest info about Service and Receiver:
![Android Manifest](https://i.imgur.com/wPx7QOQ.jpg)
***
I hope this stuff gonna help somebody. Peace bro's!

Also there's a small wiki wrote on Russian about how-to-build basic ane from scratch. If you understand russian: [you're welcome](https://github.com/dmitry-kuzmenchuk/how-to-build-ane/wiki).
