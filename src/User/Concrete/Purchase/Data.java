package User.Concrete.Purchase;

import AutoTestWeb.GWCtrlMainPage;

/**
 * 混凝土供应合同
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
		pageREQ = new GWCtrlMainPage("商品混凝土供应合同");
		pageREQ.MODULE_WAIT_ID = "billView";
	}
}
