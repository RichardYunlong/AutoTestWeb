package AutoTestWeb;

import org.openqa.selenium.JavascriptExecutor;

import AutoTest.GLog;

/**
 *  Div控件填写处理
 */
public class GWCtrlDivFill {
	
	/**
	 *  Div类目标元素，通过ID查找输入框，写入指定内容
	 *  @param divId
	 *  @param str
	 */
	public static void ById(String divId, String str) {
		JavascriptExecutor js = (JavascriptExecutor) GParam.g_Dr;
		js.executeScript("document.getElementById('" + divId + "').innerHTML="+ str);
		GLog.logRecordTime(8, "div类型输入框-填写了"+str);
	}

	/**
	 *  Div类目标元素，通过ID查找输入框，写入指定内容
	 *  @param divXpath
	 *  @param str
	 */
	public static void ByXpath(String divXpath, String str) {
		JavascriptExecutor js = (JavascriptExecutor) GParam.g_Dr;
		js.executeScript("document.evaluate(" + divXpath + ", document, null, 9, null).singleNodeValue.innerHTML="+ str);
		GLog.logRecordTime(8, "div类型输入框-填写了"+str);
	}
}
