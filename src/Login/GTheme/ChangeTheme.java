package Login.GTheme;

import AutoTestWeb.GTestIndicators;
import AutoTestWeb.GWCtrlDivClick;
import AutoTestWeb.GWCtrlPage;
import AutoTestWeb.GWCtrlWait;
import AutoTestWeb.GWCtrlWebElementId;
import io.qameta.allure.Step;

/**
 *  版式处理
 */
public class ChangeTheme {

	/**
	 *  数据
	 */
	private Data pData = null;
	
	/**
	 *  修改版式
	 */
	@Step("修改版式")
	public void ui_C_MODIFY_THEME(){
		pData = new Data();
		System.out.println("[功能]----修改版式");
		try {
			switch(pData.eThemeType) {
				case "id":{
					//使用ID方式修改板式
					ui_C_MODIFY_THEME_BY_ID();
					break;
				}
				default:{
					break;
				}
					
			}
			GWCtrlPage.ui_C_REFRESH();
			pData.bRes = true;
		}catch (Exception e){
			pData.bRes = false;
			e.printStackTrace();
		}
	}
	
	/**
	 *  通过ID方式修改板式
	 */
	@Step("通过ID方式修改板式")
	private void ui_C_MODIFY_THEME_BY_ID() {
		System.out.println("[功能]----查找并选定版式,Id方式");
		
		try {
			//打开修改板式窗口
			GWCtrlWait.Wait2BeClickableById(GTestIndicators.PageShowTime, GWCtrlWebElementId.CN_ID.get("打开主题选择"));
			GWCtrlDivClick.ById(GWCtrlWebElementId.CN_ID.get("打开主题选择"));
			
			//等待关键信息操作控件加载完成
			String themeId = pData.mapTheme.get(pData.strThemeName);
			GWCtrlWait.ViewWaitingAllById(GTestIndicators.PageShowTime, themeId);
			
			//修改选中板式
			GWCtrlDivClick.ById(themeId);
			
			//确认板式
			GWCtrlDivClick.ById(GWCtrlWebElementId.CN_ID.get("确认主题选择"));
			
			pData.bRes = true;
			
		}catch(Exception e) {
			pData.bRes = false;
			e.printStackTrace();
		}
	}
}
