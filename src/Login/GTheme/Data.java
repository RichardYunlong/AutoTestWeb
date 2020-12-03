package Login.GTheme;

import java.util.HashMap;
import java.util.Map;

/**
 *  版式信息
 */
public class Data {
	
	/**
	 *  版式修改 默认为false
	 */
	public boolean bRes = false;

	
	/**
	 *  版式设置信息
	 */
	public String strThemeName = "默认版式";//修改版式名称
	public final String eThemeType = "id";//修改版式的方式：默认为Id方式
	
	/**
	 *  切换状态 默认为false
	 */
	public boolean bLayoutStatus = false;
	
	/**
	 *  保存版式信息
	 */
	public Map<String, String> mapTheme = new HashMap<String,String>();
	
	/**
	 *  页面完整等待标识元素
	 */
	public final String waitPageId = "admin_frame";
	
	/**
	 *  初始化版式信息
	 */
	public Data() {
		mapTheme.put("默认版式","layoutE");
		mapTheme.put("Outlook版式","layoutB");
		mapTheme.put("菜单版式","layoutC");
		mapTheme.put("简洁版式","layoutA");
		mapTheme.put("一般样式按钮","themeGroup");	
	}
}
