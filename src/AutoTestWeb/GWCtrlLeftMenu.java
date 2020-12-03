package AutoTestWeb;

/**
* 左侧菜单
*/
public class GWCtrlLeftMenu {
	
    /**
    * 左侧菜单根据路径打开模块
    * @param eId 等待目标元素id
    */
	public static void ui_C_CHOOSE_MODULE(String eId) {
		//选中菜单 推荐使用唯一id方式
		GWCtrlChooseModule.SelectModule(GWCtrlChooseModule.mapMenuFrameId.get(GWCtrlChooseModule.mapModule.get("菜单位置")),
										"", 
										"", 
										GWCtrlChooseModule.mapModule.get("根菜单名称"), 
										GWCtrlChooseModule.mapModule.get("一级菜单"), 
										GWCtrlChooseModule.mapModule.get("二级菜单"), 
										GWCtrlChooseModule.mapModule.get("三级菜单"), 
										GWCtrlChooseModule.mapModule.get("四级菜单"), 
										GWCtrlChooseModule.mapModule.get("五级菜单"));
		
		//等待加载完成
		GWCtrlPage.ui_D_IFRAME_INDEX(1, "id", eId);
	}
}
