package AutoTestWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import AutoTest.GLog;


/**
 *  Div控件单击处理
 */
public class GWCtrlDivDate {
	
	public static String divDate ="";
	/**
	 * 查找div上的内容
	 * @param divId
	 * @return DivDate
	 */
	public static String ById(String divId) {
		try {
			WebElement div = GParam.g_Dr.findElement(By.id(divId));
			divDate = div.getAttribute("innerHTML");
			GLog.logRecordTime(8, "date元素-被找到了");
		} catch (Exception e) {
			GWCtrlException.SwtichTo(e, 1, 8, "date元素-查找失败", true);
		}
		return divDate;
	}
	
	
	public static String ByXpath(String divXpath) {
		try {
			WebElement div = GParam.g_Dr.findElement(By.xpath(divXpath));
			divDate = div.getAttribute("innerHTML");
			GLog.logRecordTime(8, "date元素-被找到了");
		} catch (Exception e) {
			GWCtrlException.SwtichTo(e, 1, 8, "date元素-查找失败", true);
		}
		return divDate;	
	}
	
	
	public static String ByClassName(String divClassName) {
		try {
			WebElement div = GParam.g_Dr.findElement(By.className(divClassName));
			divDate = div.getAttribute("innerHTML");
			GLog.logRecordTime(8, "date元素-被找到了");
		} catch (Exception e) {
			GWCtrlException.SwtichTo(e, 1, 8, "date元素-查找失败", true);
		}
		return divDate;
		
	}
}
