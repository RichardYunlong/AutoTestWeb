package Login.GTheme;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import AutoTestWeb.GParam;
import AutoTestWeb.GTestIndicators;
import AutoTestWeb.GWCtrlBasic;
import AutoTestWeb.GWCtrlDivClick;
import AutoTestWeb.GWCtrlWait;


/**
 *     版式处理
 * @author 张超  2020.10.21 17:45:00 
 */
public class SwitchLayoutProcess {
  
	/**
	 *  按照当前用户信息改变板式
	 */
	public  void userSwitchLayout(String layoutname){
	  
	    Data da = new Data();
		//查询当前所处层级
		String myLayout = getLayout();
		switch (myLayout) {
		case "layoute":
			//等待默认板式的左侧信息加载完成
			GWCtrlWait.Wait2BeClickableById(GTestIndicators.PageShowTime, "l_menu_list");
			System.out.println("当前处于默认版式要切换到"+layoutname);
			changeLayout(layoutname);
			break;
		case "layoutb":
			//等待OutLook板式的左侧信息加载完成
			GWCtrlWait.Wait2BeClickableById(GTestIndicators.PageShowTime, "leftDiv");
			System.out.println("当前处于OutLook版式要切换到"+layoutname);
			changeLayout(layoutname);
			break;
		case "layoutc":
			//等待菜单板式的左侧信息加载完成
			GWCtrlWait.Wait2BeClickableById(GTestIndicators.PageShowTime, "menuList");
			System.out.println("当前处于菜单版式要切换到"+layoutname);
			changeLayout(layoutname);
			break;
		case "layouta":
			String ALayout = da.mapTheme.get(layoutname);
			if (!"layoutA".equals(da.mapTheme.get(ALayout))) {
				System.out.println("当前处于简洁版式要切换到"+layoutname);
				GWCtrlWait.ViewWaitingByClassName(GTestIndicators.PageShowTime, "pull-right");
				WebElement classname = GParam.g_Dr.findElement(By.className("pull-right"));
				WebElement classElement = classname.findElement(By.cssSelector("div[id*='p-tool-layout']"));
				//鼠标悬浮
				Actions action = new Actions(GParam.g_Dr);
	            action.moveToElement(classElement).perform();
				String liStr = "li[action="+"\""+ALayout+"\""+"]";
				GWCtrlWait.Wait2BeClickableByCssSelector(GTestIndicators.PageShowTime, liStr);
				WebElement liname = classElement.findElement(By.cssSelector(liStr));	
				liname.click();
			}else {
				System.out.println("简洁模式禁止切换简洁！");
			}
			break;
		}

	}
	public static String getLayout() {
		String url = GWCtrlBasic.Geturl();
		int sum = url.indexOf("Frame/");
        String myLayout = url.substring(sum+6,sum+13);
		String newLayoutNameString = myLayout.toLowerCase();
        return newLayoutNameString;
	}
	public  void changeLayout(String layoutname) {
	    Data da = new Data();
		String nextLayout = da.mapTheme.get(layoutname);
		System.out.println("当前要切换到"+layoutname+nextLayout);
		//点击样式按钮
		GWCtrlWait.ViewWaitingById(GTestIndicators.PageShowTime, da.mapTheme.get("一般样式按钮"));
		GWCtrlDivClick.ById(da.mapTheme.get("一般样式按钮"));
		//切换到要跳转的样式
		GWCtrlWait.ViewWaitingById(GTestIndicators.PageShowTime,nextLayout);
		GWCtrlDivClick.ById(nextLayout);
		//点击确定切换
		GWCtrlWait.ViewWaitingById(GTestIndicators.PageShowTime,"themeDropOKBtn");
		GWCtrlDivClick.ById("themeDropOKBtn");

	}

}
