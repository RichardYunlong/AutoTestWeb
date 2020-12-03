package AutoTestWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import AutoTest.GLog;

/**
 *  InputFile类型输入处理
 */
public class GWCtrlInputFilefill {
	
	/**
	 *  InputFile类目标元素，通过ID查找文件框，写入指定内容
	 *  @param
	 *  @param
	 */
	public static void FindAndFillInputFileById(String inputId, String str) {
		WebElement file = GParam.g_Dr.findElement(By.id(inputId));
		file.clear();
		GLog.logRecordTime(8, "file元素-被清空了");
		file.sendKeys(str);
		GLog.logRecordTime(8, "file元素-填写了"+str);
	}
}
