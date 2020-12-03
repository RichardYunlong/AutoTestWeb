package AutoTestWeb;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import AutoTest.GLog;
import AutoTest.GText;

/**
 *  BI渲染控件
 */
public class GWCtrlVueGridBI {
	
	/**
	 *  目标vueGridBI
	 *  
	 *  能够确定唯一目标vueGridBI的上层WebElement对象,且该上层元素下仅有一个vueGridBI类型的dom
	 */
	private WebElement vueGridBI = null;
	
	/**
	 *  当前页面上的Canvases元素String对象表
	 *  <Canvas控件名称, Canvas控件元素字符串>
	 */
	public List<String> canvasesInfo = null;
	
	/**
	 *  当前页面上的Canvases控件加载成功个数
	 */
	public int nSuccess = 0;
	
	/**
	 *  当前页面上的Canvases控件加载失败个数
	 */
	public int nFailed = 0;
	
	/**
	 *  构造函数 根据目标MenuBI的WebElement对象关键属性，读取其包含的表格数据
	 *  
	 *  @param domParentType 能够确定唯一目标MenuBI的上层WebElement对象的某属性名
	 *  @param domParentValue 能够确定唯一目标MenuBI的上层WebElement对象的某属性值
	 */
	public GWCtrlVueGridBI (String domParentType, String domParentValue){
		WebElement widgetIfram = null;
		//确认菜单位置
		switch(domParentType) {
			case "id":{
				GWCtrlWait.ViewWaitingById(GTestIndicators.PageShowTime, domParentValue);
				widgetIfram = GParam.g_Dr.findElement(By.id(domParentValue));
				break;
			}
			case "cssSelector":{
				GWCtrlWait.ViewWaitingAllByCssSelector(GTestIndicators.PageShowTime, domParentValue);
				widgetIfram = GParam.g_Dr.findElement(By.cssSelector(domParentValue));
				break;
			}
			case "xpath":{
				GWCtrlWait.ViewWaitingAllByXpath(GTestIndicators.PageShowTime, domParentValue);
				widgetIfram = GParam.g_Dr.findElement(By.xpath(domParentValue));
				break;
			}
			default:{
				break;
			}
		}
		
		//创建存储区
		canvasesInfo = new ArrayList<String>();
		
		if(widgetIfram == null) {
			String msg = "数据显示区加载异常";
			GLog.logRecordTime(8, msg);
			GWCtrlAllure.makeScreenShot(msg);
			return;
		}else {
			//辅助标记
			String canvasNameTemp = "";
			String errorMsgTemp = "";
			String errorMsgCssSelector = GText.getCssSelectorTxt("div", "class", GWCtrlWebElementClass.CN_CLASS.get("渲染错误"));
			String biContainer = GText.getCssSelectorTxt("div", "class", GWCtrlWebElementClass.CN_CLASS.get("BI容器"));
			List<WebElement> biTapeTitles = null;
			List<WebElement> canvases = null;
			List<WebElement> errorMsgs = null;
			//初始化存储区数据
			try {
				//游标切换至目标一级iframe
				GWCtrlFrame.ui_C_SWITCN_ELEMENT(widgetIfram);
				GWCtrlWait.ViewWaitingAllByCssSelector(GTestIndicators.PageShowTime, GText.getCssSelectorTxt("div", "class", "portlet loading-center"));
				GWCtrlWait.ViewWaitingAllByCssSelector(GTestIndicators.PageShowTime, GText.getCssSelectorTxt("iframe", "class", "show"));		
				//目前无法确定数据集显示区单个控件的最慢加载时间，于是使用硬等待
				GWCtrlTime.Pause(3);
				WebElement showIfram = GParam.g_Dr.findElement(By.cssSelector(GText.getCssSelectorTxt("iframe", "class", "show")));
				//游标切换至目标二级iframe
				GWCtrlFrame.ui_C_SWITCN_ELEMENT(showIfram);
				GWCtrlWait.ViewWaitingAllById(GTestIndicators.PageShowTime, "wrapper");
				GWCtrlWait.ViewWaitingAllByCssSelector(GTestIndicators.PageShowTime, biContainer);
				vueGridBI = GParam.g_Dr.findElement(By.cssSelector(biContainer));
				//查找canvas元素的显示名称
				List<WebElement> biTapes = vueGridBI.findElements(By.cssSelector(GText.getCssSelectorTxt("div", "class", "bi-v-tape-layout")));
				if(biTapes != null) {
					for(WebElement biTape:biTapes){
						GWCtrlWait.ViewWaitingAllByWebElement(GTestIndicators.PageShowTime, biTape);
						
						//处理标题
						try{
							biTapeTitles = biTape.findElements(By.tagName("p"));
							if(biTapeTitles != null) {
								for(WebElement biTapeTitle:biTapeTitles){
									canvasNameTemp = biTapeTitle.getText();
									if(biTapeTitle != null && !canvasNameTemp.equals("")) {
										GLog.logRecordTime(8, "控件的标题[" + canvasNameTemp + "]");
										errorMsgs = biTape.findElements(By.cssSelector(errorMsgCssSelector));
										if(errorMsgs != null) {
											for(WebElement errorMsg:errorMsgs){
												errorMsgTemp = errorMsg.getText();
												if(errorMsg != null && !errorMsgTemp.equals("")) {
													GLog.logRecordTime(8, "控件出错[" + canvasNameTemp + "]");
													throw new Exception("控件出错[" + canvasNameTemp + "]");
												}
											}
										}
									}else {
										  throw new Exception("未找到有效的控件标题");
									}
								}
							}
							
							//处理元素
							canvases = biTape.findElements(By.tagName("canvas"));
							if(canvases != null) {
								GLog.logRecordTime(8, "找到了控件[" + canvasNameTemp + "]下的canvase对象");
								for(WebElement canvase:canvases){
									if(canvase != null) {
										canvasesInfo.add(canvasNameTemp + "|Success");
									}
									break;
								}
							}else {
								  throw new Exception("未找到有效的控件canvase对象");
							}
							nSuccess++;
						}catch(Exception e) {
							GWCtrlWait.ViewWaitingAllByCssSelector(GTestIndicators.PageShowTime, errorMsgCssSelector);
							WebElement errorMsg = biTape.findElement(By.cssSelector(errorMsgCssSelector));
							canvasesInfo.add(canvasNameTemp + "|" + errorMsg.getText());

							GWCtrlException.SwtichTo(e, 1, 8, "[" + canvasNameTemp + "]canvase控件加载失败", true);
							
							nFailed++;
						}
					}
				}else {
					GLog.logRecordTime(8, "未找到有效的canvas元素显示名称");
				}
				GWCtrlFrame.ui_C_SWITCN_DEFAULT();
				GWCtrlFrame.ui_C_SWITCN_DEFAULT();
			}catch(Exception e) {
				GWCtrlException.SwtichTo(e, 1, 8, "vueGridBI存储区数据初始化失败", true);
			}
		}
	}
}
