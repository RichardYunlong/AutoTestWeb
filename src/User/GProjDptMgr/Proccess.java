package User.GProjDptMgr;

import AutoTest.GTestCase;

/**
 *  项目信息请求处理过程
 */
public class Proccess {
	/**
	 *  当前项目状态
	 *  默认为false
	 */
	public static boolean bPrjStatus = false;
	
	/**
	 *  按照当前用户信息登录系统并做对应的显示，如改变用户层级，改变板式
	 */
	public static void prjAdd(){
//		ui_C_INPUT_NAME_PWD();
//		ui_C_CLICK_BTN();
//		ui_C_MODIFY_STRATUM();
//		ui_C_MODIFY_THEME();
//		ui_D_FULL_DISPALY();
		
		GTestCase.setTestCaseRst(bPrjStatus);
	}
}
