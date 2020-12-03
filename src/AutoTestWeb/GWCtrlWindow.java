package AutoTestWeb;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import AutoTest.GLog;

/**
 *  window切换
 */
public class GWCtrlWindow {
	
	/**
	 *  主窗口句柄 
	 */
	public static String rootHandle = "";
	
	/**
	 *  window切换到最近上一层
	 */
	public static boolean windowHandlePre() {
		boolean bHandle = false;
		try {
			GParam.g_Dr.switchTo().window(GWCtrlWindow.rootHandle);
			bHandle = true;
			GLog.logRecordTime(8, "window元素-切换到了最近上一层");
		}catch(Exception e) {
			bHandle = false;
			GWCtrlException.SwtichTo(e, 1, 8, "window元素-切换到最近上一层失败", true);
		}
		
		return bHandle;
	}
	
	/**
	 *  两个window相互切换
	 */
	public static boolean windowHandles() {
		boolean bHandle = false;
		try {
			//获取当前窗口句柄
			String handle = GParam.g_Dr.getWindowHandle();
			//保存切换前窗口句柄
			rootHandle = handle;
			//获取所有窗口句柄
			Set<String> allWindows = GParam.g_Dr.getWindowHandles();
			
			//循环判断是不是当前句柄
			for(String i:allWindows) {
				if(i.equals(handle)) {
					continue;
				}
				GParam.g_Dr.switchTo().window(i);
				GLog.logRecordTime(8, "window元素-切换到了" + i + "层");
			}
			
			bHandle = true;
		}catch(Exception e) {
			bHandle = false;
			GWCtrlException.SwtichTo(e, 1, 8, "window元素-切换失败", true);
		}
		
		return bHandle;
	}
	
	/**
	 *  多个window相互切换
	 */
	public static boolean windowsHandles(int index) {
		boolean bHandles = false;
		try {
			Set<String> windows = GParam.g_Dr.getWindowHandles();
			List<String> allWindow = new ArrayList<String>(windows);
			GParam.g_Dr.switchTo().window(allWindow.get(index));
			GLog.logRecordTime(8, "window元素-切换到了" + index + "层");
			bHandles = true;
		}catch(Exception e) {
			bHandles = false;
			GWCtrlException.SwtichTo(e, 1, 8, "window元素-切换失败", true);
			e.printStackTrace();
		}
		
		return bHandles;
	}
}
