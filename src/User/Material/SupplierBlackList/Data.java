package User.Material.SupplierBlackList;

import AutoTestWeb.GWCtrlMainPage;

/**
 * 物资供应商初评
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
	 *  
	 */
	public Data() {
		
		//构造一个临时驱动
		pageREQ = new GWCtrlMainPage("物资供应商黑名单");
		pageREQ.MODULE_WAIT_ID = "billView";
	}
}
