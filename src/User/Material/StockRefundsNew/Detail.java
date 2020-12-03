package User.Material.StockRefundsNew;

import java.awt.Color;
import java.text.DecimalFormat;

import com.alibaba.fastjson.JSON;

import AutoTest.GAssert;
import AutoTest.GException;
import AutoTest.GLog;
import AutoTest.GTestCase;
import AutoTestScene.GScene;
import AutoTestWeb.GParam;
import AutoTestWeb.GTestIndicators;
import AutoTestWeb.GWCtrlDivClick;
import AutoTestWeb.GWCtrlFrame;
import AutoTestWeb.GWCtrlGrid3;
import AutoTestWeb.GWCtrlLog;
import AutoTestWeb.GWCtrlPage;
import AutoTestWeb.GWCtrlTopMenuBtn;
import AutoTestWeb.GWCtrlTopTab;
import AutoTestWeb.GWCtrlUpTab;
import AutoTestWeb.GWCtrlWait;
import AutoTestWeb.GWCtrlWebElementId;
import AutoTestWeb.GWCtrlWebElementIframe;
import AutoTestWeb.GWCtrlWindow;
import io.qameta.allure.Step;

/**
 *  材料退货单-详情区
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
    *  新建
    *  
    *  @param strReferType 参考数据来源
    *  @param strBillCode 参考单据编号
    */
	@Step("新建-带参")
    public void ui_G_NEW(String strReferType, String strBillCode) {
       ui_D_INIT();
       pData.referType = strReferType;
       pData.billCode = strBillCode;
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
			GWCtrlFrame.ui_C_SWITCN_ELEMENT(GWCtrlWebElementIframe.getIframe(2));

			//填入【供应商】
			//点击按钮显示甲方列表二级窗体
			GWCtrlPage.ui_C_SELECT_INPUT_BTN("Efd_GYS_Name", "");
			//游标切换至二级窗体
			GWCtrlWindow.windowHandles();
			//搜索并选中
			GWCtrlPage.ui_C_WAIT_CLICK(pData.pageREQ.mapTopTabId.get("外部单位"), "");
			GWCtrlGrid3 sourceGrid3 = new GWCtrlGrid3("id", GWCtrlWebElementId.CN_ID.get("数据源"));
			sourceGrid3.ui_C_SELECT_SOURCE(pData.pageREQ.mapDynamicData.get("材料退货单-供应商"));
			pData.gvGrid3 = null;
			GWCtrlPage.ui_C_WAIT_CLICK(GWCtrlWebElementId.CN_ID.get("二级窗体 确定"), "");

        	GWCtrlWindow.windowHandlePre();
        	GWCtrlFrame.ui_C_SWITCN_DEFAULT();
        	
        	GWCtrlFrame.ui_C_SWITCN_ELEMENT(GWCtrlWebElementIframe.getIframe(2));
        	GWCtrlDivClick.ById(GWCtrlWebElementId.CN_ID.get("基本信息"));
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
	 *  材料明细
	 */
	@Step("材料明细")
	public void ui_C_M_DETAILS() {
		//设置等待
		pData.pageREQ.MODULE_WAIT_ID = GWCtrlWebElementId.CN_ID.get("材料明细");
		ui_C_CLICK_TAB("材料明细");
		ui_C_SELECT_STOCK();
		GWCtrlLog.TakesScreenshot("_2.png");
		ui_C_ASSERT();
		ui_C_BTN_TOPMENU("保存", "");
	}

	/**
	 *  参考
	 */
	@Step("参考字典")
	private void ui_C_SELECT_STOCK() {
		GLog.logRecordTime(9, "[功能]----选择在库材料");
		try {
			GWCtrlFrame.ui_C_SWITCN_ELEMENT(GWCtrlWebElementIframe.getIframe(2));
			GWCtrlPage.ui_C_WAIT_CLICK(pData.pageREQ.mapTopTabId.get("选择在库材料"), "");
			GWCtrlWindow.windowHandles();
			
			//添加材料
			boolean exist = false;
			try {
				//选择
				GWCtrlGrid3 sourceGrid3 = new GWCtrlGrid3("id", GWCtrlWebElementId.CN_ID.get("数据源"));
                String billCode = "";
                if(pData.billCode != null && !pData.billCode.equals("")) {
                    billCode = pData.billCode;
                }else {
                    billCode = pData.pageREQ.mapDynamicData.get("材料入库单-单据编号");
                }
                sourceGrid3.ui_C_SELECT_SOURCE(billCode);
				//移入
				GWCtrlPage.ui_C_WAIT_CLICK(GWCtrlWebElementId.CN_ID.get("二级窗体 移入"), "");
				//确认
				GWCtrlPage.ui_C_WAIT_CLICK(GWCtrlWebElementId.CN_ID.get("二级窗体 确定"), "");
	        	
				pData.indexRows++;
				pData.indexRowsMaterial.put("选择字典材料", pData.indexRows);
				GLog.logRecordTime(9, JSON.toJSONString(pData.indexRows));
				
				pData.bRES = true;
				pData.strStatus = "编辑中";
				GLog.logRecordTime(9, "[功能]----选择在库材料成功");
				exist = true;
			}catch (Exception e){
				GLog.logRecordTime(9, "无可被参考的在库材料");
				GWCtrlPage.ui_C_WAIT_CLICK(GWCtrlWebElementId.CN_ID.get("二级窗体 取消"), "");
				if (AutoTest.GTestCase.dTSSTYLE == 1)
					AutoTest.GParam.gRes = GException.getExceptionAllinformation(e);
				e.printStackTrace();
			}
			
			GWCtrlWindow.windowHandlePre();
			GWCtrlFrame.ui_C_SWITCN_DEFAULT();
			
			//填写表格
			if(exist) {
				ui_C_INPUT_STOCK();
			}
		}catch (Exception e){
			pData.bRES = false;
			GLog.logRecordTime(9, "[功能]----选择在库材料失败");
			if (AutoTest.GTestCase.dTSSTYLE == 1)
				AutoTest.GParam.gRes = GException.getExceptionAllinformation(e);
			e.printStackTrace();
		}
		GWCtrlPage.ui_D_IFRAME_INDEX(2, "id", pData.pageREQ.MODULE_WAIT_ID);
	}

	/**
	 *  填写
	 */
	@Step("填写")
	private void ui_C_INPUT_STOCK() {
		GLog.logRecordTime(9, "[功能]----填写在库材料必填项");
		
		try {
			GWCtrlFrame.ui_C_SWITCN_ELEMENT(GWCtrlWebElementIframe.getIframe(2));
			
			//根据行号确认填写材料明细的位置
			//填写【单价】
			pData.gvGrid3 = new GWCtrlGrid3("id", GWCtrlWebElementId.CN_ID.get("材料明细"));
			pData.gvGrid3.ui_C_GRID3_FILL(2, 
					4, 
					pData.pageREQ.mapContentId.get("退货含税单价"), 
					String.valueOf(pData.pageREQ.mapDynamicData.get("材料退货单-材料明细-含税单价")), 
					GWCtrlWebElementId.CN_ID.get("材料明细"));
			//填写【数量】
			pData.gvGrid3 = new GWCtrlGrid3("id", GWCtrlWebElementId.CN_ID.get("材料明细"));
			pData.gvGrid3.ui_C_GRID3_FILL(2, 
					5, 
					pData.pageREQ.mapContentId.get("退货数量"), 
					String.valueOf(pData.pageREQ.mapDynamicData.get("材料退货单-材料明细-数量")), 
					GWCtrlWebElementId.CN_ID.get("材料明细"));
			//填写【税率】
			pData.gvGrid3 = new GWCtrlGrid3("id", GWCtrlWebElementId.CN_ID.get("材料明细"));
			pData.gvGrid3.ui_C_GRID3_FILL(2, 
					7, 
					pData.pageREQ.mapContentId.get("税率(%)"), 
					String.valueOf(pData.pageREQ.mapDynamicData.get("材料退货单-材料明细-税率(%)")), 
					GWCtrlWebElementId.CN_ID.get("材料明细"));
			//点击空白处确认编辑结果
			GWCtrlDivClick.ById(GWCtrlWebElementId.CN_ID.get("材料明细"));
			//释放内存，在【参数校验】步骤中会重新读取细表
			pData.gvGrid3 = null;
			
			GWCtrlFrame.ui_C_SWITCN_DEFAULT();
			
			pData.bRES = true;
			pData.strStatus = "编辑中";
			GLog.logRecordTime(9, "[功能]----在库材料必填项填写成功");
		}catch (Exception e){
			pData.bRES = false;
			GLog.logRecordTime(9, "[功能]----在库材料必填项填写失败");
			if (AutoTest.GTestCase.dTSSTYLE == 1)
				AutoTest.GParam.gRes = GException.getExceptionAllinformation(e);
			e.printStackTrace();
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
        	//提取公共参数-单据编号
			pData.pageREQ.mapDynamicData.replace("材料退货单-单据编号", GWCtrlPage.ui_C_GET_CODE(pData.pageREQ.MODULE_NAME));
			//提取公共参数-单据编号-全局使用
			GScene.DYNAMIC_DATA.replace("材料退货单-单据编号", pData.pageREQ.mapDynamicData.get("材料退货单-单据编号"));

			GLog.logRecordTime(9, "[提取公共参数]----成功----自动生成单据编号：" + pData.pageREQ.mapDynamicData.get("材料退货单-单据编号"));
		}catch (Exception e){
			GLog.logRecordTime(9, "[提取公共参数]----失败");
			if (AutoTest.GTestCase.dTSSTYLE == 1)
				AutoTest.GParam.gRes = GException.getExceptionAllinformation(e);
			e.printStackTrace();
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
			pData.gvGrid3 = new GWCtrlGrid3("id", GWCtrlWebElementId.CN_ID.get("材料明细"));
			//Data.gvGrid3.showWebElementTextTableMap();
			
			//退货含税单价
			double dc = Double.valueOf((pData.gvGrid3.ui_C_GRID3_VALUE(2, 4).replaceAll(",", "")));
			//退货数量
			double ic = Double.valueOf((pData.gvGrid3.ui_C_GRID3_VALUE(2, 5).replaceAll(",", "")));
			//税率
			double ff = Double.valueOf((pData.gvGrid3.ui_C_GRID3_VALUE(2, 7).replaceAll(",", "")));
			//成本金额计算值
			double rc = dc / ((double)1.00 + ff/(double)100.00) * ic;
			DecimalFormat dR = new DecimalFormat("#.00");
			String TestResult = dR.format(rc);//理论计算的无税金额保留小数点后两位
			//成本金额显示值
			String TestCompare = (pData.gvGrid3.ui_C_GRID3_VALUE(2, 14).replaceAll(",", ""));
			
			if(GAssert.assertStringEqual(TestResult, TestCompare)) {
				pData.bRES = true;
				AutoTest.GParam.strTestResultCode = "0000";
				AutoTest.GParam.strTestResultMsg = "OK";
				AutoTest.GParam.gRes = "[算法]成本金额=退货含税单价/(1+税率)*100%*退货数量" + 
						"\n[成本金额]:" + TestCompare + "\n[算法验证]----通过";
				AutoTest.GLog.logRecord(9, "材料退货单", "res", AutoTest.GParam.gRes, 5000, 0, 0, "", "微软雅黑", 20, AutoTest.GParam.GREEN_PASS);
			}else {
				pData.bRES = false;
				AutoTest.GParam.strTestResultCode = "9999";
				AutoTest.GParam.strTestResultMsg = "ERROR";
				AutoTest.GParam.gRes = "[算法]成本金额=退货含税单价/(1+税率)*100%*退货数量*100%" + 
						"\n[成本金额]:" + TestCompare + "\n[算法验证]----未通过";
				AutoTest.GLog.logRecord(9, "材料退货单", "res", AutoTest.GParam.gRes, 5000, 0, 0, "", "微软雅黑", 20, Color.RED);
			}
			
			GWCtrlFrame.ui_C_SWITCN_DEFAULT();
			
			GLog.logRecordTime(9, "[算法校验]----成功");
		}catch (Exception e){
			GLog.logRecordTime(9, "[算法校验]----失败");
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
					GWCtrlTopTab.ui_C_CLOSE_TOPTAB(pData.pageREQ.MODULE_NAME_NEW + pData.pageREQ.mapDynamicData.get("材料退货单-单据编号"));
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
