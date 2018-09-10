1) �������� ��������� ������� AppMetrica ����������� ������� AppMetrica.getInstance();
2) ���������������� Yandex AppMetrica ������� instance.initialize(apiKey),
��� instance - ��������� ������� AppMetrica, � apiKey - ���� ���������� AppMetrica;
3) ���������� ���� �������� ����������� ������ (���� ��� ������������) � ���������� ������� � AppMetrica,
��� �������, ��� � ��������� ���������� ������ BroadcastReceiver (MetricaEventHandler);
4) ���� ��������� �������� � AppMetrica ���� ������� - ������������ instance.reportEvent(event), ��� event - ��� ������� � ���� ������;

����������:
<uses-permission android:name="android.permission.INTERNET"/>
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>

�������� � Android-�������� ���������� �� �������� � ���������:
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
		android:name="com.yandex.metrica.MetricaEventHandler"
		android:enabled="true"
		android:exported="true">
		<intent-filter>
			<action android:name="com.android.vending.INSTALL_REFERRER"/>
		</intent-filter>
	</receiver>         
</application>

������ �������:
<receiver
	android:name="com.menu4me.ane.appmetrica.InstallReferrerReceiver"
	android:enabled="true"
	android:exported="true">
	<intent-filter>
		<action android:name="com.android.vending.INSTALL_REFERRER"/>
	</intent-filter>
</receiver>