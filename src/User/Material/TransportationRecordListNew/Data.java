package User.Material.TransportationRecordListNew;

import java.util.HashMap;
import java.util.Map;

import AutoTestScene.GScene;
import AutoTestWeb.GWCtrlGrid3;
import AutoTestWeb.GWCtrlMainPage;
import AutoTestWeb.GWCtrlWebElementId;

/**
 * 运杂费记录单
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
		pageREQ = new GWCtrlMainPage("运杂费记录单");
		//顶层菜单
		pageREQ.mapTopMenuBtnId.put("新建", "btnNew");
		pageREQ.mapTopMenuBtnId.put("编辑", "btnModify");
		pageREQ.mapTopMenuBtnId.put("删除", "btnDelete");
		pageREQ.mapTopMenuBtnId.put("保存", "btnSave");
		pageREQ.mapTopMenuBtnId.put("放弃", "btGiveup");
		pageREQ.mapTopMenuBtnId.put("提交", "btnSubmit");
		//单据页签
		pageREQ.mapTopTabId.put("基本信息", "detialTabView__detialTabView_tab");
		pageREQ.mapTopTabId.put("费用项明细", "detialTabView__name_1472107286");//确认是否唯一
		pageREQ.mapTopTabId.put("附件信息", "detialTabView__detialTabView_tabAttach");	
		//二级窗体页签
		pageREQ.mapTopTabId.put("外部单位", "tabView__UnittabView_tab");
		pageREQ.mapTopTabId.put("内部单位", "tabView__OrgtabView_tab");
		//单据菜单
		pageREQ.mapTopTabId.put("新增费用项", "btnNew_FYXMX");
		//基本信息
		pageREQ.mapContentId.put("发生日期", "Efd_BizDate");
		pageREQ.mapContentId.put("往来单位", "Efd_HZDWZD_Name");
		pageREQ.mapContentId.put("备注", "Efd_evRemark_Remark");
		//费用项明细
		pageREQ.mapContentId.put("费用项名称", "gvFyxmx_col_FYXMC_editor");
		pageREQ.mapContentId.put("含税单价", "gvFyxmx_col_HSDJ_editor");
		pageREQ.mapContentId.put("数量", "gvFyxmx_col_SL_editor");
		pageREQ.mapContentId.put("税率", "gvFyxmx_col_TaxRatio_editor");
		//等待标签
		pageREQ.MODULE_WAIT_ID = GWCtrlWebElementId.CN_ID.get("运杂费记录单-费用项明细");
		//日期
		strDate = "2020-04-09";
		//动态参数
		pageREQ.mapDynamicData.put("运杂费记录单-往来单位", GScene.DYNAMIC_DATA.get("运杂费记录单-往来单位"));
		pageREQ.mapDynamicData.put("运杂费记录单-费用项明细-费用项名称", GScene.DYNAMIC_DATA.get("运杂费记录单-费用项明细-费用项名称"));
		pageREQ.mapDynamicData.put("运杂费记录单-费用项明细-含税单价", GScene.DYNAMIC_DATA.get("运杂费记录单-费用项明细-含税单价"));
		pageREQ.mapDynamicData.put("运杂费记录单-费用项明细-数量", GScene.DYNAMIC_DATA.get("运杂费记录单-费用项明细-数量"));
		pageREQ.mapDynamicData.put("运杂费记录单-费用项明细-税率(%)", GScene.DYNAMIC_DATA.get("运杂费记录单-费用项明细-税率(%)"));
		pageREQ.mapDynamicData.put("运杂费记录单-单据编号", "");
	}
}
