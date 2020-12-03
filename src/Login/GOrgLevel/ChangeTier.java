package Login.GOrgLevel;

import AutoTest.GLog;
import AutoTest.GTestCase;
import AutoTestWeb.GTestIndicators;
import AutoTestWeb.GWCtrlChooseOrg;
import AutoTestWeb.GWCtrlWait;
import GUserLayout.SwitchLayout;
import io.qameta.allure.Step;

/**
 *  用户修改机构层级业务逻辑
 */
public class ChangeTier {
   
	
	/**
	 *  数据
	 */
	private Data pData = null;
	
	/**
	 *  修改层级
	 */
	@Step("修改层级")
	public void ui_G_CHANGE_ORG(String Tiername){
		pData = new Data();	
		System.out.println("[功能]----修改层级");
		try {
		  ui_JUDGE_THEME(Tiername);
          pData.bOrgStatus = true;
          System.out.println("[功能]----修改层级成功");
      }catch (Exception e){
          pData.bOrgStatus = false;
          System.out.println("[功能]----修改层级失败");
          e.printStackTrace();
      }
		
		GTestCase.setTestCaseRst(pData.bOrgStatus);
	}
	
	/**
	 * 判断当前层级，来等待对应的标识元素
	 */
	@Step("判断当前层级")
	public void ui_JUDGE_THEME(String Tiername) {
	  switch (SwitchLayout.ui_C_GET_LAYOUT()) { 
	    case "layoute":
          //等待默认板式的左侧信息加载完成
          GWCtrlWait.Wait2BeClickableById(GTestIndicators.PageShowTime, "orgNameGroup");
          GLog.logRecordTime(9, "当前处于默认版式要切换到"+Tiername);
          GWCtrlChooseOrg.SelectOrg(Tiername);
          break;
        case "layoutb":
          //等待OutLook板式的左侧信息加载完成
          GWCtrlWait.Wait2BeClickableById(GTestIndicators.PageShowTime, "orgNameGroup");
          GLog.logRecordTime(9, "当前处于OutLook版式要切换到"+Tiername);
          GWCtrlChooseOrg.SelectOrg(Tiername);
          break;
        case "layoutc":
          //等待菜单板式的组织信息加载完成
          GWCtrlWait.Wait2BeClickableById(GTestIndicators.PageShowTime, "orgNameGroup");
          GLog.logRecordTime(9, "当前处于菜单版式要切换到"+Tiername);
          GWCtrlChooseOrg.SelectOrg(Tiername);
          break;
        case "layouta":
          //等待简洁板式的组织信息加载完成
          GWCtrlWait.ViewWaitingByClassName(GTestIndicators.PageShowTime, "pull-right");
          GLog.logRecordTime(9, "当前处于简洁版式要切换到"+Tiername);
          GWCtrlChooseOrg.SelectOrg(Tiername);
      }
      
    }
}
