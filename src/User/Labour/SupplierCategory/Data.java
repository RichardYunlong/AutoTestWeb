package User.Labour.SupplierCategory;

import AutoTestWeb.GWCtrlMainPage;

/**
 * 劳务分包商类别
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
		pageREQ = new GWCtrlMainPage("劳务分包商类别");
		pageREQ.MODULE_WAIT_ID = "dictView";
	}
}
