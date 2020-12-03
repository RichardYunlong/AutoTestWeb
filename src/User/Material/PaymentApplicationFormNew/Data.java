package User.Material.PaymentApplicationFormNew;

import java.util.HashMap;
import java.util.Map;

import AutoTestScene.GScene;
import AutoTestWeb.GWCtrlGrid3;
import AutoTestWeb.GWCtrlMainPage;
import AutoTestWeb.GWCtrlWebElementId;

/**
 *  材料付款申请单-详情区-页面数据
 *  
 *  @author 赵君 2020.11.23 19:55:28
 */
public class Data {
	
	/**
	 *  页面驱动
	 */
	public GWCtrlMainPage pageREQ = null;	
	
	/**
	 *  业务是否正常 默认为false
	 */
	public boolean bRES = false;
	
	/**
	 * 当前行号
	 */
	public Integer indexRows = 0;
	
	/**
	 * 
	 */
	public Map<String, Integer> indexRowsMaterial = new HashMap<String, Integer>();
	
	/**
	 *  单据状态 默认为未知
	 */
	public String strStatus = "未知";
	
	/**
	 *  关键日期
	 */
	public String strDate = "今天";
	
	/**
	 *  材料明细
	 */
	public GWCtrlGrid3 gvGrid3 = null;
	
	/**
	 *  初始化
	 */
	public Data() {
		
		//构造一个临时驱动
		pageREQ = new GWCtrlMainPage("材料付款申请单");
		//顶层菜单
		pageREQ.mapTopMenuBtnId.put("新建", "btnNew");
		pageREQ.mapTopMenuBtnId.put("编辑", "btnModify");
		pageREQ.mapTopMenuBtnId.put("删除", "btnDelete");
		pageREQ.mapTopMenuBtnId.put("保存", "btnSave");
		pageREQ.mapTopMenuBtnId.put("放弃", "btGiveup");
		pageREQ.mapTopMenuBtnId.put("提交", "btnSubmit");
		//单据页签
		pageREQ.mapTopTabId.put("基本信息", "detialTabView__detialTabView_tab");
		pageREQ.mapTopTabId.put("结算明细", "detialTabView__detialTabView_tabJSMX");
		pageREQ.mapTopTabId.put("发票明细", "detialTabView__detialTabView_tabFPMX");
		pageREQ.mapTopTabId.put("申请说明", "detialTabView__detialTabView_tabSQSM");
		pageREQ.mapTopTabId.put("附件信息", "detialTabView__detialTabView_tabAttach");
		//基本信息
		pageREQ.mapContentId.put("申请日期", "Efd_SQRQ");
		pageREQ.mapContentId.put("收款单位", "Efd_HZHB_Name");
		pageREQ.mapContentId.put("备注", "Efd_evRemark_Remark");
		//二级窗体页签
		pageREQ.mapTopTabId.put("外部单位", "tabView__UnittabView_tab");
		pageREQ.mapTopTabId.put("内部单位", "tabView__OrgtabView_tab");
		//等待标签
		pageREQ.MODULE_WAIT_ID = GWCtrlWebElementId.CN_ID.get("基本信息");
		
		strDate = "2020-04-09";
		
		//动态参数
		pageREQ.mapDynamicData.put("材料付款申请单-收款单位", GScene.DYNAMIC_DATA.get("材料付款申请单-收款单位"));
		pageREQ.mapDynamicData.put("材料付款申请单-单据编号", GScene.DYNAMIC_DATA.get("材料付款申请单-单据编号"));
	}
}
