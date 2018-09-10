package com.menu4me.test
{
	import flash.display.Sprite;
	import com.menu4me.ane.AppMetrica;
	import com.menu4me.ane.MetricaEvent;
	import flash.events.TimerEvent;
	import flash.utils.Timer;
	
	public class Main extends Sprite 
	{
		public function Main() 
		{	
			var appMetrica:AppMetrica = AppMetrica.getInstance();
			appMetrica.initialize("214a5076-728d-4120-ba26-813b207b9e75", true);
			appMetrica.addEventListener(MetricaEvent.FETCH_INSTALL_REFERRER, function(event:MetricaEvent):void {
				trace("kek: " + event.data);
			});
			var timer:Timer = new Timer(3000, 10);
			timer.addEventListener(TimerEvent.TIMER, function():void {
				appMetrica.fetchInstallReferrer();
			});
			timer.start();
		}
	}
}