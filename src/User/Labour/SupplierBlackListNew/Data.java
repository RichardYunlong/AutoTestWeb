package User.Labour.SupplierBlackListNew;

import java.util.HashMap;
import java.util.Map;

import AutoTestScene.GScene;
import AutoTestWeb.GWCtrlGrid3;
import AutoTestWeb.GWCtrlMainPage;

/**
 * 
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
		pageREQ = new GWCtrlMainPage("劳务分包商黑名单");
		//顶层菜单
		pageREQ.mapTopMenuBtnId.put("新建", "btnNew");
		pageREQ.mapTopMenuBtnId.put("编辑", "btnModify");
		pageREQ.mapTopMenuBtnId.put("删除", "btnDelete");
		pageREQ.mapTopMenuBtnId.put("保存", "btnSave");
		pageREQ.mapTopMenuBtnId.put("放弃", "btGiveup");
		pageREQ.mapTopMenuBtnId.put("提交", "btnSubmit");
	    pageREQ.mapTopMenuBtnId.put("加入黑名单", "btnAddBlacklist");
		
		
		//单据页签
		pageREQ.mapTopTabId.put("基本信息", "detialTabView__detialTabView_tab");
		pageREQ.mapTopTabId.put("银行信息", "detialTabView__detialTabView_YHXX");
		pageREQ.mapTopTabId.put("评价信息", "detialTabView__detialTabView_PJXX");
		pageREQ.mapTopTabId.put("企业资质", "detialTabView__detialTabView_QYZZ");
		pageREQ.mapTopTabId.put("参与我司项目", "detialTabView__detialTabView_CYWSXM");
		pageREQ.mapTopTabId.put("不良记录", "detialTabView__detialTabView_BLJL");
		pageREQ.mapTopTabId.put("所属类别", "detialTabView__detialTabView_SSLB");
		pageREQ.mapTopTabId.put("附件信息", "detialTabView__detialTabView_tabAttach");
		//基本信息
		pageREQ.mapContentId.put("供应商编码", "Efd_Code");
		pageREQ.mapContentId.put("分包商名称", "Efd_Name");
	    pageREQ.mapContentId.put("队长姓名", "Efd_LXRXM");
		
		pageREQ.mapContentId.put("备注", "Efd_evRemark_Remark");
		
		//日期
		strDate = "2020-04-09";
		
		//动态参数
		pageREQ.mapDynamicData.put("劳务分包商黑名单-分包商编码", "");
		pageREQ.mapDynamicData.put("劳务分包商黑名单-分包商名称", "");
//	    pageREQ.mapDynamicData.put("劳务分包商名录-分包商编码", "GATJT-LWFBSML-202011-0001");
//	    pageREQ.mapDynamicData.put("劳务分包商类别-类别编码", "LWFBS");
	    
	    pageREQ.mapDynamicData.put("劳务分包商名录-分包商编码", GScene.DYNAMIC_DATA.get("劳务分包商名录-分包商编码"));
        pageREQ.mapDynamicData.put("劳务分包商类别-类别编码", GScene.DYNAMIC_DATA.get("劳务分包商类别-类别编码"));
		
	}
}
