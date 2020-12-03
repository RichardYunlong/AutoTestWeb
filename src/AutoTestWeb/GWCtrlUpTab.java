package AutoTestWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import AutoTest.GLog;

public class GWCtrlUpTab {
    /**
    * 根据中部页签的文本名称定位页签并点击
    * @param driver 全局驱动
    * @param Id 基准id，不为空时以该值为查询条件
    * @param Xpath 基准xpath，基准Id为空时以该值为查询条件
    * @param tarTagName 目标元素标签类型
    * @param tabPropertyName 目标元素属性名称
    * @param tabPropertyValue 目标元素属性值
    * @param tabText 目标元素显示文本
    */
	public static void ui_C_CLICK_TAB(WebDriver driver, int tabIndex, String tabId) {
		GLog.logRecordTime(8, "页签切换至[" + tabId + "]页签");
		WebElement tab = null;
		
		try {
			GWCtrlFrame.ui_C_SWITCN_ELEMENT(GWCtrlWebElementIframe.getIframe(tabIndex));
			
			tab = driver.findElement(By.id(tabId));
			GWCtrlWait.Wait2BeClickableByWebElement(GTestIndicators.PageShowTime, tab);
			
			if(tab != null) {
				tab.click();
				GLog.logRecordTime(8, "页签切换至[" + tabId + "]页签");
			}else{
				GLog.logRecordTime(8, "未找到[" + tabId + "]页签");
			}
	
	    	//游标切换会主窗体
			GWCtrlFrame.ui_C_SWITCN_DEFAULT();
		}catch (Exception e){
			GWCtrlException.SwtichTo(e, 1, 8, "切换至[" + tabId + "]页签异常", true);
		}
	}
}
