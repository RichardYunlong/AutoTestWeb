package AutoTestWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import AutoTest.GLog;

/**
 *  Href控件点击处理
 */
public class GWCtrlHrefClick {
	
	/**
	 *  href类目标元素，通过Text找提交按钮点击提交
	 *  @param strSpanText
	 */
	public static void ByLinkText(String strLinkText) {
		GLog.logRecordTime(8, "正在查询[" + strLinkText + "]");
		WebElement href = GParam.g_Dr.findElement(By.linkText(strLinkText));
		href.click();
		GLog.logRecordTime(8, "href元素-被点击了");
	}
	

	
	/**
	 *  Href类目标元素，通过Text该按钮并点击
	 *  @param strHref
	 */
	public static void ClickHref(String strHref) {
		GLog.logRecordTime(8, "正在查询[" + strHref + "]");
        WebElement link = GParam.g_Dr.findElement(By.linkText("请登录"));
        link.click();
        GLog.logRecordTime(8, "href元素-被点击了");
	}
}
