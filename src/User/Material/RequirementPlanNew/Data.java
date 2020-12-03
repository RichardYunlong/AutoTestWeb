package User.Material.RequirementPlanNew;

import java.util.HashMap;
import java.util.Map;

import AutoTestScene.GScene;
import AutoTestWeb.GWCtrlGrid3;
import AutoTestWeb.GWCtrlMainPage;

/**
 * 材料需要计划数据
 * @author zhaoj-k
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
	//单据状态
	public String strStatus = "未知";
	
	/**
	 *  自定义需用计划计划时间
	 */
	public String strDate = "今天";
	
	/**
	 *  材料明细
	 */
	public GWCtrlGrid3 gvGrid3 = null;
	
//	/**
//	 *  重要全局参数 用于执行业务流自动化测试
//	 *  合同编号值
//	 */
//	public static String strPlanCodeValue = "";	
//	
//	/**
//	 *  重要全局参数 用于执行业务流自动化测试
//	 *  数量
//	 */
//	public static final int dQuantityValue = 100;
	
	
	/**
	 *  初始化版式信息
	 */
	public Data() {
		
		//构造一个临时驱动
		pageREQ = new GWCtrlMainPage("材料需用计划");
		//顶层菜单
		pageREQ.mapTopMenuBtnId.put("新建","");
		pageREQ.mapTopMenuBtnId.put("编辑", "btnModify");
		pageREQ.mapTopMenuBtnId.put("删除", "btnDelete");
		pageREQ.mapTopMenuBtnId.put("保存", "btnSave");
		pageREQ.mapTopMenuBtnId.put("放弃", "");
		pageREQ.mapTopMenuBtnId.put("提交", "btnSubmit");
		//单据页签
		pageREQ.mapTopTabId.put("基本信息", "detialTabView__detialTabView_tab"); //页签ID
		pageREQ.mapTopTabId.put("材料明细", "detialTabView__tab_CLMX");
		pageREQ.mapTopTabId.put("材料汇总", "detialTabView__tab_CLHZ");
		pageREQ.mapTopTabId.put("附件信息", "detialTabView__detialTabView_tabAttach");	
		//单据菜单
		pageREQ.mapTopTabId.put("选择字典材料", "btnImportMaterial");	
		//二级窗体菜单
		pageREQ.mapTopTabId.put("移入", "btn_actSelect");
		pageREQ.mapTopTabId.put("选定", "btn_actSubmit");
		//单据重要窗体
		pageREQ.mapContentXpath.put("基本信息", "/html/body/div[2]/div/div/div[2]/div/div/div/div[2]");
		pageREQ.mapContentXpath.put("材料明细", "/html/body/div[3]/div/div/div[2]/div/div/div/div[2]/div/div[2]/div/div/div/div/div[2]");
//		pageREQ.mapContentXpath.put("材料明细 上表根路路径", pageREQ.mapContentXpath.get("材料明细") + "/div");
		pageREQ.mapContentXpath.put("字典材料 二级窗体左侧","/html/body/div[1]/div/div/div[1]");
		pageREQ.mapContentXpath.put("字典材料 二级窗体右侧","/html/body/div[1]/div/div/div[2]");
																
		//基本信息

		//材料明细
		pageREQ.mapContentId.put("空白处", "gvCLMX");
		pageREQ.mapContentId.put("本期计划量", "gvCLMX_col_SL_editor");  //确认下参数2是干嘛的？
		//选择字典材料
		pageREQ.mapContentXpath.put("第一个材料", pageREQ.mapContentXpath.get("字典材料 二级窗体右侧") + "/div/div/div[1]/div/div/div/div/div[2]/div/div[1]/div[2]/div/div[1]/table");
		//选择材料类别
		pageREQ.mapTopTabId.put("展开", "btnTreeExpandAll");
		pageREQ.mapContentXpath.put("展开全部","/html/body/div[8]/ul/li[5]/a/span");
		pageREQ.mapContentXpath.put("第一个类别",pageREQ.mapContentXpath.get("材料类别 二级窗体") + "/div[3]/table/tbody/tr/td[1]/div/img");
		pageREQ.mapTopTabId.put("选定第一个类别", "btn_actSubmit");
		//材料明细 上表根路路径
		pageREQ.mapContentXpath.put("材料明细 上表根路路径", "/html/body/div[3]/div/div/div[2]/div/div/div/div[2]/div/div[2]/div/div/div/div/div[2]/div");
		//和门户的版式有关系，上边这个是默认版式，下边这个是菜单版式
//		pageREQ.mapContentXpath.put("材料明细 上表根路路径", "/html/body/div[2]/div/div/div[2]/div/div/div/div[2]/div/div[2]/div/div/div/div/div[2]/div");
		//等待标签
		pageREQ.MODULE_WAIT_ID = pageREQ.mapContentId.get("空白处");
		
		strDate = "2020-04-09";
		
		//动态参数
		pageREQ.mapDynamicData.put("材料需要计划-材料明细-本期计划量", GScene.DYNAMIC_DATA.get("材料需要计划-材料明细-本期计划量"));
		pageREQ.mapDynamicData.put("材料需要计划-单据编号", "");
	}
}

