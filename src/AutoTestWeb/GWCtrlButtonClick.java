package AutoTestWeb;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import AutoTest.GLog;

/**
 *  Button控件点击处理
 */
public class GWCtrlButtonClick {
	
	/**
	 *  Button类目标元素，通过Id找提交按钮点击提交
	 *  @param buttonId
	 */
	public static void ById(String buttonId) {
		WebElement searchButton = GParam.g_Dr.findElement(By.id(buttonId));
		searchButton.submit();
		GLog.logRecordTime(8, "button元素-被点击了");
	}
	
	/**
	 *  Button类目标元素，通过Id找提交按钮点击提交
	 *  @param buttonId
	 */
	public static void ByIdClick(String buttonId) {
		GWCtrlWait.ViewWaitingAllById(GTestIndicators.PageShowTime, buttonId);
		WebElement searchButton = GParam.g_Dr.findElement(By.id(buttonId));
		searchButton.click();
		GLog.logRecordTime(8, "button元素-被点击了");
	}
	
	/**
	 *  Button类目标元素，通过Id找提交按钮点击提交
	 *  @param buttonXpath
	 */
	public static void ByXpath(String buttonXpath) {
		WebElement searchButton = GParam.g_Dr.findElement(By.xpath(buttonXpath));
		searchButton.submit();
		GLog.logRecordTime(8, "button元素-被点击了");
	}
	
	/**
	 *  Button类目标元素，通过Id找提交按钮点击提交
	 *  @param buttonXpath
	 */
	public static void ByXpathClick(String buttonXpath) {
		WebElement button = GParam.g_Dr.findElement(By.xpath(buttonXpath));
		button.click();
		GLog.logRecordTime(8, "button元素-被点击了");
	}
	
	/**
	 *  Button类目标元素，通过ClassName找提交按钮点击提交
	 *  @param buttonClassName
	 */
	public static void ByTagName(String buttonTagName) {
		WebElement button = GParam.g_Dr.findElement(By.tagName(buttonTagName));
		button.click();
		GLog.logRecordTime(8, "button元素-被点击了");
	}
	
	/**
	 *  Button类目标元素，通过ClassName找提交按钮点击提交
	 *  @param buttonClassName
	 */
	public static void ByLinkText(String buttonLinkText) {
		WebElement button = GParam.g_Dr.findElement(By.linkText(buttonLinkText));
		button.click();
		GLog.logRecordTime(8, "button元素-被点击了");
	}
	
	/**
	 *  Button类目标元素，通过ClassName找提交按钮点击提交
	 *  @param buttonClassName
	 */
	public static void ByLinkTextAndTagName(String buttonLinkText, String buttonTagName) {
		List<WebElement> buttons = GParam.g_Dr.findElements(By.tagName("button"));
        for (WebElement webElement : buttons) {
            if (webElement.getAttribute("linkText").equals(buttonLinkText)) {
            	webElement.click();
        		GLog.logRecordTime(8, "button元素-被点击了");
            }
        }
	}
	
	/**
	 *  Button类目标元素，通过ClassName找提交按钮点击提交
	 *  @param buttonClassName
	 */
	public static void ByClassName(String buttonClassName) {
		WebElement searchButton = GParam.g_Dr.findElement(By.className(buttonClassName));
		searchButton.submit();
		GLog.logRecordTime(8, "button元素-被点击了");
	}
	
	/**
	 *  Table中的Button类目标元素，通过Xpath该按钮并点击
	 *  @param tableXpath
	 *  @param btnXpath
	 */
	public static void ByTable(String tableXpath, String btnXpath) {
		WebElement tableElement=GParam.g_Dr.findElement(By.xpath("tableXpath"));
		GWCtrlWait.ViewWaitingAllByWebElement(GTestIndicators.PageShowTime, tableElement);
		List<WebElement> rows=tableElement.findElements(By.tagName("tr"));
	       for (int i = 0; i < rows.size(); i++) {
	            //将表单的td放进list里，每个td是表单的一列，逐列遍历
	            List<WebElement> cols=rows.get(i).findElements(By.tagName("td"));
	            for (int j = 0; j < cols.size();) {
	                String tdText = cols.get(j).getText();
	                GLog.logRecordTime(8, tdText +"\t");
	                //判断哪行哪列的内容包含字段, 如果包含则进行操作
	                if(tdText.contains("是")){
	                    GLog.logRecordTime(8, String.valueOf(i+1));
	                    GLog.logRecordTime(8, String.valueOf(j+1));
	                    int row = i + 1;
	                    //点击所在行的下拉按钮
	                    WebElement button = GParam.g_Dr.findElement(By.className(btnXpath));
	                    GWCtrlWait.Wait2BeClickableByWebElement(GTestIndicators.PageShowTime, button);
	                    button.click();
	                    GLog.logRecordTime(8, "button元素-被点击了,在表的第" + row + "行");
	                }break;
	            }
	        }
	}
}
