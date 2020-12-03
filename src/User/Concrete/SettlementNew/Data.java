package User.Concrete.SettlementNew;

import java.util.HashMap;
import java.util.Map;

import AutoTestScene.GScene;
import AutoTestWeb.GWCtrlGrid3;
import AutoTestWeb.GWCtrlMainPage;

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
		pageREQ = new GWCtrlMainPage("商品混凝土结算单");
		//顶层菜单
		pageREQ.mapTopMenuBtnId.put("新建", "btnNew");
		pageREQ.mapTopMenuBtnId.put("复制", "btnCopy");
		pageREQ.mapTopMenuBtnId.put("编辑", "btnModify");
		pageREQ.mapTopMenuBtnId.put("删除", "btnDelete");
		pageREQ.mapTopMenuBtnId.put("保存", "btnSave");
		pageREQ.mapTopMenuBtnId.put("放弃", "btGiveup");
		pageREQ.mapTopMenuBtnId.put("提交", "btnSubmit");
		//单据页签
        pageREQ.mapTopTabId.put("基本信息", "detialTabView__detialTabView_tab");
        pageREQ.mapTopTabId.put("商砼对账单明细", "detialTabView__detialTabView_tabDZDMX");
        pageREQ.mapTopTabId.put("商砼小票明细", "detialTabView__detialTabView_tabXPMX");
        pageREQ.mapTopTabId.put("商砼明细", "detialTabView__detialTabView_tabSTMX");
        pageREQ.mapTopTabId.put("附件信息", "detialTabView__detialTabView_tabAttach");
		//二级窗体页签
		pageREQ.mapTopTabId.put("外部单位", "tabView__UnittabView_tab");
		pageREQ.mapTopTabId.put("内部单位", "tabView__OrgtabView_tab");
		//单据菜单
		pageREQ.mapTopTabId.put("选择单据", "btnXZDZD");
		pageREQ.mapTopTabId.put("删除单据", "btnSCDJ");
		pageREQ.mapTopTabId.put("导出", "btnactExportExcelFromPage");
		//基本信息
		pageREQ.mapContentId.put("单据编号", "Efd_Code");
	    pageREQ.mapContentId.put("使用对账单", "Efd_SYDZD");
		pageREQ.mapContentId.put("入库日期", "Efd_BizDate");
		pageREQ.mapContentId.put("库房", "Efd_KFZD_Name");
		pageREQ.mapContentId.put("材料类别", "Efd_CLLB_Name");
		pageREQ.mapContentId.put("供应类型", "Efd_GYLX");
		pageREQ.mapContentId.put("供应商", "Efd_GYS_Name");
		pageREQ.mapContentId.put("合同编号", "Efd_HT_Code");
		pageREQ.mapContentId.put("合同名称", "Efd_HT_Name");
		pageREQ.mapContentId.put("付款方式", "Efd_FKFS");
		pageREQ.mapContentId.put("经办人", "Efd_JBR");
		pageREQ.mapContentId.put("原始票号", "Efd_YSPH");
		pageREQ.mapContentId.put("税率", "Efd_TaxRatio");
		pageREQ.mapContentId.put("备注", "Efd_evRemark_Remark");
		//等待标签
		pageREQ.MODULE_WAIT_ID = "detialTabView";
		//日期
		strDate = "2020-11-11";
		//动态数据
        pageREQ.mapDynamicData.put("商品混凝土供应合同-单据编号", GScene.DYNAMIC_DATA.get("商品混凝土供应合同-单据编号"));
        pageREQ.mapDynamicData.put("商品混凝土小票-单据编号", GScene.DYNAMIC_DATA.get("商品混凝土小票-单据编号"));
        pageREQ.mapDynamicData.put("商品混凝土对账单-单据编号", GScene.DYNAMIC_DATA.get("商品混凝土对账单-单据编号"));
        pageREQ.mapDynamicData.put("商品混凝土结算单-单据编号", "");
	}
}
