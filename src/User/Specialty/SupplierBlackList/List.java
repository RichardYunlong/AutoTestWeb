package User.Specialty.SupplierBlackList;

import AutoTest.GException;
import AutoTest.GLog;
import AutoTest.GTestCase;
import AutoTestWeb.GWCtrlBasic;
import AutoTestWeb.GWCtrlFrame;
import AutoTestWeb.GWCtrlGrid3;
import AutoTestWeb.GWCtrlLeftMenu;
import AutoTestWeb.GWCtrlList;
import AutoTestWeb.GWCtrlPage;
import AutoTestWeb.GWCtrlTime;
import AutoTestWeb.GWCtrlTopMenuBtn;
import AutoTestWeb.GWCtrlTopTab;
import AutoTestWeb.GWCtrlWebElementId;
import AutoTestWeb.GWCtrlWebElementIframe;
import User.Specialty.SupplierBlackListNew.Detail;
import io.qameta.allure.Step;

/**
 *  专业分包商黑名单-列表区
 */
public class List {

	/**
	 *  数据
	 */
	private Data pData = null;

	/**
	 *  新建
	 */
	@Step("新建")
	public void ui_G_NEW() {
		ui_D_INIT();
		ui_C_TREE_MODULE();
		ui_C_BTN_TOPMENU("新_建","");
		ui_C_TAB_TOP("关_闭");
	}
	
	/**
	 *  查看
	 *  
	 *  @param strBillCode 单据编号
	 */
	@Step("查看")
	public void ui_G_VIEW(String strBillCode) {
		ui_D_INIT();
		ui_C_TREE_MODULE();
		ui_C_BTN_TOPMENU("查_看", strBillCode);
		ui_C_TAB_TOP("关_闭");
	}
	
	
	/**
	 *  删除
	 *  
	 *  @param strBillCode 单据编号
	 */
	@Step("删除")
	public void ui_G_DELETE(String strBillCode) {
		ui_D_INIT();
		ui_C_TREE_MODULE();
		ui_C_BTN_TOPMENU("删除", strBillCode);
		ui_C_TAB_TOP("关_闭");
	}

	/**
	 *  初始化
	 */
	@Step("初始化")
	public void ui_D_INIT(){
		pData = new Data();
	}
	
	/**
	 *  选择模块
	 */
	@Step("选择模块")
	public void ui_C_TREE_MODULE(){
		GLog.logRecordTime(9, "[功能]----执行[选择功能模块]");
		try {
			GWCtrlLeftMenu.ui_C_CHOOSE_MODULE(pData.pageREQ.MODULE_WAIT_ID);
			GLog.logRecordTime(9, "[功能]----执行[选择功能模块]成功");
		}catch (Exception e){
			pData.bRES = false;
			GLog.logRecordTime(9, "[功能]----执行[选择功能模块]失败");
			if (AutoTest.GTestCase.dTSSTYLE == 1)
				AutoTest.GParam.gRes = GException.getExceptionAllinformation(e);
			e.printStackTrace();
		}
	}

	/**
	 *  顶层菜单
	 *  
	 *  @param menuName 按钮名称
	 *  @param strBillCode 单据编号
	 */
	@Step("操作顶层菜单")
	public void ui_C_BTN_TOPMENU(String menuName, String strBillCode){
		GLog.logRecordTime(9, "[功能]----执行[" + menuName + "]");
		try {
			switch(menuName){
				case "新_建":{
					GWCtrlTopMenuBtn.ui_C_CLICK_TOPMENUBTN_TAB_INDEX(1, "新_建", pData.pageREQ.MODULE_WAIT_ID);
					//填写单据
					Detail add = new Detail();
					add.ui_G_NEW();
					break;
				}
				case "删除":{
  				    GWCtrlFrame.ui_C_SWITCN_ELEMENT(GWCtrlWebElementIframe.getIframe(1));
                    //搜索并选中
                    GWCtrlList list = new GWCtrlList("id", GWCtrlWebElementId.CN_ID.get("单据列表"));
                    list.ui_C_SEARCH_CODE(strBillCode);
                    //获取订单状态
                    GWCtrlGrid3 billView = new GWCtrlGrid3("id", GWCtrlWebElementId.CN_ID.get("单据列表"));
                    billView.showWebElementTableMap();
                    billView.showWebElementTextTableMap();
                    billView.ui_C_GRID3_WEBELEMENT(2, 2).click();
                    GWCtrlFrame.ui_C_SWITCN_DEFAULT();
				    
                    GWCtrlPage.ui_C_CLICK_VERIFY_YES_INDEX(1, "取消黑名单", pData.pageREQ.MODULE_WAIT_ID);
                    GWCtrlPage.ui_C_CLICK_VERIFY_YES_INDEX(1, "取消提交", pData.pageREQ.MODULE_WAIT_ID);
                    GWCtrlTime.Pause(3);
                    GWCtrlPage.ui_C_CLICK_VERIFY_YES_INDEX(1, "黑名单删除按钮", pData.pageREQ.MODULE_WAIT_ID);
					break;
				}
				default:{
					break;
				}
			}

			pData.bRES = true;
			AutoTest.GParam.strTestResultCode = "0000";
			AutoTest.GParam.strTestResultMsg = "OK";
			GLog.logRecordTime(9, "[功能]----执行[" + menuName + "]成功");
			if(!strBillCode.equals("")) {
				GLog.logRecordTime(9, "[功能]----对目标[" + strBillCode + "]执行[" + menuName + "]成功");
			}
		}catch (Exception e){
			pData.bRES = false;
			AutoTest.GParam.strTestResultCode = "9999";
            AutoTest.GParam.strTestResultMsg = "ERROR";
			GLog.logRecordTime(9, "[功能]----执行[" + menuName + "]失败");
			if (AutoTest.GTestCase.dTSSTYLE == 1)
				AutoTest.GParam.gRes = GException.getExceptionAllinformation(e);
			e.printStackTrace();
		}
		GTestCase.setTestCaseRst(pData.bRES);
	}
	
	/**
	 *  顶层页签
	 *  
	 *  @param menuName 菜单名称
	 */
	@Step("操作顶层页签")
	public void ui_C_TAB_TOP(String menuName){
		GLog.logRecordTime(9, "[功能]----执行[" + menuName + "]");
		try {
			switch(menuName){
				case "关_闭":{
					GWCtrlTopTab.ui_C_CLOSE_TOPTAB(pData.pageREQ.MODULE_NAME);
					GWCtrlBasic.Refresh();
					break;
				}
				default:{
					break;
				}
			}

			pData.bRES = true;
			AutoTest.GParam.strTestResultCode = "0000";
            AutoTest.GParam.strTestResultMsg = "OK";
			GLog.logRecordTime(9, "[功能]----执行[" + menuName + "]成功");
		}catch (Exception e){
			pData.bRES = false;
			AutoTest.GParam.strTestResultCode = "9999";
            AutoTest.GParam.strTestResultMsg = "ERROR";
			GLog.logRecordTime(9, "[功能]----执行[" + menuName + "]失败");
			if (AutoTest.GTestCase.dTSSTYLE == 1)
				AutoTest.GParam.gRes = GException.getExceptionAllinformation(e);
			e.printStackTrace();
		}
		GTestCase.setTestCaseRst(pData.bRES);
			   
	}
}
