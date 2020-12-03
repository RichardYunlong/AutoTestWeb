package AutoTestWeb;

import AutoTest.GLog;
import AutoTest.GSys;

/**
 *  系统管理
 */
public class GWebSys {
	/**
	 *  系统自检是否就绪
	 */
	public static boolean IsTestReady = false;
	
	/**
	 *  初始化测试环境
	 */
	public static boolean initTestSys(String bro) {
		long startTime = 0;
		
		try {
			// 初始化全局变量，用于传递参数;
			startTime = System.currentTimeMillis();
			GLog.logDoReady(startTime, "GParam");
			GSys.PROGRESS_CUR++;
			
			// 加载浏览器设置;
			startTime = System.currentTimeMillis();
			new GBrowser();
			GLog.logDoReady(startTime, "GBrowser");
			GSys.PROGRESS_CUR++;
			
			// 加载常用Id;
			startTime = System.currentTimeMillis();
			new GWCtrlWebElementId();
			GLog.logDoReady(startTime, "GWCtrlWebElementId");
			GSys.PROGRESS_CUR++;
			
			// 加载常用Class;
			startTime = System.currentTimeMillis();
			new GWCtrlWebElementClass();
			GLog.logDoReady(startTime, "GWCtrlWebElementClass");
			GSys.PROGRESS_CUR++;
			
			// 加载常用Src;
			startTime = System.currentTimeMillis();
			new GWCtrlWebElementSrc();
			GLog.logDoReady(startTime, "GWCtrlWebElementSrc");
			GSys.PROGRESS_CUR++;
			
			// 加载常用iFrame;
			startTime = System.currentTimeMillis();
			new GWCtrlWebElementIframe();
			GLog.logDoReady(startTime, "GWCtrlWebElementIframe");
			GSys.PROGRESS_CUR++;
			
			// 加载板式列表;
			startTime = System.currentTimeMillis();
			new Login.GTheme.Data();
			GLog.logDoReady(startTime, "Login.GTheme.Data");
			GSys.PROGRESS_CUR++;
			
			// 加载基本菜单;
			startTime = System.currentTimeMillis();
			new GWCtrlChooseModule();
			GLog.logDoReady(startTime, "GWCtrlChooseModule");
			GSys.PROGRESS_CUR++;
			
			// 初始化浏览器类型;
			GParam.setVBInfo(bro);
			GLog.logDoReady(startTime, bro);
			GSys.PROGRESS_CUR++;
			
			IsTestReady = true;
		}catch(Exception e) {
			IsTestReady = false;
			GWCtrlException.SwtichTo(e, 1, 8, "initTestSys error", true);
		}
		
		return IsTestReady;
	}
}
