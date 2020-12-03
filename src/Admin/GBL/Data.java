package Admin.GBL;

import java.util.HashMap;
import java.util.Map;

import AutoTestWeb.GWCtrlMainPage;


/**
 * 后台用户登录信息
 * @author zhangc-z 2020-12-25 12：25
 *
 */
public class Data {
	/**
	 *  页面驱动
	 */
	public GWCtrlMainPage pageREQ = null;
	
	/**
	 *  登录状态 默认为false
	 */
	public boolean bSignInStatus = false;
	
	/**
	 *  登出状态 默认为false
	 */
	public boolean bSignOutStatus = false;
	
	/**
	 *  当前登录用户信息
	 */
	public Map<String, String> mapUser = new HashMap<String,String>();
	
	/**
	 *  
	 */
	public Data() {
		
		//构造一个临时驱动
		pageREQ = new GWCtrlMainPage("登入登出");
		pageREQ.MODULE_WAIT_ID = "l_navigator";
	}
}
