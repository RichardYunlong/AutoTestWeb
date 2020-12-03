package AutoTestWeb;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import AutoTest.GLog;
import AutoTest.GText;

/**
 *  页面处理
 */
public class GWCtrlPage {
	
	/**
	 *  按照页签序号等待指定元素，需要提供指定元素的查询条件，包括【属性名称】和【属性值】，例如：以【id】方式查询，查询的【id值】为“main-content”
	 *  
	 *  @param tabIndex 页签序号 
	 *  @param waitByValueType 等待目标的条件类型 例如“id”，意为通过id来等待
	 *  @param waitByValue 等待目标的条件值  例如“main-content”，意为等待的目标元素id值为“main-content”
	 */
	public static void ui_D_IFRAME_INDEX(int tabIndex, String waitByType, String waitByTar){
		GLog.logRecordTime(8, "[页面处理]----等待[" + tabIndex + "]号页签下，" + "元素[" + waitByType + "]为[" + waitByTar + "]的 目标加载完成");
		try {
			if(GWCtrlWebElementIframe.getIframe(tabIndex) != null) {
				GWCtrlFrame.ui_C_SWITCN_ELEMENT(GWCtrlWebElementIframe.getIframe(tabIndex));
				GLog.logRecordTime(8, "[页面处理]----[" + tabIndex + "]号区域加载完成");
				GWCtrlWait.WaitingAll(waitByType, waitByTar);
				GLog.logRecordTime(8, "[页面处理]----[" + waitByTar + "]出现了，目标元素加载完成");	
			}
			GWCtrlFrame.ui_C_SWITCN_DEFAULT();
		}catch (Exception e){
			GWCtrlException.SwtichTo(e, 1, 8, "[页面处理]----[" + waitByTar + "]元素查询失败", true);
		}

	}
	/**
	 *	根据页签获得单据编号
	 *  @param moduleName 模块名称
	 */
	public static String ui_C_GET_CODE(String moduleName) {
		String res = "";
		try {
			WebElement tab = GWCtrlStaticFind.getWebElementByIdOrXpath(GParam.g_Dr, 
													  GWCtrlWebElementId.CN_ID.get("顶层页签栏"),
													  "",
													  "a",
													  "",
													  "",
													  moduleName + "_"
													  );
			res = tab.getText();
			if(res.indexOf("_") != -1) {
				String[] strArr = res.split("_");
				res = strArr[1];
			}
		}catch (Exception e){
			GWCtrlException.SwtichTo(e, 1, 8, "单据编号解析失败", true);
		}
		
		return res;
	}
	
    /**
    * 根据中部页签的文本名称定位页签并点击
    * @param driver 全局驱动
    * @param Id 基准id，不为空时以该值为查询条件
    * @param Xpath 基准xpath，基准Id为空时以该值为查询条件
    * @param tarTagName 目标元素标签类型
    * @param tabPropertyName 目标元素属性名称
    * @param tabPropertyValue 目标元素属性值
    * @param tabText 目标元素显示文本
    */
	public static void ui_C_CLICK_TAB(WebDriver driver, String iframeId, String iframeXpath, String tabName, String tabPropertyName, String tabPropertyValue, String tabText) {
		GLog.logRecordTime(8, "页签切换至[" + tabName + "]页签");
		WebElement iframe = null;
		
		try {
			if(!iframeId.equals("")) {
				GWCtrlWait.ViewWaitingAllById(GTestIndicators.PageShowTime, iframeId);
				iframe = GParam.g_Dr.findElement(By.id(iframeId));
			}else{
				GWCtrlWait.ViewWaitingAllByXpath(GTestIndicators.PageShowTime, iframeXpath);
				iframe = GParam.g_Dr.findElement(By.xpath(iframeXpath));
			}
			
			GWCtrlFrame.ui_C_SWITCN_ELEMENT(iframe);

			WebElement tab = GWCtrlStaticFind.getWebElementByIdOrXpath(driver, iframeId, "/html/body", tabName, tabPropertyName, tabPropertyValue, tabText);
			
			if(tab != null) {
				tab.click();
				GLog.logRecordTime(8, "页签切换至[" + tabText + "]页签");
			}else{
				GLog.logRecordTime(8, "未找到[" + tabText + "]页签");
			}

        	//游标切换会主窗体
			GWCtrlFrame.ui_C_SWITCN_DEFAULT();
		}catch (Exception e){
			GWCtrlException.SwtichTo(e, 1, 8, "切换至[" + tabText + "]页签异常", true);
		}
	}
	
    /**
    * 根据同级id或xpath，点击相关联的按钮
    * @param driver 全局驱动
    * @param rootId 基准id，不为空时以该值为查询条件
    * @param rootXpath 基准xpath，基准Id为空时以该值为查询条件
    * @param tarTagName 目标元素标签类型
    */
	public static void ui_C_CLICK_INPUT_BTN(WebDriver driver, String rootId, String rootXpath,String tabName) {
		GLog.logRecordTime(8, "点击与[" + rootId + "]关联的按钮");
		
		WebElement tab = null;

		try {
			if(!rootId.equals("")) {
				tab = driver.findElement(By.id(rootId));
			}else{
				tab = driver.findElement(By.xpath(rootXpath));
			}
				
			if(tab != null) {
				//如果找到，获得父级节点
				WebElement tabParent = tab.findElement(By.xpath("./.."));
				//再从上步得到的父节点中查找子节点
				List<WebElement> tars = tabParent.findElements(By.tagName(tabName));
				for(WebElement tar:tars){
					if(tar != null) {
						tar.click();
						break;
					}
				}
				GLog.logRecordTime(8, "点击与[" + rootId + "]关联的按钮成功");
			}else{
				GLog.logRecordTime(8, "未找与[" + rootId + "]关联的按钮");
			}
		}catch (Exception e){
			GWCtrlException.SwtichTo(e, 1, 8, "查找与[" + rootId + "]关联的按钮异常", true);
		}
	}
	
    /**
    * 根据同级id或xpath，点击相关联的按钮
    * @param rootId 基准id，不为空时以该值为查询条件
    * @param rootXpath 基准xpath，基准Id为空时以该值为查询条件
    */
	public static void ui_C_SELECT_INPUT_BTN(String rootId, String rootXpath) {
		ui_C_CLICK_INPUT_BTN(GParam.g_Dr, rootId, rootXpath, "span");
	}
	
    /**
    * 根据目标字符串选定日期
    * @param cooTable 单位列表
    * @param cooTar 目标单位
    */
	public static void ui_C_SELECT_DATE_STR(String date) {
		String dateDivRootSelector = GText.getCssSelectorTxt("div", "class", "x-menu x-menu-floating x-layer x-date-menu x-menu-plain");
		
		try {
			WebElement dateDivRoot = GParam.g_Dr.findElement(By.cssSelector(dateDivRootSelector));
			if(dateDivRoot != null) {
				List<WebElement> dateButtons = dateDivRoot.findElements(By.tagName("button"));
	    		for(WebElement dateButton:dateButtons){
	    			if(dateButton.getText().equals(date)) {
	    				dateButton.click();
	    				GLog.logRecordTime(8, "找到了button类操作区域[" + date + "]");
	    				return;
	    			}
	    		}
	    		List<WebElement> dateSpans = dateDivRoot.findElements(By.tagName("span"));
	    		for(WebElement dateSpan:dateSpans){
	    			if(dateSpan.getText().equals(date)) {
	    				dateSpan.click();
	    				GLog.logRecordTime(8, "找到了span类操作区域[" + date + "]");
	    				return;
	    			}
	    		}
			}else {
				GLog.logRecordTime(8, "未找到日期选择控件");
			}
		}catch (Exception e) {
			GWCtrlException.SwtichTo(e, 1, 8, "选定日期失败", true);
		}
	}
	
    /**
    * 选定日期
    * @param cooTable 单位列表
    * @param cooTar 目标单位
    */
	public static void ui_C_SELECT_DATE(String date) {
		for(int i = 10;i <= 20;i++) {
			String strDateDiv = "/html/body/div[" + String.valueOf(i) + "]";
			WebElement webDateDiv = GWCtrlStaticFind.getWebElementByIdOrXpath(GParam.g_Dr, "", strDateDiv, "button", date);
				if(webDateDiv != null) {
					webDateDiv.click();
					break;
				}
		}
	}
	
    /**
    * 选定乙方
    * @param cooTable 单位列表
    * @param cooTar 目标单位
    */
	public static void ui_C_SELECT_COOPRATION(String cooTable, String cooTar) {
		GWCtrlWait.ViewWaitingTextByXpath(GTestIndicators.PageShowTime, cooTable, cooTar);
		WebElement coo = GWCtrlStaticFind.getWebElementByIdOrXpath(
				GParam.g_Dr, 
				"", 
				cooTable, 
				"div", 
				"", 
				"", 
				cooTar);
		GWCtrlWait.Wait2BeClickableByWebElement(GTestIndicators.PageShowTime, coo);
		coo.click();
	}
	
	/**
	 *  根据条件字符串搜索【数据源】中某目标
	 *  
	 *  @param cooName 单位名称
	 */
	public static void ui_C_SEARCH_COO(String cooName){
		WebElement layoutPanel1 = GParam.g_Dr.findElement(By.id("layoutPanel1"));
		GWCtrlWait.ViewWaitingAllByWebElement(GTestIndicators.PageShowTime, layoutPanel1);
		if(layoutPanel1 != null) {
			try {
				List<WebElement> colCodes = layoutPanel1.findElements(By.cssSelector(GText.getCssSelectorTxt("div", "class", "x-panel-tbar x-panel-tbar-noheader x-panel-tbar-noborder")));
				if(colCodes != null) {
					for(WebElement colCode:colCodes){
						List<WebElement> inputs = colCode.findElements(By.tagName("input"));
						for(WebElement input:inputs){
							if(input.getAttribute("type").equals("text")) {
								GWCtrlInputFill.ByWebElementUnClear(input, cooName);
								GLog.logRecordTime(8, "找到目标[" + cooName.toString() + "]");
								GWCtrlWait.ViewWaitingTextByWebElement(GTestIndicators.PageShowTime, layoutPanel1, cooName);
								WebElement coo = GParam.g_Dr.findElement(By.cssSelector(GText.getCssSelectorTxt("div", "class", "x-grid3-cell-inner x-grid3-col-0 x-unselectable")));
								List<WebElement> spans = coo.findElements(By.tagName("span"));
								for(WebElement span:spans){
									if(span.getText().equals(cooName)) {
										coo.click();
										break;
									}
								}
							}
							break;
						}
						break;
					}
				}else {
					GLog.logRecordTime(8, "未找到任何编码参数");
				}
				
			} catch (Exception e) {
				GWCtrlException.SwtichTo(e, 1, 8, "没有找到有效的编码参数", true);
			}
		}
	}
	
    /**
    * 选定甲方
    * @param jiafangSearch 单位列表搜索区
    * @param jiafangTable 单位列表
    * @param jiafangTar 目标单位名称
    */
	public static void ui_C_SELECT_JIAFANG(String jiafangSearch, String jiafangTable, String jiafangTar) {
		GWCtrlWait.ViewWaitingAllByXpath(GTestIndicators.PageShowTime, jiafangSearch);
		//搜索
		WebElement search = GWCtrlStaticFind.getWebElementByIdOrXpath(
				GParam.g_Dr, 
				"", 
				jiafangSearch, 
				"input", 
				"type", 
				"text", 
				"");
		GWCtrlWait.Wait2BeClickableByWebElement(GTestIndicators.PageShowTime, search);
		search.sendKeys(jiafangTar);
		
		WebElement searchBtnJiaFang = GWCtrlStaticFind.getWebElementByIdOrXpath(
				GParam.g_Dr, 
				"", 
				jiafangSearch, 
				"img", 
				"src", 
				"data:image/gif;base64,R0lGODlhAQABAID/AMDAwAAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==", 
				"");
		GWCtrlWait.Wait2BeClickableByWebElement(GTestIndicators.PageShowTime, searchBtnJiaFang);
		searchBtnJiaFang.click();
		GWCtrlWait.ViewWaitingTextByXpath(GTestIndicators.PageShowTime, jiafangTable, jiafangTar);
		GWCtrlWait.ViewWaitingAllByCssSelector(GTestIndicators.PageShowTime, GText.getCssSelectorTxt("div", "class", "x-grid3-cell-inner x-grid3-col-0 x-unselectable"));
		WebElement searchTar = GWCtrlStaticFind.getWebElementByIdOrXpath(
				GParam.g_Dr, 
				"", 
				jiafangTable, 
				"span", 
				"", 
				"", 
				jiafangTar);
		GWCtrlWait.Wait2BeClickableByWebElement(GTestIndicators.PageShowTime, searchTar);
		searchTar.click();
	}
	
	/**
	 *  点击某定区域内某Id元素
	 *  @param tabIndex 指定页签序号
	 *  @param eId 指定元素id
	 *  @param sName 区分标记，用于判断是哪个操作唤起了确认窗
	 *  @param bOK 是或否
	 *  @param wId 等待元素Id
	 */
	public static void ui_C_CLICK_VERIFY(int tabIndex, String eId, String sName, boolean bOK, String wId){
		GLog.logRecordTime(8, "点击id为[" + eId + "]的按钮");
		try {
			//由母版区域进入目标区域
			GWCtrlFrame.ui_C_SWITCN_ELEMENT(GWCtrlWebElementIframe.getIframe(tabIndex));
			//等待目标出现
	    	GWCtrlWait.Wait2BeClickableById(GTestIndicators.PageShowTime, eId);
	    	if(sName.equals("删除") || sName.equals("删_除")) {
	    		GWCtrlTime.Pause(3);
	    	}
	    	GWCtrlDivClick.ById(eId);
	    	
	    	String CCS = GText.getCssSelectorTxt("div", "class", " x-window x-window-plain x-window-dlg");
	    	GWCtrlWait.ViewWaitingByCssSelector(GTestIndicators.PageShowTime, CCS);
	    	WebElement divRoot = GParam.g_Dr.findElement(By.cssSelector(CCS));
	    	
	    	if(divRoot != null) {
        		
        		List<WebElement> buttons = divRoot.findElements(By.tagName("button"));
        		for(WebElement button:buttons){
        			if(bOK && button.getText().equals("是")) {
        				GLog.logRecordTime(8, "找到目标，类型为：" + "button" + "；元素为[" + button.getText() + "]");
        				button.click();
        				break;
        			}
        			if(!bOK && button.getText().equals("否")) {
        				GLog.logRecordTime(8, "找到目标，类型为：" + "button" + "；元素为[" + button.getText() + "]");
        				button.click();
        				break;
        			}
        			if(bOK && button.getText().equals("确定")) {
                      GLog.logRecordTime(8, "找到目标，类型为：" + "button" + "；元素为[" + button.getText() + "]");
                      button.click();
                      break;
                  }
        		}
        	}
	    	
	    	//返回母版区域
			GWCtrlFrame.ui_C_SWITCN_DEFAULT();
			
			//检查按钮状态
	    	if(sName.equals("删_除")) {//如果删除按钮不是【置灰】格式，就一直等待到置灰
				if(!GWCtrlTopMenuBtn.ui_C_GET_TOPMENUBTN_TAB1_STATUS(sName, GTestIndicators.PageShowTime, wId)) {
					GWCtrlTopMenuBtn.ui_C_GET_TOPMENUBTN_TAB1_STATUS(sName, GTestIndicators.PageShowTime, wId);
				}
	    	}
			
			//等待完成
			if(sName.equals("删除")) {
				GWCtrlPage.ui_D_IFRAME_INDEX(1, "id", GWCtrlWebElementId.CN_ID.get("单据列表"));
			}else {
				GWCtrlPage.ui_D_IFRAME_INDEX(tabIndex, "id", wId);
			}

			GLog.logRecordTime(8, "点击id为[" + eId + "]的按钮成功");
		}catch (Exception e){
			GWCtrlException.SwtichTo(e, 1, 8, "点击id为[" + eId + "]的按钮异常", true);
		}
	}
	
	/**
    * 根据页签序号和按钮的文本名称定位并点击，选择“确定”
    * 
    * @param tabText 目标元素显示文本
	 */
	public static void ui_C_CLICK_VERIFY_YES_INDEX(int tabIndex, String btnName, String wId){		
		GWCtrlPage.ui_C_CLICK_VERIFY(tabIndex, 
				GWCtrlWebElementId.CN_ID.get(btnName), btnName,
				true, 
				wId);
	}
	
	/**
    * 根据页签序号和按钮的文本名称定位并点击，选择“取消”
    * 
    * @param tabText 目标元素显示文本
	*/
	public static void ui_C_CLICK_VERIFY_NO_INDEX(int tabIndex, String btnName, String wId){		
		GWCtrlPage.ui_C_CLICK_VERIFY(tabIndex, 
				GWCtrlWebElementId.CN_ID.get(btnName), btnName,
				false, 
				wId);
	}
	
	/**
	 *  点击某定区域内某Id或Xpath的元素
	 *  @param eId 指定id
	 *  @param eXpath 指定xpath 
	 */
	public static void ui_C_WAIT_CLICK(String eId, String eXpath){
		if(!eId.equals("")) {
			GWCtrlWait.Wait2BeClickableById(GTestIndicators.PageShowTime, eId);
			GWCtrlDivClick.ById(eId);
		}else{
			GWCtrlWait.Wait2BeClickableByXpath(GTestIndicators.PageShowTime, eXpath);
			GWCtrlDivClick.ByXpath(eXpath);
		}
	}
	
	/**
	 *  点击某定区域内某Id或Xpath的元素
	 *  @param eId 指定id
	 *  @param eXpath 指定xpath 
	 */
	public static void ui_C_WAIT_CLICK_BTN(String eId,String btnText){
		WebElement divRoot = GParam.g_Dr.findElement(By.id(eId));
    	if(divRoot != null) {
    		
    		List<WebElement> buttons = divRoot.findElements(By.tagName("button"));
    		for(WebElement button:buttons){
    			if(button.getText().equals(btnText)) {
    				GLog.logRecordTime(8, "找到目标，类型为：" + "button" + "；元素为[" + button.getText() + "]");
    				button.click();
    				try {
    					//
    				}catch (Exception e){
    					GWCtrlException.SwtichTo(e, 1, 8, "提示窗处理异常", true);
    				}
    				break;
    			}
    		}
    	}
		
	}
	
	
	/**
	 *  GW方式刷新
	 */
	public static void ui_C_REFRESH(){
		
		GParam.g_Dr.navigate().refresh();
		ui_C_WAIT_MAIN();
		GLog.logRecordTime(8, "浏览器-刷新了");
	}
	/**
     *  GW方式刷新后台使用
     */
    public static void ui_C_REFRESH_ADMIN(){
        
        GParam.g_Dr.navigate().refresh();
        ui_C_WAIT_MAIN_ADMIN();
        GLog.logRecordTime(8, "浏览器-刷新了");
    }
	
	/**
	 *  等待母版页加载完成 用户前台系统
	 */
	public static void ui_C_WAIT_MAIN(){
	  
		try {
			GWCtrlWait.ViewWaitingTextByCssSelector(GTestIndicators.PageShowTime, GText.getCssSelectorTxt("div", "class", "left-content"), GWCtrlChooseModule.mapModule.get("根菜单名称"));
			GWCtrlWait.Wait2BeClickableById(GTestIndicators.PageShowTime, GWCtrlWebElementId.CN_ID.get("左侧根菜单"));
			GWCtrlWait.Wait2BeClickableById(GTestIndicators.PageShowTime, GWCtrlWebElementId.CN_ID.get("左侧列表菜单"));
			GWCtrlWait.Wait2BeClickableById(GTestIndicators.PageShowTime, GWCtrlWebElementId.CN_ID.get("打开机构层级"));
			GWCtrlWait.Wait2BeClickableById(GTestIndicators.PageShowTime, GWCtrlWebElementId.CN_ID.get("用户"));
			GWCtrlWebElementIframe.setIframe(0, "id", GWCtrlWebElementId.CN_ID.get("门户页"));
			GLog.logRecordTime(8, "页面刷新成功");
		} catch (Exception e) {
			GWCtrlException.SwtichTo(e, 1, 8, "页面刷新异常", true);
		}
	}
	
	/**
	 *  等待母版页加载完成 用户后台系统
	 */
	public static void ui_C_WAIT_MAIN_ADMIN(){		
		try {
			GWCtrlWait.ViewWaitingTextByCssSelector(GTestIndicators.PageShowTime, GText.getCssSelectorTxt("div", "class", "left-content"), GWCtrlChooseModule.mapModule.get("根菜单名称"));
			GWCtrlWait.Wait2BeClickableById(GTestIndicators.PageShowTime, GWCtrlWebElementId.CN_ID.get("左侧根菜单"));
			GWCtrlWait.Wait2BeClickableById(GTestIndicators.PageShowTime, GWCtrlWebElementId.CN_ID.get("左侧列表菜单"));
			GWCtrlWait.Wait2BeClickableById(GTestIndicators.PageShowTime, GWCtrlWebElementId.CN_ID.get("用户"));
			GWCtrlWebElementIframe.setIframe(0, "id", GWCtrlWebElementId.CN_ID.get("门户页"));
			GLog.logRecordTime(8, "页面刷新成功");
		} catch (Exception e) {
			GWCtrlException.SwtichTo(e, 1, 8, "页面刷新异常", true);
		}
	}
	
	/**
	 *  等待母版页菜单栏加载完成
	 *  
	 *  @param menuName 菜单栏目标名称
	 */
	public static void ui_C_WAIT_MAIN(String menuName){		
		try {
			GWCtrlWait.ViewWaitingTextByCssSelector(GTestIndicators.PageShowTime, GText.getCssSelectorTxt("div", "class", "left-content"), menuName);
			GWCtrlWait.Wait2BeClickableById(GTestIndicators.PageShowTime, GWCtrlWebElementId.CN_ID.get("左侧根菜单"));
			GWCtrlWait.Wait2BeClickableById(GTestIndicators.PageShowTime, GWCtrlWebElementId.CN_ID.get("左侧列表菜单"));
			GLog.logRecordTime(8, "页面刷新成功");
		} catch (Exception e) {
			GWCtrlException.SwtichTo(e, 1, 8, "页面刷新异常", true);
		}
	}
}
