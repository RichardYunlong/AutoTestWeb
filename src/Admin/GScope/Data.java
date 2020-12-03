package Admin.GScope;


import java.util.HashMap;
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
	 *  构造函数
	 */
	public Data() {
		mapUser.put("用户姓名", "super");
		mapUser.put("过滤分类树搜索框", "naviTree_orgTree_edQuery");
		mapUser.put("用户授权树", "naviTree_orgTree_qryList");
		mapUser.put("管理本人数据", "RegBizDimTemplateDlg_innerDetail_genChkBox2");
		mapUser.put("查看组织数据", "RegBizDimTemplateDlg_innerDetail_genChkBox4");
		mapUser.put("管理组织数据", "RegBizDimTemplateDlg_innerDetail_genChkBox8");
	    mapUser.put("组织管理范围常用对象树", "BizDimTemplateDetails_srcFunc");
		mapUser.put("左移右移", "BizDimTemplateDetails_buttonPanel");
		mapUser.put("确定", "RegBizDimTemplateDlg_innerDetail_DlgConfirmBtn");
		mapUser.put("新建", "AddBtn");
		
		//构造一个临时驱动
		pageREQ = new GWCtrlMainPage("授权范围");
		pageREQ.MODULE_WAIT_ID = "AddBtn";
	}
}
