package AutoTestWeb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import AutoTest.GLog;
import AutoTest.GTestMission;
import AutoTest.GText;
import io.qameta.allure.Step;

/**
 *  BI菜单
 */
public class GWCtrlMenuBI {
	
	/**
	 *  目标menuBI
	 *  
	 *  能够确定唯一目标menuBI的上层WebElement对象,且该上层元素下仅有一个menuBI类型的dom
	 */
	private WebElement menuBI = null;
	
	/**
	 *  当前空间区路径
	 */
	private String menuPath = "";
	
	/**
	 *  Canvases控件加载成功个数总计
	 */
	public int nTotalSuccess = 0;
	
	/**
	 *  Canvases控件加载失败个数总计
	 */
	public int nTotalFailed = 0;
	
	/**
	 *  菜单区-菜单
	 *  <菜单序号<菜单名, 菜单元素>>
	 *  根据产品菜单的显隐方式，虽然二级菜单默认为隐藏，但是采用同一类型的tagname可以搜索到所有菜单名称，只是需要将搜索结果中的的【一级、二级菜单对应关系】另做保存
	 */
	public Map<Integer, Map<String, WebElement>> index_menu = null;
	
	/**
	 *  菜单区-一级菜单
	 *  <序号, 菜单名>
	 */
	public Map<Integer, String> index_menu1 = null;
	
	/**
	 *  菜单区-一级、二级菜单对应关系
	 *  <菜单名, 菜单名>
	 */
	public Map<String, String> menu1_menu2 = null;
	
	/**
	 *  叶子菜单上的Canvases元素String对象表
	 *  <叶子菜单序号<Canvas控件名称, Canvas控件元素字符串>>
	 */
	public List<String> leaves_String = new ArrayList<String>();
	

	/**
	 *  构造函数 根据目标MenuBI的WebElement对象关键属性，读取其包含的表格数据
	 *  
	 *  @param domParentType 能够确定唯一目标MenuBI的上层WebElement对象的某属性名
	 *  @param domParentValue 能够确定唯一目标MenuBI的上层WebElement对象的某属性值
	 */
	public GWCtrlMenuBI(String domParentType, String domParentValue) {
		//确认菜单位置
		switch(domParentType) {
			case "id":{
				GWCtrlWait.ViewWaitingById(GTestIndicators.PageShowTime, domParentValue);
				menuBI = GParam.g_Dr.findElement(By.id(domParentValue));
				break;
			}
			case "cssSelector":{
				GWCtrlWait.ViewWaitingAllByCssSelector(GTestIndicators.PageShowTime, domParentValue);
				menuBI = GParam.g_Dr.findElement(By.cssSelector(domParentValue));
				break;
			}
			case "xpath":{
				GWCtrlWait.ViewWaitingAllByXpath(GTestIndicators.PageShowTime, domParentValue);
				menuBI = GParam.g_Dr.findElement(By.xpath(domParentValue));
				break;
			}
			default:{
				break;
			}
		}
		
		//创建存储区
		index_menu = new HashMap<Integer, Map<String, WebElement>>();
		index_menu1 = new HashMap<Integer, String>();
    	menu1_menu2 = new HashMap<String, String>();

		if(menuBI == null) {
			String msg = "没有找到有效的MenuBI元素";
			GLog.logRecordTime(8, msg);
			GWCtrlAllure.makeScreenShot(msg);
			return;
		}else {
			//辅助标记
			String companyNameTemp = "";
			int menuIndexTemp = 0;
			String menuNameTemp = "";
			WebElement menuWebElementTemp = null;
			//初始化存储区数据
			try {
				//查找当前选中的机构名称
				WebElement company = GParam.g_Dr.findElement(By.cssSelector(GText.getCssSelectorTxt("span", "class", "company-title theme-platform-name")));
				companyNameTemp = company.getText();
				//查找菜单元素 通过span标签可以找到所有一级、二级菜单
				List<WebElement> menus = menuBI.findElements(By.tagName("span"));
				for(WebElement menu:menus){
					//取得当前菜单的名称
					menuNameTemp = menu.getAttribute("title");
					//如果当前菜单不为null且标题字符串不为空，则当前菜单是个【有效菜单】
					if(menu != null && !menuNameTemp.equals("")) {
						//有效菜单数加1
						menuIndexTemp++;
						//获得当前span标签的【上上级】，即当前菜单的【独立区域最顶部】
						menuWebElementTemp = menu.findElement(By.xpath("../.."));
						//如果当前菜单的【独立区域最顶部】不为空，则将当前的<菜单序号<菜单名, 菜单元素>>保存到数据区
						if(menuWebElementTemp != null) {
							Map<String, WebElement> menuNameWebElementTemp = new HashMap<String, WebElement>();
							menuNameWebElementTemp.put(menuNameTemp, menuWebElementTemp);
							index_menu.put(Integer.valueOf(menuIndexTemp), menuNameWebElementTemp);
							index_menu1.put(Integer.valueOf(menuIndexTemp), menuNameTemp);
							clickMenuBI(companyNameTemp, menuIndexTemp, menuNameTemp);
							//目前无法确定点击父菜单后子菜单的最慢加载时间，于是使用硬等待,如果找到更好的方法，则删除此项
							//GWCtrlTime.Pause(3);
						}else {
							GLog.logRecordTime(8, "未找目标一级菜单上的可点击区域");
						}
					}else {
						GLog.logRecordTime(8, "未找到有效的一级菜单");
					}
				}
			}catch(Exception e) {
				GWCtrlException.SwtichTo(e, 1, 8, "menuBI存储区数据初始化失败", true);
			}
		}
	}
	
	
	/**
     * 点击菜单
     */
    @Step("点击菜单[{0}]-[{1}]-[{2}]")
	public void clickMenuBI(String companyName, Integer menuIndex, String menuName){
    	WebElement menuWebElement = null;
    	
		//辅助标记
		WebElement menuSubTemp = null;
		String vueGridBICssSelector = GText.getCssSelectorTxt("iframe", "name", "widgetIfram");
    	
    	try {
    		//取得目标菜单
    		menuWebElement = index_menu.get(menuIndex).get(menuName);
    		GWCtrlWait.ViewWaitingAllByWebElement(GTestIndicators.PageShowTime, menuWebElement);
	    	if(menuWebElement != null){
	    		//检测当前菜单是否为叶子菜单
	    		try {
	    			menuSubTemp = menuWebElement.findElement(By.cssSelector(GText.getCssSelectorTxt("div", "class", "sub-menu")));
	    			//如果存在下级菜单，则非叶子菜单
	    			if(menuSubTemp != null) {
	    				GLog.logRecordTime(8, "当前菜单[" + menuName + "]不是叶子菜单");
	    				//点击展开
	    				menuWebElement.click();
	    				menu1_menu2.put(menuName, "空");
	    				//如果不是叶子节点，有可能是一级菜单，则记录一下当前路径的一级菜单
	    				menuPath += menuName;
	    				return;
	    			}
		    	}catch(Exception e) {
		    		//如果不存在夏季菜单，则是叶子菜单，则点击
		    		menuWebElement.click();
		    		String msgTemp = "当前菜单[" + menuName + "]是叶子菜单，直接扫描数据集";
		    		menu1_menu2.put(String.valueOf(menuIndex), menuName);
		    		if(!menuPath.equals("")) {
		    			menuPath += "|" + menuName;
		    		}else {
		    			menuPath = menuName + "|空";
		    		}
					GLog.logRecordTime(8, msgTemp);
		    		//等待数据集区加载完成
		    		GWCtrlWait.ViewWaitingAllByCssSelector(GTestIndicators.PageShowTime, vueGridBICssSelector);
		    		//暂时取消正常用例的截图
		    		//GWCtrlAllure.makeScreenShot(msgTemp);
		    		
		    		//创建GWCtrlVueGridBI类
		    		GWCtrlVueGridBI vueGridBI = new GWCtrlVueGridBI("cssSelector", vueGridBICssSelector);
		    		if(vueGridBI.canvasesInfo != null) {
						for(String canvas:vueGridBI.canvasesInfo){
							leaves_String.add(companyName + "|"+ menuPath + "|" + canvas);
						}
					}	
		    		nTotalSuccess += vueGridBI.nSuccess;
		    		nTotalFailed += vueGridBI.nFailed;
		    		menuPath = "";
				}
	    	}else {
				GLog.logRecordTime(8, "未找菜单[" + menuName + "]");
			}
	    }catch(Exception e) {
			GWCtrlException.SwtichTo(e, 1, 8, "菜单[" + menuName + "]点击失败", true);
		}
    }
    
    /**
     * 打印叶子菜单
     */
    @Step("打印叶子菜单")
    public void showMenuWebElement(){
		GLog.logRecordTime(8, "<序号,菜单名>");
		GLog.logRecordTime(8, index_menu1.toString());
    }
    
    /**
     * 打印一级、二级菜单关系
     */
    @Step("打印一级、二级菜单关系")
    public void showMenu1Menu2(){
		GLog.logRecordTime(8, "<一级菜单名, 二级菜单名>");
		if(menu1_menu2 != null) {
			GLog.logRecordTime(8, menu1_menu2.toString());
		}else {
			GLog.logRecordTime(8, "menu1_menu2暂时为空，即本次监控非二级菜单");
		}	
    }
    
    /**
     * 打印叶子菜单上的CanvasList
     */
    @Step("打印叶子菜单上的CanvasList")
    public void showMenuCanvasString(){
		GLog.logRecordTime(8, "<叶子菜单名<Canvas控件名, Canvas控件元素>>");
		GLog.logRecordTime(8, "成功[" + nTotalSuccess + "] 失败[：" + nTotalFailed + "]");
		GLog.logRecordTime(8, leaves_String.toString());		
    }
    
    /**
     * 发送数据至html报告准备区
     */
    @Step("发送数据至html报告准备区")
    public void preBIMonitorReport(){
    	GTestMission.endSysTime = System.currentTimeMillis();
    	
    	//初始化明细表格
    	for(String leaf:leaves_String){
    		if(leaf.indexOf("Success") == -1) {
    			GWCtrlSummoryBI.addBIInfo(leaf, false);
    		}else{
    			GWCtrlSummoryBI.addBIInfo(leaf, true);
    		}
    	}
    	GLog.logRecordTime(8, leaves_String.toString());
    }
    
    
    /**
     * 生成html报告
     */
    @Step("生成html报告")
    public static void biMonitorReport(){
    	GWCtrlMonitorBI.outPutHtml();
    }
}
