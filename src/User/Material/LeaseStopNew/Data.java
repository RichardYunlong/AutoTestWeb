package User.Material.LeaseStopNew;

import java.util.HashMap;
import java.util.Map;

import AutoTestScene.GScene;
import AutoTestWeb.GWCtrlGrid3;
import AutoTestWeb.GWCtrlMainPage;
import AutoTestWeb.GWCtrlWebElementId;

/**
 *  租赁周转材料停租单-详情区-页面数据
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
		pageREQ = new GWCtrlMainPage("租赁周转材料停租单");
		//顶层菜单
		pageREQ.mapTopMenuBtnId.put("新建", "btnNew");
		pageREQ.mapTopMenuBtnId.put("编辑", "btnModify");
		pageREQ.mapTopMenuBtnId.put("删除", "btnDelete");
		pageREQ.mapTopMenuBtnId.put("保存", "btnSave");
		pageREQ.mapTopMenuBtnId.put("放弃", "btGiveup");
		pageREQ.mapTopMenuBtnId.put("提交", "btnSubmit");
		//单据页签
		pageREQ.mapTopTabId.put("基本信息", "detialTabView__detialTabView_tab");
		pageREQ.mapTopTabId.put("材料明细", "detialTabView__name_246048817");
		pageREQ.mapTopTabId.put("材料汇总", "detialTabView__detialTabView_CLHZ");
		pageREQ.mapTopTabId.put("附件信息", "detialTabView__detialTabView_tabAttach");
		//二级窗体页签
		pageREQ.mapTopTabId.put("外部单位", "tabView__UnittabView_tab");
		pageREQ.mapTopTabId.put("内部单位", "tabView__OrgtabView_tab");
		//单据菜单
		pageREQ.mapTopTabId.put("选择在场材料", "btnSelectZCCL");
		pageREQ.mapTopTabId.put("批量设置换算单位", "BtnDWHS");
		//基本信息
		pageREQ.mapContentId.put("合同编号", "Efd_HT_Code");
		pageREQ.mapContentId.put("供应商", "Efd_GYS_Name");
		pageREQ.mapContentId.put("合同名称", "Efd_HT_Name");
		pageREQ.mapContentId.put("备注", "Efd_evRemark_Remark");
		//材料明细
		pageREQ.mapContentId.put("含税停租单价", "gvCLMX_col_HSTZDJ_editor");
		pageREQ.mapContentId.put("停租数量", "gvCLMX_col_TZSL_editor");
		//等待标签
		pageREQ.MODULE_WAIT_ID = GWCtrlWebElementId.CN_ID.get("材料明细");
		
		strDate = "2020-04-09";
		
		//动态参数
		pageREQ.mapDynamicData.put("租赁周转材料停租单-合同编号", GScene.DYNAMIC_DATA.get("周转材料租赁合同-单据编号"));
		pageREQ.mapDynamicData.put("租赁周转材料停租单-供应商", GScene.DYNAMIC_DATA.get("租赁周转材料停租单-供应商"));
		pageREQ.mapDynamicData.put("租赁周转材料停租单-使用单位", GScene.DYNAMIC_DATA.get("租赁周转材料停租单-使用单位"));
		pageREQ.mapDynamicData.put("租赁周转材料停租单-材料类型编码", GScene.DYNAMIC_DATA.get("租赁周转材料停租单-材料类型编码"));
		pageREQ.mapDynamicData.put("租赁周转材料停租单-材料编码", GScene.DYNAMIC_DATA.get("租赁周转材料停租单-材料编码"));
		pageREQ.mapDynamicData.put("租赁周转材料停租单-停租单价", GScene.DYNAMIC_DATA.get("租赁周转材料停租单-停租单价"));
		pageREQ.mapDynamicData.put("租赁周转材料停租单-停租数量", GScene.DYNAMIC_DATA.get("租赁周转材料停租单-停租数量"));
		pageREQ.mapDynamicData.put("租赁周转材料停租单-单据编号", "");
	}
}
