package AutoTestWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 *  控制鼠标悬浮
 */
public class GWCtrlMouseMove {

	/**
	 *  控制鼠标悬浮在某元素
	 *  
	 *  @param driver 全局驱动
	 *  @param eWeb 目标元素
	 */
	 public static void ToWebElement(WebDriver driver, WebElement eWeb){
	    //创建鼠标属性方法
	    Actions action=new Actions(driver);
	    // 获取 moveToElement 方法 ，元素定位到想要移上去的元素上 
	    action.moveToElement(eWeb).perform();
	 }
	 
	/**
	 *  控制鼠标悬浮在某元素
	 *  
	 *  @param driver 全局驱动
	 *  @param eCss 目标元素css
	 */
	 public static void ToCssSelector(WebDriver driver, String eCss){
	    //创建鼠标属性方法
	    Actions action=new Actions(driver);
	    // 获取 moveToElement 方法 ，元素定位到想要移上去的元素上 
	    action.moveToElement(driver.findElement(By.cssSelector(eCss))).perform();
	 }
	 
	/**
	 *  控制鼠标悬浮在某元素
	 *  
	 *  @param driver 全局驱动
	 *  @param eLinkText 目标元素文本
	 */
	 public static void ToLinkText(WebDriver driver, String eLinkText){
	    //创建鼠标属性方法
	    Actions action=new Actions(driver);
	    // 获取 moveToElement 方法 ，元素定位到想要移上去的元素上 
	    action.moveToElement(driver.findElement(By.linkText(eLinkText))).perform();
	 }
	 
	/**
	 *  控制鼠标悬浮在某元素
	 *  
	 *  @param driver 全局驱动
	 *  @param eLinkText 目标元素文本
	 */
	 public static void ToId(WebDriver driver, String eId){
	    //创建鼠标属性方法
	    Actions action=new Actions(driver);
	    // 获取 moveToElement 方法 ，元素定位到想要移上去的元素上 
	    action.moveToElement(driver.findElement(By.id(eId))).perform();
	 }
}
