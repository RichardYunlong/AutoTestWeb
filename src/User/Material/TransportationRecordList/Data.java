package User.Material.TransportationRecordList;

import AutoTestWeb.GWCtrlMainPage;

/**
 * 运杂费记录单-列表区-数据
 * 
 * @author 赵君 2020.11.10 19:55:24
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
		pageREQ = new GWCtrlMainPage("运杂费记录单");
		pageREQ.MODULE_WAIT_ID = "billView";
	}
}
