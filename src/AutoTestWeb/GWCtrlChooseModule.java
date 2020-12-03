package AutoTestWeb;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;

import AutoTest.GLog;
import AutoTest.GText;

/**
 *  一级菜单栏功能查找并选中处理
 */
public class GWCtrlChooseModule {
	
	/**
	 *  页面上各个菜单位置 以Xpath为查询条件
	 */
	public static Map<String, String> mapMenuFrameXpath = new HashMap<String,String>();
	
	/**
	 *  页面上各个菜单位置 以Id为查询条件
	 */
	public static Map<String, String> mapMenuFrameId= new HashMap<String,String>();
	
	/**
	 *  目标功能模块信息
	 *  目前最多支持五级子菜单，各级别均为必填项，如果没有请负值为空
	 */
	public static Map<String, String> mapModule = new HashMap<String,String>();
	
	/**
	 *  左侧菜单处理 目前最大到5级菜单
	 *  @param divId 菜单位置参数 例如：l_navigator
	 *  @param divXpath 菜单位置参数 例如：/html/body/div[4]/div/div[2]/div[1]
	 *  @param strModuleTitle 根菜单名称 例如：项目管理
	 *  @param strModuleLevel1 一级菜单名称 例如：成本管理
	 *  @param strModuleLevel2 二级菜单名称 例如：目标责任成本管理
	 *  @param strModuleLevel3 三级菜单名称 例如：目标责任成本（清单方式）
	 *  @param strModuleLevel4 四级菜单名称 例如：目标责任成本编制（清单方式）
	 *  @param strModuleLevel5 五级菜单名称 例如：备用
	 */
	public static void SelectModule(String menuId,
									String menuClass, 
									String menuXpath, 
									String strModuleTitle, 
									String strModuleLevel1, 
									String strModuleLevel2, 
									String strModuleLevel3, 
									String strModuleLevel4,
									String strModuleLevel5) {
		
		try {
			//判断菜单位置参数
			if(menuId.equals("") && menuClass.equals("") && menuXpath.equals("")) {
				GLog.logRecordTime(8, "菜单位置参数为空，无法找到菜单位置，请修正后重试");
				return;
			}
			if(strModuleTitle == null) {
				GLog.logRecordTime(8, "[strModuleTitle]为空, 未指定根菜单名称，请检查修正后重试");
				return;
			}
			
			//确认根菜单 使用方式优先级：id > class > xpath
			WebElement menuRoot = null;
			if(!menuId.equals("")) {
				GWCtrlWait.ViewWaitingAllById(GTestIndicators.PageShowTime, menuId);
				menuRoot = GWCtrlStaticFind.getWebElementByIdOrXpath(GParam.g_Dr, menuId, "", "span", "title", strModuleTitle, strModuleTitle);
			}else if(menuId.equals("") && (!menuClass.equals(""))) {
				GWCtrlWait.ViewWaitingAllByClassName(GTestIndicators.PageShowTime, menuClass);
				menuRoot = GWCtrlStaticFind.getWebElementByIdOrXpath(GParam.g_Dr, "", menuClass, "span", "title", strModuleTitle, strModuleTitle);	
			}else {
				GWCtrlWait.ViewWaitingAllByXpath(GTestIndicators.PageShowTime, menuXpath);
				menuRoot = GWCtrlStaticFind.getWebElementByIdOrXpath(GParam.g_Dr, "", menuXpath, "span", "title", strModuleTitle, strModuleTitle);	
			}
			
			//如果找到元素，则点击元素，如果没找到，则根据显示文本值点击，如“点击写着【项目管理】区域”
			if(menuRoot != null) {
				menuRoot.click();
			}else {
				GWCtrlSpanClick.ByLinkText(strModuleTitle);
			}
			
			//确认一级菜单
			if(strModuleLevel1 == null || strModuleLevel1.equals("")) {
				GLog.logRecordTime(8, "[strModuleLevel1]为空, 未指定一级菜单名称，请检查修正后重试");
			}else {
				GWCtrlSpanClick.ByCssSelector(GText.getCssSelectorTxt("span", "title", strModuleLevel1));
			}

			//确认二级菜单
			if(strModuleLevel2 == null || strModuleLevel2.equals("")) {
				GLog.logRecordTime(8, "[strModuleLevel2]为空, 未指定二级菜单名称，请检查修正后重试");
			}else {
				if(strModuleLevel3 == null || strModuleLevel3.equals("")) {
					GWCtrlHrefClick.ByLinkText(strModuleLevel2);
				}else {
					GWCtrlMouseMove.ToCssSelector(GParam.g_Dr, GText.getCssSelectorTxt("a", "title", strModuleLevel2));
				}
			}

			//确认三级菜单
			if(strModuleLevel3 == null || strModuleLevel3.equals("")) {
				GLog.logRecordTime(8, "[strModuleLevel3]为空, 未指定三级菜单名称，请检查修正后重试");
			}else {
				GWCtrlHrefClick.ByLinkText(strModuleLevel3);
			}
			
			//确认四级菜单
			if(strModuleLevel4 == null || strModuleLevel4.equals("")) {
				GLog.logRecordTime(8, "[strModuleLevel4]为空, 未指定四级菜单名称，请检查修正后重试");
			}else {
				GWCtrlHrefClick.ByLinkText(strModuleLevel4);
			}

			//确认五级菜单
			if(strModuleLevel5 == null || strModuleLevel5.equals("")) {
				GLog.logRecordTime(8, "[strModuleLevel5]为空, 未指定五级菜单名称，请检查修正后重试");
			}else {
				GWCtrlHrefClick.ByLinkText(strModuleLevel5);
			}
			
			//等待中心显示区加载完成 "iframe_main show"并不是某个具体元素，而是等待某个元素为加载完成，该元素有个属性为【class="iframe_main show"】
			//如果【列表页签】能有确定且唯一的属性，例如id或者class的值唯一，则需要优化以下等待方式
			GWCtrlWebElementIframe.setIframe(1, "cssSelector", "iframe_main show");
			
			//打印当前菜单
			GLog.logRecordTime(8, "当前功能模块:" 
								+ "[" + strModuleTitle + "]-"
								+ "[" + strModuleLevel1 + "]-" 
								+ "[" + strModuleLevel2 + "]-" 
								+ "[" + strModuleLevel3 + "]-" 
								+ "[" + strModuleLevel4 + "]-" 
								+ "[" + strModuleLevel5 + "]");
		}catch(Exception e) {
			GWCtrlException.SwtichTo(e, 1, 8, "功能模块菜单选择失败", true);
		}
	}
	
	public GWCtrlChooseModule(){
		
		mapMenuFrameId.put("顶端", "");
		mapMenuFrameId.put("左侧", "l_navigator");
		mapMenuFrameId.put("中间", "");
		mapMenuFrameId.put("右侧", "");
		
		mapMenuFrameXpath.put("顶端", "");
		mapMenuFrameXpath.put("左侧", "");
		mapMenuFrameXpath.put("中间", "");
		mapMenuFrameXpath.put("右侧", "");
	}
}
