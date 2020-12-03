package AutoTestWeb;

import java.util.HashMap;
import java.util.Map;

/**
 * 常用元素Id
 */
public class GWCtrlWebElementId {
	
	/**
	 * 常用Id
	 */
	public static Map<String, String> CN_ID = new HashMap<String,String>();
	
	/**
	 * 明细页签
	 * 每当对一个新的控件表格类型执行grid3读取时，需要先将其条件id值及其对应名称加到此处，督促开发者梳理一遍这种新控件的数据结构
	 */
	public static String[][] ID_DETAIL = {{"billView", "列表区"}, 
										  {"gvCLMX", "材料明细"}, 
										  {"gvDHDYDCLMX", "到货点验单材料明细"}, 
										  {"gvSTMX", "商砼明细"}, 
										  {"gvZLMX", "周转材料租赁结算单"}, {"gvRZMX", "周转材料租赁合同"}, {"gvCCMX", "租赁周转材料出场单"}, 
										  {"gvPartnerAssList", "分包商集中评价，分包商页签上半部分"}, {"dictView", "分包商类别"}, 
									  	  {"naviTree_orgTree_qryList", "用户权限范围搜索用户后出现的记过列表"}, 
										  {"BizDimTemplateDetails_srcFunc", "组织管理范围常用对象"}, 
										  {"userList", "用户删除查询出的用户信息"},
										  {"RegDialog_cardPanel_orgSelector_targetList", "授权用户树"},
										  {"RegDialog_cardPanel_orgSelector_sourcePanel_qryList", "选择授权对象、选择功能操作表格"}, 
										  {"RegDialog_cardPanel_funcSelector_tar", "授权明细项列表"},
										  {"undefined_deptSelector_qryList", "新建用户时搜索部门后出现的记过列表"},
										  {"treeGrid", "合同数据源"}, {"treeView", "二级窗体类别树表格"}, {"Source", "二级窗体明细树表格"}, {"Selected", "二级窗体选中树表格"},
										  {"gvFyxmx", "运杂费记录单费用项明细"},{"gvQTFY", "其他费用"},{"gvFYMX", "运杂费结算单-费用明细"}
										};
	
	public GWCtrlWebElementId(){
		
		//
		CN_ID.put("模块搜索-搜索框","searchKey");
		
		//一级窗体
		//主体显示区
		CN_ID.put("门户页","template_0");
		
		//登入登出
		CN_ID.put("账号","username");
		CN_ID.put("密码","password");
		CN_ID.put("登入","btLogin");
		
		//切换层级
		CN_ID.put("打开机构层级","orgNameGroup");
		CN_ID.put("机构层级","orgNameDrop");
		CN_ID.put("查看机构树","PTL.frame.NaviPanel.btnShowTree");
		CN_ID.put("查看机构表","PTL.frame.NaviPanel.btnShowList");
		CN_ID.put("机构列表","PTL.frame.NaviList");
		
		//用户状态
		CN_ID.put("用户","userNameGroup");
		CN_ID.put("用户状态","userNameDrop");
		CN_ID.put("我的桌面","myDesktop");
		CN_ID.put("我的设备","myDevice");
		CN_ID.put("个人信息","ModifiedUserInfo");
		CN_ID.put("修改密码","ModifiedPwd");
		CN_ID.put("注销","sysExit");
		
		//切换主题
		CN_ID.put("打开主题选择","themeGroup");
		CN_ID.put("确认主题选择","themeDropOKBtn");
		
		//顶层页签菜单栏
		CN_ID.put("左侧根菜单","l_navigator");
		CN_ID.put("左侧列表菜单","l_menu_list");
		
		//顶层页签菜单栏
		CN_ID.put("顶层页签栏","lst_tabpages");
		
		//列表区-菜单
		CN_ID.put("新_建","btn_New");
		CN_ID.put("查_看","btn_View");
		CN_ID.put("删_除","btn_Delete");
		
		//列表区-细表
		CN_ID.put("单据列表","billView");
		
		//单据区-菜单
		CN_ID.put("新建", "btnNew");
		CN_ID.put("复制", "btnCopy");
		CN_ID.put("编辑", "btnModify");
		CN_ID.put("删除", "btnDelete");
		CN_ID.put("类别-删除", "btnRemove");
		CN_ID.put("保存", "btnSave");
		CN_ID.put("放弃", "btGiveup");
		CN_ID.put("提交", "btnSubmit");
		CN_ID.put("取消提交", "btnSubmit");
		CN_ID.put("打印", "btnListPrintWindowView");
		CN_ID.put("刷新", "btnRefresh");
		CN_ID.put("选择字典材料", "btnImportMaterial");
	    CN_ID.put("黑名单删除按钮", "btn_Delete");
		CN_ID.put("加入黑名单", "btnAddBlacklist");
	    CN_ID.put("取消黑名单", "btnDeleteBlacklist");
		
		
		//单据区-基本信息
		CN_ID.put("基本信息", "InfoContainerView");
		CN_ID.put("单据编号", "Efd_Code");
		
		//单据区-细表-材料明细
		CN_ID.put("材料明细", "gvCLMX");
		CN_ID.put("材料到货点验单-材料明细", "gvDHDYDCLMX");
		
	    //单据区-细表-商砼明细
        CN_ID.put("商砼明细", "gvSTMX");
		
		//单据区-细表-单据明细
		CN_ID.put("单据明细", "gvDJMX");
		
		//单据区-细表-评价信息
		CN_ID.put("评价信息", "gvPJXX");
		
		//单据区-细表-供应商列表
		CN_ID.put("供应商列表", "gvPartnerAssList");
		
		//单据去-细表-费用项明细/其他费用
		CN_ID.put("运杂费记录单-费用项明细", "gvFyxmx");
		CN_ID.put("其他费用", "gvQTFY");
		CN_ID.put("运杂费结算单-费用明细", "gvFYMX");

		//二级窗体
		//顶部页签
		CN_ID.put("外部单位", "tabView__UnittabView_tab");
		CN_ID.put("内部单位", "tabView__OrgtabView_tab");
		
		//功能按钮
		CN_ID.put("二级窗体 移入", "btn_actSelect");
		CN_ID.put("二级窗体 移出", "btn_actRemove");
		CN_ID.put("二级窗体 全部移入", "btn_actSelectAll");
		CN_ID.put("二级窗体 全部移出", "btn_actRemoveAll");
		CN_ID.put("二级窗体 确定", "btn_actSubmit");
		CN_ID.put("二级窗体 取消", "btn_actCancel");
		
		//表格数据
		//表格数据-类别树
		CN_ID.put("类别树", "treeView");
		
		CN_ID.put("类别树-展收栏", "treeView_toolbar");
		CN_ID.put("类别树-搜索区", "treeView_search");
		CN_ID.put("类别树-搜索区-搜索框", "treeSearch");
		//表格数据-数据源
		CN_ID.put("数据源", "Source");
		CN_ID.put("数据源-综合搜索", "Source_toolbar");
		CN_ID.put("数据源-综合搜索-搜索条件", "query_panel");
		CN_ID.put("数据源-分类搜索", "Source_clSearch");
		CN_ID.put("数据源-分类搜索-材料名称", "clmcText");
		CN_ID.put("数据源-分类搜索-规格", "clggText");
		CN_ID.put("数据源-分类搜索-型号", "clxhText");
		CN_ID.put("数据源-分类搜索-搜索钮", "btnCLSearch");
		CN_ID.put("数据源-分页", "Source_paging");
		//表格数据-选中值
		CN_ID.put("选中值", "Selected");
		
		//参考数据 
		CN_ID.put("参考树", "treeGrid");//与【评价内容】细表id相同
		CN_ID.put("单据树", "gvBill");
		CN_ID.put("单位树", "layoutPanel1");
		
		//选择合同二级窗体中的查询方案
		CN_ID.put("查询方案", "_menu_button");
		
	}
}
