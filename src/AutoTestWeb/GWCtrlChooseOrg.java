package AutoTestWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import AutoTest.GLog;
import GUserLayout.SwitchLayout;

/**
 *  一级菜单栏功能查找并选中处理
 */
public class GWCtrlChooseOrg{
	
	/**
	 *  根据机构描述切换机构
	 *  @param groupName 集团名称
	 *  @param companyName 公司名称
	 *  @param prjectName 项目部名称
	 */
	public static void SelectOrg(String strOrgName) {
		try {
			if ("layouta".equals(SwitchLayout.ui_C_GET_LAYOUT())) {
				GWCtrlWait.ViewWaitingByClassName(GTestIndicators.PageShowTime, "pull-right");
				WebElement classname = GParam.g_Dr.findElement(By.className("pull-right"));
				WebElement classElement = classname.findElement(By.cssSelector("div[id*='p-tool-org']"));
				//鼠标悬浮
				Actions action = new Actions(GParam.g_Dr);
				action.moveToElement(classElement).perform();
			}else {
				//打开修改层级窗口
				GWCtrlWait.Wait2BeClickableById(GTestIndicators.PageShowTime, GWCtrlWebElementId.CN_ID.get("打开机构层级"));
				GWCtrlDivClick.ById(GWCtrlWebElementId.CN_ID.get("打开机构层级"));
			}
				
			//查看机构列表
			GWCtrlWait.Wait2BeClickableById(GTestIndicators.PageShowTime, GWCtrlWebElementId.CN_ID.get("查看机构表"));
			WebElement div = GParam.g_Dr.findElement(By.id(GWCtrlWebElementId.CN_ID.get("查看机构表")));
			div.click();
			GLog.logRecordTime(8, "查看机构列表");
						
			//选中项目部;
			GWCtrlWait.ViewWaitingTextById(GTestIndicators.PageShowTime, "PTL.frame.NaviList", strOrgName);
			WebElement orgName = GWCtrlStaticFind.getWebElementByIdOrXpath(GParam.g_Dr, GWCtrlWebElementId.CN_ID.get("机构列表"), "", "span", "", "", strOrgName);
			orgName.click();
			
			GLog.logRecordTime(8, "选中[" + strOrgName + "]");
		} catch(Exception e) {
			GWCtrlException.SwtichTo(e, 1, 8, "组织结构选择失败", true);
		}
	}
}
