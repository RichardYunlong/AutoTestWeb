package AutoTestWeb;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import AutoTest.GLog;
import AutoTest.GText;

/**
 *  主显示区-提示处理
 */
public class GWCtrlAlert {
	
	/**
	 * 支持弹出提示前的操作列表
	 */
	public static String PRE_ALERTS[] = {"SAVE", "MODIFY", "SUBMIT", "CANCELSUBMIT"};
	
	/**
	 * 记录弹出提示前的操作 默认为"save"，即保存操作
	 */
	public static String PRE_ALERT = "SAVE";
	
	/**
	 * 记录弹出提示前的操作 默认为"save"，即保存操作
	 */
	public static boolean ui_C_ALERT(int tabIndex,String strPreAlert) {
		boolean bRes = false;
		try {
			while (!bRes) {
				GLog.logRecordTime(8, "检测是否存在校验窗体");
				GWCtrlFrame.ui_C_SWITCN_ELEMENT(GWCtrlWebElementIframe.getIframe(tabIndex));
				String cssCheck = GText.getCssSelectorTxt("div", "class", " x-window x-window-plain x-window-dlg");
				//GWCtrlWait.ViewWaitingByCssSelector(3, cssCheck);
				WebElement iframeDiv = GParam.g_Dr.findElement(By.cssSelector(cssCheck));
		    	if(iframeDiv != null) {
	    			GLog.logRecordTime(8, "检测到校验窗体");
					switch(strPreAlert) {
						case "保存":{
							List<WebElement> buttons = iframeDiv.findElements(By.tagName("button"));
			        		for(WebElement button:buttons){
			        			if(button.getText().equals("是")) {
			        				GLog.logRecordTime(8, "找到目标，类型为：" + "button" + "；元素为[" + button.getText() + "]");
			        				button.click();
			        				break;
			        			}
			        		}
			    			GLog.logRecordTime(8, "校验窗体点击确定");
			    			bRes = true;
			    			break;
						}
						default:{
							List<WebElement> buttons = iframeDiv.findElements(By.tagName("button"));
			        		for(WebElement button:buttons){
			        			if(button.getText().equals("确定")) {
			        				GLog.logRecordTime(8, "找到目标，类型为：" + "button" + "；元素为[" + button.getText() + "]");
			        				button.click();
			        				break;
			        			}
			        		}
			    			GLog.logRecordTime(8, "校验窗体点击确定");
			    			bRes = true;
							break;
						}
					}
		    	}
			}
			GLog.logRecordTime(8, "校验窗体-正常关闭");
        }catch(Exception e) {
        	GLog.logRecordTime(8, "校验窗体不存在或操作异常");
        }
		GWCtrlFrame.ui_C_SWITCN_DEFAULT();
		return bRes;
	}
}
