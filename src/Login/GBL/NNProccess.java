package Login.GBL;
import AutoTest.GTestCase;
import AutoTestWeb.GTestIndicators;
import AutoTestWeb.GWCtrlDivClick;
import AutoTestWeb.GWCtrlDivDate;
import AutoTestWeb.GWCtrlInputFill;
import AutoTestWeb.GWCtrlWait;
import AutoTestWeb.GWCtrlWebElementId;
import User.GProjDptMgr.Proccess;
import io.qameta.allure.Step;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户名为空测试用例(失败用例)
 */
public class NNProccess extends Proccess{
	
	/**
	 * 用户名为空测试用例
	 */
	@Step("用户名为空测试用例")
    public static Map<String,String> nameNullSignln(){
    	//数据初始化
        Data da = new Data();
        Map<String, String> mapResponse =  new HashMap<String, String>();
    	System.out.println("[功能点]----填写用户名密码");
		try {
			GWCtrlWait.ViewWaitingAllById(GTestIndicators.PageShowTime, GWCtrlWebElementId.CN_ID.get("账号"));//等待用户名控件加载完成
			GWCtrlWait.ViewWaitingAllById(GTestIndicators.PageShowTime, GWCtrlWebElementId.CN_ID.get("密码"));//等待密码控件加载完成
			GWCtrlInputFill.ById(GWCtrlWebElementId.CN_ID.get("账号"), "");//填写用户名
			GWCtrlInputFill.ById(GWCtrlWebElementId.CN_ID.get("密码"), da.mapUser.get("密码"));//填写密码
			System.out.println("[功能点]----填写用户名密码成功");
			da.bSignInStatus=true;
		}catch (Exception e){
		  da.bSignInStatus=false;
			System.out.println("[功能点]----填写用户名密码异常");
			e.printStackTrace();
			System.out.println("填写登录信息时错误"+da.bSignInStatus);
            mapResponse.put("retCode","901");
            mapResponse.put("retMessage","填写登录信息时错误");
            //将失败状态填充
            GTestCase.setTestCaseRst(da.bSignInStatus);
            return mapResponse;
		}
//		ui_C_CLICK_BTN();
		System.out.println("[功能]----点击登录按钮");
        try {
            GWCtrlWait.ViewWaitingAllById(GTestIndicators.PageShowTime, GWCtrlWebElementId.CN_ID.get("登入"));//等待按钮加载完成
            GWCtrlDivClick.ById(GWCtrlWebElementId.CN_ID.get("登入"));//点击登录按钮
            da.bSignInStatus=true;
            System.out.println("[功能]----点击登录成功");
        }catch (Exception e){
          da.bSignInStatus=false;
          System.out.println("[功能]----点击登录按钮异常");
          e.printStackTrace();
        }
        if (!da.bSignInStatus){
            System.out.println("点击登录按钮时错误");
            mapResponse.put("retCode","801");
            mapResponse.put("retMessage","点击登录按钮时错误");
            return mapResponse;
        }
        System.out.println(da.bSignInStatus+"---------------------");
        //等待msg标签加载出来
        GWCtrlWait.ViewWaitingAllById(GTestIndicators.PageShowTime, "msg");
        String divDate = GWCtrlDivDate.ById("msg");
        //封装返回信息
        if (divDate.equals("")) {
        	//错误用例执行失败
        	mapResponse.put("retCode","702");
            mapResponse.put("retMessage","nameNullProccess错误用例未正确执行");
            GTestCase.setTestCaseRst(false);
            
        	return mapResponse;
        }
        //用户名为空用例执行成功（异常用例）
        GTestCase.setTestCaseRst(true);
        System.out.println("用户名为空用例执行成功（异常用例）");

        return mapResponse;
    }	
}
