package AutoTestWeb;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import AutoTest.GLog;
import AutoTest.GText;

/**
 *  列表区处理
 */
public class GWCtrlList {
	
	
	/**
	 *  目标List
	 *  
	 *  能够确定唯一目标grid3的上层WebElement对象,且该上层元素下仅有一个grid3类型的dom
	 */
	private WebElement divGrid3List = null;
	
	/**
	 *  列表区的搜索条件输入框
	 */
	private WebElement inputSearch = null;
	
	/**
	 *  构造函数1 根据目标ListSearch的WebElement对象初始化
	 *  
	 *  @param domRoot 能够确定唯一目标GWCtrlListSearch的WebElement对象
	 */
	public GWCtrlList(WebElement domRoot) {
		
	}
	
	/**
	 *  构造函数1 根据目标ListSearch的WebElement对象初始化
	 *  
	 *  @param domRootType 能够确定唯一目标ListSearch的上层WebElement对象的某属性名
	 *  @param domRootValue 能够确定唯一目标ListSearch的上层WebElement对象的某属性值
	 */
	public GWCtrlList(String domParentType, String domParentValue) {
		WebElement domRoot = null;
		try {
			switch(domParentType) {
				case "id":{
					domRoot = GParam.g_Dr.findElement(By.id(domParentValue));
					break;
				}
				case "cssSelector":{
					domRoot = GParam.g_Dr.findElement(By.cssSelector(domParentValue));
					break;
				}
				case "xpath":{
					domRoot = GParam.g_Dr.findElement(By.xpath(domParentValue));
					break;
				}
				default:{
					break;
				}
			}
			
			divGrid3List = domRoot;
			
			//定位搜索区
			List<WebElement> searchFields = domRoot.findElements(By.cssSelector(GText.getCssSelectorTxt("div", "class", GWCtrlWebElementClass.CN_CLASS.get("列表区-搜索区"))));
			if(searchFields != null) {
				for(WebElement searchField:searchFields){
					List<WebElement> inputSearchFields = searchField.findElements(By.tagName("input"));
					if(inputSearchFields != null) {	
						for(WebElement inputSearchField:inputSearchFields){
							GLog.logRecordTime(8, "找到目标，类型为：inputSearchField；元素为[" + inputSearchField.toString() + "]");
							inputSearch = inputSearchField;
							break;
						}
					}
					break;
				}
			}
			
		} catch (Exception e) {
			GWCtrlException.SwtichTo(e, 1, 8, "没有找到有效的list元素", true);
		}
	}
	
	/**
	 *  根据单据编号搜索并选中目标数据
	 *  
	 *  @param colCode 单据编号
	 */
	public void ui_C_SEARCH_CODE(String colCode) {
		try {
			//填写条件
			GWCtrlInputFill.ByWebElementUnClear(inputSearch, colCode);
			
			try {
				GLog.logRecordTime(8, "尝试点击搜索按钮确保搜索结果的有效性");
				try {
					GLog.logRecordTime(8, "尝试点击搜索按钮的图片的上级span元素");
					WebElement search2 = GParam.g_Dr.findElement(By.cssSelector(GText.getCssSelectorTxt("img", "class", GWCtrlWebElementClass.CN_CLASS.get("列表区-搜索区-搜索按钮"))));
					WebElement searchParent = search2.findElement(By.xpath(".."));
					searchParent.click();
				}catch (Exception e) {
					GLog.logRecordTime(8, "尝试点击搜索按钮，但失败，再尝试点击搜索按钮的图片");
					e.printStackTrace();
					WebElement search1 = GParam.g_Dr.findElement(By.cssSelector(GText.getCssSelectorTxt("img", "class", GWCtrlWebElementClass.CN_CLASS.get("列表区-搜索区-搜索按钮"))));
					search1.click();
				}
				
			} catch (Exception e) {
				GLog.logRecordTime(8, "尝试点击搜索按钮，但失败");
				e.printStackTrace();
			}
			
			GWCtrlWait.ViewWaitingTextByWebElement(GTestIndicators.PageShowTime, divGrid3List, colCode);

			//选中单据
			GParam.g_Dr.findElement(By.cssSelector(GText.getCssSelectorTxt("div", "class", "x-grid3-cell-inner x-grid3-col-numberer x-unselectable"))).click();
			GLog.logRecordTime(8, "查找单据成功");
		} catch (Exception e) {
			GWCtrlException.SwtichTo(e, 1, 8, "查找单据失败", true);
		}
	}
	
	/**
	 *  根据条件字符串选中【列表】中某目标
	 *  
	 *  @param tagColCode 选中条件，使用【类别编码】为选中条件
	 */
	public void ui_C_SELECT_BILLVIEW(String tagColCode){
		try {
			GWCtrlInputFill.ByWebElementUnClear(inputSearch, tagColCode);
			GParam.g_Dr.findElement(By.cssSelector(GText.getCssSelectorTxt("img", "class", GWCtrlWebElementClass.CN_CLASS.get("列表区-搜索区-搜索按钮"))));
		} catch (Exception e) {
			GLog.logRecordTime(8, "No DisplayCode Exist");
			return;
		}
		
		if(divGrid3List != null) {
			GWCtrlWait.ViewWaitingTextByWebElement(GTestIndicators.PageShowTime, divGrid3List, tagColCode);
			try {
				List<WebElement> colStates = null;
				List<WebElement> colDeptNames = null;
				//精确搜索保证仅有一条记录后，方可通过点击“不具备跳转功能的区域”，来确认选中
				colStates = divGrid3List.findElements(By.cssSelector(GText.getCssSelectorTxt("div", "class", "x-grid3-cell-inner x-grid3-col-col_State x-unselectable")));
				colDeptNames = divGrid3List.findElements(By.cssSelector(GText.getCssSelectorTxt("div", "class", "x-grid3-cell-inner x-grid3-col-col_DeptName x-unselectable")));
				
				if(colStates != null && colStates.size() != 0) {
					for(WebElement colState:colStates){//尝试点击【状态】字段，因为该字段点击只有“选中”效果，没有“跳转”效果
						if(!colState.getText().equals("")) {//目前只保存第一个找到的divGrid3List
							colState.click();
							GLog.logRecordTime(8, "目标[" + tagColCode.toString() + "]被点击了");
							break;
						}
					}
				}else {//如果没有【状态】字段，尝试点击【编制机构】字段，因为该字段点击只有“选中”效果，没有“跳转”效果
					for(WebElement colDeptName:colDeptNames){//尝试点击【状态】字段，因为该字段点击只有“选中”效果，没有“跳转”效果
						if(!colDeptName.getText().equals("")) {//目前只保存第一个找到的divGrid3List
							colDeptName.click();
							GLog.logRecordTime(8, "目标[" + tagColCode.toString() + "]被点击了");
							break;
						}
					}
				}

				GWCtrlWait.ViewWaitingTextByWebElement(GTestIndicators.PageShowTime, divGrid3List, tagColCode);
			} catch (Exception e) {
				GLog.logRecordTime(8, "No DisplayCode Exist");
				e.printStackTrace();
			}
		}
	}
	
	/**
	 *  根据给定的参数名称在参数列表区搜索目标数据
	 *  因此方法用到的很多方法都是公共方法，为避免后续代码重复，因为在公共方法中增加--待确认是否可行
	 *  @author 赵君  2020.10.29
	 *  @param name 参数名称
	 */
	public void ui_C_SEARCH_NAME(String name) {
		try {
			//填写条件
			GWCtrlInputFill.ByWebElementUnClear(inputSearch, name);
			
			GParam.g_Dr.findElement(By.cssSelector(GText.getCssSelectorTxt("img", "class", GWCtrlWebElementClass.CN_CLASS.get("列表区-搜索区-搜索按钮"))));
			
			GWCtrlWait.ViewWaitingAllByWebElement(GTestIndicators.PageShowTime, divGrid3List);
			GWCtrlWait.ViewWaitingTextByWebElement(GTestIndicators.PageShowTime, divGrid3List, name);
			GLog.logRecordTime(8, "查找参数成功");
		} catch (Exception e) {
			GLog.logRecordTime(8, "查找参数失败");
			e.printStackTrace();
		}
	}
}
