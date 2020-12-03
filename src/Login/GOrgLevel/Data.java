package Login.GOrgLevel;

import AutoTestWeb.GWCtrlMainPage;

/**
 *  层级信息
 */
public class Data {
	
	/**
	 *  页面驱动
	 */
	public GWCtrlMainPage pageREQ = null;
	
	/**
	 *  层级修改 默认为false
	 */
	public boolean bOrgStatus = false;
	
	/**
	 *  
	 */
	public Data() {
		
		//构造一个临时驱动
		pageREQ = new GWCtrlMainPage("机构层级");
		pageREQ.MODULE_WAIT_ID = "orgName";
	}
}
