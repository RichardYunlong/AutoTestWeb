package AutoTestWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import AutoTest.GLog;

public class GWCtrlCheckBox {
	
	/**
	 *  勾选单选框
	 *  @param checkboxId
	 */
	public static void ById(String checkboxId) {
		WebElement checkbox = GParam.g_Dr.findElement(By.id(checkboxId));
		if(!checkbox.isSelected()) {
			checkbox.click();
			GLog.logRecordTime(8, "checkbox元素-被选中了");
		}
	}
	
	/**
	 *  取消勾选单选框
	 *  @param checkboxId
	 */
	public static void ById2Cancel(String checkboxId) {
		WebElement checkbox = GParam.g_Dr.findElement(By.id(checkboxId));
		if(checkbox.isSelected()) {
			checkbox.click();
			GLog.logRecordTime(8, "checkbox元素-被取消选中了");
		}
	}
}
