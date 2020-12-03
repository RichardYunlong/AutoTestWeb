package User.Material.FinalSettlementNew;


import AutoTest.GLog;
import AutoTest.GTestCase;
import AutoTestScene.GScene;
import AutoTestWeb.GParam;
import AutoTestWeb.GTestIndicators;
import AutoTestWeb.GWCtrlException;
import AutoTestWeb.GWCtrlFrame;
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
 *  材料最终结算单-详情区
 *  @author 赵君 2020.11.27 19:13:39
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
		ui_C_INPUT_NEW();
		ui_C_BASICINFO();
		ui_C_BTN_TOPMENU("提交", "");
		ui_C_BTN_TOPMENU("取消提交", "");
		ui_C_BTN_TOPMENU("修改", "");
		ui_C_BTN_TOPMENU("提交", "");
		ui_C_TAB_TOP("关闭");
	}
	
	/**
	 *  新建-不提交
	 */
	@Step("新建-不提交")
	public void ui_G_SAVE() {
		ui_D_INIT();
		ui_C_BASICINFO();
		ui_C_TAB_TOP("关闭");
	}
	
	/**
	 *  删除
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
	}
	
	/**
	 *  基本信息
	 */
	@Step("基本信息")
	private void ui_C_BASICINFO() {
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
	@Step("填写新增窗体")
	private void ui_C_INPUT_NEW() {
		GLog.logRecordTime(9, "[功能]----填写新增弹窗");
		try {
			//切换至中心iframe
			GWCtrlFrame.ui_C_SWITCN_ELEMENT(GWCtrlWebElementIframe.getIframe(1));
			
//			//填入【供应商】
//        	GWCtrlPage.ui_C_SELECT_INPUT_BTN(pData.pageREQ.mapContentId.get("供应商"), "");
//        	//游标切换至二级窗体
//			GWCtrlWindow.windowHandles();
//			//搜索并选中
//			GWCtrlPage.ui_C_WAIT_CLICK(pData.pageREQ.mapTopTabId.get("外部单位"), "");
//			GWCtrlGrid3 sourceGrid3 = new GWCtrlGrid3("id", GWCtrlWebElementId.CN_ID.get("数据源"));
//			sourceGrid3.ui_C_SELECT_SOURCE(pData.pageREQ.mapDynamicData.get("材料最终结算单-供应商"));
//			pData.gvGrid3 = null;
//			GWCtrlPage.ui_C_WAIT_CLICK(GWCtrlWebElementId.CN_ID.get("二级窗体 确定"), "");
//        	//游标切换回主窗体
//			GWCtrlWindow.windowHandlePre();
			
//			//切换至中心iframe
//			GWCtrlFrame.ui_C_SWITCN_ELEMENT(GWCtrlWebElementIframe.getIframe(1));
//			//点击确定
//			WebElement divRoot = null;
//			divRoot = GParam.g_Dr.findElement(By.id("wvXZ"));
//			if(divRoot != null) {
//				List<WebElement> buttons = divRoot.findElements(By.tagName("button"));
//				for(WebElement button:buttons){
//					if(button.getText().equals("确定")) {
//						button.click();
//						break;
//					}
//				}
//			}
			
			GWCtrlFrame.ui_C_SWITCN_DEFAULT();
				
			pData.bRES = true;
			pData.strStatus = "编辑中";
			GLog.logRecordTime(9, "[功能]----新增弹窗填写成功");
		}catch (Exception e){
			pData.bRES = false;
			GWCtrlException.SwtichTo(e, 1, 9, "[功能]----新增弹窗填写失败", true);
		}
		GWCtrlLog.TakesScreenshot("_1.png");
		GTestCase.setTestCaseRst(pData.bRES);
	}
	
	/**
	 *  填写基本信息
	 */
	@Step("填写基本信息")
	private void ui_C_INPUT_BASICINFO() {
		GLog.logRecordTime(9, "[功能]----填写基本信息");
		try {
			//切换至中心iframe
			GWCtrlFrame.ui_C_SWITCN_ELEMENT(GWCtrlWebElementIframe.getIframe(2));
			
			GLog.logRecordTime(9, "基本信息暂时无需自行填写");
			
			GWCtrlFrame.ui_C_SWITCN_DEFAULT();
				
			pData.bRES = true;
			pData.strStatus = "编辑中";
			GLog.logRecordTime(9, "[功能]----基本信息填写成功");
		}catch (Exception e){
			pData.bRES = false;
			GWCtrlException.SwtichTo(e, 1, 9, "[功能]----基本信息填写失败", true);
		}
		GWCtrlPage.ui_D_IFRAME_INDEX(2, "id", pData.pageREQ.MODULE_WAIT_ID);
		GWCtrlLog.TakesScreenshot("_1.png");
		GTestCase.setTestCaseRst(pData.bRES);
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
			//设置等待
			GWCtrlUpTab.ui_C_CLICK_TAB(GParam.g_Dr, 2, pData.pageREQ.mapTopTabId.get(tabName));
			
			pData.bRES = true;
			pData.strStatus = "编辑中";
			GLog.logRecordTime(9, "[功能]----切换上部页签至" + tabName + "成功");
		}catch (Exception e){
			pData.bRES = false;
			GWCtrlException.SwtichTo(e, 1, 9, "[功能]----切换上部页签至" + tabName + "失败", true);
		}
		GWCtrlPage.ui_D_IFRAME_INDEX(2, "id", pData.pageREQ.MODULE_WAIT_ID);
		GTestCase.setTestCaseRst(pData.bRES);
	}
	
	/**
	 *  参数提取
	 */
	@Step("参数提取")
	private void ui_C_PARAMS() {
		GLog.logRecordTime(9, "[提取公共参数]");
		try {
			//提取公共参数-单据编号
			pData.pageREQ.mapDynamicData.replace("材料最终结算单-单据编号", GWCtrlPage.ui_C_GET_CODE(pData.pageREQ.MODULE_NAME));
			//提取公共参数-单据编号-全局使用
			GScene.DYNAMIC_DATA.replace("材料最终结算单-单据编号", pData.pageREQ.mapDynamicData.get("材料最终结算单-单据编号"));
        	
        	GLog.logRecordTime(9, "[提取公共参数]----成功----自动生成单据编号：" + pData.pageREQ.mapDynamicData.get("材料最终结算单-单据编号"));
		}catch (Exception e){
			GWCtrlException.SwtichTo(e, 1, 9, "[提取公共参数]----失败", true);
		}
	}
	
	
	/**
	 *  操作顶层菜单
	 *  
	 *  @param menuName 按钮名称
	 *  @param strBillCode 单据编号
	 */
	@Step("操作顶层菜单")
	private void ui_C_BTN_TOPMENU(String btnName, String menuCode) {
		GLog.logRecordTime(9, "[功能]----" + btnName);
		try {
			switch(btnName){
				case "编辑":{
					GWCtrlTopMenuBtn.ui_C_CLICK_TOPMENUBTN_TAB_INDEX(2, btnName, pData.pageREQ.MODULE_WAIT_ID);
					pData.strStatus = "编辑中";
					break;
				}
				case "删除":{
					//设置等待 默认与基本信息页签等待条件一致
					pData.pageREQ.MODULE_WAIT_ID = GWCtrlWebElementId.CN_ID.get("单据编号");
					if(GWCtrlTopMenuBtn.ui_C_GET_TOPMENUBTN_TAB2_STATUS(btnName, GTestIndicators.PageShowTime, pData.pageREQ.MODULE_WAIT_ID)) {
						GWCtrlPage.ui_C_CLICK_VERIFY_YES_INDEX(2, "提交", pData.pageREQ.MODULE_WAIT_ID);
						if(GWCtrlTopMenuBtn.ui_C_GET_TOPMENUBTN_TAB2_STATUS(btnName, GTestIndicators.PageShowTime, pData.pageREQ.MODULE_WAIT_ID)) {
							pData.strStatus = "编辑中";
						}
					}
					GWCtrlPage.ui_C_CLICK_VERIFY_YES_INDEX(2, "删除", pData.pageREQ.MODULE_WAIT_ID);
					pData.strStatus = "已删除";
					break;
				}
				case "保存":{
					GWCtrlTopMenuBtn.ui_C_CLICK_TOPMENUBTN_TAB_INDEX(2, btnName, pData.pageREQ.MODULE_WAIT_ID);
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
					if(GWCtrlTopMenuBtn.ui_C_GET_TOPMENUBTN_TAB2_STATUS(btnName, GTestIndicators.PageShowTime, pData.pageREQ.MODULE_WAIT_ID)) {
						pData.strStatus = "已保存";
					}
					break;
				}
				case "提交":{
					GWCtrlPage.ui_C_CLICK_VERIFY_YES_INDEX(2, btnName, pData.pageREQ.MODULE_WAIT_ID);
					if(GWCtrlTopMenuBtn.ui_C_GET_TOPMENUBTN_TAB2_STATUS(btnName, GTestIndicators.PageShowTime, pData.pageREQ.MODULE_WAIT_ID)) {
						pData.strStatus = "已提交";
					}
					break;
				}
				case "取消提交":{
					if(pData.strStatus.equals("已提交")) {
						GWCtrlPage.ui_C_CLICK_VERIFY_YES_INDEX(2, "提交", pData.pageREQ.MODULE_WAIT_ID);
						if(GWCtrlTopMenuBtn.ui_C_GET_TOPMENUBTN_TAB2_STATUS(btnName, GTestIndicators.PageShowTime, pData.pageREQ.MODULE_WAIT_ID)) {
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
			GLog.logRecordTime(9, "[功能]----" + btnName + "----成功");
			if(!menuCode.equals("")) {
				GLog.logRecordTime(9, "[功能]----对目标[" + menuCode + "]执行[" + btnName + "]成功");
			}
		}catch (Exception e){
			pData.bRES = false;
			GWCtrlException.SwtichTo(e, 1, 9, "[功能]----" + btnName + "----失败", true);
		}
		GTestCase.setTestCaseRst(pData.bRES);
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
					GWCtrlTopTab.ui_C_CLOSE_TOPTAB(pData.pageREQ.MODULE_NAME_NEW + pData.pageREQ.mapDynamicData.get("材料最终结算单-单据编号"));
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
