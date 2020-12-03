package AutoTestWeb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import AutoTest.GLog;
import AutoTest.GText;

/**
 * 常用元素iframe
 */
public class GWCtrlWebElementIframe {
	
	/**
	 * iframe
	 */
	private static Map<String, WebElement> CN_IFRAME = new HashMap<String,WebElement>();
	
	/**
	 *  设置新iframe元素值
	 *  
	 *  @param tabIndex 页签序号 
	 *  @param waitByValueType 等待目标的条件类型 例如“id”，意为通过id来等待
	 *  @param waitByValue 等待目标的条件值  例如“main-content”，意为等待的目标元素id值为“main-content”
	 */
	public static void setIframe(int tabIndex, String waitByType, String waitByTar){
		WebElement webElement = null;
		WebElement webElementIframe = null;
		try {
			GLog.logRecordTime(8, "[页面处理]----添加动态iframe：" + String.valueOf(tabIndex));
			
			switch(waitByType) {
			case "id":{
				GWCtrlWait.ViewWaitingAllById(GTestIndicators.PageShowTime, waitByTar);
				webElement = GParam.g_Dr.findElement(By.id(waitByTar));
				break;
			}
			case "cssSelector":{
				GWCtrlWait.ViewWaitingByCssSelector(GTestIndicators.PageShowTime, GText.getCssSelectorTxt("div", "class", waitByTar));
				webElement = GParam.g_Dr.findElement(By.cssSelector(GText.getCssSelectorTxt("div", "class", waitByTar)));
				break;
			}
			case "xpath":{
				GWCtrlWait.ViewWaitingAllByXpath(GTestIndicators.PageShowTime, waitByTar);
				webElement = GParam.g_Dr.findElement(By.xpath(waitByTar));
				break;
			}
			default:{
				webElement = null;
				break;
			}
		}
			List<WebElement> iframes = webElement.findElements(By.tagName("iframe"));
			//第一个找到的即为目标元素“最外层的iframe”，返回该元素
			for(WebElement iframe:iframes){
				//取得属性src对应的值
				String strAttribute = iframe.getAttribute("src");
				if(strAttribute.indexOf("portalPage") != -1) {//如果src对应的值中包含“portalPage”字符串，则正面当前页面iframe为【门户页】，即【我的桌面】
					GLog.logRecordTime(8, "[页面处理]----添加了【我的桌面】iframe");
				}else if (strAttribute.indexOf("ListPage") != -1) {//如果src对应的值中包含“ListPage”字符串，则正面当前页面iframe为【列表页签】
					GLog.logRecordTime(8, "[页面处理]----添加了【列表页签】iframe");
				}else if (strAttribute.indexOf("EditPage") != -1) {//如果src对应的值中包含“EditPage”字符串，则正面当前页面iframe为【编辑页签】
					GLog.logRecordTime(8, "[页面处理]----添加了【编辑页签】iframe");
				}else{
					GLog.logRecordTime(8, "[页面处理]----添加了【未知】iframe");
				}
				webElementIframe = iframe;
				break;
			}
			
			CN_IFRAME.put(String.valueOf(tabIndex), webElementIframe);
		} catch (Exception e){
			GLog.logRecordTime(8, "[页面处理]----添加动态iframe失败");
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取iframe
	 */
	public static WebElement getIframe(int tabIndex){
		return CN_IFRAME.get(String.valueOf(tabIndex));
	}
	
	/**
	 * 替换iframe
	 */
	public static WebElement replaceIframe(int tabIndex, WebElement webElement){
		return CN_IFRAME.replace(String.valueOf(tabIndex), webElement);
	}
}
