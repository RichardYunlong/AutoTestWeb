package User.Material.DemandPlan;

import AutoTestWeb.GWCtrlMainPage;

/**
 * 材料需用计划-列表区-数据
 * 
 * @author 赵君 2020.10.21 10:58:31
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
		pageREQ = new GWCtrlMainPage("材料需用计划");
		pageREQ.MODULE_WAIT_ID = "billView";
	}
}
