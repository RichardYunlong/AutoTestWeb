package AutoTestWeb;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *  重写webdriver类方法，简化selenium库
 */
public class GWCtrl {
	
	/**
	 *  打开IE时使用非安全模式
	 */
	public static DesiredCapabilities StopSafety() {
		DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
		dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		// IE默认启动保护模式，要么手动在浏览器的设置中关闭保护模式，要么在代码中加上这一句，即可
		dc.setCapability("ignoreProtectedModeSettings", true);

		return dc;
	}

	/**
	 *  打开目标地址
	 */
	public static void Open(String Url) {
		GParam.g_Dr.get(Url);
	}

	/**
	 *  浏览器最大化
	 */
	public static void Maximize() {
		GParam.g_Dr.manage().window().maximize();
	}

	/**
	 *  刷新浏览器
	 */
	public static void Refresh() {
		GParam.g_Dr.navigate().refresh();
	}

	/**
	 *  浏览器后退
	 */
	public static void Back() {
		GParam.g_Dr.navigate().back();
	}

	/**
	 *  浏览器前进
	 */
	public static void Forward() {
		GParam.g_Dr.navigate().forward();
	}

	/**
	 *  已目标元素ID查找输入框，写入指定内容
	 */
	public static void FindAndFillInputById(String inputId, String str) {
		WebElement searchBox = GParam.g_Dr.findElement(By.id(inputId));
		searchBox.sendKeys(str);
	}

	/**
	 *  通过提交按钮Id找提交按钮点击提交
	 */
	public static void FindAndClickButtonById(String buttonId) {
		WebElement searchButton = GParam.g_Dr.findElement(By.id(buttonId));
		searchButton.submit();
	}
 
	/**
	 *  通过ClassName找提交按钮点击提交
	 */
	public static void FindAndClickButtonByClassName(String className) {
		WebElement searchButton = GParam.g_Dr.findElement(By.className(className));
		searchButton.submit();
	}

	/**
	 *  截屏
	 */
	public static void TakesScreenshot(String imgURL) {
		File srcFile = ((org.openqa.selenium.TakesScreenshot) GParam.g_Dr).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(GOutPutCtrl.getOutputPath() + GTestCase.getTestScripstion() + imgURL));
		} catch (Exception e) {
			System.out.println("TakesScreenshoting Failed");
		}
	}

	/**
	 *  关闭浏览器
	 */
	public static void Quit() {
		GParam.g_Dr.quit();
	}
 
	/**
	 *  根据时间暂停
	 */
	public static void Pause(int mtime) {
		try {
			Thread.sleep(mtime);
		} catch (Exception e) {
			System.out.println("Pause Failed");
		}
	}

	/**
	 *  根据时间智能等待
	 */
	public static void Waiting(int mtime) {
		try {
			GParam.g_Dr.manage().timeouts().implicitlyWait(mtime, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println("Page Reload TimeOut");
		}
	}

	/**
	 *  显式等待目标Id
	 */
	public static void ViewWaitingById(int mtime, String tagId) {
		WebDriverWait wait = new WebDriverWait(GParam.g_Dr, mtime);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(tagId)));
	}
 
	/**
	 *  显式等待目标链接字符串
	 */
	public static void ViewWaitingByLinkText(int mtime, String linkText) {
		WebDriverWait wait = new WebDriverWait(GParam.g_Dr, mtime);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(linkText)));
	}
	 
	/**
	 *  处理下拉菜单：按照元素序号选中
	 */
	public static void GetDropDownIndexValueById(String dropdownId, int Index) {
		//1、根据元素定位找到select这个标签
		Select sel = new Select(GParam.g_Dr.findElement(By.id(dropdownId)));
		//2、getOptions()方法获得的是一个WebElement的集合
		List<WebElement> webElements = sel.getOptions();

		//3、新建一个List，用来存储每个选项的文本值
		List<String> downs = new ArrayList<>();

		//4、for-each循环每个选项        
		for (WebElement webElement : webElements) {
		    System.out.println("选项的值："+webElement.getText()); //调试的时候打印看一下
		        //5、将每个选项的文本值添加到List集合
		    downs.add(webElement.getText()); 
		}
		
		//6、获取下拉选项的数量        
		int num = webElements.size();
		//7、根据序号选择
		if(Index >= 0 && Index < num) {
			sel.selectByIndex(Index);
		}	
	}
	
	/**
	 *  处理下拉菜单：按照元素文字值选中
	 */
	public static void GetDropDownIndexValueById(String dropdownId,String strValue) {
		//1、根据元素定位找到select这个标签
		Select sel = new Select(GParam.g_Dr.findElement(By.id(dropdownId)));
		//2、getOptions()方法获得的是一个WebElement的集合
		List<WebElement> webElements = sel.getOptions();

		//3、新建一个List，用来存储每个选项的文本值
		List<String> downs = new ArrayList<>();

		//4、for-each循环每个选项        
		for (WebElement webElement : webElements) {
		    System.out.println("选项的值："+webElement.getText()); //调试的时候打印看一下
		    //5、将每个选项的文本值添加到List集合
		    downs.add(webElement.getText()); 
		    if(webElement.getText().equals(strValue)) {
		    	//6、根据值选择
		    	sel.selectByValue(strValue);
		    }
		}	
	}
	
	/**
	 *  显式等待目标XPath
	 */
	public static void ViewWaitingByXPath(int mtime, String tagXPath) {
		WebDriverWait wait = new WebDriverWait(GParam.g_Dr, mtime);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(tagXPath)));
	}
	
	/**
	 *  显式等待目标XPath
	 */
	public static void ClickHref(String strHref) {
        WebElement link = GParam.g_Dr.findElement(By.linkText("请登录"));
        link.click();
	}
}
