package com.menu4me.ane {
	import flash.events.Event;
	
	public class MetricaEvent extends Event {
		public static const METRICA_INITIALIZED:String = "metricaInitialized";
		public static const REPORT_SUCCESS:String = "reportEventSuccess";
		public static const REPORT_FAIL:String = "reportEventFail";
		public static const API_KEY_IS_NOT_VALID:String = "apiKeyIsNotValid";
		public static const UNEXPECTED_EXCEPTION:String = "unexpectedException";
		public static const FETCH_INSTALL_REFERRER:String = "fetchInstallReferrer";
		
		public var data:String;
		
		public function MetricaEvent(type:String, bubbles:Boolean = false, cancelable:Boolean = false) {
			super(type, bubbles, cancelable);
		}
	}
}