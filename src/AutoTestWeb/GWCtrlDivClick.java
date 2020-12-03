package AutoTestWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import AutoTest.GLog;
import AutoTest.GText;

/**
 *  Div控件单击处理
 */
public class GWCtrlDivClick {
	
	/**
	 *  Div类目标元素，通过ID查找层，确认点击
	 *  @param divId
	 */
	public static void ById(String divId) {
		GWCtrlWait.Wait2BeClickableById(GTestIndicators.PageShowTime, divId);
		WebElement div = GParam.g_Dr.findElement(By.id(divId));
		GLog.logRecordTime(8, "目标元素可见性为：" + String.valueOf(div.isDisplayed()));
		Actions action=new Actions(GParam.g_Dr);
		action.click(div).perform();
		GLog.logRecordTime(8, "div元素-被点击了");
	}
	
	/**
	 *  Div类目标元素，通过ID查找层，确认点击
	 *  @param divId
	 */
	public static void ByIdClick(String divId) {
		GWCtrlWait.Wait2BeClickableById(GTestIndicators.PageShowTime, divId);
		WebElement div = GParam.g_Dr.findElement(By.id(divId));
		div.click();
		GLog.logRecordTime(8, "div元素-被点击了");
	}
	
	/**
	 *  Div类目标元素，通过Xpath查找层，确认点击
	 *  @param divXpath
	 */
	public static void ByXpath(String divXpath) {
		GWCtrlWait.Wait2BeClickableByXpath(GTestIndicators.PageShowTime, divXpath);
		WebElement div = GParam.g_Dr.findElement(By.xpath(divXpath));
		JavascriptExecutor js=(JavascriptExecutor) GParam.g_Dr;
		js.executeScript("arguments[0].scrollIntoView(true);",div);
		GWCtrlWait.ViewWaitingAllByWebElement(GTestIndicators.PageShowTime, div);
		Actions action=new Actions(GParam.g_Dr);
		action.click(div).perform();
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
		action.click(div).perform();
		GLog.logRecordTime(8, "div元素-被点击了");
	}
	
	/**
	 *  Div类目标元素，通过ClassName查找层，确认点击
	 *  @param cssSelector
	 */
	public static void ByCssSelector(String cssSelector) {
		String divCss = "";
		if(null != cssSelector && !cssSelector.equals("")) {
			divCss = cssSelector;
		}else {
			divCss = GText.getCssSelectorTxt("table", "class", "x-btn g-btn-recommend x-btn-noicon");
		}
		GWCtrlWait.Wait2BeClickableByCssSelector(GTestIndicators.PageShowTime, divCss);
		WebElement div = GParam.g_Dr.findElement(By.cssSelector(divCss));
		div.click();
		GLog.logRecordTime(8, "div元素-被点击了");
	}
}
