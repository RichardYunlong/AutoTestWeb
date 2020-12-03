package AutoTestWeb;

<<<<<<< HEAD
import AutoTest.GTestCase;

=======
>>>>>>> 8d1834e5aed6c409826727dfa38808b37859076e
public class GIE {
	/**
	 *  调用实例
	 */
	public static void TestDemo(){
		GParam.setVBInfo("ie");
<<<<<<< HEAD
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
=======
		GOutPutCtrl.setOutputPath("./output/ie/");
		GTestCase.setTestScripstion("百度查询CFCA");

		GWCtrl.Open("https://www.baidu.com");
		GWCtrl.ViewWaitingById(10, "s_btn_wr");
		GWCtrl.Maximize();
		GWCtrl.Refresh();
		GWCtrl.FindAndFillInputById("kw", "中国金融认证中心");
		GWCtrl.FindAndClickButtonById("su");
		GWCtrl.ViewWaitingById(10, "content_bottom");
		GWCtrl.TakesScreenshot("_1.png");
		GWCtrl.Pause(1000);
		GWCtrl.Quit();
>>>>>>> 8d1834e5aed6c409826727dfa38808b37859076e
	}
}
