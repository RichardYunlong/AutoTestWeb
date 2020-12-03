package User.Material.StockAllot;

import AutoTestWeb.GWCtrlMainPage;

/**
 *  
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
	    *  参考数据来源
     */
    public String referType = "";
    
    /**
             *  参考单据编号
     */
    public String billCode = "";
            
    /**
     *  
     */
	
			
	/**
	 *  
	 */
	public Data() {
		
		//构造一个临时驱动
		pageREQ = new GWCtrlMainPage("材料库房调拨单");
		pageREQ.MODULE_WAIT_ID = "billView";
	}
}
