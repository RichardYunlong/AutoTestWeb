package User.Material.LocationPlan;

import AutoTestWeb.GWCtrlMainPage;

/**
 * 材料部位计划-列表区-数据
 * 
 * @author 赵君 2020.11.04 17:29:35
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
		pageREQ = new GWCtrlMainPage("材料部位计划");
		pageREQ.MODULE_WAIT_ID = "billView";
	}
}
