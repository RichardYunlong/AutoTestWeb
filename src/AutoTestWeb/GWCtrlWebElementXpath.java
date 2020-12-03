package AutoTestWeb;

import java.util.HashMap;
import java.util.Map;

public class GWCtrlWebElementXpath {
	/**
	 * 常用Id
	 */
	public static Map<String, String> CN_XPATH = new HashMap<String,String>();
	
	public GWCtrlWebElementXpath(){
		//主体显示区
		CN_XPATH.put("主体显示区","/html/body/div[4]/div/div[2]/div[3]/div[2]/div[3]/iframe");
		CN_XPATH.put("顶层页签0 主体显示区","/html/body/div[4]/div/div[2]/div[3]/div[2]/div[2]/iframe");
		CN_XPATH.put("顶层页签1 主体显示区","/html/body/div[4]/div/div[2]/div[3]/div[2]/div[3]/iframe");
		CN_XPATH.put("顶层页签2 主体显示区","/html/body/div[4]/div/div[2]/div[3]/div[2]/div[4]/iframe");
	}
}
