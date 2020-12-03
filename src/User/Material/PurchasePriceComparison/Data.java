package User.Material.PurchasePriceComparison;

import AutoTestWeb.GWCtrlMainPage;

/**
 * 材料采购比价单-列表区-数据
 * 
 * @author 赵君 2020.11.09 18:44:36
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
		pageREQ = new GWCtrlMainPage("材料采购比价单");
		pageREQ.MODULE_WAIT_ID = "billView";
	}
}
