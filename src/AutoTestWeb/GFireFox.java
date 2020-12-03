package AutoTestWeb;

import AutoTest.GTestCase;

public class GFireFox {
	/**
	 *  调用实例
	 */
	public static void TestDemo(){
		GParam.setVBInfo("firefox");
		GTestCase.setTestCaseSpt("百度查询CFCA");

		GWCtrlBasic.Open("https://www.baidu.com");
		GWCtrlWait.ViewWaitingById(GTestIndicators.PageShowTime, "su");
		GWCtrlBasic.Maximize();
		GWCtrlBasic.Refresh();
		GWCtrlInputFill.ById("kw", "中国金融认证中心");
		GWCtrlInputClick.ById("su");
		GWCtrlWait.ViewWaitingById(GTestIndicators.PageShowTime, "content_bottom");
		GWCtrlLog.TakesScreenshot("_1.png");
		GWCtrlTime.Pause(1);
		GWCtrlBasic.Quit();
	}
	
	public static void main(String[] args) {
		GFireFox.TestDemo();
	}
}
