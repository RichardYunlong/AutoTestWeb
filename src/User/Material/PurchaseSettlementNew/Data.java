package User.Material.PurchaseSettlementNew;

import java.util.HashMap;
import java.util.Map;

import AutoTestScene.GScene;
import AutoTestWeb.GWCtrlGrid3;
import AutoTestWeb.GWCtrlMainPage;
import AutoTestWeb.GWCtrlWebElementId;

/**
 * 材料采购结算单-详情区-数据
 * @author 赵君 2020.11.16 19:20:30
 */
public class Data {
	
	/**
	 *  页面驱动
	 */
	public GWCtrlMainPage pageREQ = null;
	
	/**
	 *  创建合同业务是否正常 默认为false
	 */
	public boolean bRES = false;
	
	/**
	 * 当前行号
	 */
	public Integer indexRows = 0;
	
	/**
	 * 每一种材料导入方式导入的材料对应的行号及元素
	 */
	public Map<String, Integer> indexRowsMaterial = new HashMap<String, Integer>();

	/**
	 *  单据状态 默认为未知
	 */
	public String strStatus = "未知";
	
	/**
	 *  自定义计划时间
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
		pageREQ = new GWCtrlMainPage("材料采购结算单");
		//顶层菜单
		pageREQ.mapTopMenuBtnId.put("新建", "btnNew");
		pageREQ.mapTopMenuBtnId.put("编辑", "btnModify");
		pageREQ.mapTopMenuBtnId.put("删除", "btnDelete");
		pageREQ.mapTopMenuBtnId.put("保存", "btnSave");
		pageREQ.mapTopMenuBtnId.put("放弃", "btGiveup");
		pageREQ.mapTopMenuBtnId.put("提交", "btnSubmit");
		//单据页签
		pageREQ.mapTopTabId.put("基本信息", "detialTabView__detialTabView_tab");
		pageREQ.mapTopTabId.put("单据明细", "detialTabView__detialTabView_tabDJMX");
		pageREQ.mapTopTabId.put("材料明细", "detialTabView__detialTabView_tabCLMX");
		pageREQ.mapTopTabId.put("批次明细", "detialTabView__detialTabView_tabCLPCMX");
		pageREQ.mapTopTabId.put("其他费用", "detialTabView__detialTabView_tabQTFY");
		pageREQ.mapTopTabId.put("附件信息", "detialTabView__detialTabView_tabAttach");	
		//二级窗体页签
		pageREQ.mapTopTabId.put("外部单位", "tabView__UnittabView_tab");
		pageREQ.mapTopTabId.put("内部单位", "tabView__OrgtabView_tab");
		//单据菜单
		pageREQ.mapTopTabId.put("新增费用项", "btnNew_QTFY");
		//基本信息
		pageREQ.mapContentId.put("结算日期", "Efd_BizDate");
		pageREQ.mapContentId.put("供应商", "Efd_HZHB_Name");
		pageREQ.mapContentId.put("备注", "Efd_evRemark_Remark");
		//单据明细
		pageREQ.mapTopTabId.put("选择单据", "btnChooseDJ");
		//材料明细
		pageREQ.mapContentId.put("含税结算单价", "gvCLMX_col_HSJSDJ_editor");
		//费用项明细
		pageREQ.mapContentId.put("费用项名称", "gvQTFY_col_FYXMC_editor");
		pageREQ.mapContentId.put("含税单价", "gvQTFY_col_HSDJ_editor");
		pageREQ.mapContentId.put("数量", "gvQTFY_col_SL_editor");
		pageREQ.mapContentId.put("税率", "gvQTFY_col_TaxRatio_editor");
		//等待标签
		pageREQ.MODULE_WAIT_ID = GWCtrlWebElementId.CN_ID.get("其他费用");
		//日期
		strDate = "2020-04-09";
		//动态参数
		pageREQ.mapDynamicData.put("材料采购结算单-供应商", GScene.DYNAMIC_DATA.get("材料采购结算单-供应商"));
		pageREQ.mapDynamicData.put("材料采购结算单-材料明细-含税结算单价", GScene.DYNAMIC_DATA.get("材料采购结算单-材料明细-含税结算单价"));
		pageREQ.mapDynamicData.put("材料采购结算单-材料明细-结算数量", GScene.DYNAMIC_DATA.get("材料采购结算单-材料明细-结算数量"));
		pageREQ.mapDynamicData.put("材料采购结算单-材料明细-税率(%)", GScene.DYNAMIC_DATA.get("材料采购结算单-材料明细-税率(%)"));
		pageREQ.mapDynamicData.put("材料采购结算单-单据编号", "");
		pageREQ.mapDynamicData.put("材料入库单-单据编号", GScene.DYNAMIC_DATA.get("材料入库单-单据编号"));
	}
}
