package User.Material.OwnerSupplyPlanNew;

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
		pageREQ = new GWCtrlMainPage("材料甲供计划");
		//顶层菜单
		pageREQ.mapTopMenuBtnId.put("新建", "btnNew");
		pageREQ.mapTopMenuBtnId.put("编辑", "btnModify");
		pageREQ.mapTopMenuBtnId.put("删除", "btnDelete");
		pageREQ.mapTopMenuBtnId.put("保存", "btnSave");
		pageREQ.mapTopMenuBtnId.put("放弃", "btGiveup");
		pageREQ.mapTopMenuBtnId.put("提交", "btnSubmit");
		//单据页签
		pageREQ.mapTopTabId.put("基本信息", "detialTabView__detialTabView_tab");
		pageREQ.mapTopTabId.put("材料明细", "detialTabView__name_1265100187");//与开发已确认此ID唯一
		pageREQ.mapTopTabId.put("材料汇总", "detialTabView__tab_CLHZ");
		pageREQ.mapTopTabId.put("附件信息", "detialTabView__detialTabView_tabAttach");													
		//基本信息
		pageREQ.mapContentId.put("计划日期", "Efd_BizDate");
		pageREQ.mapContentId.put("备注", "Efd_evRemark_Remark");
		//材料明细
		pageREQ.mapContentId.put("本期计划量", "gvCLMX_col_BCJHL_editor");
		//等待标签
		pageREQ.MODULE_WAIT_ID = GWCtrlWebElementId.CN_ID.get("材料明细");
		//日期
		strDate = "2020-04-09";
		//动态参数
		pageREQ.mapDynamicData.put("材料甲供计划-材料类型编码", GScene.DYNAMIC_DATA.get("材料甲供计划-材料类型编码"));
		pageREQ.mapDynamicData.put("材料甲供计划-材料编码", GScene.DYNAMIC_DATA.get("材料甲供计划-材料编码"));
		pageREQ.mapDynamicData.put("材料甲供计划-本期计划量", GScene.DYNAMIC_DATA.get("材料甲供计划-本期计划量"));
		pageREQ.mapDynamicData.put("材料甲供计划-单据编号", "");
	}
}
