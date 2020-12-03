package AutoTestWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import AutoTest.GLog;

/**
 *  Input控件点击处理
 */
public class GWCtrlInputClick {
	
	/**
	 *  Input类目标元素，通过ID查找输入框，确认点击
	 *  @param inputId
	 */
	public static void ById(String inputId) {
		WebElement button = GParam.g_Dr.findElement(By.id(inputId));
		button.click();
		GLog.logRecordTime(8, "input元素-被点击了");
	}
}
