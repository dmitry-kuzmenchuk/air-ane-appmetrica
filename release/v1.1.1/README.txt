1) Получить экземпляр объекта AppMetrica статическим методом AppMetrica.getInstance();
2) Инициализировать Yandex AppMetrica методом instance.initialize(apiKey),
где instance - экземпляр объекта AppMetrica, а apiKey - ключ приложения AppMetrica;
3) Расширение само получает реферальную ссылку (если она присутствует) и отправляет событие в AppMetrica,
при условии, что в манифесте приложения указан BroadcastReceiver (MetricaEventHandler);
4) Если требуется отослать в AppMetrica свое событие - испольузется instance.reportEvent(event), где event - имя события в виде строки;

Разрешения:
<uses-permission android:name="android.permission.INTERNET"/>
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>

Добавить в Android-манифест информацию об сервисах и ресиверах:
<application>
	<service
		android:name="com.yandex.metrica.MetricaService"
		android:enabled="true"
		android:exported="true"
		android:process=":Metrica">
			<intent-filter>
				<category android:name="android.intent.category.DEFAULT"/>
				<action android:name="com.yandex.metrica.IMetricaService"/>
				<data android:scheme="metrica"/>
			</intent-filter>
			<meta-data android:name="metrica:api:level" android:value="52"/>
	</service>
	<receiver
		android:name="com.menu4me.ane.appmetrica.InstallReferrerReceiver"
		android:enabled="true"
		android:exported="true">
		<intent-filter>
			<action android:name="com.android.vending.INSTALL_REFERRER"/>
		</intent-filter>
	</receiver>
</application>