package AutoTestWeb;

<<<<<<< HEAD
import AutoTest.GTestCase;

=======
>>>>>>> 8d1834e5aed6c409826727dfa38808b37859076e
public class GFireFox {
	/**
	 *  调用实例
	 */
	public static void TestDemo(){
		GParam.setVBInfo("firefox");
<<<<<<< HEAD
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
=======
		GOutPutCtrl.setOutputPath("./output/firefox/");
		GTestCase.setTestScripstion("百度查询CFCA");

		GWCtrl.Open("https://www.baidu.com");
		GWCtrl.ViewWaitingById(10, "su");
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
