package User.Material.ContractClarificaitonNew;

import java.util.HashMap;
import java.util.Map;

import AutoTestScene.GScene;
import AutoTestWeb.GWCtrlGrid3;
import AutoTestWeb.GWCtrlMainPage;

/**
 * 物资合同交底-详情区-页面数据
 * @author 赵君 2020.11.12 18:59:01
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
	 *  材料明细
	 */
	public GWCtrlGrid3 gvGrid3 = null;
	
	/**
	 *  初始化
	 */
	public Data() {
		
		//构造一个临时驱动
		pageREQ = new GWCtrlMainPage("物资合同交底");
		//顶层菜单
		pageREQ.mapTopMenuBtnId.put("新建", "btnNew");
		pageREQ.mapTopMenuBtnId.put("编辑", "btnModify");
		pageREQ.mapTopMenuBtnId.put("删除", "btnDelete");
		pageREQ.mapTopMenuBtnId.put("保存", "btnSave");
		pageREQ.mapTopMenuBtnId.put("放弃", "btGiveup");
		pageREQ.mapTopMenuBtnId.put("提交", "btnSubmit");
		//单据页签
		pageREQ.mapTopTabId.put("基本信息", "detialTabView__detialTabView_tab");
		pageREQ.mapTopTabId.put("附件信息", "detialTabView__detialTabView_tabAttach");													
		//基本信息
		pageREQ.mapContentId.put("合同编号", "Efd_HT_Code");
		//等待标签
		pageREQ.MODULE_WAIT_ID = "detialTabView";
		//日期
		strDate = "2020-04-09";
		//动态参数
		pageREQ.mapDynamicData.put("物资合同交底-单据编号", GScene.DYNAMIC_DATA.get("物资合同交底-单据编号"));
		pageREQ.mapDynamicData.put("材料采购合同-合同编号", GScene.DYNAMIC_DATA.get("材料采购合同-单据编号"));
	}
}
