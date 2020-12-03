package AutoTestWeb;

import java.util.HashMap;
import java.util.Map;

/**
 * 常用元素class
 */
public class GWCtrlWebElementClass {
	
	/**
	 * 常用class
	 */
	public static Map<String, String> CN_CLASS = new HashMap<String,String>();
	
	public GWCtrlWebElementClass(){
		
		//
		CN_CLASS.put("左侧根菜单","left-content");
		
		//
		CN_CLASS.put("模块列表-向上滚动","scroll-up");
		CN_CLASS.put("模块列表-向下滚动","scroll-down");
		
		//
		CN_CLASS.put("主体区域","main-content");
		
		//
		CN_CLASS.put("列表区-搜索区"," ex-panel x-box-item");
		CN_CLASS.put("列表区-搜索区-输入框","");
		CN_CLASS.put("列表区-搜索区-清楚按钮", "x-form-trigger x-form-clear-trigger");
		CN_CLASS.put("列表区-搜索区-搜索按钮", "x-form-trigger x-form-Fuzzy-trigger");
		
		//
		CN_CLASS.put("类别树-搜索区-搜索按钮", "x-form-trigger x-form-search-trigger");
		CN_CLASS.put("类别树-搜索区-全部展开按钮", "x-btn-text ci-toolbar-GTP_allunfold-png");
		//
		CN_CLASS.put("数据源-搜索区-搜索按钮", "x-form-trigger x-form-Fuzzy-trigger");
		
		//
		CN_CLASS.put("表格", "x-grid3");
		CN_CLASS.put("表格-显示区", "x-grid3-viewport");
		CN_CLASS.put("表格-显示区-字段名", "x-grid3-header");
		CN_CLASS.put("表格-显示区-字段值", "x-grid3-scroller");
		CN_CLASS.put("表格-显示区-字段值-数据区", "x-grid3-body");
		CN_CLASS.put("表格-显示区-字段值-选中区", "x-grid3-focus");
	}
}
