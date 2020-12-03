package AutoTestWeb;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import AutoTest.GLog;
import AutoTestScene.GScene;
/**
 *  主显示区-顶层菜单栏
 */
public class GWCtrlTopMenuBtn {
	
	/**
	 *  选定范围条件
	 */
	public static boolean ui_C_SELECT_SCOPE(int nIndex){
		//辅助标记
		//范围选择区域类型描述
		int bWindowIndex = 0;
		//范围选择区域是否存在
		boolean bWindow = false;
		//范围选择区域类型描述
		String bWindowScript = "未知类型";
		//范围选择区域是已经处理完成
		boolean bWindowComplete = false;
		
		if(nIndex <= 1) {
			WebElement divRoot = null;
			GLog.logRecordTime(8, "判断是否需要选定范围条件");
			try {
				//先判断范围选择区域是否存在
				while(!bWindow) {
					try {
						switch(bWindowIndex){
							case 0:{bWindowScript = "windowView";break;}
							case 1:{bWindowScript = "wvXZ";break;}
							default:{GLog.logRecordTime(8, "无需选定范围条件");return false;}
						}
						GWCtrlWait.ViewWaitingAllById(3, bWindowScript);
						divRoot = GParam.g_Dr.findElement(By.id(bWindowScript));
						bWindow = true;
						GLog.logRecordTime(8, "范围选择区域存在，类型编号为[" + bWindowIndex + "]");
					} catch(Exception e) {
						bWindowIndex++;
						GLog.logRecordTime(8, "循环判断[范围选择区域是否存在]");
					}
				}
				
				if(divRoot != null) {
					//范围选择区域未处理完成时循环判断类型
					while(!bWindowComplete) {
						try {
							//输入条件 根本不同的范围业务执行不同的业务范围选择，目前主要用于列表区菜单
							switch(bWindowIndex){
								case 0:{
									List<WebElement> dates = divRoot.findElements(By.id("Efd_BizDate_EV"));
									for(WebElement date:dates){
										if(date != null) {
											GLog.logRecordTime(8, "输入范围条件");
											GWCtrlInputFill.ByWebElement(date, "2020-11-23");
											break;
										}
									}
									break;
								}
								case 1:{
									//填入【结算单位】
									//点击按钮显示供应商列表二级窗体
									GWCtrlPage.ui_C_SELECT_INPUT_BTN("Efd_GYSMC", "");
									//游标切换至二级窗体
									GWCtrlWindow.windowHandles();
									//搜索并选中
									GWCtrlPage.ui_C_WAIT_CLICK(GWCtrlWebElementId.CN_ID.get("外部单位"), "");
									GWCtrlGrid3 sourceGrid3 = new GWCtrlGrid3("id", GWCtrlWebElementId.CN_ID.get("数据源"));
									sourceGrid3.ui_C_SELECT_SOURCE(GScene.DYNAMIC_DATA.get("材料最终结算单-供应商"));
									GWCtrlPage.ui_C_WAIT_CLICK(GWCtrlWebElementId.CN_ID.get("二级窗体 确定"), "");
						        	//游标切换回主窗体
									GWCtrlWindow.windowHandlePre();
									break;
								}
								default:{
									break;
								}
							}
								
							bWindowComplete = true;
							GLog.logRecordTime(8, "范围选择类型[" + bWindowScript + "]处理完成");
						} catch(Exception e) {
							GLog.logRecordTime(8, "循环判断[范围选择类型]");
						}
					}
					
					//点击确定
					GWCtrlFrame.ui_C_SWITCN_ELEMENT(GWCtrlWebElementIframe.getIframe(nIndex));
					GWCtrlWait.ViewWaitingAllById(3, bWindowScript);
					divRoot = GParam.g_Dr.findElement(By.id(bWindowScript));
					List<WebElement> buttons = divRoot.findElements(By.tagName("button"));
					for(WebElement button:buttons){
						if(button.getText().equals("确定")) {
							GLog.logRecordTime(8, "选定范围条件");
							button.click();
							break;
						}
					}
				}else {
					GLog.logRecordTime(8, "无需选定范围条件");
				}
			}catch (Exception e){
				GLog.logRecordTime(8, "判断是否需要选定范围条件出错");
				e.printStackTrace();
			}
		}

		return bWindowComplete;
	}
	
	/**
	 *  点击某定区域内某Id元素
	 *  @param eXpath 指定区域xpath
	 *  @param eId 指定元素id
	 *  @param wId 等待元素Id
	 */
	public static void ui_C_CLICK_TOPMENUBTN(int tabIndex, String eId, String wId){
		GLog.logRecordTime(8, "尝试点击id为[" + eId + "]的按钮");
		try {	
			//由母版区域进入目标区域
			GWCtrlFrame.ui_C_SWITCN_ELEMENT(GWCtrlWebElementIframe.getIframe(tabIndex));
			//等待目标出现
	    	GWCtrlWait.ViewWaitingAllById(GTestIndicators.PageShowTime, eId);
	    	//点击该目标
	    	GWCtrlDivClick.ById(eId);
	    	
	    	ui_C_SELECT_SCOPE(tabIndex);
	    	
	    	//返回母版区域
			GWCtrlFrame.ui_C_SWITCN_DEFAULT();
			//等待完成
			GWCtrlPage.ui_D_IFRAME_INDEX(tabIndex, "id", wId);
			
			GLog.logRecordTime(8, "点击id为[" + eId + "]的按钮成功");
		}catch (Exception e){
			GWCtrlException.SwtichTo(e, 1, 8, "点击id为[" + eId + "]的按钮异常", true);
		}
	}
	
	/**
	 *  按照页签序号点击顶层菜单按钮中的按钮
	 *  
	 *  @param indexTab 页签序号
	 *  @param menubtnName 按钮名称
	 *  @param wId 等待元素Id
	 */
	public static void ui_C_CLICK_TOPMENUBTN_TAB_INDEX(int tabIndex, String topBtnName,String wId){	
		//点击按钮
		ui_C_CLICK_TOPMENUBTN(tabIndex, GWCtrlWebElementId.CN_ID.get(topBtnName), wId);
		//检测校验窗体
		if(topBtnName.equals("保存")) {//如果当前为【保存按钮】功能
			if(GWCtrlAlert.ui_C_ALERT(tabIndex, "")) {//如果当前存在【提示窗体】
				if(!GWCtrlTopMenuBtn.ui_C_GET_TOPMENUBTN_TAB2_STATUS(topBtnName, GTestIndicators.PageShowTime, wId)) {//如果【保存按钮】不是【置灰状态】
					GWCtrlTopMenuBtn.ui_C_CLICK_TOPMENUBTN_TAB_INDEX(tabIndex, topBtnName, wId);
				}
			}		
		}else if(topBtnName.equals("新_建") || topBtnName.equals("新建") ){
			//点击新建后，将当前显示在最前端的窗体设置为目标，从中读取iframe，然后保存。这种方法有风险，如果当前显示在最前端的窗体不是【单据内容】窗体，则会使后面的一席列操作出错
			//记得优化此处的逻辑
			GWCtrlWebElementIframe.setIframe(2, "cssSelector", "iframe_main show");
		}else if(topBtnName.equals("查_看") || topBtnName.equals("查看") ){
			//点击新建后，将当前显示在最前端的窗体设置为目标，从中读取iframe，然后保存。这种方法有风险，如果当前显示在最前端的窗体不是【单据内容】窗体，则会使后面的一席列操作出错
			//记得优化此处的逻辑
			GWCtrlWebElementIframe.setIframe(2, "cssSelector", "iframe_main show");
		}else if(topBtnName.equals("删_除") || topBtnName.equals("删除") ){
			//先判断目标状态是否可删除
			
			//然后确认删除	
		}
	}
	
	/**
	 *  判断1号页签中顶层菜单按钮中的按钮状态
	 *  
	 *  @param menubtnName 按钮名称
	 *  @param mTime 最大等待时间
	 *  @param wId 等待目标
	 */
	public static boolean ui_C_GET_TOPMENUBTN_TAB1_STATUS(String menubtnName,int mTime, String wId){
		boolean bRes = false;
		WebElement divRoot = null;
		//由母版区域进入目标区域
		GWCtrlFrame.ui_C_SWITCN_ELEMENT(GWCtrlWebElementIframe.getIframe(1));
		//等待目标出现
    	GWCtrlWait.Wait2BeClickableById(mTime, GWCtrlWebElementId.CN_ID.get(menubtnName));
    	
    	//限制等待时间 如果传入的时间不大于10s，则等待时间减半
    	if(mTime <= 10) {
    		mTime = mTime / 2;
    		if(mTime <= 3) {
    			mTime = 3;
    		}
    	}
    	
		try {
	    	//定时检测
	    	GWCtrlTime.setTimer(mTime);
	    	divRoot = GParam.g_Dr.findElement(By.id(GWCtrlWebElementId.CN_ID.get(menubtnName)));
	    	while(GWCtrlTime.getTimer() != 0) {
	    		switch(menubtnName) {
		    		case "删_除":{
						//判断状态是否为置灰
						String btnStatus = divRoot.getAttribute("class");
						if(null != btnStatus && !btnStatus.equals("")) {
							if(btnStatus.indexOf("-disabled") != -1) {
								bRes = true;
								GLog.logRecordTime(8, "名称为[" + menubtnName + "]的按钮状态判断成功，为[置灰]");
								GWCtrlTime.setTimer(0);
							}else {
								GLog.logRecordTime(8, String.valueOf(GWCtrlTime.getTimer()));
								GWCtrlTime.Pause(1);
								GWCtrlTime.TimerMinus();
							}
						}
		    			break;
		    		}
		    		case "提交":{
		    			//判断是否为取消提交
						List<WebElement> buttons = divRoot.findElements(By.tagName("button"));
						for(WebElement button:buttons){
							if(button.getText().equals("取消提交")) {
								bRes = true;
								GLog.logRecordTime(8, "名称为[" + menubtnName + "]的按钮状态判断成功，为[取消提交]");
								GWCtrlTime.setTimer(0);
								break;
							}else {
								GLog.logRecordTime(8, String.valueOf(GWCtrlTime.getTimer()));
								GWCtrlTime.Pause(1);
								GWCtrlTime.TimerMinus();
							}
						}
		    			break;
		    		}
		    		case "取消提交":{
		    			//判断是否为取消提交
						List<WebElement> buttons = divRoot.findElements(By.tagName("button"));
						for(WebElement button:buttons){
							if(button.getText().equals("提交")) {
								bRes = true;
								GLog.logRecordTime(8, "名称为[" + menubtnName + "]的按钮状态判断成功，为[提交]");
								GWCtrlTime.setTimer(0);
								break;
							}else {
								GLog.logRecordTime(8, String.valueOf(GWCtrlTime.getTimer()));
								GWCtrlTime.Pause(1);
								GWCtrlTime.TimerMinus();
							}
						}
		    			break;
		    		}
		    		default:{
		    			break;
		    		}
	    		}
	    	}
		}catch (Exception e){
			GWCtrlException.SwtichTo(e, 1, 8, "名称为[" + menubtnName + "]的按钮状态判断失败", true);
		}
    	//返回母版区域
		GWCtrlFrame.ui_C_SWITCN_DEFAULT();
		//检测校验窗体 目前有两个位置需要增加提示窗体处理，此处暂时关闭
		//GWCtrlAlert.ui_C_ALERT(GWCtrlWebElementXpath.CN_XPATH.get("顶层页签2 主体显示区"), "保存");
		//等待完成
		GWCtrlPage.ui_D_IFRAME_INDEX(1, "id", wId);
		return bRes;
	}
	
	/**
	 *  判断2号页签中顶层菜单按钮中的按钮状态
	 *  
	 *  @param menubtnName 按钮名称
	 *  @param mTime 最大等待时间
	 *  @param wId 等待目标
	 */
	public static boolean ui_C_GET_TOPMENUBTN_TAB2_STATUS(String menubtnName,int mTime, String wId){
		boolean bRes = false;
		WebElement divRoot = null;
		//由母版区域进入目标区域
		GWCtrlFrame.ui_C_SWITCN_ELEMENT(GWCtrlWebElementIframe.getIframe(2));
		//等待目标出现
    	GWCtrlWait.Wait2BeClickableById(mTime, GWCtrlWebElementId.CN_ID.get(menubtnName));
    	
    	//限制等待时间 如果传入的时间不大于10s，则等待时间减半
    	if(mTime <= 10) {
    		mTime = mTime / 2;
    		if(mTime <= 3) {
    			mTime = 3;
    		}
    	}
    	
		try {
	    	//定时检测
	    	GWCtrlTime.setTimer(mTime);
	    	divRoot = GParam.g_Dr.findElement(By.id(GWCtrlWebElementId.CN_ID.get(menubtnName)));
	    	while(GWCtrlTime.getTimer() != 0) {
	    		switch(menubtnName) {
		    		case "删除":{
						//判断状态是否为置灰
						String btnStatus = divRoot.getAttribute("class");
						if(null != btnStatus && !btnStatus.equals("")) {
							if(btnStatus.indexOf("-disabled") != -1) {
								bRes = true;
								GLog.logRecordTime(8, "名称为[" + menubtnName + "]的按钮状态判断成功，为[置灰]");
								GWCtrlTime.setTimer(0);
							}else {
								GLog.logRecordTime(8, String.valueOf(GWCtrlTime.getTimer()));
								GWCtrlTime.Pause(1);
								GWCtrlTime.TimerMinus();
							}
						}
		    			break;
		    		}
		    		case "保存":{
						//判断状态是否为置灰
						String btnStatus = divRoot.getAttribute("class");
						if(null != btnStatus && !btnStatus.equals("")) {
							if(btnStatus.indexOf("-disabled") != -1) {
								bRes = true;
								GLog.logRecordTime(8, "名称为[" + menubtnName + "]的按钮状态判断成功，为[置灰]");
								GWCtrlTime.setTimer(0);
							}else {
								GLog.logRecordTime(8, String.valueOf(GWCtrlTime.getTimer()));
								GWCtrlTime.Pause(1);
								GWCtrlTime.TimerMinus();
							}
						}
		    			break;
		    		}
		    		case "提交":{
		    			//判断是否为取消提交
						List<WebElement> buttons = divRoot.findElements(By.tagName("button"));
						for(WebElement button:buttons){
							if(button.getText().equals("取消提交")) {
								bRes = true;
								GLog.logRecordTime(8, "名称为[" + menubtnName + "]的按钮状态判断成功，为[取消提交]");
								GWCtrlTime.setTimer(0);
								break;
							}else {
								GLog.logRecordTime(8, String.valueOf(GWCtrlTime.getTimer()));
								GWCtrlTime.Pause(1);
								GWCtrlTime.TimerMinus();
							}
						}
		    			break;
		    		}
		    		case "取消提交":{
		    			//判断是否为取消提交
						List<WebElement> buttons = divRoot.findElements(By.tagName("button"));
						for(WebElement button:buttons){
							if(button.getText().equals("提交")) {
								bRes = true;
								GLog.logRecordTime(8, "名称为[" + menubtnName + "]的按钮状态判断成功，为[提交]");
								GWCtrlTime.setTimer(0);
								break;
							}else {
								GLog.logRecordTime(8, String.valueOf(GWCtrlTime.getTimer()));
								GWCtrlTime.Pause(1);
								GWCtrlTime.TimerMinus();
							}
						}
		    			break;
		    		}
                    case "加入黑名单":{
                      //判断状态是否为置灰
                      String btnStatus = divRoot.getAttribute("class");
                      if(null != btnStatus && !btnStatus.equals("")) {
                          if(btnStatus.indexOf("-disabled") != -1) {
                              bRes = true;
                              GLog.logRecordTime(8, "名称为[" + menubtnName + "]的按钮状态判断成功，为[置灰]");
                              GWCtrlTime.setTimer(0);
                          }else {
                              GLog.logRecordTime(8, String.valueOf(GWCtrlTime.getTimer()));
                              GWCtrlTime.Pause(1);
                              GWCtrlTime.TimerMinus();
                          }
                      }
                      break;
                    }
                    case "取消黑名单":{
                      //判断状态是否为置灰
                      String btnStatus = divRoot.getAttribute("class");
                      if(null != btnStatus && !btnStatus.equals("")) {
                          if(btnStatus.indexOf("-disabled") != -1) {
                              bRes = true;
                              GLog.logRecordTime(8, "名称为[" + menubtnName + "]的按钮状态判断成功，为[置灰]");
                              GWCtrlTime.setTimer(0);
                          }else {
                              GLog.logRecordTime(8, String.valueOf(GWCtrlTime.getTimer()));
                              GWCtrlTime.Pause(1);
                              GWCtrlTime.TimerMinus();
                          }
                      }
                      break;
                    }
                  
		    		default:{
		    			break;
		    		}
	    		}
	    	}
		}catch (Exception e){
			GWCtrlException.SwtichTo(e, 1, 8, "名称为[" + menubtnName + "]的按钮状态判断失败", true);
		}
    	//返回母版区域
		GWCtrlFrame.ui_C_SWITCN_DEFAULT();
		//检测校验窗体 目前有两个位置需要增加提示窗体处理，此处暂时关闭
		//GWCtrlAlert.ui_C_ALERT(GWCtrlWebElementXpath.CN_XPATH.get("顶层页签2 主体显示区"), "保存");
		//等待完成
		GWCtrlPage.ui_D_IFRAME_INDEX(2, "id", wId);
		return bRes;
	}
}
