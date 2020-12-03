package User.Concrete.AllotSettlementNew;

import java.awt.Color;
import AutoTest.GException;
import AutoTest.GLog;
import AutoTest.GTestCase;
import AutoTestScene.GScene;
import AutoTestWeb.GParam;
import AutoTestWeb.GTestIndicators;
import AutoTestWeb.GWCtrlDivClick;
import AutoTestWeb.GWCtrlException;
import AutoTestWeb.GWCtrlFrame;
import AutoTestWeb.GWCtrlGrid3;
import AutoTestWeb.GWCtrlLog;
import AutoTestWeb.GWCtrlPage;
import AutoTestWeb.GWCtrlSelect;
import AutoTestWeb.GWCtrlTopMenuBtn;
import AutoTestWeb.GWCtrlTopTab;
import AutoTestWeb.GWCtrlUpTab;
import AutoTestWeb.GWCtrlWait;
import AutoTestWeb.GWCtrlWebElementId;
import AutoTestWeb.GWCtrlWebElementIframe;
import AutoTestWeb.GWCtrlWindow;
import io.qameta.allure.Step;

/**
 *  商品混凝土调拨结算单-详情区 zhangc-z 2020-11-16
 */
public class Detail {
	
	/**
	 *  数据
	 */
	private Data pData = null;
	
	/**
	 *  填写
	 */
	@Step("新建")
	public void ui_G_NEW() {
		ui_D_INIT();
		ui_C_BASICINFO();
		ui_C_M_DETAILS();
		ui_C_BTN_TOPMENU("提交", "");
		ui_C_BTN_TOPMENU("取消提交", "");
		ui_C_BTN_TOPMENU("修改", "");
		ui_C_BTN_TOPMENU("提交", "");
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
            //选择收料单位
            GWCtrlFrame.ui_C_SWITCN_ELEMENT(GWCtrlWebElementIframe.getIframe(2));
            //点击按钮显示使用单位二级列表
            GWCtrlPage.ui_C_SELECT_INPUT_BTN(pData.pageREQ.mapContentId.get("收料单位"), "");
            //游标切换至二级窗体
            GWCtrlWindow.windowHandles();
            switch (GScene.DYNAMIC_DATA.get("商品混凝土调拨结算单-收料单位")) {
              case "内部单位":
                //搜索并选中
                GWCtrlPage.ui_C_WAIT_CLICK(pData.pageREQ.mapTopTabId.get("内部单位"), "");
                GWCtrlPage.ui_C_SEARCH_COO(pData.pageREQ.mapDynamicData.get("商品混凝土供应合同-甲方"));
                GWCtrlPage.ui_C_WAIT_CLICK(GWCtrlWebElementId.CN_ID.get("二级窗体 确定"), "");
                break;
              case "外部单位":
                //搜索并选中
                GWCtrlPage.ui_C_WAIT_CLICK(pData.pageREQ.mapTopTabId.get("外部单位"), "");
                GWCtrlGrid3 Grid3 = new GWCtrlGrid3("id", GWCtrlWebElementId.CN_ID.get("数据源"));
                Grid3.ui_C_SELECT_SOURCE(pData.pageREQ.mapDynamicData.get("商品混凝土小票-供应商"));
                pData.gvGrid3 = null;
                GWCtrlPage.ui_C_WAIT_CLICK(GWCtrlWebElementId.CN_ID.get("二级窗体 确定"), "");
                break;
            }
            //游标切换回主窗体
            GWCtrlWindow.windowHandlePre();
            GWCtrlFrame.ui_C_SWITCN_DEFAULT();
            
			pData.bRES = true;
			AutoTest.GParam.strTestResultCode = "0000";
            AutoTest.GParam.strTestResultMsg = "OK";
			pData.strStatus = "编辑中";
			GLog.logRecordTime(9, "[功能]----基本信息填写成功");
		}catch (Exception e){
			pData.bRES = false;
			AutoTest.GParam.strTestResultCode = "9999";
            AutoTest.GParam.strTestResultMsg = "ERROR";
			GLog.logRecordTime(9, "[功能]----基本信息填写失败");
			if (AutoTest.GTestCase.dTSSTYLE == 1)
				AutoTest.GParam.gRes = GException.getExceptionAllinformation(e);
			e.printStackTrace();
		}
		GTestCase.setTestCaseRst(pData.bRES);
		GWCtrlPage.ui_D_IFRAME_INDEX(2, "id", pData.pageREQ.MODULE_WAIT_ID);
	}
	

    /**
     * 选择商品混凝土供应合同
     */
	@Step("选择指定的商品混凝土供应合同")
    private void ui_C_SELECT_CONTRACT() {
      GLog.logRecordTime(9, "[功能]----选择商品混凝土供应合同");
      try {
          GWCtrlFrame.ui_C_SWITCN_ELEMENT(GWCtrlWebElementIframe.getIframe(2));
          GWCtrlDivClick.ById("detialTabView");
          //选择商品混凝土供应合同
          GWCtrlPage.ui_C_SELECT_INPUT_BTN(pData.pageREQ.mapContentId.get("合同编号"), "");
          //游标切换至二级窗体
          GWCtrlWindow.windowHandles();
          //搜索并选中
          GWCtrlSelect.ByValue(GWCtrlWebElementId.CN_ID.get("查询方案"), pData.pageREQ.mapDynamicData.get("商品混凝土供应合同-单据编号"));
          GWCtrlPage.ui_C_WAIT_CLICK(GWCtrlWebElementId.CN_ID.get("二级窗体 确定"), "");
          pData.bRES = true;
          AutoTest.GParam.strTestResultCode = "0000";
          AutoTest.GParam.strTestResultMsg = "OK";
      } catch (Exception e) {
        pData.bRES = false;
        AutoTest.GParam.strTestResultCode = "9999";
        AutoTest.GParam.strTestResultMsg = "ERROR";
        GWCtrlException.SwtichTo(e, 1, 9, "无可被选择的商品混凝土供应合同", true);
        GWCtrlPage.ui_C_WAIT_CLICK(GWCtrlWebElementId.CN_ID.get("二级窗体 取消"), "");
      }
      GTestCase.setTestCaseRst(pData.bRES);
      //游标切换回主窗体
      GWCtrlWindow.windowHandlePre();
      GWCtrlFrame.ui_C_SWITCN_DEFAULT();
      GWCtrlPage.ui_D_IFRAME_INDEX(2, "id", pData.pageREQ.MODULE_WAIT_ID);
    }
	
	/**
	 *  单据明细
	 */
	@Step("单据明细")
	public void ui_C_M_DETAILS() {
		
		//切换页签
		ui_C_CLICK_TAB("商砼小票明细");

		//选择单据
		ui_C_CLICK_REFER_TO("选择单据");
		
		//保存截图
		GWCtrlLog.TakesScreenshot("_2.png");
		

		//保存
		ui_C_BTN_TOPMENU("保存", "");
	}
	
	/**
	 * @param strModuelName 选择单据
	 */
	@Step("选择单据")
	private void ui_C_CLICK_REFER_TO(String strModuelName) {
		GLog.logRecordTime(9, "[功能]----" + strModuelName);
		try {
			AutoTest.GLog.logRecord(9, "商品混凝土调拨结算单", "res", "选择指定商砼小票", 8000, 0, 0, "", "微软雅黑", 20, Color.RED);
			GWCtrlFrame.ui_C_SWITCN_ELEMENT(GWCtrlWebElementIframe.getIframe(2));
			GWCtrlPage.ui_C_WAIT_CLICK(pData.pageREQ.mapTopTabId.get("选择单据"), "");
			GWCtrlWindow.windowHandles();
			try {
		         //搜索
	            GWCtrlSelect.ByValue(GWCtrlWebElementId.CN_ID.get("查询方案"), pData.pageREQ.mapDynamicData.get("商品混凝土小票-单据编号"));
	            //选中
	            GWCtrlGrid3 sourceGrid3 = new GWCtrlGrid3("id", GWCtrlWebElementId.CN_ID.get("数据源"));
	            sourceGrid3.ui_C_SELECT_SOURCE(pData.pageREQ.mapDynamicData.get("商品混凝土小票-单据编号"));
	            //移入
	            GWCtrlPage.ui_C_WAIT_CLICK(GWCtrlWebElementId.CN_ID.get("二级窗体 移入"), "");
	            //确定
	            GWCtrlPage.ui_C_WAIT_CLICK(GWCtrlWebElementId.CN_ID.get("二级窗体 确定"), "");
	            pData.bRES = true;
	            AutoTest.GParam.strTestResultCode = "0000";
	            AutoTest.GParam.strTestResultMsg = "OK";
              
            } catch (Exception e) {
                pData.bRES = false;
                AutoTest.GParam.strTestResultCode = "9999";
                AutoTest.GParam.strTestResultMsg = "ERROR";
                GLog.logRecordTime(9, "无可用的" + strModuelName);
                GWCtrlPage.ui_C_WAIT_CLICK(GWCtrlWebElementId.CN_ID.get("二级窗体 取消"), "");
                if (AutoTest.GTestCase.dTSSTYLE == 1)
                    AutoTest.GParam.gRes = GException.getExceptionAllinformation(e);
                e.printStackTrace();
            }

			GWCtrlWindow.windowHandlePre();
			GWCtrlFrame.ui_C_SWITCN_DEFAULT();
			
		}catch (Exception e){
			pData.bRES = false;
			AutoTest.GParam.strTestResultCode = "9999";
            AutoTest.GParam.strTestResultMsg = "ERROR";
			GLog.logRecordTime(9, "[功能]----" + strModuelName + "失败");
			if (AutoTest.GTestCase.dTSSTYLE == 1)
				AutoTest.GParam.gRes = GException.getExceptionAllinformation(e);
			e.printStackTrace();
		}
		GTestCase.setTestCaseRst(pData.bRES);
		GWCtrlPage.ui_D_IFRAME_INDEX(2, "id", pData.pageREQ.MODULE_WAIT_ID);
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
			AutoTest.GParam.strTestResultCode = "0000";
            AutoTest.GParam.strTestResultMsg = "OK";
			pData.strStatus = "编辑中";
			GLog.logRecordTime(9, "[功能]----切换上部页签至" + tabName + "成功");
		}catch (Exception e){
			pData.bRES = false;
			AutoTest.GParam.strTestResultCode = "0000";
            AutoTest.GParam.strTestResultMsg = "OK";
			GLog.logRecordTime(9, "[功能]----切换上部页签至" + tabName + "失败");
			if (AutoTest.GTestCase.dTSSTYLE == 1)
				AutoTest.GParam.gRes = GException.getExceptionAllinformation(e);
			e.printStackTrace();
		}
		GTestCase.setTestCaseRst(pData.bRES);
		GWCtrlPage.ui_D_IFRAME_INDEX(2, "id", pData.pageREQ.MODULE_WAIT_ID);
	}
	
	/**
	 *  参数提取
	 */
	@Step("参数提取")
	private void ui_C_PARAMS() {
		GLog.logRecordTime(9, "[提取公共参数]");
		try {
        	//提取公共参数-单据编号
			pData.pageREQ.mapDynamicData.replace("商品混凝土调拨结算单-单据编号", GWCtrlPage.ui_C_GET_CODE(pData.pageREQ.MODULE_NAME));
			//提取公共参数-单据编号-全局使用
			GScene.DYNAMIC_DATA.replace("商品混凝土调拨结算单-单据编号", pData.pageREQ.mapDynamicData.get("商品混凝土调拨结算单-单据编号"));
			pData.bRES = true;
			AutoTest.GParam.strTestResultCode = "0000";
            AutoTest.GParam.strTestResultMsg = "OK";
			GLog.logRecordTime(9, "[提取公共参数]----成功----自动生成单据编号：" + pData.pageREQ.mapDynamicData.get("商品混凝土调拨结算单-单据编号"));
		}catch (Exception e){
  		    pData.bRES = false;
  		    AutoTest.GParam.strTestResultCode = "0000";
            AutoTest.GParam.strTestResultMsg = "OK";
			GLog.logRecordTime(9, "[提取公共参数]----失败");
			if (AutoTest.GTestCase.dTSSTYLE == 1)
				AutoTest.GParam.gRes = GException.getExceptionAllinformation(e);
			e.printStackTrace();
		}
		GTestCase.setTestCaseRst(pData.bRES);
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
							if(null != strCode && !strCode.equals("") && strCode.length() >= 19) {
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
			AutoTest.GParam.strTestResultCode = "0000";
            AutoTest.GParam.strTestResultMsg = "OK";
			GLog.logRecordTime(9, "[功能]----" + menuName + "----成功");
			if(!strBillCode.equals("")) {
				GLog.logRecordTime(9, "[功能]----对目标[" + strBillCode + "]执行[" + menuName + "]成功");
			}
		}catch (Exception e){
			pData.bRES = false;
			AutoTest.GParam.strTestResultCode = "9999";
            AutoTest.GParam.strTestResultMsg = "ERROR";
			GLog.logRecordTime(9, "[功能]----" + menuName + "----失败");
			if (AutoTest.GTestCase.dTSSTYLE == 1)
				AutoTest.GParam.gRes = GException.getExceptionAllinformation(e);
			e.printStackTrace();
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
					GWCtrlTopTab.ui_C_CLOSE_TOPTAB(pData.pageREQ.MODULE_NAME_NEW + pData.pageREQ.mapDynamicData.get("商品混凝土调拨结算单-单据编号"));
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
