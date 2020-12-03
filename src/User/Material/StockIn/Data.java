package User.Material.StockIn;

import AutoTestWeb.GWCtrlMainPage;

/**
 *  列表数据
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
		pageREQ = new GWCtrlMainPage("材料入库单");
		pageREQ.MODULE_WAIT_ID = "billView";
	}
}
