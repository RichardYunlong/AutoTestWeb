package User.Concrete.PurchaseNew;

import java.awt.Color;
import java.text.DecimalFormat;

import com.alibaba.fastjson.JSON;

import AutoTest.GAssert;
import AutoTest.GException;
import AutoTest.GLog;
import AutoTest.GTestCase;
import AutoTest.GTime;
import AutoTestScene.GScene;
import AutoTestWeb.GParam;
import AutoTestWeb.GTestIndicators;
import AutoTestWeb.GWCtrlDivClick;
import AutoTestWeb.GWCtrlFrame;
import AutoTestWeb.GWCtrlGrid3;
import AutoTestWeb.GWCtrlInputFill;
import AutoTestWeb.GWCtrlLog;
import AutoTestWeb.GWCtrlPage;
import AutoTestWeb.GWCtrlTopMenuBtn;
import AutoTestWeb.GWCtrlTopTab;
import AutoTestWeb.GWCtrlUpTab;
import AutoTestWeb.GWCtrlWait;
import AutoTestWeb.GWCtrlWebElementId;
import AutoTestWeb.GWCtrlWebElementIframe;
import AutoTestWeb.GWCtrlWindow;

/**
 *  商品混凝土供应合同-详情区
 */
public class Detail {
	
	/**
	 *  数据
	 */
	private Data pData = null;
	
	/**
	 *  新建
	 */
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
	 *  新建-不提交
	 */
	public void ui_G_SAVE() {
		ui_D_INIT();
		ui_C_BASICINFO();
		ui_C_M_DETAILS();
		ui_C_TAB_TOP("关闭");
	}
	
	/**
	 *  删除
	 */
	public void ui_G_DELETE(String strBillCode) {
		ui_D_INIT();
		ui_C_BTN_TOPMENU("删除", strBillCode);
	}
	
	/**
	 *  初始化
	 */
	private void ui_D_INIT(){
		pData = new Data();
		GWCtrlPage.ui_D_IFRAME_INDEX(2, "id", GWCtrlWebElementId.CN_ID.get("单据编号"));
	}
	
	/**
	 *  基本信息
	 */
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
	private void ui_C_INPUT_BASICINFO() {
		GLog.logRecordTime(9, "[功能]----填写基本信息");
		try {
			//切换至中心iframe
			GWCtrlFrame.ui_C_SWITCN_ELEMENT(GWCtrlWebElementIframe.getIframe(2));
			
			//填入【合同名称】
			String conName = "GAT商品混凝土供应合同" + GTime.getCurrentTime(GTime.FORMAT_14);
			GWCtrlInputFill.ById(pData.pageREQ.mapContentId.get("合同名称"), conName);
			pData.pageREQ.mapDynamicData.replace("商品混凝土供应合同-合同名称", conName);
			
			//填入税率
	        GWCtrlInputFill.ById(pData.pageREQ.mapContentId.get("税率(%)"), pData.pageREQ.mapDynamicData.get("商品混凝土供应合同-商砼明细-税率(%)"));

			//填入签约日期
        	GWCtrlPage.ui_C_SELECT_INPUT_BTN("Efd_BizDate", "");
        	GWCtrlPage.ui_C_SELECT_DATE("今天");
			
			//填入【甲方】
			//点击按钮显示甲方列表二级窗体
			GWCtrlPage.ui_C_SELECT_INPUT_BTN("Efd_JF_Name", "");
			//游标切换至二级窗体
			GWCtrlWindow.windowHandles();
			//搜索并选中
			GWCtrlPage.ui_C_WAIT_CLICK(pData.pageREQ.mapTopTabId.get("内部单位"), "");
			GWCtrlPage.ui_C_SEARCH_COO(pData.pageREQ.mapDynamicData.get("商品混凝土供应合同-甲方"));
			GWCtrlPage.ui_C_WAIT_CLICK(GWCtrlWebElementId.CN_ID.get("二级窗体 确定"), "");
        	//游标切换回主窗体
        	GWCtrlWindow.windowHandlePre();
        	//游标切换回母版iframe
        	GWCtrlFrame.ui_C_SWITCN_DEFAULT();
        	
        	//切换至中心iframe
        	GWCtrlFrame.ui_C_SWITCN_ELEMENT(GWCtrlWebElementIframe.getIframe(2));
        	
        	//填入【乙方】
			//点击按钮显示甲方列表二级窗体
			GWCtrlPage.ui_C_SELECT_INPUT_BTN("Efd_YF_Name", "");
			//游标切换至二级窗体
			GWCtrlWindow.windowHandles();
			//搜索并选中
			GWCtrlPage.ui_C_WAIT_CLICK(pData.pageREQ.mapTopTabId.get("外部单位"), "");
			GWCtrlGrid3 sourceGrid3 = new GWCtrlGrid3("id", GWCtrlWebElementId.CN_ID.get("数据源"));
			sourceGrid3.ui_C_SELECT_SOURCE(pData.pageREQ.mapDynamicData.get("商品混凝土供应合同-乙方"));
			pData.gvGrid3 = null;
			GWCtrlPage.ui_C_WAIT_CLICK(GWCtrlWebElementId.CN_ID.get("二级窗体 确定"), "");
        	//游标切换回主窗体
			GWCtrlWindow.windowHandlePre();
        	GWCtrlFrame.ui_C_SWITCN_DEFAULT();

        	GWCtrlFrame.ui_C_SWITCN_ELEMENT(GWCtrlWebElementIframe.getIframe(2));
        	GWCtrlDivClick.ById(GWCtrlWebElementId.CN_ID.get("基本信息"));
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
		GWCtrlLog.TakesScreenshot("_1.png");
	}
	
	/**
	 *  商砼明细
	 */
	public void ui_C_M_DETAILS() {
		pData.pageREQ.MODULE_WAIT_ID = GWCtrlWebElementId.CN_ID.get("商砼明细");
		ui_C_CLICK_TAB("商砼明细");
		ui_C_CLICK_REFER_TO("参考需用计划");
		ui_C_ASSERT();
		ui_C_BTN_TOPMENU("保存", "");
	}

	/**
	 *  参考
	 */
	private void ui_C_CLICK_REFER_TO(String strModuelName) {
		GLog.logRecordTime(9, "[功能]----" + strModuelName);
		try {
			GLog.logRecord(9, "商品混凝土供应合同", "res", 
					"参考之前创建的需用计划[" + pData.pageREQ.mapDynamicData.get("材料需用计划-单据编号") + "]", 
					10000, 0, 0, "", "微软雅黑", 20, Color.BLUE);
			
			GWCtrlFrame.ui_C_SWITCN_ELEMENT(GWCtrlWebElementIframe.getIframe(2));
			GWCtrlPage.ui_C_WAIT_CLICK(pData.pageREQ.mapTopTabId.get("参考"), "");
			GWCtrlPage.ui_C_WAIT_CLICK(pData.pageREQ.mapTopTabId.get(strModuelName), "");
			GWCtrlWindow.windowHandles();
			
			//添加材料
			boolean exist = false;
			try {
				//类别
				GWCtrlGrid3 treeViewGrid3 = new GWCtrlGrid3("id", GWCtrlWebElementId.CN_ID.get("单据树"));
				treeViewGrid3.ui_C_SELECT_TREEVIEW(pData.pageREQ.mapDynamicData.get("材料需用计划-单据编号"));
				//材料
				GWCtrlGrid3 sourceGrid3 = new GWCtrlGrid3("id", GWCtrlWebElementId.CN_ID.get("数据源"));
				sourceGrid3.ui_C_SELECT_SOURCE(pData.pageREQ.mapDynamicData.get("材料需用计划-单据编号"));
				//移入
				GWCtrlPage.ui_C_WAIT_CLICK(GWCtrlWebElementId.CN_ID.get("二级窗体 移入"), "");
				//确认
				GWCtrlPage.ui_C_WAIT_CLICK(GWCtrlWebElementId.CN_ID.get("二级窗体 确定"), "");
	        	
				pData.indexRows++;
				pData.indexRowsMaterial.put(strModuelName, pData.indexRows);
	        	GLog.logRecordTime(9, JSON.toJSONString(pData.indexRows));
	        	
	        	pData.bRES = true;
	        	AutoTest.GParam.strTestResultCode = "0000";
                AutoTest.GParam.strTestResultMsg = "OK";
	        	pData.strStatus = "编辑中";
				GLog.logRecordTime(9, "[功能]----" + strModuelName + "成功");
	        	exist = true;
			}catch (Exception e){
			    pData.bRES = false;
			    AutoTest.GParam.strTestResultCode = "9999";
                AutoTest.GParam.strTestResultMsg = "ERROR";
				GLog.logRecordTime(9, "无可用的" + strModuelName);
				GWCtrlPage.ui_C_WAIT_CLICK(GWCtrlWebElementId.CN_ID.get("二级窗体 取消"), "");
				e.printStackTrace();
			}
			GTestCase.setTestCaseRst(pData.bRES);
			GWCtrlWindow.windowHandlePre();
			GWCtrlFrame.ui_C_SWITCN_DEFAULT();
			
			//填写表格
			if(exist){
				ui_C_INPUT_REFER();
			}
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
		GWCtrlLog.TakesScreenshot("_2.png");
	}

	/**
	 *  参考
	 */
	private void ui_C_INPUT_REFER() {
		GLog.logRecordTime(9, "[功能]----填写参考必填项");
		try {
			GWCtrlFrame.ui_C_SWITCN_ELEMENT(GWCtrlWebElementIframe.getIframe(2));
			
			pData.gvGrid3 = new GWCtrlGrid3("id", GWCtrlWebElementId.CN_ID.get("商砼明细"));
			if(GScene.gSceneName.equals("GDemandPlanQuantityOccupancy")) {
				//读取当前默认的剩余数量
				GScene.DYNAMIC_DATA.replace("材料需用计划-本期计划量-剩余数量", pData.gvGrid3.ui_C_GRID3_VALUE(2, 5).replaceAll(",", ""));
				//占位验证
				GScene.materialCountSurplusVerify();
			}

			GLog.logRecord(9, "商品混凝土供应合同", "res", 
					"含税单价:" + String.valueOf(pData.pageREQ.mapDynamicData.get("商品混凝土供应合同-商砼明细-含税单价")) 
					+ "\n数量:" + String.valueOf(pData.pageREQ.mapDynamicData.get("商品混凝土供应合同-商砼明细-数量")) 
					+ "\n税率:" + String.valueOf(pData.pageREQ.mapDynamicData.get("商品混凝土供应合同-商砼明细-税率(%)")), 
					5000, 0, 0, "", "微软雅黑", 20, Color.BLUE);
			
			//根据行列坐标确认填写商砼明细的位置
			//填写【含税供应单价】
			pData.gvGrid3 = new GWCtrlGrid3("id", GWCtrlWebElementId.CN_ID.get("商砼明细"));
			pData.gvGrid3.showWebElementTextTableMap();
			pData.gvGrid3.ui_C_GRID3_FILL(2, 
					3, 
					pData.pageREQ.mapContentId.get("含税供应单价"), 
					String.valueOf(pData.pageREQ.mapDynamicData.get("商品混凝土供应合同-商砼明细-含税单价")), 
					GWCtrlWebElementId.CN_ID.get("商砼明细"));
			//填写【供应数量】
			pData.gvGrid3 = new GWCtrlGrid3("id", GWCtrlWebElementId.CN_ID.get("商砼明细"));
			pData.gvGrid3.ui_C_GRID3_FILL(2, 
					4, 
					pData.pageREQ.mapContentId.get("供应数量"), 
					String.valueOf(pData.pageREQ.mapDynamicData.get("商品混凝土供应合同-商砼明细-数量")), 
					GWCtrlWebElementId.CN_ID.get("商砼明细"));
			//点击空白处确认编辑结果
			GWCtrlDivClick.ById(GWCtrlWebElementId.CN_ID.get("商砼明细"));
			//释放内存，在【参数校验】步骤中会重新读取细表
			pData.gvGrid3 = null;
			
			GWCtrlFrame.ui_C_SWITCN_DEFAULT();
			
			pData.bRES = true;
			AutoTest.GParam.strTestResultCode = "0000";
            AutoTest.GParam.strTestResultMsg = "OK";
			pData.strStatus = "编辑中";
			GLog.logRecordTime(9, "[功能]----填写参考必填项成功");
		}catch (Exception e){
			pData.bRES = false;
			AutoTest.GParam.strTestResultCode = "9999";
            AutoTest.GParam.strTestResultMsg = "ERROR";
			GLog.logRecordTime(9, "[功能]----填写参考必填项失败");
			if (AutoTest.GTestCase.dTSSTYLE == 1)
				AutoTest.GParam.gRes = GException.getExceptionAllinformation(e);
			e.printStackTrace();
		}
		GTestCase.setTestCaseRst(pData.bRES);
		GWCtrlPage.ui_D_IFRAME_INDEX(2, "id", pData.pageREQ.MODULE_WAIT_ID);
	}
	
	/**
	 *  上部页签切换
	 */
	private void ui_C_CLICK_TAB(String tabName){
		GLog.logRecordTime(9, "[功能]----切换上部页签至" + tabName);
		try {
			//设置等待
			GWCtrlUpTab.ui_C_CLICK_TAB(GParam.g_Dr, 2, pData.pageREQ.mapTopTabId.get(tabName));
			
			pData.bRES = true;
			AutoTest.GParam.strTestResultCode = "0000";
            AutoTest.GParam.strTestResultMsg = "OK";
			pData.strStatus = "编辑中";
			GLog.logRecordTime(9, "[功能]----切换上部页签至" + tabName + "成功");
		}catch (Exception e){
			pData.bRES = false;
			AutoTest.GParam.strTestResultCode = "9999";
            AutoTest.GParam.strTestResultMsg = "ERROR";
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
	private void ui_C_PARAMS() {
		GLog.logRecordTime(9, "[提取公共参数]");
		try {
			//提取公共参数-单据编号
			pData.pageREQ.mapDynamicData.replace("商品混凝土供应合同-单据编号", GWCtrlPage.ui_C_GET_CODE(pData.pageREQ.MODULE_NAME));
			//提取公共参数-单据编号-全局使用
			GScene.DYNAMIC_DATA.replace("商品混凝土供应合同-单据编号", pData.pageREQ.mapDynamicData.get("商品混凝土供应合同-单据编号"));
			pData.bRES = true;
            AutoTest.GParam.strTestResultCode = "0000";
            AutoTest.GParam.strTestResultMsg = "OK";
        	GLog.logRecordTime(9, "[提取公共参数]----成功----自动生成单据编号：" + pData.pageREQ.mapDynamicData.get("商品混凝土供应合同-单据编号"));
		}catch (Exception e){
  		    pData.bRES = false;
            AutoTest.GParam.strTestResultCode = "9999";
            AutoTest.GParam.strTestResultMsg = "ERROR";
			GLog.logRecordTime(9, "[提取公共参数]----失败");
			if (AutoTest.GTestCase.dTSSTYLE == 1)
				AutoTest.GParam.gRes = GException.getExceptionAllinformation(e);
			e.printStackTrace();
		}
	    GTestCase.setTestCaseRst(pData.bRES);
	}
	
	/**
	 *  校验
	 */
	private void ui_C_ASSERT(){
		GLog.logRecordTime(9, "[算法校验]");
		try {
			if(GScene.gSceneName.equals("GDemandPlanQuantityOccupancy")) {
				//更新单据数量
				GScene.billCountPlus("商品混凝土供应合同-新建数量", pData.pageREQ.mapDynamicData.get("商品混凝土供应合同-单据编号"));
				//更新材料占位数量
				GScene.materialCountPlus("商品混凝土供应合同-商砼明细-已占位数量", pData.pageREQ.mapDynamicData.get("商品混凝土供应合同-商砼明细-数量"));
				//占位验证
				GScene.materialCountStatusVerify();
			}else {
				GWCtrlFrame.ui_C_SWITCN_ELEMENT(GWCtrlWebElementIframe.getIframe(2));
				pData.gvGrid3 = new GWCtrlGrid3("id", GWCtrlWebElementId.CN_ID.get("商砼明细"));
				pData.gvGrid3.showWebElementTextTableMap();
				//页面填入的含税金额
				double ac = Double.valueOf((pData.gvGrid3.ui_C_GRID3_VALUE(2, 5).replaceAll(",", "")));
				//页面填入的税率
				double ff = Double.valueOf((pData.pageREQ.mapDynamicData.get("商品混凝土供应合同-商砼明细-税率(%)")));
				//理论计算的无税金额 含税金额=无税金额*(1+税率)，则无税金额=含税金额/(1+税率)
				double dc = ac / (1 + ff / Double.valueOf(100));
				DecimalFormat dR = new DecimalFormat("#.00");
				String TestResult = dR.format(dc);//理论计算的无税金额保留小数点后两位
				//页面实际显示的无税金额
				String TestCompare = (pData.gvGrid3.ui_C_GRID3_VALUE(2, 28).replaceAll(",", ""));
				
				if(GAssert.assertStringEqual(TestResult, TestCompare)) {
					pData.bRES = true;
					AutoTest.GParam.strTestResultCode = "0000";
					AutoTest.GParam.strTestResultMsg = "OK";
					AutoTest.GParam.gRes = "[算法]含税金额=无税金额*(1+税率)\n则无税金额=含税金额/(1+税率)" + "\n[预期无税金额]:" + TestResult  + "\n[实际无税金额]:" + TestCompare+ "\n[算法验证]----通过";
					AutoTest.GLog.logRecord(9, "商品混凝土供应合同", "res", AutoTest.GParam.gRes, 5000, 0, 0, "", "微软雅黑", 18, AutoTest.GParam.GREEN_PASS);
				}else {
					pData.bRES = false;
					AutoTest.GParam.strTestResultCode = "9999";
					AutoTest.GParam.strTestResultMsg = "ERROR";
					AutoTest.GParam.gRes = "[算法]含税金额=无税金额*(1+税率)\n则无税金额=含税金额/(1+税率)" + "\n[预期无税金额]:" + TestResult  + "\n[实际无税金额]:" + TestCompare+ "\n[算法验证]----未通过";
					AutoTest.GLog.logRecord(9, "商品混凝土供应合同", "res", AutoTest.GParam.gRes, 5000, 0, 0, "", "微软雅黑", 18, Color.RED);
				}
				GWCtrlFrame.ui_C_SWITCN_DEFAULT();
			}

			GLog.logRecordTime(9, "[算法校验]----成功");
		}catch (Exception e){
			GLog.logRecordTime(9, "[算法校验]----失败");
			if (AutoTest.GTestCase.dTSSTYLE == 1)
				AutoTest.GParam.gRes = GException.getExceptionAllinformation(e);
			e.printStackTrace();
		}
		GTestCase.setTestCaseRst(pData.bRES);
	}
	
	/**
	 *  顶层菜单
	 *  
	 *  @param btnName 按钮名称
	 *  @param menuCode 目标关键字 可以为空
	 */
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
            AutoTest.GParam.strTestResultCode = "0000";
            AutoTest.GParam.strTestResultMsg = "OK";
			GLog.logRecordTime(9, "[功能]----" + btnName + "----成功");
			if(!menuCode.equals("")) {
				GLog.logRecordTime(9, "[功能]----对目标[" + menuCode + "]执行[" + btnName + "]成功");
			}
		}catch (Exception e){
			pData.bRES = false;
            AutoTest.GParam.strTestResultCode = "9999";
            AutoTest.GParam.strTestResultMsg = "ERROR";
			GLog.logRecordTime(9, "[功能]----" + btnName + "----失败");
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
	public void ui_C_TAB_TOP(String menuName){
		GLog.logRecordTime(9, "[功能]----执行[" + menuName + "]");
		try {
			switch(menuName){
				case "关_闭":{
					GWCtrlTopTab.ui_C_CLOSE_TOPTAB(pData.pageREQ.MODULE_NAME_NEW + pData.pageREQ.mapDynamicData.get("商品混凝土供应合同-单据编号"));
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
