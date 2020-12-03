package Login.GBL;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import AutoTest.GLog;
import AutoTest.GText;
import AutoTestWeb.GParam;
import AutoTestWeb.GTestIndicators;
import AutoTestWeb.GWCtrlDivClick;
import AutoTestWeb.GWCtrlWait;
import AutoTestWeb.GWCtrlWebElementId;
import io.qameta.allure.Step;

/**
 *  用户退出业务逻辑
 */
public class SignOut {

	/**
	 *  数据
	 */
	private Data pData = null;
	
	/**
	 *  用户退出登录
	 */
	@Step("注销")
	public void ui_G_LOGOUT(boolean bYes) {
		pData = new Data();
		
		GLog.logRecordTime(9, "[功能]----用户退出登录");
		try {
			GWCtrlWait.ViewWaitingAllById(GTestIndicators.PageShowTime, GWCtrlWebElementId.CN_ID.get("用户"));//等待用户状态窗口
			GWCtrlDivClick.ById(GWCtrlWebElementId.CN_ID.get("用户"));//打开用户状态窗口
			GWCtrlWait.ViewWaitingAllById(GTestIndicators.PageShowTime, GWCtrlWebElementId.CN_ID.get("注销"));//等待“注销”区域
			GWCtrlDivClick.ById(GWCtrlWebElementId.CN_ID.get("注销"));//并点击“注销”区域
			
			String CCS = GText.getCssSelectorTxt("div", "class", " x-window x-window-plain x-window-dlg");
	    	GWCtrlWait.ViewWaitingByCssSelector(GTestIndicators.PageShowTime, CCS);
	    	WebElement divRoot = GParam.g_Dr.findElement(By.cssSelector(CCS));
	    	
	    	if(divRoot != null) {
        		
        		List<WebElement> buttons = divRoot.findElements(By.tagName("button"));
        		for(WebElement button:buttons){
        			if(bYes && button.getText().equals("是")) {
        				GLog.logRecordTime(8, "找到目标，类型为：" + "button" + "；元素为[" + button.getText() + "]");
        				button.click();
        				break;
        			}
        			if(!bYes && button.getText().equals("否")) {
        				GLog.logRecordTime(8, "找到目标，类型为：" + "button" + "；元素为[" + button.getText() + "]");
        				button.click();
        				break;
        			}
        		}
        	}
			
			pData.bSignOutStatus=true;
			GLog.logRecordTime(9, "[功能]----用户退出登录成功");	
		}catch (Exception e){
			pData.bSignOutStatus=false;
			GLog.logRecordTime(9, "[功能]----用户退出登录异常");	
			e.printStackTrace();
		}
	}
}
