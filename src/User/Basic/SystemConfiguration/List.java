package User.Basic.SystemConfiguration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import AutoTest.GException;
import AutoTest.GLog;
import AutoTest.GTestCase;
import AutoTest.GText;
import AutoTestWeb.GParam;
import AutoTestWeb.GWCtrlDivClick;
import AutoTestWeb.GWCtrlFrame;
import AutoTestWeb.GWCtrlLeftMenu;
import AutoTestWeb.GWCtrlList;
import AutoTestWeb.GWCtrlWebElementIframe;
import io.qameta.allure.Step;

/**
 *  机构参数设置
 */
public class List {
	
	/**
	 *  数据
	 */
	private Data pData = null;

	/**
	 *  设置机构参数值
	 */
	@Step("设置结构参数值")
	public void ui_G_NEW(String catalog,String type,String parameter,String value) {
		ui_D_INIT();
		ui_C_TREE_MODULE();
		ui_C_SYSTEM_SETTINGS(catalog,type,parameter,value);
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
	 * 修改指定机构参数的参数值
	 * 
	 * @param catalog 参数所属业务口
	 * @param type 参数类型：业务参数、管控参数
	 * @param parameter 参数名
	 * @param value 参数值
	 */
	@Step("修改指定机构参数的参数值")
	public void ui_C_SYSTEM_SETTINGS(String catalog,String type,String parameter,String value) {
		GLog.logRecordTime(9, "[功能]----设置[" + catalog + "]"+"下的["+type+"]参数值");
		try {
			GWCtrlFrame.ui_C_SWITCN_ELEMENT(GWCtrlWebElementIframe.getIframe(1));
			//获取所有参数目录及参数类型列表
			java.util.List<WebElement> divs = null;
			WebElement dictView = GParam.g_Dr.findElement(By.id(pData.pageREQ.MODULE_WAIT_ID));
			divs = dictView.findElements(By.cssSelector(GText.getCssSelectorTxt("div", "class", "x-grid3-cell-inner x-grid3-col-col_Name")));
			//定义一个变量存储指定目录业务口索引
			int catalogAt = 0;
			
			//从已知列表中获取指定业务口索引
			if(divs != null && divs.size() != 0) {
				for(WebElement div:divs){
					if(div.getText().equals(catalog)) {
						catalogAt = divs.indexOf(div);
						GLog.logRecordTime(9, "找到目标业务口目录[" + catalog + "]了");
						break;
					}
				}
				
				if(catalogAt != -1) {
					//业务口目录后紧跟的【第一个】或【第一个和第二个】元素即为该业务口的参数类型（有两个类型都有的，也有只有一个类型的）
					if(divs.get(catalogAt + 1).getText().equals(type)) {
						//选中参数类型后设置指定参数的参数值
						divs.get(catalogAt + 1).click();
						ui_C_SETTINGVALUE(parameter,value);
					}else if(divs.get(catalogAt + 2).getText().equals(type)){
						//选中参数类型后设置指定参数的参数值
						divs.get(catalogAt + 2).click();
						ui_C_SETTINGVALUE(parameter,value);
					}else {			
						GLog.logRecordTime(9, "目标业务口目录[" + catalog + "]下不存在"+ type +"类型参数");
					}
				}else {
					GLog.logRecordTime(9, "未找到目标业务口目录[" + catalog + "]");
				}
			}
			GWCtrlFrame.ui_C_SWITCN_DEFAULT();
			
			pData.bRES = true;
			AutoTest.GParam.strTestResultCode = "0000";
			AutoTest.GParam.strTestResultMsg = "OK";
		}catch(Exception e) {
			pData.bRES = false;
			AutoTest.GParam.strTestResultCode = "9999";
			AutoTest.GParam.strTestResultMsg = "ERROR";
			GLog.logRecordTime(9, "[功能]----设置[" + catalog + "]"+"下的["+type+"]参数值失败");
		}
		GTestCase.setTestCaseRst(pData.bRES);
	}
	
	/**
	 * 选中指定参数名称参数，并修改弹窗中的参数默认值
	 * 
	 * @param parameter 参数名
	 * @param value 参数值
	 */
	@Step("选中指定参数名称参数，并修改弹窗中的参数默认值")
	public void ui_C_SETTINGVALUE(String parameter,String value) {
		GLog.logRecordTime(9, "[功能]----选中并修改" + parameter + "参数值");
		try {
			//搜索
			GWCtrlList list = new GWCtrlList("id", pData.pageREQ.mapTopTabId.get("参数列表区域"));
			list.ui_C_SEARCH_NAME(parameter);
			
			//获取右侧参数列表并修改指定参数参数值
			java.util.List<WebElement> divs = null;
			WebElement settingList = GParam.g_Dr.findElement(By.id(pData.pageREQ.mapTopTabId.get("参数列表区域")));
			divs = settingList.findElements(By.cssSelector(GText.getCssSelectorTxt("div", "class", "x-grid3-cell-inner x-grid3-col-col_Name x-unselectable")));
			if(divs != null && divs.size() != 0) {
				for(WebElement div:divs){
					if(div.getText().equals(parameter)) {
						div.click();
						//修改参数值
						ui_C_FILL_VALUE(value);
						GLog.logRecordTime(9, "修改了目标参数[" + parameter + "]参数值");
						break;
					}else {
						GLog.logRecordTime(9, "未找到目标参数[" + parameter + "]");
					}
				}
			}
			
		}catch(Exception e) {
			GLog.logRecordTime(9, "[功能]----选中并修改" + parameter + "参数值失败");
		}
	}
	
	/**
	 * 填写机构参数的参数值
	 * 
	 * @param value 参数值
	 */
	@Step("填写机构参数的参数值")
	public void ui_C_FILL_VALUE(String value) {
		GLog.logRecordTime(9, "[功能]----填写参数值");
		try {
			//点击参数设置弹窗参数值字段下拉按钮
			WebElement settingList = GParam.g_Dr.findElement(By.id(pData.pageREQ.mapTopTabId.get("编辑弹窗")));
			settingList.findElement(By.cssSelector(GText.getCssSelectorTxt("img", "class", "x-form-trigger x-form-arrow-trigger"))).click();
			//选中下拉菜单中指定的参数值
			WebElement dropList = GParam.g_Dr.findElement(By.cssSelector(GText.getCssSelectorTxt("div", "class", "x-combo-list-inner")));
			//方法待审核，因不能使用select类相关方法，此处使用了xpath定位
			dropList.findElement(By.xpath("div[text()='"+value+"']")).click();
			//保存
			GWCtrlDivClick.ByIdClick("btnSaveAndCloseSZ");
			GLog.logRecordTime(9, "[功能]----填写参数值成功");
		}catch(Exception e) {
			GLog.logRecordTime(9, "[功能]----填写参数值失败");
		}
	}
	
}