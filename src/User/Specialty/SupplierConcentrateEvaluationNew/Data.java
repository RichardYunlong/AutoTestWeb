package User.Specialty.SupplierConcentrateEvaluationNew;

import java.util.HashMap;
import java.util.Map;

import AutoTestScene.GScene;
import AutoTestWeb.GWCtrlGrid3;
import AutoTestWeb.GWCtrlMainPage;

/**
 * 专业分包商集中评价
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
		pageREQ = new GWCtrlMainPage("专业分包商集中评价");
		//顶层菜单
		pageREQ.mapTopMenuBtnId.put("新建", "btnNew");
		pageREQ.mapTopMenuBtnId.put("编辑", "btnModify");
		pageREQ.mapTopMenuBtnId.put("删除", "btnDelete");
		pageREQ.mapTopMenuBtnId.put("保存", "btnSave");
		pageREQ.mapTopMenuBtnId.put("放弃", "btGiveup");
		pageREQ.mapTopMenuBtnId.put("提交", "btnSubmit");
		//单据页签
		pageREQ.mapTopTabId.put("基本信息", "detialTabView__detialTabView_tab");	
		pageREQ.mapTopTabId.put("分包商评价", "detialTabView__detailTabView_tabChildAssess");
		pageREQ.mapTopTabId.put("附件信息", "detialTabView__detialTabView_tabAttach");
		//基本信息
		pageREQ.mapContentId.put("单据编号", "Efd_Code");
	    pageREQ.mapContentId.put("评价周期", "Efd_PJZQ");		
		pageREQ.mapContentId.put("分包商编码", "fd_PartnerList_Code");
		pageREQ.mapContentId.put("分包商名称", "fd_PartnerList_Name");
		pageREQ.mapContentId.put("集中评价日期", "Efd_BizDate");
		pageREQ.mapContentId.put("集中评价状态", "Efd_PJZT");
		pageREQ.mapContentId.put("备注", "Efd_evRemark_Remark");
		//分包商评价
		pageREQ.mapContentId.put("选择分包商", "btnSelectPartner");
		
		
		//日期
		strDate = "2020-11-16";
		
		//动态参数
		pageREQ.mapDynamicData.put("专业分包商集中评价-单据编号", "");
		pageREQ.mapDynamicData.put("专业分包商集中评价-分包商编码", "");
		pageREQ.mapDynamicData.put("专业分包商集中评价-分包商名称", "");
		pageREQ.mapDynamicData.put("专业分包商类别-类别编码", GScene.DYNAMIC_DATA.get("专业分包商类别-类别编码"));
        pageREQ.mapDynamicData.put("专业分包商名录-分包商编码", GScene.DYNAMIC_DATA.get("专业分包商名录-分包商编码"));
		
		
	}
}
