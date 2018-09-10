1) Получить экземпляр объекта AppMetrica статическим методом AppMetrica.getInstance();
2) Инициализировать Yandex AppMetrica методом instance.initialize(apiKey),
где instance - экземпляр объекта AppMetrica, а apiKey - ключ приложения AppMetrica;
3) Расширение само получает реферальную ссылку (если она присутствует) и отправляет событие в AppMetrica,
при условии, что в манифесте приложения указан BroadcastReceiver (MetricaEventHandler);
4) Если требуется отослать в AppMetrica свое событие - испольузется instance.reportEvent(event), где event - имя события в виде строки;

Встроить в манифест приложения, для получения реферальной ссылки:
<application>        
	<receiver
		android:name="com.yandex.metrica.MetricaEventHandler"
		android:enabled="true"
		android:exported="true">
		<intent-filter>
			<action android:name="com.android.vending.INSTALL_REFERRER"/>
		</intent-filter>
	</receiver>         
</application>