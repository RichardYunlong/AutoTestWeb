package User.Material.LeaseEntryNew;

import java.util.HashMap;
import java.util.Map;

import AutoTestScene.GScene;
import AutoTestWeb.GWCtrlGrid3;
import AutoTestWeb.GWCtrlMainPage;
import AutoTestWeb.GWCtrlWebElementId;

/**
 *  租赁周转材料进场单-详情区-页面数据
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
		pageREQ = new GWCtrlMainPage("租赁周转材料进场单");
		//顶层菜单
		pageREQ.mapTopMenuBtnId.put("新建", "btnNew");
		pageREQ.mapTopMenuBtnId.put("编辑", "btnModify");
		pageREQ.mapTopMenuBtnId.put("删除", "btnDelete");
		pageREQ.mapTopMenuBtnId.put("保存", "btnSave");
		pageREQ.mapTopMenuBtnId.put("放弃", "btGiveup");
		pageREQ.mapTopMenuBtnId.put("提交", "btnSubmit");
		//单据页签
		pageREQ.mapTopTabId.put("基本信息", "detialTabView__detialTabView_tab");
		pageREQ.mapTopTabId.put("材料明细", "detialTabView__name_1137490801");
		pageREQ.mapTopTabId.put("费用明细", "detialTabView__name_1484762961");
		pageREQ.mapTopTabId.put("附件信息", "detialTabView__detialTabView_tabAttach");
		//二级窗体页签
		pageREQ.mapTopTabId.put("外部单位", "tabView__UnittabView_tab");
		pageREQ.mapTopTabId.put("内部单位", "tabView__OrgtabView_tab");
		//单据菜单
		pageREQ.mapTopTabId.put("选择合同材料", "btnSelectHTCL");
		pageREQ.mapTopTabId.put("批量设置换算单位", "BtnDWHS");
		//基本信息
		pageREQ.mapContentId.put("进场日期", "Efd_JCRQ");
		pageREQ.mapContentId.put("合同编号", "Efd_HT_Code");
		pageREQ.mapContentId.put("合同名称", "Efd_HT_Name");
		pageREQ.mapContentId.put("点出单位", "Efd_DCDW_Name");
		pageREQ.mapContentId.put("备注", "Efd_evRemark_Remark");
		//材料明细
		pageREQ.mapContentId.put("使用单位", "gvCLMX_col_SYDW_editor");
		//等待标签
		pageREQ.MODULE_WAIT_ID = GWCtrlWebElementId.CN_ID.get("材料明细");
		
		strDate = "2020-04-09";
		
		//动态参数
		pageREQ.mapDynamicData.put("租赁周转材料进场单-单据编号", "");
		pageREQ.mapDynamicData.put("租赁周转材料进场单-供应商", GScene.DYNAMIC_DATA.get("租赁周转材料进场单-供应商"));
		pageREQ.mapDynamicData.put("租赁周转材料进场单-使用单位", GScene.DYNAMIC_DATA.get("租赁周转材料进场单-使用单位"));
		pageREQ.mapDynamicData.put("租赁周转材料进场单-材料类型编码", GScene.DYNAMIC_DATA.get("租赁周转材料进场单-材料类型编码"));
		pageREQ.mapDynamicData.put("租赁周转材料进场单-材料编码", GScene.DYNAMIC_DATA.get("租赁周转材料进场单-材料编码"));
		pageREQ.mapDynamicData.put("周转材料租赁合同-单据编号", GScene.DYNAMIC_DATA.get("周转材料租赁合同-单据编号"));
	}
}
