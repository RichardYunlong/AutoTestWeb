package AutoTestWeb;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AutoTest.GLog;

/**
 *  元素等待功能
 */
public class GWCtrlWait {
	
	/**
	 *  隐式等待，对webdriver对象进行等待时间设置，有效范围为该webdriver对象整个生命周期，一旦设置不便于灵活控制，所以不推荐使用
	 *  
	 *  @param mtime 等待时间
	 */
	public static void Waiting(int mtime) {
		GLog.logRecordTime(8, "最多等待" + mtime + "秒");
		try {
			GParam.g_Dr.manage().timeouts().implicitlyWait(mtime, TimeUnit.SECONDS);
		} catch (Exception e) {
			GWCtrlException.SwtichTo(e, 1, 8, "Page Reload TimeOut, it should be less than" + GTestIndicators.PageShowTime, true);
		}
	}
	
	/**
	 *  显式等待等待，需要提供指定元素的查询条件，包括【属性名称】和【属性值】，例如：以【id】方式查询，查询的【id值】为“main-content”
	 *  等待时间受全局参数影响，目前为【GTestIndicators.PageShowTime】，请注意该值得改动情况
	 *  
	 *  @param waitByValueType 等待目标的条件类型 例如“id”，意为通过id来等待
	 *  @param waitByValue 等待目标的条件值  例如“main-content”，意为等待的目标元素id值为“main-content”
	 */
	public static void WaitingAll(String waitByType, String waitByTar) {
		try {
			GLog.logRecordTime(8, "[页面处理]----等待元素完全加载：类型-" + waitByType + ";条件-" + waitByTar);
			switch(waitByType) {
			case "id":{
				ViewWaitingAllById(GTestIndicators.PageShowTime, waitByTar);  
				break;
			}
			case "cssSelector":{
				ViewWaitingAllByCssSelector(GTestIndicators.PageShowTime, waitByTar);
				break;
			}
			case "xpath":{
				ViewWaitingAllByXpath(GTestIndicators.PageShowTime, waitByTar); 
				break;
			}
			default:{
				ViewWaitingAllById(GTestIndicators.PageShowTime, waitByTar);
				break;
			}
		}
			GLog.logRecordTime(8, "[页面处理]----等待元素完全加载成功");
		} catch (Exception e){
			GWCtrlException.SwtichTo(e, 1, 8, "[页面处理]----等待元素完全加载失败", true);
		}
	}
	
	/**
	 *  显式等待 符合目标Id的某个元素出现，单位为秒(s)
	 *  @param mtime 等待时间
	 *  @param tagId 目标id
	 */
	public static void ViewWaitingById(int mtime, String tagId) {
		GLog.logRecordTime(8, "正在查询["+ tagId + "],最多等待" + mtime + "秒");
		WebDriverWait wait = new WebDriverWait(GParam.g_Dr, mtime);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(tagId)));
		GLog.logRecordTime(8, "[" + tagId + "]-加载完成");
	}
	
	/**
	 *  显式等待 符合目标Id的某一组元素出现，单位为秒(s)
	 *  @param mtime 等待时间
	 *  @param tagId 目标id
	 */
	public static void ViewWaitingAllById(int mtime, String tagId) {
		GLog.logRecordTime(8, "正在查询["+ tagId + "],最多等待" + mtime + "秒");
		WebDriverWait wait = new WebDriverWait(GParam.g_Dr, mtime);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(tagId)));
		GLog.logRecordTime(8, "[" + tagId + "]-加载完成");
	}
	
	/**
	 *  显式等待 符合目标Xpath的某个元素出现，单位为秒(s)
	 *  @param mtime 等待时间
	 *  @param tagXpath 目标xpath
	 */
	public static void ViewWaitingByXpath(int mtime, String tagXpath) {
		GLog.logRecordTime(8, "正在查询["+ tagXpath + "],最多等待" + mtime + "秒");
		WebDriverWait wait = new WebDriverWait(GParam.g_Dr, mtime);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(tagXpath)));
		GLog.logRecordTime(8, "[" + tagXpath + "]-加载完成");
	}
	
	/**
	 *  显式等待 符合目标Xpath的某一组元素出现，单位为秒(s)
	 *  @param mtime 等待时间
	 *  @param tagXpath 目标xpath
	 */
	public static void ViewWaitingAllByXpath(int mtime, String tagXpath) {
		GLog.logRecordTime(8, "正在查询["+ tagXpath + "],最多等待" + mtime + "秒");
		WebDriverWait wait = new WebDriverWait(GParam.g_Dr, mtime);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(tagXpath)));
		GLog.logRecordTime(8, "[" + tagXpath + "]-加载完成");
	}
	
	/**
	 *  显式等待 符合目标linkText的某个元素出现，单位为秒(s)
	 *  @param mtime 等待时间
	 *  @param linkText 目标文本
	 */
	public static void ViewWaitingByLinkText(int mtime, String linkText) {
		GLog.logRecordTime(8, "正在查询["+ linkText + "],最多等待" + mtime + "秒");
		WebDriverWait wait = new WebDriverWait(GParam.g_Dr, mtime);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(linkText)));
		GLog.logRecordTime(8, "[" + linkText + "]-加载完成");
	}
	
	/**
	 *  显式等待 符合目标linkText的某一组元素出现，单位为秒(s)
	 *  @param mtime 等待时间
	 *  @param linkText 目标文本
	 */
	public static void ViewWaitingAllByLinkText(int mtime, String linkText) {
		GLog.logRecordTime(8, "正在查询["+ linkText + "],最多等待" + mtime + "秒");
		WebDriverWait wait = new WebDriverWait(GParam.g_Dr, mtime);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText(linkText)));
		GLog.logRecordTime(8, "[" + linkText + "]-加载完成");
	}
	
	/**
	 *  显式等待 符合目标cssSelector的某个元素出现，单位为秒(s)
	 *  @param mtime 等待时间
	 *  @param cssSelector 目标cssSelector
	 */
	public static void ViewWaitingByCssSelector(int mtime, String cssSelector) {
		GLog.logRecordTime(8, "正在查询["+ cssSelector + "],最多等待" + mtime + "秒");
		WebDriverWait wait = new WebDriverWait(GParam.g_Dr, mtime);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector)));
		GLog.logRecordTime(8, "[" + cssSelector + "]-加载完成");
	}
	
	/**
	 *  显式等待 符合目标cssSelector的某一组元素出现，单位为秒(s)
	 *  @param mtime 等待时间
	 *  @param cssSelector 目标cssSelector
	 */
	public static void ViewWaitingAllByCssSelector(int mtime, String cssSelector) {
		GLog.logRecordTime(8, "正在查询["+ cssSelector + "],最多等待" + mtime + "秒");
		WebDriverWait wait = new WebDriverWait(GParam.g_Dr, mtime);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(cssSelector)));
		GLog.logRecordTime(8, "[" + cssSelector + "]-加载完成");
	}
	
	/**
	 *  显式等待 符合目标className的某个元素出现，单位为秒(s)
	 *  @param mtime 等待时间
	 *  @param className 目标className
	 */
	public static void ViewWaitingByClassName(int mtime, String className) {
		GLog.logRecordTime(8, "正在查询["+ className + "],最多等待" + mtime + "秒");
		WebDriverWait wait = new WebDriverWait(GParam.g_Dr, mtime);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className(className)));
		GLog.logRecordTime(8, "[" + className + "]-加载完成");
	}
	
	/**
	 *  显式等待 符合目标className的某一组元素出现，单位为秒(s)
	 *  @param mtime 等待时间
	 *  @param className 目标className
	 */
	public static void ViewWaitingAllByClassName(int mtime, String tagClassName) {
		GLog.logRecordTime(8, "正在查询["+ tagClassName + "],最多等待" + mtime + "秒");
		WebDriverWait wait = new WebDriverWait(GParam.g_Dr, mtime);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className(tagClassName)));
		GLog.logRecordTime(8, "[" + tagClassName + "]-加载完成");
	}
	
	/**
	 *  显式等待 某个元素出现，单位为秒(s)
	 *  @param mtime 等待时间
	 *  @param webElement 目标webElement
	 */
	public static void ViewWaitingByWebElement(int mtime, WebElement webElement) {
		GLog.logRecordTime(8, "正在查询["+ webElement.toString() + "],最多等待" + mtime + "秒");
		WebDriverWait wait = new WebDriverWait(GParam.g_Dr, mtime);
		wait.until(ExpectedConditions.visibilityOf(webElement));
		GLog.logRecordTime(8, "[" + webElement.toString() + "]-加载完成");
	}
	
	/**
	 *  显式等待 某一组元素出现，单位为秒(s)
	 *  @param mtime 等待时间
	 *  @param webElement 目标webElement
	 */
	public static void ViewWaitingAllByWebElement(int mtime, WebElement webElement) {
		ArrayList<WebElement> elements = new ArrayList<WebElement>();
		elements.add(webElement);
		GLog.logRecordTime(8, "正在查询["+ webElement.toString() + "],最多等待" + mtime + "秒");
		WebDriverWait wait = new WebDriverWait(GParam.g_Dr, mtime);
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
		GLog.logRecordTime(8, "[" + webElement.toString() + "]-加载完成");
	}
	
	/**
	 *  显式等待 符合目标Id的某个元素中出现指定字符串，单位为秒(s)
	 *  @param mtime 等待时间
	 *  @param tagId 目标id
	 *  @param tText 目标字符串
	 */
	public static void ViewWaitingTextById(int mtime, String tagId, String tText) {
		GLog.logRecordTime(8, "正在查询["+ tText + "],最多等待" + mtime + "秒");
		WebDriverWait wait = new WebDriverWait(GParam.g_Dr, mtime);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id(tagId), tText));
		GLog.logRecordTime(8, "[" + tText + "]-加载完成");
	}
	
	/**
	 *  显式等待 符合目标Id的某个元素已经可被点击，单位为秒(s)
	 *  @param mtime 等待时间
	 *  @param tagId 目标id
	 */
	public static void Wait2BeClickableById(int mtime, String tagId) {
		GLog.logRecordTime(8, "正在查询["+ tagId + "],最多等待" + mtime + "秒");
		WebDriverWait wait = new WebDriverWait(GParam.g_Dr, mtime);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(tagId)));
		GLog.logRecordTime(8, "[" + tagId + "]-加载完成");
	}
	
	/**
	 *  显式等待 符合目标xpath的某个元素中出现指定字符串，单位为秒(s)
	 *  @param mtime 等待时间
	 *  @param tagXpath 目标xpath
	 *  @param tText 目标字符串
	 */
	public static void ViewWaitingTextByXpath(int mtime, String tagXpath, String tText) {
		GLog.logRecordTime(8, "正在查询["+ tText + "],最多等待" + mtime + "秒");
		WebDriverWait wait = new WebDriverWait(GParam.g_Dr, mtime);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(tagXpath), tText));
		GLog.logRecordTime(8, "[" + tText + "]-加载完成");
	}
	
	/**
	 *  显式等待 符合目标Id的某个元素已经可被点击，单位为秒(s)
	 *  @param mtime 等待时间
	 *  @param tagXpath 目标xpath
	 */
	public static void Wait2BeClickableByXpath(int mtime, String tagXpath) {
		GLog.logRecordTime(8, "正在查询["+ tagXpath + "],最多等待" + mtime + "秒");
		WebDriverWait wait = new WebDriverWait(GParam.g_Dr, mtime);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(tagXpath)));
		GLog.logRecordTime(8, "[" + tagXpath + "]-加载完成");
	}
	
	/**
	 *  显式等待 符合目标cssSelector的某个元素中出现指定字符串，单位为秒(s)
	 *  @param mtime 等待时间
	 *  @param cssSelector 目标cssSelector
	 *  @param tText 目标字符串
	 */
	public static void ViewWaitingTextByCssSelector(int mtime, String cssSelector, String tText) {
		GLog.logRecordTime(8, "正在查询["+ tText + "],最多等待" + mtime + "秒");
		WebDriverWait wait = new WebDriverWait(GParam.g_Dr, mtime);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(cssSelector), tText));
		GLog.logRecordTime(8, "[" + tText + "]-加载完成");
	}
	
	/**
	 *  显式等待 符合目标cssSelector的某个元素已经可被点击，单位为秒(s)
	 *  @param mtime 等待时间
	 *  @param cssSelector 目标cssSelector
	 */
	public static void Wait2BeClickableByCssSelector(int mtime, String cssSelector) {
		GLog.logRecordTime(8, "正在查询["+ cssSelector + "],最多等待" + mtime + "秒");
		WebDriverWait wait = new WebDriverWait(GParam.g_Dr, mtime);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector)));
		GLog.logRecordTime(8, "[" + cssSelector + "]-加载完成");
	}
	
	/**
	 *  显式等待 符合目标webElement的某个元素中出现指定字符串，单位为秒(s)
	 *  @param mtime  等待时间
	 *  @param webElement 目标webElement
	 *  @param tText 目标字符串
	 */
	public static void ViewWaitingTextByWebElement(int mtime, WebElement webElement, String tText) {
		GLog.logRecordTime(8, "正在查询["+ tText + "],最多等待" + mtime + "秒");
		WebDriverWait wait = new WebDriverWait(GParam.g_Dr, mtime);
		wait.until(ExpectedConditions.textToBePresentInElement(webElement, tText));
		GLog.logRecordTime(8, "[" + tText + "]-加载完成");
	}
	
	/**
	 *  显式等待 符合目标webElement的某个元素已经可被点击，单位为秒(s)
	 *  @param mtime 等待时间
	 *  @param webElement 目标webElement
	 */
	public static void Wait2BeClickableByWebElement(int mtime, WebElement webElement) {
		GLog.logRecordTime(8, "正在查询["+ webElement.toString() + "],最多等待" + mtime + "秒");

		JavascriptExecutor js = (JavascriptExecutor) GParam.g_Dr;
		js.executeScript("arguments[0].click();", webElement);
		
		WebDriverWait wait = new WebDriverWait(GParam.g_Dr, mtime);
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
		GLog.logRecordTime(8, "[" + webElement.toString() + "]-加载完成");
	}
}
