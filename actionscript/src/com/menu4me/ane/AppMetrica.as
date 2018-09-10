package com.menu4me.ane {
	import flash.events.Event;
	import flash.events.StatusEvent;
	import flash.external.ExtensionContext;
	import flash.events.EventDispatcher;
	import com.menu4me.ane.utils.Log;
	import com.menu4me.ane.MetricaEvent;
	import flash.system.Capabilities;
	
	public class AppMetrica extends EventDispatcher {
		private static const TAG:String = "AppMetrica ANE";
		
		private static const MSG_CONTEXT_CREATED:String = "Extension context was created successfully";
		private static const MSG_CONTEXT_CREATION_ERROR:String = "Unable to create extension context";
		private static const MSG_CONTEXT_SINGLETON:String = "AppMetrica is a singleton, do not use constructor directly. Use getInstance() instead";
		private static const MSG_CONTEXT_NOT_AVAILABLE:String = "Extension context wasn't initialized properly, returning";
		
		private static const PACKAGE:String = "com.menu4me.ane.AppMetrica";
		private static var extensionContext:ExtensionContext = null;
		private static var instance:AppMetrica  = null;
		private static var showLogs:Boolean = false;
		
		public function AppMetrica() {
			if (!instance) {
				if (!extensionContext) {
					extensionContext = ExtensionContext.createExtensionContext(PACKAGE, null);
				}
				if (!extensionContext) {
					Log.e(TAG, MSG_CONTEXT_CREATION_ERROR);
				}
				else {
					Log.d(TAG, MSG_CONTEXT_CREATED);
					extensionContext.addEventListener(StatusEvent.STATUS, onStatusEvent);
				}
			}
			else {
				Log.w(TAG, MSG_CONTEXT_SINGLETON);
			}
		}
		
		public static function getInstance():AppMetrica {
			if (!instance) {
				instance = new AppMetrica();
			}
			return instance;
		}
		
		public static function isSupported():Boolean {
			if (Capabilities.os.search("android") > -1) {
				return true;
			}
			else {
				return false;
			}
		}
		
		public function initialize(apiKey:String, isShowLogs:Boolean = false):void {
			if (extensionContext) {
				showLogs = isShowLogs;
				extensionContext.call("initialize", apiKey);
			}
			else {
				Log.e(TAG, MSG_CONTEXT_NOT_AVAILABLE);
			}
		}
		
		public function reportEvent(event:String):void {
			if (extensionContext) {
				extensionContext.call("reportEvent", event);
			}
			else {
				Log.e(TAG, MSG_CONTEXT_NOT_AVAILABLE);
			}
		}
		
		public function fetchInstallReferrer():void {
			if (extensionContext) {
				extensionContext.call("fetchInstallReferrer");
			}
			else {
				Log.e(TAG, MSG_CONTEXT_NOT_AVAILABLE);
			}
		}
		
		private function onStatusEvent(event:StatusEvent):void {
			var metricaEvent:MetricaEvent;
			var data:String = event.level;
			if (event.code == MetricaEvent.METRICA_INITIALIZED) {
				if (showLogs) {
					Log.d(TAG, data);
				}
				metricaEvent = new MetricaEvent(MetricaEvent.METRICA_INITIALIZED);
				metricaEvent.data = data;
			}
			else if (event.code == MetricaEvent.REPORT_SUCCESS) {
				if (showLogs) {
					Log.d(TAG, data);
				}
				metricaEvent = new MetricaEvent(MetricaEvent.REPORT_SUCCESS);
				metricaEvent.data = data;
			}
			else if (event.code == MetricaEvent.REPORT_FAIL) {
				if (showLogs) {
					Log.d(TAG, data);
				}
				metricaEvent = new MetricaEvent(MetricaEvent.REPORT_FAIL);
				metricaEvent.data = data;
			}
			else if (event.code == MetricaEvent.FETCH_INSTALL_REFERRER) {
				if (showLogs) {
					Log.d(TAG, data);
				}
				metricaEvent = new MetricaEvent(MetricaEvent.FETCH_INSTALL_REFERRER);
				metricaEvent.data = data;
			}
			else if (event.code == MetricaEvent.API_KEY_IS_NOT_VALID) {
				if (showLogs) {
					Log.d(TAG, data);
				}
				metricaEvent = new MetricaEvent(MetricaEvent.API_KEY_IS_NOT_VALID);
				metricaEvent.data = data;
			}
			else if (event.code == MetricaEvent.UNEXPECTED_EXCEPTION) {
				if (showLogs) {
					Log.d(TAG, data);
				}
				metricaEvent = new MetricaEvent(MetricaEvent.UNEXPECTED_EXCEPTION);
				metricaEvent.data = data;
			}
			dispatchEvent(metricaEvent);
		}
	}
}