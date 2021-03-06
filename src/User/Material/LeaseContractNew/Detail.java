package User.Material.LeaseContractNew;

import java.awt.Color;
import java.text.DecimalFormat;

import com.alibaba.fastjson.JSON;

import AutoTest.GAssert;
import AutoTest.GLog;
import AutoTest.GTestCase;
import AutoTest.GTime;
import AutoTestScene.GScene;
import AutoTestWeb.GParam;
import AutoTestWeb.GTestIndicators;
import AutoTestWeb.GWCtrlAllure;
import AutoTestWeb.GWCtrlDivClick;
import AutoTestWeb.GWCtrlDropDownMutiSelect;
import AutoTestWeb.GWCtrlException;
import AutoTestWeb.GWCtrlFrame;
import AutoTestWeb.GWCtrlGrid3;
import AutoTestWeb.GWCtrlInputFill;
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
 *  周转材料租赁合同-详情区
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
		ui_C_M_DETAILS();
		ui_C_BTN_TOPMENU("提交", "");
		ui_C_BTN_TOPMENU("取消提交", "");
		ui_C_BTN_TOPMENU("修改", "");
		ui_C_BTN_TOPMENU("提交", "");
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
			
			//填入【合同名称】
			String conName = "GAT周转材料租赁合同" + GTime.getCurrentTime(GTime.FORMAT_14);
			GWCtrlInputFill.ById(pData.pageREQ.mapContentId.get("合同名称"), conName);
			pData.pageREQ.mapDynamicData.replace("周转材料租赁合同-合同名称", conName);
			
			//填入签约日期
        	GWCtrlPage.ui_C_SELECT_INPUT_BTN(pData.pageREQ.mapContentId.get("签约日期"), "");
        	GWCtrlPage.ui_C_SELECT_DATE("今天");
        	
        	//填入计费方式
			GWCtrlPage.ui_C_SELECT_INPUT_BTN(pData.pageREQ.mapContentId.get("计费方式"), "");
			GWCtrlDropDownMutiSelect.ByValue(pData.pageREQ.mapContentId.get("计费方式"), new String[]{"日租", "月租", "工程量"});
        	
			//填入【甲方】
			//点击按钮显示甲方列表二级窗体
			GWCtrlPage.ui_C_SELECT_INPUT_BTN(pData.pageREQ.mapContentId.get("甲方"), "");
			//游标切换至二级窗体
			GWCtrlWindow.windowHandles();
			//搜索并选中
			GWCtrlPage.ui_C_WAIT_CLICK(pData.pageREQ.mapTopTabId.get("内部单位"), "");
			GWCtrlPage.ui_C_SEARCH_COO(pData.pageREQ.mapDynamicData.get("周转材料租赁合同-甲方"));
			GWCtrlPage.ui_C_WAIT_CLICK(GWCtrlWebElementId.CN_ID.get("二级窗体 确定"), "");
        	//游标切换回主窗体
        	GWCtrlWindow.windowHandlePre();
        	//游标切换回母版iframe
        	GWCtrlFrame.ui_C_SWITCN_DEFAULT();
        	
        	//切换至中心iframe
        	GWCtrlFrame.ui_C_SWITCN_ELEMENT(GWCtrlWebElementIframe.getIframe(2));
        	
        	//填入【乙方】
			//点击按钮显示甲方列表二级窗体
			GWCtrlPage.ui_C_SELECT_INPUT_BTN(pData.pageREQ.mapContentId.get("乙方"), "");
			//游标切换至二级窗体
			GWCtrlWindow.windowHandles();
			//搜索并选中
			GWCtrlPage.ui_C_WAIT_CLICK(pData.pageREQ.mapTopTabId.get("外部单位"), "");
			GWCtrlGrid3 sourceGrid3 = new GWCtrlGrid3("id", GWCtrlWebElementId.CN_ID.get("数据源"));
			sourceGrid3.ui_C_SELECT_SOURCE(pData.pageREQ.mapDynamicData.get("周转材料租赁合同-乙方"));
			pData.gvGrid3 = null;
			GWCtrlPage.ui_C_WAIT_CLICK(GWCtrlWebElementId.CN_ID.get("二级窗体 确定"), "");
        	//游标切换回主窗体
			GWCtrlWindow.windowHandlePre();
        	GWCtrlFrame.ui_C_SWITCN_DEFAULT();
        	
        	GWCtrlFrame.ui_C_SWITCN_ELEMENT(GWCtrlWebElementIframe.getIframe(2));
        	GWCtrlDivClick.ById(GWCtrlWebElementId.CN_ID.get("基本信息"));
			GWCtrlFrame.ui_C_SWITCN_DEFAULT();
			
			GWCtrlFrame.ui_C_SWITCN_DEFAULT();
			
			pData.bRES = true;
			pData.strStatus = "编辑中";
			GLog.logRecordTime(9, "[功能]----基本信息填写成功");
		}catch (Exception e){
			pData.bRES = false;
			GWCtrlException.SwtichTo(e, 1, 9, "[功能]----基本信息填写失败", true);
		}
		GWCtrlPage.ui_D_IFRAME_INDEX(2, "id", pData.pageREQ.MODULE_WAIT_ID);
	}
	
	/**
	 *  日租明细
	 */
	@Step("日租明细")
	public void ui_C_M_DETAILS() {
		GLog.logRecord(8, "周转材料租赁合同", "res", "填写日租明细", 5000, 0, 0, "", "微软雅黑", 20, Color.RED);
		//设置等待
		pData.pageREQ.MODULE_WAIT_ID = pData.pageREQ.mapContentId.get("日租明细");
		ui_C_CLICK_TAB("日租明细");
		//ui_C_SELECT_DICT();
		GWCtrlLog.TakesScreenshot("_2.png");
		ui_C_CLICK_REFER_TO("参考周转材料租赁计划");
		ui_C_ASSERT();
		ui_C_BTN_TOPMENU("保存", "");
		GWCtrlAllure.makeScreenShot("周转材料租赁合同-详情区-日租明细-功能截图");
	}
	
	/**
	 *  参考字典
	 */
	@Step("参考字典")
	private void ui_C_SELECT_DICT() {
		GLog.logRecordTime(9, "[功能]----选择字典材料");
		try {
			GWCtrlFrame.ui_C_SWITCN_ELEMENT(GWCtrlWebElementIframe.getIframe(2));
			GWCtrlPage.ui_C_WAIT_CLICK(GWCtrlWebElementId.CN_ID.get("选择字典材料"), "");
			GWCtrlWindow.windowHandles();

			//添加材料
			boolean exist = false;
			try {
				//类别
				GWCtrlGrid3 treeViewGrid3 = new GWCtrlGrid3("id", GWCtrlWebElementId.CN_ID.get("类别树"));
				treeViewGrid3.ui_C_SELECT_TREEVIEW(pData.pageREQ.mapDynamicData.get("周转材料租赁计划-材料类型编码"));
				//材料
				GWCtrlSelect.ByValue(GWCtrlWebElementId.CN_ID.get("查询方案"), pData.pageREQ.mapDynamicData.get("周转材料租赁计划-材料编码"));
				GWCtrlGrid3 sourceGrid3 = new GWCtrlGrid3("id", GWCtrlWebElementId.CN_ID.get("数据源"));
				sourceGrid3.ui_C_SELECT_SOURCE(pData.pageREQ.mapDynamicData.get("周转材料租赁计划-材料编码"));
				//移入
				GWCtrlPage.ui_C_WAIT_CLICK(GWCtrlWebElementId.CN_ID.get("二级窗体 移入"), "");
				//确认
				GWCtrlPage.ui_C_WAIT_CLICK(GWCtrlWebElementId.CN_ID.get("二级窗体 确定"), "");
	        	
				pData.indexRows++;
				pData.indexRowsMaterial.put("选择字典材料", pData.indexRows);
				
				pData.bRES = true;
				pData.strStatus = "编辑中";
				GLog.logRecordTime(9, "[功能]----选择字典材料成功\n" + JSON.toJSONString(pData.indexRows));
				exist = true;
			}catch (Exception e){
				GWCtrlException.SwtichTo(e, 1, 9, "无可被参考的字典材料", true);
				GWCtrlPage.ui_C_WAIT_CLICK(GWCtrlWebElementId.CN_ID.get("二级窗体 取消"), "");
			}
			
        	GWCtrlWindow.windowHandlePre();
			GWCtrlFrame.ui_C_SWITCN_DEFAULT();
			
			//填写表格
			if(exist) {
				ui_C_INPUT_DICT();
			}
		}catch (Exception e){
			pData.bRES = false;
			GWCtrlException.SwtichTo(e, 1, 9, "[功能]----选择字典材料失败", true);
		}
		GWCtrlPage.ui_D_IFRAME_INDEX(2, "id", pData.pageREQ.MODULE_WAIT_ID);
	}

	/**
	 *  填写
	 */
	@Step("填写")
	private void ui_C_INPUT_DICT() {
		GLog.logRecordTime(9, "[功能]----填写字典材料必填项");
		try {
			GWCtrlFrame.ui_C_SWITCN_ELEMENT(GWCtrlWebElementIframe.getIframe(2));
			
			//根据行列坐标确认填写材料明细的位置			
			pData.gvGrid3 = new GWCtrlGrid3("id", GWCtrlWebElementId.CN_ID.get("材料明细"));
			pData.gvGrid3.ui_C_GRID3_FILL(2, 
									8, 
									pData.pageREQ.mapContentId.get("本期计划量"), 
									pData.pageREQ.mapDynamicData.get("周转材料租赁合同-数量"), 
									GWCtrlWebElementId.CN_ID.get("材料明细"));
			
			//点击空白处确认编辑结果
			GWCtrlDivClick.ById(GWCtrlWebElementId.CN_ID.get("材料明细"));
			//释放内存，在【参数校验】步骤中会重新读取细表
			pData.gvGrid3 = null;
			
			GWCtrlFrame.ui_C_SWITCN_DEFAULT();
			
			pData.bRES = true;
			pData.strStatus = "编辑中";
			GLog.logRecordTime(9, "[功能]----填写字典材料必填项成功");
		}catch (Exception e){
			pData.bRES = false;
			GWCtrlException.SwtichTo(e, 1, 9, "[功能]----填写字典材料必填项失败", true);
		}
		GWCtrlPage.ui_D_IFRAME_INDEX(2, "id", pData.pageREQ.MODULE_WAIT_ID);
	}
	
	/**
	 *  参考
	 *  
	 *  @param strModuelName 参考途径
	 */
	@Step("参考")
	private void ui_C_CLICK_REFER_TO(String strModuelName) {
		GLog.logRecordTime(9, "[功能]----" + strModuelName);
		try {
			GLog.logRecord(9, "周转材料租赁合同", "res", 
					"参考之前创建的周转材料租赁计划[" + pData.pageREQ.mapDynamicData.get("周转材料租赁计划-单据编号") + "]", 
					10000, 0, 0, "", "微软雅黑", 20, Color.BLUE);
			
			GWCtrlFrame.ui_C_SWITCN_ELEMENT(GWCtrlWebElementIframe.getIframe(2));
			GWCtrlPage.ui_C_WAIT_CLICK(pData.pageREQ.mapTopTabId.get(strModuelName), "");
			GWCtrlWindow.windowHandles();
			
			//添加材料
			boolean exist = false;
			try {
				//类别
				GWCtrlGrid3 treeViewGrid3 = new GWCtrlGrid3("id", GWCtrlWebElementId.CN_ID.get("单据树"));
				treeViewGrid3.ui_C_SELECT_TREEVIEW(pData.pageREQ.mapDynamicData.get("周转材料租赁计划-单据编号"));
				//材料
				GWCtrlGrid3 sourceGrid3 = new GWCtrlGrid3("id", GWCtrlWebElementId.CN_ID.get("数据源"));
				sourceGrid3.ui_C_SELECT_SOURCE(pData.pageREQ.mapDynamicData.get("周转材料租赁合同-材料编码"));
				//移入
				GWCtrlPage.ui_C_WAIT_CLICK(GWCtrlWebElementId.CN_ID.get("二级窗体 移入"), "");
				//确认
				GWCtrlPage.ui_C_WAIT_CLICK(GWCtrlWebElementId.CN_ID.get("二级窗体 确定"), "");
	        	
				pData.indexRows++;
				pData.indexRowsMaterial.put(strModuelName, pData.indexRows);
	        	GLog.logRecordTime(9, JSON.toJSONString(pData.indexRows));
	        	
	        	pData.bRES = true;
	        	pData.strStatus = "编辑中";
				GLog.logRecordTime(9, "[功能]----" + strModuelName + "成功");
	        	exist = true;
			}catch (Exception e){
				GLog.logRecordTime(9, "无可用的" + strModuelName);
				GWCtrlPage.ui_C_WAIT_CLICK(GWCtrlWebElementId.CN_ID.get("二级窗体 取消"), "");
				e.printStackTrace();
			}	

			GWCtrlWindow.windowHandlePre();
			GWCtrlFrame.ui_C_SWITCN_DEFAULT();
			
			//填写表格
			if(exist){
				ui_C_INPUT_REFER();
			}
		}catch (Exception e){
			pData.bRES = false;
			GWCtrlException.SwtichTo(e, 1, 9, "[功能]----" + strModuelName + "失败", true);
		}
		GWCtrlPage.ui_D_IFRAME_INDEX(2, "id", pData.pageREQ.MODULE_WAIT_ID);
		GWCtrlLog.TakesScreenshot("_2.png");
	}
	
	/**
	 *  填写
	 */
	@Step("填写")
	private void ui_C_INPUT_REFER() {
		GLog.logRecordTime(9, "[功能]----填写参考必填项");
		try {
			GWCtrlFrame.ui_C_SWITCN_ELEMENT(GWCtrlWebElementIframe.getIframe(2));
			//根据行列坐标确认填写材料明细的位置
			//填写【天数】
			pData.gvGrid3 = new GWCtrlGrid3("id", pData.pageREQ.mapContentId.get("日租明细"));
			pData.gvGrid3.ui_C_GRID3_FILL(2, 
					22, 
					pData.pageREQ.mapContentId.get("租赁天数"), 
					String.valueOf(pData.pageREQ.mapDynamicData.get("周转材料租赁合同-租赁天数")), 
					pData.pageREQ.mapContentId.get("日租明细"));
			//填写【单价】
			pData.gvGrid3 = new GWCtrlGrid3("id", pData.pageREQ.mapContentId.get("日租明细"));
			pData.gvGrid3.ui_C_GRID3_FILL(2, 
					23, 
					pData.pageREQ.mapContentId.get("含税日租单价"), 
					String.valueOf(pData.pageREQ.mapDynamicData.get("周转材料租赁合同-含税日租单价")), 
					pData.pageREQ.mapContentId.get("日租明细"));
			//填写【数量】
			pData.gvGrid3 = new GWCtrlGrid3("id", pData.pageREQ.mapContentId.get("日租明细"));
			pData.gvGrid3.ui_C_GRID3_FILL(2, 
					27, 
					pData.pageREQ.mapContentId.get("数量"), 
					String.valueOf(pData.pageREQ.mapDynamicData.get("周转材料租赁合同-数量")), 
					pData.pageREQ.mapContentId.get("日租明细"));
			//填写【税率】
			pData.gvGrid3 = new GWCtrlGrid3("id", pData.pageREQ.mapContentId.get("日租明细"));
			pData.gvGrid3.showWebElementTextTableMap();
			pData.gvGrid3.ui_C_GRID3_FILL(2, 
					32, 
					pData.pageREQ.mapContentId.get("税率"), 
					String.valueOf(pData.pageREQ.mapDynamicData.get("周转材料租赁合同-税率")), 
					pData.pageREQ.mapContentId.get("日租明细"));
			//点击空白处确认编辑结果
			GWCtrlDivClick.ById(pData.pageREQ.mapContentId.get("日租明细"));
			//释放内存，在【参数校验】步骤中会重新读取细表
			pData.gvGrid3 = null;
			
			GWCtrlFrame.ui_C_SWITCN_DEFAULT();
			
			pData.bRES = true;
			pData.strStatus = "编辑中";
			GLog.logRecordTime(9, "[功能]----填写参考必填项成功");
		}catch (Exception e){
			pData.bRES = false;
			GWCtrlException.SwtichTo(e, 1, 9, "[功能]----填写参考必填项失败", true);
		}
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
			pData.strStatus = "编辑中";
			GLog.logRecordTime(9, "[功能]----切换上部页签至" + tabName + "成功");
		}catch (Exception e){
			pData.bRES = false;
			GWCtrlException.SwtichTo(e, 1, 9, "[功能]----切换上部页签至" + tabName + "失败", true);
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
			pData.pageREQ.mapDynamicData.replace("周转材料租赁合同-单据编号", GWCtrlPage.ui_C_GET_CODE(pData.pageREQ.MODULE_NAME));
			//提取公共参数-单据编号-全局使用
			GScene.DYNAMIC_DATA.replace("周转材料租赁合同-单据编号", pData.pageREQ.mapDynamicData.get("周转材料租赁合同-单据编号"));
        	
        	GLog.logRecordTime(9, "[提取公共参数]----成功----自动生成单据编号：" + pData.pageREQ.mapDynamicData.get("周转材料租赁合同-单据编号"));
        	
		}catch (Exception e){
			GWCtrlException.SwtichTo(e, 1, 9, "[提取公共参数]----失败", true);
		}
	}
	
	/**
	 *  校验
	 */
	@Step("算法校验")
	private void ui_C_ASSERT(){
		GLog.logRecordTime(9, "[算法校验]");
		try {
			GWCtrlFrame.ui_C_SWITCN_ELEMENT(GWCtrlWebElementIframe.getIframe(2));
			pData.gvGrid3 = new GWCtrlGrid3("id", pData.pageREQ.mapContentId.get("日租明细"));
			
			double ac = Double.valueOf(pData.gvGrid3.ui_C_GRID3_VALUE(2, 23).replaceAll(",", ""));
			double dc = Double.valueOf(pData.gvGrid3.ui_C_GRID3_VALUE(2, 27).replaceAll(",", ""));
			double df = Double.valueOf(pData.gvGrid3.ui_C_GRID3_VALUE(2, 32).replaceAll(",", ""));
			
			double dd = (ac / (Double.valueOf(1.00) + df/Double.valueOf(100.0))) * dc;
			DecimalFormat dR = new DecimalFormat("#.00");
			String TestResult = dR.format(dd);//理论计算的无税金额保留小数点后两位
			String TestCompare = (pData.gvGrid3.ui_C_GRID3_VALUE(2, 37).replaceAll(",", ""));
			
			if(GAssert.assertStringEqual(TestResult, TestCompare)) {
				pData.bRES = true;
				AutoTest.GParam.strTestResultCode = "0000";
				AutoTest.GParam.strTestResultMsg = "OK";
				AutoTest.GParam.gRes = "[算法]\n[含税日租单价]:" + String.valueOf(ac) + "\n[数量]:" + String.valueOf(dc) + "\n[税率]:" + String.valueOf(df) + "\n[无税金额]:" + TestCompare + "\n[算法验证]----通过";
				AutoTest.GLog.logRecord(9, "材料需用计划", "res", AutoTest.GParam.gRes, 5000, 0, 0, "", "微软雅黑", 20, AutoTest.GParam.GREEN_PASS);
			}else {
				pData.bRES = false;
				AutoTest.GParam.strTestResultCode = "9999";
				AutoTest.GParam.strTestResultMsg = "ERROR";
				AutoTest.GParam.gRes = "[算法]\n[含税日租单价]:" + String.valueOf(ac) + "\n[数量]:" + String.valueOf(dc) + "\n[税率]:" + String.valueOf(df) + "\n[无税金额]:" + TestCompare + "\n[算法验证]----未通过";
				AutoTest.GLog.logRecord(9, "材料需用计划", "res", AutoTest.GParam.gRes, 5000, 0, 0, "", "微软雅黑", 20, Color.RED);
			}
			GWCtrlFrame.ui_C_SWITCN_DEFAULT();
			
			GLog.logRecordTime(9, "[算法校验]----成功");
		}catch (Exception e){
			GWCtrlException.SwtichTo(e, 1, 9, "[算法校验]----失败", true);
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
					GWCtrlTopTab.ui_C_CLOSE_TOPTAB(pData.pageREQ.MODULE_NAME_NEW + pData.pageREQ.mapDynamicData.get("材料需用计划-单据编号"));
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
