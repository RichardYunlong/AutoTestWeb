package AutoTestWeb;

import AutoTest.GLog;

/**
 *  浏览器基本功能
 */
public class GWCtrlBasic {
	/**
	 *  打开目标地址
	 */
	public static void Open(String Url) {
		GParam.g_Dr.get(Url);
		GLog.logRecordTime(8, "浏览器-访问了" + Url);
	}
	
	/**
	 *  浏览器最大化
	 */
	public static void Maximize() {
		GParam.g_Dr.manage().window().maximize();
		GLog.logRecordTime(8, "浏览器-最大化了");
	}
	
	/**
	 *  刷新浏览器
	 */
	public static void Refresh() {
		GParam.g_Dr.navigate().refresh();
		GLog.logRecordTime(8, "浏览器-刷新了");
	}

	/**
	 *  浏览器后退
	 */
	public static void Back() {
		GParam.g_Dr.navigate().back();
		GLog.logRecordTime(8, "浏览器-后退了");
	}

	/**
	 *  浏览器前进
	 */
	public static void Forward() {
		GParam.g_Dr.navigate().forward();
		GLog.logRecordTime(8, "浏览器-前进了");
	}
	
	/**
	 *  浏览器关闭
	 */
	public static void Quit() {
		GParam.g_Dr.quit();
		GLog.logRecordTime(8, "浏览器-被关闭了");
	}
	
	/**
	 *  页签关闭
	 */
	public static void Close() {
		GParam.g_Dr.close();
		GLog.logRecordTime(8, "页签-被关闭了");
	}
	
	/**
	 *  获取当前地址栏文本
	 */
	public static String Geturl() {
		String url= GParam.g_Dr.getCurrentUrl();
		GLog.logRecordTime(8, "浏览器当前处于"+url);
		return url;
	}
}
