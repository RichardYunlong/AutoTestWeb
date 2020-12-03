package AutoTestWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import AutoTest.GLog;

/**
 *  Input控件填写处理
 */
public class GWCtrlInputFill {
	
	/**
	 *  Input类目标元素，通过ID查找输入框，写入指定内容
	 *  @param inputId
	 *  @param str
	 */
	public static void ById(String inputId, String str) {
		GWCtrlWait.ViewWaitingAllById(GTestIndicators.PageShowTime, inputId);
		WebElement input = GParam.g_Dr.findElement(By.id(inputId));
		input.clear();
		GLog.logRecordTime(8, "text类型输入框-清空了");
		input.sendKeys(str);
		GLog.logRecordTime(8, "text类型输入框-填写了"+str);
	}
	
	/**
	 *  Input类目标元素，通过WebElement查找输入框，写入指定内容
	 *  @param inputId
	 *  @param str
	 */
	public static void ByWebElement(WebElement input, String str) {
		GWCtrlWait.ViewWaitingAllByWebElement(GTestIndicators.PageShowTime, input);
		input.click();
		input.clear();
		input.sendKeys(Keys.BACK_SPACE ); 
		input.sendKeys(Keys.chord(Keys.CONTROL, "a")); 
		input.sendKeys(Keys.DELETE); 
		GLog.logRecordTime(8, "text类型输入框-清空了");
		input.sendKeys(str);
		GLog.logRecordTime(8, "text类型输入框-填写了"+str);
		input.sendKeys(Keys.ENTER);
		GLog.logRecordTime(8, "text类型输入框-键入了回车");
	}
	
	/**
	 *  Input类目标元素，通过CssSelector查找输入框，写入指定内容
	 *  @param CssSelector
	 *  @param str
	 */
	public static void ByCssSelector(String CssSelector, String str) {
		GWCtrlWait.ViewWaitingAllByCssSelector(GTestIndicators.PageShowTime, CssSelector);
		WebElement input = GParam.g_Dr.findElement(By.cssSelector(CssSelector));
		input.clear();
		GLog.logRecordTime(8, "text类型输入框-清空了");
		input.sendKeys(str);
		GLog.logRecordTime(8, "text类型输入框-填写了"+str);
	}

	/**
	 *  Input类目标元素，通过ID查找输入框，写入指定内容
	 *  @param inputXpath
	 *  @param str
	 */
	public static void ByXpath(String inputXpath, String str) {
		WebElement input = GParam.g_Dr.findElement(By.xpath(inputXpath));
		input.clear();
		GLog.logRecordTime(8, "text类型输入框-清空了");
		input.sendKeys(str);
		GLog.logRecordTime(8, "text类型输入框-填写了"+str);
	}
	
	
	/**
	 *  Input类目标元素，通过ID查找输入框，不清空直接写入指定内容
	 *  @param inputId
	 *  @param str
	 */
	public static void ByIdUnClear(String inputId, String str) {
		WebElement input = GParam.g_Dr.findElement(By.id(inputId));
		input.sendKeys(str);
		GLog.logRecordTime(8, "text类型输入框-填写了"+str);
		input.sendKeys(Keys.ENTER);
		GLog.logRecordTime(8, "text类型输入框-键入了回车");
	}

	/**
	 *  Input类目标元素，不清空直接写入指定内容
	 *  @param inputId
	 *  @param str
	 */
	public static void ByWebElementUnClear(WebElement input, String str) {
		input.sendKeys(str);
		GLog.logRecordTime(8, "text类型输入框-填写了"+str);
		//GWCtrlTime.Pause(3);
		input.sendKeys(Keys.ENTER);
		GLog.logRecordTime(8, "text类型输入框-键入了回车");
	}
	
	/**
	 *  Input类目标元素，通过ID查找输入框，不清空直接写入指定内容
	 *  @param inputXpath
	 *  @param str
	 */
	public static void ByXpathUnClear(String inputXpath, String str) {
		WebElement input = GParam.g_Dr.findElement(By.xpath(inputXpath));
		input.sendKeys(str);
		GLog.logRecordTime(8, "text类型输入框-填写了"+str);
	}
	
	/**
	 *  通过双击Div元素临时生成的Input类目标元素，通过Xpath地位Div，Id查找Input，写入指定内容
	 *  @param divXpath xpath参数
	 *  @param inputId id参数
	 *  @param str 输入的字符串
	 *  @param blank 空白处id参数
	 */
	public static void ByXpathFromClickDiv(String divXpath, String inputId, String str, String blank) {
		GWCtrlWait.ViewWaitingAllByXpath(GTestIndicators.PageShowTime, divXpath);
		GWCtrlDivDoubleClick.ByXpath(divXpath);
		WebElement input = GParam.g_Dr.findElement(By.id(inputId));
		JavascriptExecutor js=(JavascriptExecutor) GParam.g_Dr;
		js.executeScript("arguments[0].scrollIntoView(true);",input);
		GWCtrlWait.ViewWaitingAllByWebElement(GTestIndicators.PageShowTime, input);
		input.clear();
		GWCtrlDivClick.ById(blank);
		GWCtrlDivDoubleClick.ByXpath(divXpath);
		GWCtrlInputFill.ByIdUnClear(inputId, str);
		GWCtrlDivClick.ById(blank);
	}
	
	/**
	 *  当输入框输入后，点击空白处时，系统做了自动校验，则不能再输入为空的情况下点击空白处
	 *  @param divXpath xpath参数
	 *  @param inputId id参数
	 *  @param str 输入的字符串
	 *  @param blank 空白处id参数
	 *  @param bAutoCheck 点击空白处是否自动校验
	 */
	public static void ByXpathFromClickDiv(String divXpath, String inputId, String str ,String blank, boolean bAutoCheck) {
		WebElement inputDiv = GParam.g_Dr.findElement(By.xpath(divXpath));
		JavascriptExecutor js=(JavascriptExecutor) GParam.g_Dr;
		js.executeScript("arguments[0].scrollIntoView(true);",inputDiv);
		
		inputDiv.click();
		WebElement input = GParam.g_Dr.findElement(By.id(inputId));
		GWCtrlWait.ViewWaitingAllByWebElement(GTestIndicators.PageShowTime, input);

		if(!bAutoCheck) {
			input.clear();
			GWCtrlDivClick.ById(blank);
		}
		input.sendKeys(str);
		GLog.logRecordTime(8, "text类型输入框-填写了"+str);
		input.sendKeys(Keys.ENTER);
		GLog.logRecordTime(8, "text类型输入框-键入了回车");
		GWCtrlDivClick.ById(blank);
	}
	
	/**
	 *  通过双击Div元素临时生成的Input类目标元素，通过WebElement地位Div，Id查找Input，写入指定内容
	 *  @param inputWebElement WebElement参数
	 *  @param inputId id参数
	 *  @param str 输入的字符串
	 *  @param blank 空白处id参数
	 */
	public static void ByWebElementFromClickDiv(WebElement inputWebElement, String inputId, String str, String blank, boolean bAutoCheck) {
		WebElement input = null;
		
		if(!bAutoCheck) {
			GWCtrlDivDoubleClick.ByWebElement(inputWebElement);
			input = GParam.g_Dr.findElement(By.id(inputId));
			JavascriptExecutor js=(JavascriptExecutor) GParam.g_Dr;
			js.executeScript("arguments[0].scrollIntoView(true);",input);
			GWCtrlWait.ViewWaitingAllByWebElement(GTestIndicators.PageShowTime, input);
			input.sendKeys(Keys.DELETE);
			GWCtrlInputFill.ByIdUnClear(inputId, str);
			GWCtrlDivClick.ById(blank);
		}else {
			JavascriptExecutor js=(JavascriptExecutor) GParam.g_Dr;
			js.executeScript("arguments[0].scrollIntoView(true);",inputWebElement);
			
			inputWebElement.click();
			input = GParam.g_Dr.findElement(By.id(inputId));
			GWCtrlWait.ViewWaitingAllByWebElement(GTestIndicators.PageShowTime, input);

			if(!bAutoCheck) {
				input.clear();
				GWCtrlDivClick.ById(blank);
			}
			input.sendKeys(str);
			GLog.logRecordTime(8, "text类型输入框-填写了"+str);
			input.sendKeys(Keys.ENTER);
			GLog.logRecordTime(8, "text类型输入框-键入了回车");
			GWCtrlDivClick.ById(blank);
		}
	}
	
	
	public static void ByWebElementFromClickDiv_Category(WebElement inputWebElement, String inputId, String str, String blank, boolean bAutoCheck) {
      WebElement input = null;
      if(!bAutoCheck) {
          GWCtrlDivDoubleClick.ByWebElement(inputWebElement);
          input = GParam.g_Dr.findElement(By.id(inputId));
          JavascriptExecutor js=(JavascriptExecutor) GParam.g_Dr;
          js.executeScript("arguments[0].scrollIntoView(true);",input);
          GWCtrlWait.ViewWaitingAllByWebElement(GTestIndicators.PageShowTime, input);
          input.sendKeys(Keys.DELETE);
          GWCtrlInputFill.ById(inputId, str);
      }
  }
}
