package User.Material.ContractClarificaiton;

import AutoTestWeb.GWCtrlMainPage;

/**
 * 物资合同交底-列表区-数据
 * @author 赵君 2020.11.12 18:54:13
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
		pageREQ = new GWCtrlMainPage("物资合同交底");
		pageREQ.MODULE_WAIT_ID = "billView";
	}
}
