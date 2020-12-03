package User.Material.StockOut;

import AutoTestWeb.GWCtrlMainPage;

/**
 *  材料出库单
 */
public class Data {
  
  
    /**
              *  参考数据来源
    */
    public String referType = "";
  

    /**
               * 参考单据编号
     */
    public String billCode = "";
	
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
		pageREQ = new GWCtrlMainPage("材料出库单");
		pageREQ.MODULE_WAIT_ID = "billView";
	}
}
