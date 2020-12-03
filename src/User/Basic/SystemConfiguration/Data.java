package User.Basic.SystemConfiguration;

import AutoTestWeb.GWCtrlMainPage;

/**
 * 机构参数设置
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
	 *  构造函数
	 */
	public Data() {
		
		//构造一个临时驱动
		pageREQ = new GWCtrlMainPage("机构参数设置");
		pageREQ.MODULE_WAIT_ID = "treeView";
		
		pageREQ.mapTopTabId.put("参数列表区域","dictView");
		pageREQ.mapTopTabId.put("编辑弹窗","evCSSZ");
	}
}
