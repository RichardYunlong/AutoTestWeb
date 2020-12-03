package User.Labour.SupplierCategoryNew;

import java.util.HashMap;
import java.util.Map;
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
		pageREQ = new GWCtrlMainPage("劳务分包商类别");
		//顶层菜单
		pageREQ.mapTopMenuBtnId.put("新建", "btnNew");
		pageREQ.mapTopMenuBtnId.put("编辑", "btnModify");
		pageREQ.mapTopMenuBtnId.put("删除", "btnDelete");
		pageREQ.mapTopMenuBtnId.put("保存", "btnSave");
		pageREQ.mapTopMenuBtnId.put("放弃", "btGiveup");
		pageREQ.mapTopMenuBtnId.put("提交", "btnSubmit");
	    pageREQ.mapTopMenuBtnId.put("加入黑名单", "btnAddBlacklist");
		
		//基本信息
		pageREQ.mapContentId.put("类别编码", "dictView_col_Code_editor");
		pageREQ.mapContentId.put("类别名称", "dictView_col_Name_editor");
	    pageREQ.mapContentId.put("备注", "dictView_col_Remark_editor");
		
		//日期
		strDate = "2020-11-19";
		
		//动态参数
		pageREQ.mapDynamicData.put("劳务分包商类别-类别编码", "");
		pageREQ.mapDynamicData.put("劳务分包商类别-类别名称", "");

		
	}
}
