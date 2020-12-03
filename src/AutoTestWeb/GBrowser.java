package AutoTestWeb;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import AutoTest.GProcess;

/**
 *  浏览器设置
 */
public class GBrowser {
	/**
	 *  系统自检是否就绪
	 */
	private static String BrsType = "";
	
	/**
	 *  获取当前浏览器类型
	 */
	public static String getBrsType() {
		return BrsType;
	}
	
	/**
	 *  设置当前浏览器类型
	 */
	public static void setBrsType(String strType) {
		BrsType = strType;
	}
	
	/**
	 *  打开IE时使用非安全模式
	 */
	public static DesiredCapabilities StopSafety() {
		DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
		// IE默认启动保护模式，要么手动在浏览器的设置中关闭保护模式，要么在代码中加上这一句，即可
		//dc.setCapability("ignoreProtectedModeSettings", true);
//		dc.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
//		dc.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING,false);
//		dc.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
//		dc.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
//		dc.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);

		System.out.println("浏览器-IE开启了保护模式");
		return dc;
	}
	
	public static void main(String[] args) {
//		String command = "taskkill /f /im chromedriver.exe";
//		try {
//			Runtime.getRuntime().exec(command);
//			System.out.println("执行[" + command + "]成功");
//		} catch (IOException e) {
//			System.out.println("执行[" + command + "]失败");
//			e.printStackTrace();
//		}
		String proName = "chromedriver.exe";
		if(GProcess.findAddKillProcess(proName)) {
			System.out.println("执行杀死[" + proName + "]进程成功");
		}
	}
}
