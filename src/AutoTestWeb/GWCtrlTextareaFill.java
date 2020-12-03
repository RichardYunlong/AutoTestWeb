package AutoTestWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import AutoTest.GLog;

/**
 *  Textarea类型输入处理
 */
public class GWCtrlTextareaFill {
	
	/**
	 *  textarea类目标元素，通过ID查找文本框，写入指定内容
	 *  @param textareaId
	 *  @param str
	 */
	public static void ById(String textareaId, String str) {
		WebElement textarea = GParam.g_Dr.findElement(By.id(textareaId));
		textarea.clear();
		GLog.logRecordTime(8, "textarea元素-被清空了");
		textarea.sendKeys(str);
		GLog.logRecordTime(8, "textarea元素-填写了"+str);
	}
}
