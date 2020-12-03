package AutoTestWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import AutoTest.GLog;

/**
 *  frame切换
 */
public class GWCtrlFrame {
	
	/**
	 *  根据frame的索引来定位，也就是说一个页面如果有多个frame，可以根据frame(1),frame(2)从上往下去定位。
	 */
	public static void ui_C_SWITCN_INDEX(int nIndex) {
		GParam.g_Dr.switchTo().frame(nIndex);
		GLog.logRecordTime(8, "frame元素-切换到了" + nIndex + "层");
		
	}
	
	/**
	 *  根据frame的ID或者name去识别
	 */
	public static void ui_C_SWITCN_NAME_OR_ID(String nameOrId) {
		GParam.g_Dr.switchTo().frame(nameOrId);
		GLog.logRecordTime(8, "frame元素-切换到了" + nameOrId + "层");
	}
	
	/**
	 *  根据该找到iframe这个WebElement去识别，可通过xpath定位
	 *  @param frameElement 焦点转到目标iframe
	 */
	public static void ui_C_SWITCN_ELEMENT(WebElement frameElement) {
		GParam.g_Dr.switchTo().frame(frameElement);
		GLog.logRecordTime(8, "frame元素-切换到了" + frameElement.toString() + "层");
	}
	
	/**
	 *  焦点切换回母版iframe
	 */
	public static void ui_C_SWITCN_DEFAULT() {
		GParam.g_Dr.switchTo().defaultContent();
		GLog.logRecordTime(8, "frame元素-切换到了顶层");
	}
	
	/**
	 *  切换到目标iframe
	 */
	public static void ui_C_SWITCN_XPATH(String strFrameXpath){
		GWCtrlWait.ViewWaitingAllByXpath(GTestIndicators.PageShowTime, strFrameXpath);
		WebElement iframe = GParam.g_Dr.findElement(By.xpath(strFrameXpath));
		GWCtrlFrame.ui_C_SWITCN_ELEMENT(iframe);
		GLog.logRecordTime(8, "frame元素-切换到了目标层[" + strFrameXpath + "]");
	}
}
