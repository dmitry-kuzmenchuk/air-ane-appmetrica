1) �������� ��������� ������� AppMetrica ����������� ������� AppMetrica.getInstance();
2) ���������������� Yandex AppMetrica ������� instance.initialize(apiKey),
��� instance - ��������� ������� AppMetrica, � apiKey - ���� ���������� AppMetrica;
3) ���������� ���� �������� ����������� ������ (���� ��� ������������) � ���������� ������� � AppMetrica,
��� �������, ��� � ��������� ���������� ������ BroadcastReceiver (MetricaEventHandler);
4) ���� ��������� �������� � AppMetrica ���� ������� - ������������ instance.reportEvent(event), ��� event - ��� ������� � ���� ������;

�������� � �������� ����������, ��� ��������� ����������� ������:
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