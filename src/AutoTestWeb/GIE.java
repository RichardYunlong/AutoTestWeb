package AutoTestWeb;

import AutoTest.GTestCase;

public class GIE {
	/**
	 *  调用实例
	 */
	public static void TestDemo(){
		GParam.setVBInfo("ie");
		GTestCase.setTestCaseSpt("百度查询Glodon");

		GWCtrlBasic.Open("https://www.baidu.com");
		GWCtrlWait.ViewWaitingById(GTestIndicators.PageShowTime, "su");
		GWCtrlBasic.Maximize();
		GWCtrlBasic.Refresh();
		GWCtrlInputFill.ById("kw", "广联达");
		GWCtrlInputClick.ById("su");
		GWCtrlWait.ViewWaitingById(GTestIndicators.PageShowTime, "content_bottom");
		GWCtrlLog.TakesScreenshot("_1.png");
		GWCtrlTime.Pause(1000);
		GWCtrlBasic.Quit();
	}
}