package User.Material.LeaseContractNew;

import java.util.HashMap;
import java.util.Map;

import AutoTestScene.GScene;
import AutoTestWeb.GWCtrlGrid3;
import AutoTestWeb.GWCtrlMainPage;
import AutoTestWeb.GWCtrlWebElementId;

/**
 *  周转材料租赁计划-详情区-页面数据
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
		pageREQ = new GWCtrlMainPage("周转材料租赁合同");
		//顶层菜单
		pageREQ.mapTopMenuBtnId.put("新建", "btnNew");
		pageREQ.mapTopMenuBtnId.put("编辑", "btnModify");
		pageREQ.mapTopMenuBtnId.put("删除", "btnDelete");
		pageREQ.mapTopMenuBtnId.put("保存", "btnSave");
		pageREQ.mapTopMenuBtnId.put("放弃", "btGiveup");
		pageREQ.mapTopMenuBtnId.put("提交", "btnSubmit");
		//单据页签
		pageREQ.mapTopTabId.put("基本信息", "detialTabView__detialTabView_tab");
		pageREQ.mapTopTabId.put("日租明细", "detialTabView__detialTabView_tabRzmx");
		pageREQ.mapTopTabId.put("月租明细", "detialTabView__detialTabView_tabYzmx");
		pageREQ.mapTopTabId.put("工程量明细", "detialTabView__detialTabView_GCLMX");
		pageREQ.mapTopTabId.put("维修项明细", "detialTabView__detialTabView_tabWxxmx");
		pageREQ.mapTopTabId.put("其他费用", "detialTabView__detialTabView_tabQtfy");
		pageREQ.mapTopTabId.put("合同条款摘要", "detialTabView__detialTabView_tabHttkzy");
		pageREQ.mapTopTabId.put("合同支付计划", "detialTabView__detialTabView_tabHtzfjh");
		pageREQ.mapTopTabId.put("附件信息", "detialTabView__detialTabView_tabAttach");
		//二级窗体页签
		pageREQ.mapTopTabId.put("外部单位", "tabView__UnittabView_tab");
		pageREQ.mapTopTabId.put("内部单位", "tabView__OrgtabView_tab");
		//单据菜单
		pageREQ.mapTopTabId.put("选择字典材料", "btnImportMaterial_RZMX");
		pageREQ.mapTopTabId.put("参考周转材料租赁计划", "btnreferenceZZCLZLJH_RZMX");
		pageREQ.mapTopTabId.put("批量设置单价", "BtnRZDJ");
		//基本信息
		pageREQ.mapContentId.put("合同名称", "Efd_Name");
		pageREQ.mapContentId.put("甲方", "Efd_JF_Name");
		pageREQ.mapContentId.put("乙方", "Efd_YF_Name");
		pageREQ.mapContentId.put("计费方式", "Efd_JFFS");
		pageREQ.mapContentId.put("签约日期", "Efd_BizDate");
		pageREQ.mapContentId.put("备注", "Efd_evRemark_Remark");
		//材料明细
		pageREQ.mapContentId.put("日租明细", "gvRZMX");
		pageREQ.mapContentId.put("进场日期", "gvRZMX_col_JCRQ_HT_editor");
		pageREQ.mapContentId.put("出场日期", "gvRZMX_col_CCRQ_HT_editor");
		pageREQ.mapContentId.put("租赁天数", "gvRZMX_col_ZLTS_HT_editor");
		pageREQ.mapContentId.put("含税日租单价", "gvRZMX_col_HSRZDJ_editor");
		pageREQ.mapContentId.put("含税停租单价", "gvRZMX_col_HSTZDJ_editor");
		pageREQ.mapContentId.put("含税赔偿单价", "gvRZMX_col_HSPCDJ_editor");
		pageREQ.mapContentId.put("数量", "gvRZMX_col_SL_HT_editor");
		pageREQ.mapContentId.put("税率", "gvRZMX_col_TaxRatio_editor");
		//等待标签
		pageREQ.MODULE_WAIT_ID = GWCtrlWebElementId.CN_ID.get("材料明细");
		
		strDate = "2020-04-09";
		
		//动态参数
		pageREQ.mapDynamicData.put("周转材料租赁合同-合同名称", GScene.DYNAMIC_DATA.get("周转材料租赁合同-合同名称"));
		pageREQ.mapDynamicData.put("周转材料租赁合同-甲方", GScene.DYNAMIC_DATA.get("周转材料租赁合同-甲方"));
		pageREQ.mapDynamicData.put("周转材料租赁合同-乙方", GScene.DYNAMIC_DATA.get("周转材料租赁合同-乙方"));
		pageREQ.mapDynamicData.put("周转材料租赁合同-计费方式", GScene.DYNAMIC_DATA.get("周转材料租赁合同-计费方式"));
		pageREQ.mapDynamicData.put("周转材料租赁合同-进场日期", GScene.DYNAMIC_DATA.get("周转材料租赁合同-进场日期"));
		pageREQ.mapDynamicData.put("周转材料租赁合同-出场日期", GScene.DYNAMIC_DATA.get("周转材料租赁合同-出场日期"));
		pageREQ.mapDynamicData.put("周转材料租赁合同-租赁天数", GScene.DYNAMIC_DATA.get("周转材料租赁合同-租赁天数"));
		pageREQ.mapDynamicData.put("周转材料租赁合同-含税日租单价", GScene.DYNAMIC_DATA.get("周转材料租赁合同-含税日租单价"));
		pageREQ.mapDynamicData.put("周转材料租赁合同-含税停租单价", GScene.DYNAMIC_DATA.get("周转材料租赁合同-含税停租单价"));
		pageREQ.mapDynamicData.put("周转材料租赁合同-含税赔偿单价", GScene.DYNAMIC_DATA.get("周转材料租赁合同-含税赔偿单价"));
		pageREQ.mapDynamicData.put("周转材料租赁合同-数量", GScene.DYNAMIC_DATA.get("周转材料租赁合同-数量"));
		pageREQ.mapDynamicData.put("周转材料租赁合同-税率", GScene.DYNAMIC_DATA.get("周转材料租赁合同-税率"));
		pageREQ.mapDynamicData.put("周转材料租赁合同-材料类型编码", GScene.DYNAMIC_DATA.get("周转材料租赁合同-材料类型编码"));
		pageREQ.mapDynamicData.put("周转材料租赁合同-材料编码", GScene.DYNAMIC_DATA.get("周转材料租赁合同-材料编码"));
		pageREQ.mapDynamicData.put("周转材料租赁计划-单据编号", GScene.DYNAMIC_DATA.get("周转材料租赁计划-单据编号"));
		pageREQ.mapDynamicData.put("周转材料租赁合同-单据编号", "");
	}
}
