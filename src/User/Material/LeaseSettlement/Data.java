package User.Material.LeaseSettlement;

import AutoTestWeb.GWCtrlMainPage;

/**
 * 周转材料租赁结算单-列表区-数据
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
		pageREQ = new GWCtrlMainPage("周转材料租赁结算单");
		pageREQ.MODULE_WAIT_ID = "billView";
	}
}
