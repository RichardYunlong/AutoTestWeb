package AutoTestWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import AutoTest.GLog;

/**
 *  Div控件双击处理
 */
public class GWCtrlDivDoubleClick {
	
	/**
	 *  Div类目标元素，通过ID查找层，确认点击
	 *  @param divId
	 */
	public static void ById(String divId) {
		GWCtrlWait.Wait2BeClickableById(GTestIndicators.PageShowTime, divId);
		WebElement div = GParam.g_Dr.findElement(By.id(divId));
		Actions action=new Actions(GParam.g_Dr);
		action.doubleClick(div).build().perform();
		GLog.logRecordTime(8, "div元素-被点击了");
	}
	
	/**
	 *  Div类目标元素，通过Xpath查找层，确认点击
	 *  @param divXpath
	 */
	public static void ByXpath(String divXpath) {
		GWCtrlWait.Wait2BeClickableByXpath(GTestIndicators.PageShowTime, divXpath);
		WebElement div = GParam.g_Dr.findElement(By.xpath(divXpath));
		Actions action=new Actions(GParam.g_Dr);
		action.doubleClick(div).build().perform();
		GLog.logRecordTime(8, "div元素-被点击了");
	}
	
	/**
	 *  Div类目标元素，通过ClassName查找层，确认点击
	 *  @param divClassName
	 */
	public static void ByClassName(String divClassName) {
		WebElement div = GParam.g_Dr.findElement(By.className(divClassName));
		GWCtrlWait.ViewWaitingAllByWebElement(GTestIndicators.PageShowTime, div);
		Actions action=new Actions(GParam.g_Dr);
		action.doubleClick(div).build().perform();
		GLog.logRecordTime(8, "div元素-被点击了");
	}
	
	/**
	 *  Div类目标元素，通过WebElement查找层，确认点击
	 *  @param divId
	 */
	public static void ByWebElement(WebElement divWebElement) {
		GWCtrlWait.Wait2BeClickableByWebElement(GTestIndicators.PageShowTime, divWebElement);
		Actions action=new Actions(GParam.g_Dr);
		action.doubleClick(divWebElement).build().perform();
		GLog.logRecordTime(8, "div元素-被点击了");
	}
}
