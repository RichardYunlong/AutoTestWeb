package AutoTestWeb;

import org.openqa.selenium.By;

import AutoTest.GLog;
import AutoTest.GText;

/**
 *  Span控件点击处理
 */
public class GWCtrlSpanClick {
	
	/**
	 *  Span类目标元素，通过Text找提交按钮点击提交
	 *  @param strSpanText
	 */
	public static void ByText(String strSpanText) {
		GParam.g_Dr.findElement(By.xpath("//span[text()=\"" + strSpanText + "\"]")).click();
		GLog.logRecordTime(8, "span元素-被点击了");
	}
	
	/**
	 *  Span类目标元素，通过Text找提交按钮点击提交
	 *  @param strSpanText
	 */
	public static void ByCssSelector(String strCssSelector) {
		GParam.g_Dr.findElement(By.cssSelector(strCssSelector)).click();
		GLog.logRecordTime(8, "span元素-被点击了");
	}
	
	/**
	 *  Span类目标元素，通过Text找提交按钮点击提交
	 *  @param strSpanText
	 */
	public static void ByCssSelectorByTagName(String strSpanText, String tagName) {
		GParam.g_Dr.findElement(By.cssSelector(GText.getCssSelectorTxt(tagName, "title", strSpanText))).click();
		GLog.logRecordTime(8, "span元素-被点击了");
	}
	
	/**
	 *  Span类目标元素，通过Text找提交按钮点击提交
	 *  @param strSpanText
	 */
	public static void ByLinkText(String strSpanText) {
		GParam.g_Dr.findElement(By.linkText(strSpanText)).click();
		GLog.logRecordTime(8, "span元素-被点击了");
	}
}
