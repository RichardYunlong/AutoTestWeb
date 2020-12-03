package GUserLayout;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import AutoTest.GLog;
import AutoTest.GTestCase;
import AutoTestWeb.GParam;
import AutoTestWeb.GTestIndicators;
import AutoTestWeb.GWCtrlBasic;
import AutoTestWeb.GWCtrlDivClick;
import AutoTestWeb.GWCtrlWait;
import Login.GTheme.Data;
import io.qameta.allure.Step;


/**
 *  版式处理
 *  
 *  @author 张超  2020.10.21 17:45:00 
 */
public class SwitchLayout {
  
	/**
	 *  按照当前用户信息改变版式
	 *  
	 *  @param layoutname 版式名称
	 */
	@Step("切换版式")
	public void ui_C_SWITCH_LAYOUT(String layoutname){
		
	    Data da = new Data();
	    GLog.logRecordTime(9, "[功能]----用户退出登录");
		try {
			//查询当前所处层级
			String myLayout = ui_C_GET_LAYOUT();
			switch (myLayout) {
			case "layoute":
				//等待默认板式的左侧信息加载完成
				GWCtrlWait.Wait2BeClickableById(GTestIndicators.PageShowTime, "l_menu_list");
				GLog.logRecordTime(9, "当前处于默认版式要切换到"+layoutname);
				ui_C_CHANGE_LAYOUT(layoutname);
				break;
			case "layoutb":
				//等待OutLook板式的左侧信息加载完成
				GWCtrlWait.Wait2BeClickableById(GTestIndicators.PageShowTime, "leftDiv");
				GLog.logRecordTime(9, "当前处于OutLook版式要切换到"+layoutname);
				ui_C_CHANGE_LAYOUT(layoutname);
				break;
			case "layoutc":
				//等待菜单板式的左侧信息加载完成
				GWCtrlWait.Wait2BeClickableById(GTestIndicators.PageShowTime, "menuList");
				GLog.logRecordTime(9, "当前处于菜单版式要切换到"+layoutname);
				ui_C_CHANGE_LAYOUT(layoutname);
				break;
			case "layouta":
				String ALayout = da.mapTheme.get(layoutname);
				if (!"layoutA".equals(da.mapTheme.get(ALayout))) {
					//等待简洁板式的左侧信息加载完成
				    
					GLog.logRecordTime(9, "当前处于简洁版式要切换到"+layoutname);
					GWCtrlWait.ViewWaitingByClassName(GTestIndicators.PageShowTime, "pull-right");
					WebElement classname = GParam.g_Dr.findElement(By.className("pull-right"));
					WebElement classElement = classname.findElement(By.cssSelector("div[id*='p-tool-layout']"));
					GWCtrlWait.Wait2BeClickableByWebElement(GTestIndicators.PageShowTime, classElement);
					//鼠标悬浮
					Actions action = new Actions(GParam.g_Dr);
		            action.moveToElement(classElement).perform();
					String liStr = "li[action="+"\""+ALayout+"\""+"]";
					GWCtrlWait.Wait2BeClickableByCssSelector(GTestIndicators.PageShowTime, liStr);
					WebElement liname = classElement.findElement(By.cssSelector(liStr));	
					GLog.logRecordTime(9, liname+"----------------");
					liname.click();
				}else {
					GLog.logRecordTime(9, "简洁模式禁止切换简洁！");
				}
				break;
			}
			da.bLayoutStatus = true;
			GLog.logRecordTime(9, "[功能]----用户主题切换成功");	
		}catch (Exception e){
			da.bLayoutStatus = false;
			GLog.logRecordTime(9, "[功能]----用户主题切换失败");	
			e.printStackTrace();
		}
		
		GTestCase.setTestCaseRst(da.bLayoutStatus);//记录用例执行结果标记
	}
	
	/**
	 *  获得当前用户版式
	 *  
	 *  @param layoutname 版式名称
	 */
	@Step("获得当前版式")
	public static String ui_C_GET_LAYOUT() {
		String url = GWCtrlBasic.Geturl();
		int sum = url.indexOf("Frame/");
        String myLayout = url.substring(sum+6,sum+13);
		String newLayoutNameString = myLayout.toLowerCase();
        GLog.logRecordTime(9, newLayoutNameString+"----------------------");
        return newLayoutNameString;
	}
	
	/**
	 *  确认切换到的目标版式
	 *  
	 *  @param layoutname 版式名称
	 */
	@Step("确认切换版式")
	public void ui_C_CHANGE_LAYOUT(String layoutname) {
		
	    Data da = new Data();
		String nextLayout = da.mapTheme.get(layoutname);
		GLog.logRecordTime(9, "当前要切换到" + layoutname+nextLayout);
		//点击样式按钮
		GWCtrlWait.Wait2BeClickableById(GTestIndicators.PageShowTime, da.mapTheme.get("一般样式按钮"));
		GWCtrlDivClick.ById(da.mapTheme.get("一般样式按钮"));
		//切换到要跳转的样式
//		GWCtrlWait.ViewWaitingById(GTestIndicators.PageShowTime,nextLayout);
		GWCtrlWait.Wait2BeClickableById(GTestIndicators.PageShowTime,nextLayout);
		GWCtrlDivClick.ById(nextLayout);
		//点击确定切换
		GWCtrlWait.ViewWaitingById(GTestIndicators.PageShowTime,"themeDropOKBtn");
		GWCtrlDivClick.ById("themeDropOKBtn");
	}

}
