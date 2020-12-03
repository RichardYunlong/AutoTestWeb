package User.Material.LeaseSettlement;

import AutoTest.GLog;
import AutoTest.GTestCase;
import AutoTestWeb.GWCtrlBasic;
import AutoTestWeb.GWCtrlException;
import AutoTestWeb.GWCtrlFrame;
import AutoTestWeb.GWCtrlGrid3;
import AutoTestWeb.GWCtrlLeftMenu;
import AutoTestWeb.GWCtrlList;
import AutoTestWeb.GWCtrlPage;
import AutoTestWeb.GWCtrlTopMenuBtn;
import AutoTestWeb.GWCtrlTopTab;
import AutoTestWeb.GWCtrlWebElementId;
import AutoTestWeb.GWCtrlWebElementIframe;
import User.Material.LeaseSettlementNew.Detail;
import io.qameta.allure.Step;

/**
 *  周转材料租赁结算单-列表区
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
	 *  查看并删除
	 *  
	 *  @param strBillCode 单据编号
	 */
	@Step("查看并删除")
	public void ui_G_VIEW_AND_DELETE(String strBillCode) {
		ui_D_INIT();
		ui_C_TREE_MODULE();
		ui_C_BTN_TOPMENU("查_看", strBillCode);
		ui_C_BTN_TOPMENU("删除", strBillCode);
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
		ui_C_BTN_TOPMENU("删_除", strBillCode);
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
			GWCtrlException.SwtichTo(e, 1, 9, "[功能]----执行[选择功能模块]失败", true);
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
					//删除单据-detail区
					Detail detail = new Detail();
					detail.ui_G_DELETE(strBillCode);
					break;
				}
				case "删_除":{
					GWCtrlFrame.ui_C_SWITCN_ELEMENT(GWCtrlWebElementIframe.getIframe(1));
					//搜索并选中
					GWCtrlList list = new GWCtrlList("id", GWCtrlWebElementId.CN_ID.get("单据列表"));
					list.ui_C_SEARCH_CODE(strBillCode);
					//获取订单状态
					GWCtrlGrid3 billView = new GWCtrlGrid3("id", GWCtrlWebElementId.CN_ID.get("单据列表"));
					billView.showWebElementTableMap();
					billView.showWebElementTextTableMap();
					String billState = billView.ui_C_GRID3_VALUE(2, 1).replaceAll(",", "");
					billView.ui_C_GRID3_WEBELEMENT(2, 1).click();
					GWCtrlFrame.ui_C_SWITCN_DEFAULT();
					
					if(billState.equals("已提交")){
						//取消提交
						GWCtrlPage.ui_C_CLICK_VERIFY_YES_INDEX(1, "提交", pData.pageREQ.MODULE_WAIT_ID);
					}			
					//删除
					GWCtrlPage.ui_C_CLICK_VERIFY_YES_INDEX(1, "删_除", pData.pageREQ.MODULE_WAIT_ID);
					GWCtrlFrame.ui_C_SWITCN_DEFAULT();
					GWCtrlPage.ui_D_IFRAME_INDEX(1, "id", pData.pageREQ.MODULE_WAIT_ID);
					break;
				}
				case "查_看":{
					GWCtrlFrame.ui_C_SWITCN_ELEMENT(GWCtrlWebElementIframe.getIframe(1));
					//搜索并选中
					GWCtrlList list = new GWCtrlList("id", GWCtrlWebElementId.CN_ID.get("单据列表"));
					list.ui_C_SELECT_BILLVIEW(strBillCode);
					GWCtrlFrame.ui_C_SWITCN_DEFAULT();
					//点击查看
					GWCtrlTopMenuBtn.ui_C_CLICK_TOPMENUBTN_TAB_INDEX(1, "查_看", pData.pageREQ.MODULE_WAIT_ID);
					break;
				}
				default:{
					break;
				}
			}

			pData.bRES = true;
			GLog.logRecordTime(9, "[功能]----执行[" + menuName + "]成功");
			if(!strBillCode.equals("")) {
				GLog.logRecordTime(9, "[功能]----对目标[" + strBillCode + "]执行[" + menuName + "]成功");
			}
		}catch (Exception e){
			pData.bRES = false;
			GWCtrlException.SwtichTo(e, 1, 9, "[功能]----执行[" + menuName + "]失败", true);
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
			GLog.logRecordTime(9, "[功能]----执行[" + menuName + "]成功");
		}catch (Exception e){
			pData.bRES = false;
			GWCtrlException.SwtichTo(e, 1, 9, "[功能]----执行[" + menuName + "]失败", true);
		}
		GTestCase.setTestCaseRst(pData.bRES);	   
	}
}
