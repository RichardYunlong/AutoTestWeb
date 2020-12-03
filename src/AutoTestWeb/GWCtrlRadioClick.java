package AutoTestWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import AutoTest.GLog;

/**
 *  单选选择功能
 */
public class GWCtrlRadioClick {
	
	/**
	 *  选中radio
	 *  @param radioId
	 */
	public static void ById(String radioId) {
		WebElement radio = GParam.g_Dr.findElement(By.id(radioId));
		if(!radio.isSelected()) {
			radio.click();
			GLog.logRecordTime(8, "radio元素-被选中了");
		}
	}
	
	/**
	 *  取消选中radio
	 *  @param radioId
	 */
	public static void ById2Cancel(String radioId) {
		WebElement radio = GParam.g_Dr.findElement(By.id(radioId));
		if(radio.isSelected()) {
			radio.click();
			GLog.logRecordTime(8, "radio元素-被取消选中了");
		}
	}
}
