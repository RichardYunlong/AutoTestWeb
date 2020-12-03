package User.Concrete.PurchaseNew;

import java.util.HashMap;
import java.util.Map;

import AutoTestScene.GScene;
import AutoTestWeb.GWCtrlGrid3;
import AutoTestWeb.GWCtrlMainPage;
import AutoTestWeb.GWCtrlWebElementId;

/**
 * 
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
	 *  合同状态 默认为未知
	 */
	public String strStatus = "未知";
	
	/**
	 *  自定义合同签署时间
	 */
	public String strDate = "今天";
	
	/**
	 *  商砼明细
	 */
	public GWCtrlGrid3 gvGrid3 = null;
	
	/**
	 *  初始化
	 */
	public Data() {
		
		//构造一个临时驱动
		pageREQ = new GWCtrlMainPage("商品混凝土供应合同");
		//顶层菜单
		pageREQ.mapTopMenuBtnId.put("新建合同","");
		pageREQ.mapTopMenuBtnId.put("新建变更","");
		pageREQ.mapTopMenuBtnId.put("编辑", "btnModify");
		pageREQ.mapTopMenuBtnId.put("删除", "");
		pageREQ.mapTopMenuBtnId.put("保存", "btnSave");
		pageREQ.mapTopMenuBtnId.put("放弃", "");
		pageREQ.mapTopMenuBtnId.put("提交", "btnSubmit");
		pageREQ.mapTopMenuBtnId.put("共享", "");
		//单据页签
		pageREQ.mapTopTabId.put("基本信息", "detialTabView__detialTabView_tab");
		pageREQ.mapTopTabId.put("商砼明细", "detialTabView__detailTabView_tabStmx");
		pageREQ.mapTopTabId.put("附加费明细", "detialTabView__detailTableView_tabFJF");
		pageREQ.mapTopTabId.put("合同条款摘要", "detialTabView__detialTabView_tabHttkzy");
		pageREQ.mapTopTabId.put("合同支付计划", "detialTabView__detialTabView_tabHtzfjh");
		pageREQ.mapTopTabId.put("附件信息", "detialTabView__detialTabView_tabAttach");
		//二级窗体页签
		pageREQ.mapTopTabId.put("外部单位", "tabView__UnittabView_tab");
		pageREQ.mapTopTabId.put("内部单位", "tabView__OrgtabView_tab");
		//单据菜单
		pageREQ.mapTopTabId.put("选择字典材料", "btnImportMaterial");
		pageREQ.mapTopTabId.put("选择材料类别", "btnSelectCLLB");
		pageREQ.mapTopTabId.put("参考", "btnRefer");
		pageREQ.mapTopTabId.put("参考采购计划", "x-menu-el-actReferenceCGJH_menu");
		pageREQ.mapTopTabId.put("参考需用计划", "x-menu-el-actRefXYJH_menu");
		pageREQ.mapTopTabId.put("参考总量计划", "x-menu-el-actRefZLJH_menu");
		pageREQ.mapTopTabId.put("参考部位计划", "x-menu-el-actRefBWJH_menu");
		pageREQ.mapTopTabId.put("参考目标责任成本", "x-menu-el-actRefMBZRCB_menu");														
		//基本信息
		pageREQ.mapContentId.put("合同编号", "Efd_Code");
		pageREQ.mapContentId.put("签约日期", "Efd_BizDate");
		pageREQ.mapContentId.put("乙方", "Efd_YF_Name");
		pageREQ.mapContentId.put("甲方", "Efd_JF_Name");
		pageREQ.mapContentId.put("合同名称", "Efd_Name");
	    pageREQ.mapContentId.put("税率(%)", "Efd_TaxRatio");
		
		//商砼明细
		pageREQ.mapContentId.put("含税供应单价", "gvSTMX_col_DJ_editor");
		pageREQ.mapContentId.put("供应数量", "gvSTMX_col_SL_editor");
		//等待标签
		pageREQ.MODULE_WAIT_ID = GWCtrlWebElementId.CN_ID.get("商砼明细");
		//日期
		strDate = "2020-11-10";
		//动态参数
		pageREQ.mapDynamicData.put("商品混凝土供应合同-甲方", GScene.DYNAMIC_DATA.get("商品混凝土供应合同-甲方"));
		pageREQ.mapDynamicData.put("商品混凝土供应合同-乙方", GScene.DYNAMIC_DATA.get("商品混凝土供应合同-乙方"));
		pageREQ.mapDynamicData.put("商品混凝土供应合同-商砼明细-含税单价", GScene.DYNAMIC_DATA.get("商品混凝土供应合同-商砼明细-含税单价"));
		pageREQ.mapDynamicData.put("商品混凝土供应合同-商砼明细-数量", GScene.DYNAMIC_DATA.get("商品混凝土供应合同-商砼明细-数量"));
		pageREQ.mapDynamicData.put("商品混凝土供应合同-商砼明细-税率(%)", GScene.DYNAMIC_DATA.get("商品混凝土供应合同-商砼明细-税率(%)"));
		pageREQ.mapDynamicData.put("材料需用计划-单据编号", GScene.DYNAMIC_DATA.get("材料需用计划-单据编号"));
		pageREQ.mapDynamicData.put("商品混凝土供应合同-单据编号", "");
		pageREQ.mapDynamicData.put("商品混凝土供应合同-合同名称", "");
	}
}
