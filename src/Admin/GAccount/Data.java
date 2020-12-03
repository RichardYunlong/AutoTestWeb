package Admin.GAccount;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import AutoTestWeb.GWCtrlMainPage;

/**
 * 后台用户数据
 * @author zhangc-z 2020-10-25 12：22
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
	 *  页面数据
	 */
	public Map<String, String> mapUser = new HashMap<String,String>();

	/**
	 *  内置全部权限，后续按需增加或删减
	 */
	public List<String> listUserPower = Arrays.asList(
//	    "基础信息",
	    //"投标管理",
//	    "项目信息",
//	    "合同管理",
	    //"生产及工期管理",
//	    "资金管理",
        "物资管理",
//        "机械设备管理",
//        "劳务管理",
//        "专业分包管理",
//        "成本管理",
//        "技术管理",
//        "质量管理",
//        "安全管理",
//        "环境管理",
//        "收尾管理",
//        "集成管理",
//        "帮助系统",
        "增值税管理"
	    );
	
	/**
	 *  构造函数
	 */
	public Data() {
		mapUser.put("新建","actAddUser");      
		mapUser.put("用户姓名id", "undefined_edUserName");
		mapUser.put("用户姓名", "super");
		mapUser.put("所属部门id", "undefined_edDeptName");
		mapUser.put("搜索框", "undefined_deptSelector_edQuery");
		mapUser.put("所属部门", "GAT项目部");
		mapUser.put("部门搜索结果", "undefined_deptSelector_qryList");
		mapUser.put("确定", "undefined_DeptDlg_btnOK");
		mapUser.put("提交并关闭", "undefined_btnOk");
		mapUser.put("新建授权", "btnAddOptRule");
		mapUser.put("授权搜索框", "RegDialog_cardPanel_orgSelector_sourcePanel_edQuery");
		mapUser.put("授权用户右移按钮", "RegDialog_cardPanel_orgSelector_btnAdd");
		mapUser.put("选择功能操作", "RegDialog_cardPanel__funcPanel");
		mapUser.put("用户授权树", "RegDialog_cardPanel_orgSelector_sourcePanel_qryList");
		mapUser.put("授权功能右移按钮", "RegDialog_cardPanel_funcSelector_btnAdd");
		mapUser.put("授权确定按钮", "RegDialog_btnOk");
	  
		//构造一个临时驱动
		pageREQ = new GWCtrlMainPage("用户维护");
		pageREQ.MODULE_WAIT_ID = "actAddUser";
	}
}
