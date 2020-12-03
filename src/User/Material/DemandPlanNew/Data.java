package User.Material.DemandPlanNew;

import java.util.HashMap;
import java.util.Map;

import AutoTestScene.GScene;
import AutoTestWeb.GWCtrlGrid3;
import AutoTestWeb.GWCtrlMainPage;
import AutoTestWeb.GWCtrlWebElementId;

/**
 *  材料需用计划-详情区-页面数据
 *  
 *  @author 赵君 2020.10.21 10:58:31
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
		pageREQ = new GWCtrlMainPage("材料需用计划");
		//顶层菜单
		pageREQ.mapTopMenuBtnId.put("新建", "btnNew");
		pageREQ.mapTopMenuBtnId.put("编辑", "btnModify");
		pageREQ.mapTopMenuBtnId.put("删除", "btnDelete");
		pageREQ.mapTopMenuBtnId.put("保存", "btnSave");
		pageREQ.mapTopMenuBtnId.put("放弃", "btGiveup");
		pageREQ.mapTopMenuBtnId.put("提交", "btnSubmit");
		//单据页签
		pageREQ.mapTopTabId.put("基本信息", "detialTabView__detialTabView_tab");
		pageREQ.mapTopTabId.put("材料明细", "detialTabView__tab_CLMX");
		pageREQ.mapTopTabId.put("材料汇总", "detialTabView__tab_CLHZ");
		pageREQ.mapTopTabId.put("附件信息", "detialTabView__detialTabView_tabAttach");
		//基本信息
		pageREQ.mapContentId.put("计划日期", "Efd_BizDate");
		pageREQ.mapContentId.put("计划类型", "Efd_JHLX");
		pageREQ.mapContentId.put("备注", "Efd_evRemark_Remark");
		//材料明细
		pageREQ.mapContentId.put("本期计划量", "gvCLMX_col_SL_editor");
		//等待标签
		pageREQ.MODULE_WAIT_ID = GWCtrlWebElementId.CN_ID.get("材料明细");
		
		strDate = "2020-04-09";
		
		//动态参数
		pageREQ.mapDynamicData.put("材料需用计划-材料类型编码", GScene.DYNAMIC_DATA.get("材料需用计划-材料类型编码"));
		pageREQ.mapDynamicData.put("材料需用计划-材料编码", GScene.DYNAMIC_DATA.get("材料需用计划-材料编码"));
		pageREQ.mapDynamicData.put("材料需用计划-本期计划量", GScene.DYNAMIC_DATA.get("材料需用计划-本期计划量"));
		pageREQ.mapDynamicData.put("材料需用计划-单据编号", "");
	}
}
