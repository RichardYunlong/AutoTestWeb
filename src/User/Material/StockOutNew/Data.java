package User.Material.StockOutNew;

import java.util.HashMap;
import java.util.Map;

import AutoTestScene.GScene;
import AutoTestWeb.GWCtrlGrid3;
import AutoTestWeb.GWCtrlMainPage;
import AutoTestWeb.GWCtrlWebElementId;

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
	      *  参考数据来源
     */
    public String referType = "";
    
    /**
             *  参考单据编号
     */
    public String billCode = "";
	
	/**
	 * 当前行号
	 */
	public Integer indexRows = 0;
	
	/**
	 * 每一种材料导入方式导入的材料对应的行号及元素
	 */
	public Map<String, Integer> indexRowsMaterial = new HashMap<String, Integer>();
	
	/**
	 *  到货点验单状态 默认为未知
	 */
	public String strStatus = "未知";
	
	/**
	 *  自定义到货时间
	 */
	public String strDate = "今天";
	
	/**
	 *  材料明细
	 */
	public GWCtrlGrid3 gvGrid3 = null;
	
	/**
	 *  初始化版式信息
	 */
	public Data() {
	    
		
		//构造一个临时驱动
		pageREQ = new GWCtrlMainPage("材料出库单");
		//顶层菜单
		pageREQ.mapTopMenuBtnId.put("新建", "btnNew");
		pageREQ.mapTopMenuBtnId.put("编辑", "btnModify");
		pageREQ.mapTopMenuBtnId.put("删除", "btnDelete");
		pageREQ.mapTopMenuBtnId.put("保存", "btnSave");
		pageREQ.mapTopMenuBtnId.put("放弃", "btGiveup");
		pageREQ.mapTopMenuBtnId.put("提交", "btnSubmit");
		//单据页签
		pageREQ.mapTopTabId.put("基本信息", "detialTabView__detialTabView_tab");
		pageREQ.mapTopTabId.put("材料明细", "detialTabView__name_CLMX");
		pageREQ.mapTopTabId.put("材料批次明细", "detialTabView__name_CLPCMX");
		pageREQ.mapTopTabId.put("附件信息", "detialTabView__detialTabView_tabAttach");
		//二级窗体页签
		pageREQ.mapTopTabId.put("外部单位", "tabView__UnittabView_tab");
		pageREQ.mapTopTabId.put("内部单位", "tabView__OrgtabView_tab");
		//单据菜单
		pageREQ.mapTopTabId.put("选择在库材料", "btnSelectZKCL");
		//基本信息
		pageREQ.mapContentId.put("单据编号", "Efd_Code");
		pageREQ.mapContentId.put("出库日期", "Efd_BizDate");
		pageREQ.mapContentId.put("库房", "Efd_KFZD_Name");
		pageREQ.mapContentId.put("材料类别", "Efd_CLLB_Name");
		pageREQ.mapContentId.put("领料单位", "Efd_LLDW_Name");
		pageREQ.mapContentId.put("领料人", "Efd_LLR");
		pageREQ.mapContentId.put("计价方式", "Efd_JJFS");
		pageREQ.mapContentId.put("混凝土原材料不进成本", "Efd_HNTYCBJCB");
		pageREQ.mapContentId.put("备注", "Efd_evRemark_Remark");
		//材料明细
		pageREQ.mapContentId.put("出库数量", "gvCLMX_col_SL_editor");
		//等待标签
		pageREQ.MODULE_WAIT_ID = GWCtrlWebElementId.CN_ID.get("材料明细");
		//日期
		strDate = "2020-04-09";
		//动态数据
		pageREQ.mapDynamicData.put("材料出库单-供应商", GScene.DYNAMIC_DATA.get("材料出库单-供应商"));
		pageREQ.mapDynamicData.put("材料出库单-领料单位", GScene.DYNAMIC_DATA.get("材料出库单-领料单位"));
		pageREQ.mapDynamicData.put("材料出库单-材料编码", GScene.DYNAMIC_DATA.get("材料出库单-材料编码"));
		pageREQ.mapDynamicData.put("材料出库单-材料明细-数量", GScene.DYNAMIC_DATA.get("材料出库单-材料明细-数量"));
		pageREQ.mapDynamicData.put("材料入库单-单据编号", GScene.DYNAMIC_DATA.get("材料入库单-单据编号"));
		pageREQ.mapDynamicData.put("材料出库单-单据编号", "");
	}
}