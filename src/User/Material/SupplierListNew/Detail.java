package User.Material.SupplierListNew;

import AutoTest.GException;
import AutoTest.GLog;
import AutoTest.GTestCase;
import AutoTest.GTime;
import AutoTestScene.GScene;
import AutoTestWeb.GParam;
import AutoTestWeb.GTestIndicators;
import AutoTestWeb.GWCtrlFrame;
import AutoTestWeb.GWCtrlInputFill;
import AutoTestWeb.GWCtrlLog;
import AutoTestWeb.GWCtrlPage;
import AutoTestWeb.GWCtrlTopMenuBtn;
import AutoTestWeb.GWCtrlTopTab;
import AutoTestWeb.GWCtrlUpTab;
import AutoTestWeb.GWCtrlWait;
import AutoTestWeb.GWCtrlWebElementId;
import AutoTestWeb.GWCtrlWebElementIframe;
import io.qameta.allure.Step;

/**
 *  物资供应商名录-详情区
 */
public class Detail {
	
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
		ui_C_BASICINFO();
		ui_C_SP_DETAILS();
		ui_C_TAB_TOP("关闭");
	}
	
	/**
	 *  删除
	 *  
	 *  @param strBillCode 单据编号
	 */
	@Step("删除")
	public void ui_G_DELETE(String strBillCode) {
		ui_D_INIT();
		ui_C_BTN_TOPMENU("删除", strBillCode);
	}

	/**
	 *  初始化
	 */
	@Step("初始化")
	private void ui_D_INIT(){
		pData = new Data();
		GWCtrlPage.ui_D_IFRAME_INDEX(2, "id", GWCtrlWebElementId.CN_ID.get("单据编号"));
	}
	
	/**
	 *  基本信息
	 */
	@Step("基本信息")
	private void ui_C_BASICINFO() {
		//设置等待
		pData.pageREQ.MODULE_WAIT_ID = GWCtrlWebElementId.CN_ID.get("单据编号");
		ui_C_CLICK_TAB("基本信息");
		ui_C_INPUT_BASICINFO();
		GWCtrlLog.TakesScreenshot("_1.png");
		ui_C_BTN_TOPMENU("保存", "");
		ui_C_PARAMS();
	}

	/**
	 *  填写基本信息
	 */
	@Step("填写基本信息")
	private void ui_C_INPUT_BASICINFO() {
		GLog.logRecordTime(9, "[功能]----填写基本信息");
		try {
			GWCtrlFrame.ui_C_SWITCN_ELEMENT(GWCtrlWebElementIframe.getIframe(2));
			
			//填入【供应商名称】
			String conName = "GAT物资供应商" + GTime.getCurrentTime(GTime.FORMAT_14);
			GWCtrlInputFill.ById(pData.pageREQ.mapContentId.get("供应商名称"), conName);
			pData.pageREQ.mapDynamicData.replace("物资供应商名录-供应商名称", conName);
			
			//填入【成立日期】
			GWCtrlInputFill.ById(pData.pageREQ.mapContentId.get("成立日期"), "1988-08-05");
			
			GWCtrlFrame.ui_C_SWITCN_DEFAULT();
			
			pData.bRES = true;
			pData.strStatus = "编辑中";
			GLog.logRecordTime(9, "[功能]----基本信息填写成功");
		}catch (Exception e){
			pData.bRES = false;
			GLog.logRecordTime(9, "[功能]----基本信息填写失败");
			if (AutoTest.GTestCase.dTSSTYLE == 1)
				AutoTest.GParam.gRes = GException.getExceptionAllinformation(e);
			e.printStackTrace();
		}
		GWCtrlPage.ui_D_IFRAME_INDEX(2, "id", pData.pageREQ.MODULE_WAIT_ID);
	}
	
	/**
	 *  评价信息
	 */
	@Step("评价信息")
	public void ui_C_SP_DETAILS() {
		//设置等待
		pData.pageREQ.MODULE_WAIT_ID = GWCtrlWebElementId.CN_ID.get("评价信息");
		ui_C_CLICK_TAB("评价信息");
		GLog.logRecordTime(9, "暂不填写评价信息");
		GWCtrlLog.TakesScreenshot("_2.png");
		ui_C_BTN_TOPMENU("保存", "");
	}
	
	/**
	 *  上部页签切换
	 *  
	 *  @param tabName 页签名称
	 */
	@Step("上部页签切换")
	private void ui_C_CLICK_TAB(String tabName){
		GLog.logRecordTime(9, "[功能]----切换上部页签至" + tabName);
		try {
			GWCtrlUpTab.ui_C_CLICK_TAB(GParam.g_Dr, 2, pData.pageREQ.mapTopTabId.get(tabName));
			
			pData.bRES = true;
			pData.strStatus = "编辑中";
			GLog.logRecordTime(9, "[功能]----切换上部页签至" + tabName + "成功");
		}catch (Exception e){
			pData.bRES = false;
			GLog.logRecordTime(9, "[功能]----切换上部页签至" + tabName + "失败");
			if (AutoTest.GTestCase.dTSSTYLE == 1)
				AutoTest.GParam.gRes = GException.getExceptionAllinformation(e);
			e.printStackTrace();
		}
		GWCtrlPage.ui_D_IFRAME_INDEX(2, "id", pData.pageREQ.MODULE_WAIT_ID);
	}
	
	/**
	 *  参数提取
	 */
	@Step("参数提取")
	private void ui_C_PARAMS() {
		GLog.logRecordTime(9, "[提取公共参数]");
		try {
			//提取公共参数-单据编号-测试类内部使用
			pData.pageREQ.mapDynamicData.replace("物资供应商名录-供应商编码", GWCtrlPage.ui_C_GET_CODE(pData.pageREQ.MODULE_NAME));
			//提取公共参数-单据编号-全局使用
			GScene.DYNAMIC_DATA.replace("物资供应商名录-供应商编码", pData.pageREQ.mapDynamicData.get("物资供应商名录-供应商编码"));
			GScene.DYNAMIC_DATA.replace("物资供应商名录-供应商名称", pData.pageREQ.mapDynamicData.get("物资供应商名录-供应商名称"));
        	
        	GLog.logRecordTime(9, "[提取公共参数]----成功----自动生成单据编号：" + pData.pageREQ.mapDynamicData.get("物资供应商名录-供应商编码"));
        	
		}catch (Exception e){
			GLog.logRecordTime(9, "[提取公共参数]----失败");
			if (AutoTest.GTestCase.dTSSTYLE == 1)
				AutoTest.GParam.gRes = GException.getExceptionAllinformation(e);
			e.printStackTrace();
		}
	}
	
	/**
	 *  顶层菜单
	 *  
	 *  @param menuName 按钮名称
	 *  @param strBillCode 目标关键字 可以为空
	 */
	@Step("操作顶层菜单")
	private void ui_C_BTN_TOPMENU(String menuName, String strBillCode) {
		GLog.logRecordTime(9, "[功能]----" + menuName);
		try {
			switch(menuName){
				case "编辑":{
					GWCtrlTopMenuBtn.ui_C_CLICK_TOPMENUBTN_TAB_INDEX(2, menuName, pData.pageREQ.MODULE_WAIT_ID);
					pData.strStatus = "编辑中";
					break;
				}
				case "删除":{
					//设置等待 默认与基本信息页签等待条件一致
					pData.pageREQ.MODULE_WAIT_ID = GWCtrlWebElementId.CN_ID.get("单据编号");
					if(GWCtrlTopMenuBtn.ui_C_GET_TOPMENUBTN_TAB2_STATUS(menuName, GTestIndicators.PageShowTime, pData.pageREQ.MODULE_WAIT_ID)) {
						GWCtrlPage.ui_C_CLICK_VERIFY_YES_INDEX(2, "提交", pData.pageREQ.MODULE_WAIT_ID);
						if(GWCtrlTopMenuBtn.ui_C_GET_TOPMENUBTN_TAB2_STATUS(menuName, GTestIndicators.PageShowTime, pData.pageREQ.MODULE_WAIT_ID)) {
							pData.strStatus = "编辑中";
						}
					}
					GWCtrlPage.ui_C_CLICK_VERIFY_YES_INDEX(2, "删除", pData.pageREQ.MODULE_WAIT_ID);
					pData.strStatus = "已删除";
					break;
				}
				case "保存":{
					GWCtrlTopMenuBtn.ui_C_CLICK_TOPMENUBTN_TAB_INDEX(2, menuName, pData.pageREQ.MODULE_WAIT_ID);
					if(pData.pageREQ.MODULE_WAIT_ID.equals(GWCtrlWebElementId.CN_ID.get("单据编号"))) {
						boolean bSaved = false;
						while(!bSaved) {
							String strCode = GWCtrlPage.ui_C_GET_CODE(pData.pageREQ.MODULE_NAME);
							if(null != strCode && !strCode.equals("") && strCode.length() >= 20) {
								bSaved = true;
							}
						}
					}else {
						GWCtrlFrame.ui_C_SWITCN_ELEMENT(GWCtrlWebElementIframe.getIframe(2));
						GWCtrlWait.Wait2BeClickableById(GTestIndicators.PageShowTime, pData.pageREQ.MODULE_WAIT_ID);
						GWCtrlFrame.ui_C_SWITCN_DEFAULT();
					}
					if(GWCtrlTopMenuBtn.ui_C_GET_TOPMENUBTN_TAB2_STATUS(menuName, GTestIndicators.PageShowTime, pData.pageREQ.MODULE_WAIT_ID)) {
						pData.strStatus = "已保存";
					}
					break;
				}
				case "提交":{
					GWCtrlPage.ui_C_CLICK_VERIFY_YES_INDEX(2, menuName, pData.pageREQ.MODULE_WAIT_ID);
					if(GWCtrlTopMenuBtn.ui_C_GET_TOPMENUBTN_TAB2_STATUS(menuName, GTestIndicators.PageShowTime, pData.pageREQ.MODULE_WAIT_ID)) {
						pData.strStatus = "已提交";
					}
					break;
				}
				case "取消提交":{
					if(pData.strStatus.equals("已提交")) {
						GWCtrlPage.ui_C_CLICK_VERIFY_YES_INDEX(2, "提交", pData.pageREQ.MODULE_WAIT_ID);
						if(GWCtrlTopMenuBtn.ui_C_GET_TOPMENUBTN_TAB2_STATUS(menuName, GTestIndicators.PageShowTime, pData.pageREQ.MODULE_WAIT_ID)) {
							pData.strStatus = "编辑中";
						}
					}else{
						pData.strStatus = "已提交";
						throw new Exception("不允许取消提交");
					}
					break;
				}
				default:{
					break;
				}
			}

			pData.bRES = true;
			GLog.logRecordTime(9, "[功能]----" + menuName + "----成功");
			if(!strBillCode.equals("")) {
				GLog.logRecordTime(9, "[功能]----对目标[" + strBillCode + "]执行[" + menuName + "]成功");
			}
		}catch (Exception e){
			pData.bRES = false;
			GLog.logRecordTime(9, "[功能]----" + menuName + "----失败");
			if (AutoTest.GTestCase.dTSSTYLE == 1)
				AutoTest.GParam.gRes = GException.getExceptionAllinformation(e);
			e.printStackTrace();
		}
	}
	
	/**
	 *  顶层页签
	 *  
	 *  @param menuName 操作名称
	 */
	@Step("操作顶层页签")
	public void ui_C_TAB_TOP(String menuName){
		GLog.logRecordTime(9, "[功能]----执行[" + menuName + "]");
		try {
			switch(menuName){
				case "关_闭":{
					GWCtrlTopTab.ui_C_CLOSE_TOPTAB(pData.pageREQ.MODULE_NAME_NEW + pData.pageREQ.mapDynamicData.get("物资供应商名录-供应商编码"));
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
			GLog.logRecordTime(9, "[功能]----执行[" + menuName + "]失败");
			if (AutoTest.GTestCase.dTSSTYLE == 1)
				AutoTest.GParam.gRes = GException.getExceptionAllinformation(e);
			e.printStackTrace();
		}
		GTestCase.setTestCaseRst(pData.bRES);
	}
}
