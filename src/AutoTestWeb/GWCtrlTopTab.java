package AutoTestWeb;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import AutoTest.GLog;

/**
 *  主显示区-顶层页签栏
 */
public class GWCtrlTopTab {
	
	   /**
	    * 根据顶层页签的文本名称定位页签并点击 顶层页签元素模块名称与关闭按钮处于同级元素，所以需要先按照页签名称找到父级元素，在找到同级的关闭按钮或其他子元素执行点击
	    * @param moduleName 模块名称
	    * @param driver 全局驱动
	    * @param Id 基准id，不为空时以该值为查询条件
	    * @param Xpath 基准xpath，基准Id为空时以该值为查询条件
	    * @param tarTagName 目标元素标签类型
	    * @param tabPropertyName 目标元素属性名称
	    * @param tabPropertyValue 目标元素属性值
	    * @param tabText 目标元素显示文本
	    */
		public static void ui_C_CLICK_TOPTAB(String moduleName, WebDriver driver, String rootId, String rootXpath,String tabName, String tabPropertyName, String tabPropertyValue, String tabText) {
			GLog.logRecordTime(8, "[顶层页签]----尝试查找[" + moduleName + "]页签");
			WebElement topTab = null;
					
			try {
				//先按照页签名称查找页签
				WebElement tab = GWCtrlStaticFind.getWebElementByIdOrXpath(driver, rootId, rootXpath, tabName, tabPropertyName, moduleName, tabText);
				if(tab != null) {
					//如果找到，获得父级节点
					WebElement tabParent = tab.findElement(By.xpath("./.."));
					//再从上步得到的父节点中查找子节点
					List<WebElement> tars = tabParent.findElements(By.tagName(tabName));
					for(WebElement tar:tars){
						//如果元素属性名和属性值均不为空，则按照元素属性名称和属性值定位元素
						if(!tabPropertyName.equals("") && !tabPropertyValue.equals("")) {
							if(tar.getAttribute(tabPropertyName).equals(tabPropertyValue)) {
								GLog.logRecordTime(8, "页签属性名[" + tabPropertyName + "]，页签属性值[" + tabPropertyValue + "]");
								topTab = tar;
								break;
							}
						}else {//如果元素属性名和属性值任意一项为空，则按照文本定位元素
							if(!tabText.equals("") && tar.getText().equals(tabText)) {
								GLog.logRecordTime(8, "文本值[" + tabText + "]");
								topTab = tar;
								break;
							}
						}

					}
					topTab.click();
					GLog.logRecordTime(8, "[顶层页签]----已处理[" + moduleName + "]页签");
				}else{
					GLog.logRecordTime(8, "[顶层页签]----未找到[" + moduleName + "]页签");
				}
			}catch (Exception e){
				GWCtrlException.SwtichTo(e, 1, 8, "[顶层页签]----查找[" + moduleName + "]页签异常", true);
			}
		}
		
	   /**
	    * 根据顶层页签的文本名称定位页签并关闭
	    */
		public static void ui_C_CLOSE_TOPTAB(String strTabName) {
			ui_C_CLICK_TOPTAB(strTabName
			, GParam.g_Dr
			, GWCtrlWebElementId.CN_ID.get("顶层页签栏")
			, ""
			, "a"
			, "title"
			, "关闭"
			, "");
		}
}
