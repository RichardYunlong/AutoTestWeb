package AutoTestWeb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
<<<<<<< HEAD
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
=======
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
>>>>>>> 8d1834e5aed6c409826727dfa38808b37859076e

/**
 * 系统参数管理
 */
public class GParam {
	
	/**
	 * 有界面浏览器信息:Visible Browser Info
	 * {"浏览器名称", 
	 *  "浏览器版本号", 
	 *  "浏览器启动应用程序属性名称",
	 *  "浏览器启动应用程序安装路径"
	 *  "浏览器启动应用程序名称", 
	 *  "浏览器驱动属性名称"
	 *  "浏览器驱动程序全名",
	 *  },
	 */
	public static final String VBInfo[][] = {
			{"ie",      "11", 
			 "webdriver.ie.bin",
<<<<<<< HEAD
			 "C:/Program Files/internet explorer", 
			 "iexplore.exe", 
			 "webdriver.ie.driver", 
			 "./driver/ie/IEDriverServer.exe", 
			 },
			{"chrome",  "85", 
			 "webdriver.chrome.bin",
			 "C:/Program Files (x86)/Google/Chrome/Application/", 
=======
			 "C:/Program Files/Internet Explorer/", 
			 "iexplore.exe", 
			 "webdriver.ie.driver", 
			 "./driver/ie/IEDriverServer_x64.exe", 
			 },
			{"chrome",  "40", 
			 "webdriver.chrome.bin",
			 "C:/Users/hewei/AppData/Local/Google/Chrome/Application/", 
>>>>>>> 8d1834e5aed6c409826727dfa38808b37859076e
			 "chrome.exe", 
			 "webdriver.chrome.driver", 
			 "./driver/chrome/chromedriver.exe", 
			 },
<<<<<<< HEAD
			{"firefox", "76", 
		     "webdriver.firefox.bin",
			 "C:/Program Files/Mozilla Firefox/", 
			 "firefox.exe", 
			 "webdriver.gecko.driver", 
			 "./driver/firefox/geckodriver.exe", 
=======
			{"firefox", "52", 
		     "webdriver.firefox.bin",
			 "E:/Program Files/Mozilla Firefox/", 
			 "firefox.exe", 
			 "webdriver.gecko.driver", 
			 "E:/Program Files/Mozilla Firefox/geckodriver64.exe", 
>>>>>>> 8d1834e5aed6c409826727dfa38808b37859076e
			 },
			{"opera",   "30",
			 "webdriver.opera.bin",
			 "E:/Program Files (x86)/Opera/", 
			 "launcher.exe", 
			 "", 
			 "./driver/Opera-driver.exe", 
			 },
			{"safari",  "50",
		     "webdriver.safari.bin",
<<<<<<< HEAD
			 "D:/Program Files (x86)/Safari", 
			 "Safari.exe", 
			 "webdriver.safari.webdriver", 
			 "selenium-safari-driver.jar", 
			 },
			 {"edge",  "85", 
			 "webdriver.edge.bin",
			 "C:/Program Files (x86)/Microsoft/Edge/Application", 
			 "msedge.exe", 
			 "webdriver.edge.driver", 
			 "./driver/edge/msedgedriver.exe", 
=======
			 "E:/Program Files (x86)/Safari/", 
			 "safari.exe", 
			 "", 
			 "./driver/Safari-driver.exe", 
			 },
			 {"Tapestry7",  "7", 
			 "webdriver.chrome.bin",
			 "C:\\Program Files (x86)\\CFCA\\Tapestry(Embeded Edition)", 
			 "Tapestry7.exe", 
			 "webdriver.chrome.driver", 
			 "./driver/Tapestry/chromedriver.exe", 
>>>>>>> 8d1834e5aed6c409826727dfa38808b37859076e
			 },
	};
	
	/**
	 * 全局驱动变量
	 */
	public static WebDriver g_Dr;
	
	/**
<<<<<<< HEAD
	 * 全局驱动变量属性
	 */
	public static ChromeOptions g_Opt;
	
	/**
=======
>>>>>>> 8d1834e5aed6c409826727dfa38808b37859076e
	 * 根据驱动序号设置系统属性
	 */
	private static void setVBInfoByDriverIndex(int dDriverIndex){
        System.setProperty(GParam.VBInfo[dDriverIndex][2], GParam.VBInfo[dDriverIndex][3]+GParam.VBInfo[dDriverIndex][4]);
        System.setProperty(GParam.VBInfo[dDriverIndex][5], GParam.VBInfo[dDriverIndex][6]);
	}
	
	/**
	 * 设置内置驱动，可选参数如下：
	 * ie
	 * chrome
	 * firefox
	 * opera
	 * safari
	 * other-目前我为空
	 */
	@SuppressWarnings("deprecation")
	public static void setVBInfo(String strDriverName) {
		int dDriverIndex = 9;
		switch(strDriverName) {
			case "ie":
			{
				dDriverIndex = 0;
				setVBInfoByDriverIndex(dDriverIndex);
<<<<<<< HEAD
				g_Dr = new InternetExplorerDriver(GBrowser.StopSafety());
=======
				g_Dr = new InternetExplorerDriver(GWCtrl.StopSafety());
>>>>>>> 8d1834e5aed6c409826727dfa38808b37859076e
				break;
			}
			case "chrome":
			{
				dDriverIndex = 1;
				setVBInfoByDriverIndex(dDriverIndex);
<<<<<<< HEAD
		        g_Opt = new ChromeOptions();
		        g_Opt.addArguments("--whitelisted-ips=\"\"");
				g_Dr = new ChromeDriver(g_Opt);
=======
				g_Dr = new ChromeDriver();
>>>>>>> 8d1834e5aed6c409826727dfa38808b37859076e
				break;
			}
			case "firefox":
			{
				dDriverIndex = 2;
				setVBInfoByDriverIndex(dDriverIndex);
				g_Dr = new FirefoxDriver();
				break;
			}
			case "opera":
			{
				dDriverIndex = 3;
				setVBInfoByDriverIndex(dDriverIndex);
<<<<<<< HEAD
				g_Dr = new OperaDriver();
=======
>>>>>>> 8d1834e5aed6c409826727dfa38808b37859076e
				break;
			}
			case "safari":
			{
				dDriverIndex = 4;
				setVBInfoByDriverIndex(dDriverIndex);
<<<<<<< HEAD
				g_Dr = new SafariDriver();
				break;
			}
			case "edge":
			{
				dDriverIndex = 5;
				setVBInfoByDriverIndex(dDriverIndex);
				g_Dr = new EdgeDriver();
=======
				break;
			}
			case "Tapestry7":
			{
				dDriverIndex = 5;
				System.setProperty("webdriver.chrome.driver",
						"C:\\Program Files (x86)\\CFCA\\Tapestry(Embeded Edition)\\chromedriver.exe");
				g_Dr = new ChromeDriver();
>>>>>>> 8d1834e5aed6c409826727dfa38808b37859076e
				break;
			}
			default:
			{
				break;
			}
		}
		if(dDriverIndex == 9) {
			System.out.println("Unknown Diver Type!");
		}
	}
	
	/**
	 * 设置内置驱动，可选参数如下：
	 * 1-ie
	 * 2-chrome
	 * 3-firefox
	 * 4-opera
	 * 5-safari
	 * other-目前我为空
	 */
	@SuppressWarnings("deprecation")
	public static void setVBInfo(int dDriverIndex) {
		dDriverIndex = 9;
		switch(dDriverIndex) {
			case 0:
			{
				dDriverIndex = 0;
				setVBInfoByDriverIndex(dDriverIndex);
<<<<<<< HEAD
				g_Dr = new InternetExplorerDriver(GBrowser.StopSafety());
=======
				g_Dr = new InternetExplorerDriver(GWCtrl.StopSafety());
>>>>>>> 8d1834e5aed6c409826727dfa38808b37859076e
				break;
			}
			case 1:
			{
				dDriverIndex = 1;
				setVBInfoByDriverIndex(dDriverIndex);
<<<<<<< HEAD
				g_Dr = new ChromeDriver(g_Opt);
=======
				g_Dr = new ChromeDriver();
>>>>>>> 8d1834e5aed6c409826727dfa38808b37859076e
				break;
			}
			case 2:
			{
				dDriverIndex = 2;
				setVBInfoByDriverIndex(dDriverIndex);
				g_Dr = new FirefoxDriver();
				break;
			}
			case 3:
			{
				dDriverIndex = 3;
				setVBInfoByDriverIndex(dDriverIndex);
<<<<<<< HEAD
				g_Dr = new OperaDriver();
				
=======
>>>>>>> 8d1834e5aed6c409826727dfa38808b37859076e
				break;
			}
			case 4:
			{
				dDriverIndex = 4;
				setVBInfoByDriverIndex(dDriverIndex);
<<<<<<< HEAD
				g_Dr = new SafariDriver();
=======
>>>>>>> 8d1834e5aed6c409826727dfa38808b37859076e
				break;
			}
			case 5:
			{
				dDriverIndex = 5;
				setVBInfoByDriverIndex(dDriverIndex);
<<<<<<< HEAD
				g_Dr = new EdgeDriver();
=======
>>>>>>> 8d1834e5aed6c409826727dfa38808b37859076e
				break;
			}
			default:
			{
				break;
			}
		}
		if(dDriverIndex == 9) {
			System.out.println("Unknown Diver Type!");
		}
	}
}
