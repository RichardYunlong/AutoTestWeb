package Admin.GBL;

import AutoTest.GLog;
import AutoTest.GTestCase;
import AutoTestWeb.GTestIndicators;
import AutoTestWeb.GWCtrlDivClick;
import AutoTestWeb.GWCtrlInputFill;
import AutoTestWeb.GWCtrlLog;
import AutoTestWeb.GWCtrlPage;
import AutoTestWeb.GWCtrlWait;
import AutoTestWeb.GWCtrlWebElementId;
import io.qameta.allure.Step;


/**
 * 后台登录业务逻辑
 * @author zhangc-z 2020-10-25 12：26
 *
 */
public class SignIn {
	
	/**
	 *  数据
	 */
	private Data pData = null;

	/**
	 *  登录
	 */
	@Step("登录")
	public void ui_C_LOGIN(){
		pData = new Data();
		
		//初始化登录用户信息 之后会放置于配置文件
		pData.mapUser.put("账号", "admin");
		pData.mapUser.put("密码", "");
		pData.mapUser.put("公钥", "");
		pData.mapUser.put("版式", "默认版式");
		pData.mapUser.put("层级", "");
		
		try {
			ui_C_INPUT_NAME_PWD();//填写用户名密码
			//保存截图
			GWCtrlLog.TakesScreenshot("_1.png");
			
			ui_C_CLICK_BTN();//点击登录按钮
			
			GWCtrlPage.ui_C_WAIT_MAIN_ADMIN();
			GLog.logRecordTime(9, "[功能]----登陆成功");
		} catch (Exception e) {
			GLog.logRecordTime(9, "[功能]----登陆失败");
			pData.bSignInStatus=false;
		}
		GTestCase.setTestCaseRst(pData.bSignInStatus);//记录用例执行结果标记
		//保存截图
		GWCtrlLog.TakesScreenshot("_2.png");
	}
	
	/**
	 *  填写用户名密码
	 */
	@Step("填写用户名密码")
	private void ui_C_INPUT_NAME_PWD(){
		GLog.logRecordTime(9, "[功能]----填写用户名密码");
		try {
			GWCtrlWait.ViewWaitingAllById(GTestIndicators.PageShowTime, GWCtrlWebElementId.CN_ID.get("账号"));//等待用户名控件加载完成
			GWCtrlWait.ViewWaitingAllById(GTestIndicators.PageShowTime, GWCtrlWebElementId.CN_ID.get("密码"));//等待密码控件加载完成
			GWCtrlInputFill.ById(GWCtrlWebElementId.CN_ID.get("账号"), pData.mapUser.get("账号"));//填写用户名
			GWCtrlInputFill.ById(GWCtrlWebElementId.CN_ID.get("密码"), pData.mapUser.get("密码"));//填写密码
			GLog.logRecordTime(9, "[功能]----填写用户名密码成功");
		}catch (Exception e){
			GLog.logRecordTime(9, "[功能]----填写用户名密码异常");
			e.printStackTrace();
		}
	}
	
	/**
	 *  点击登录按钮
	 */
	@Step("点击登录按钮")
	private void ui_C_CLICK_BTN(){
		GLog.logRecordTime(9, "[功能]----点击登录按钮");
		try {
			GWCtrlWait.ViewWaitingAllById(GTestIndicators.PageShowTime, GWCtrlWebElementId.CN_ID.get("登入"));//等待按钮加载完成
			GWCtrlDivClick.ById(GWCtrlWebElementId.CN_ID.get("登入"));//点击登录按钮
			pData.bSignInStatus=true;
			GLog.logRecordTime(9, "[功能]----点击登录成功");
		}catch (Exception e){
			pData.bSignInStatus=false;
			GLog.logRecordTime(9, "[功能]----点击登录按钮异常");
			e.printStackTrace();
		}
	}
}
