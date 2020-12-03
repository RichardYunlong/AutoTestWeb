package AutoTestWeb;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import AutoTest.GLog;

public class GWCtrlStaticFind {
	
    /**
    * 根据详细层级元素查询目标元素 全遍历，速度慢，慎用，目前仅支持按照目标的getText()值查找
    * @param driver 全局驱动
    * @param divId 基准div的id，不为空时以该值为查询条件
    * @param divXpath 基准div的xpath，divId为空时以该值为查询条件
    * @param tarTagName 目标元素标签类型
    * @param tarKeyword 目标元素关键词
    */
	public static WebElement getWebElementByIdOrXpath(WebDriver driver, String divId, String divXpath, String tarTagName, String tarKeyword){
		WebElement res = null;
		WebElement divRoot = null;
		if(divId == null || divId.equals("")) {
			if(divXpath == null || divXpath.equals("")) {
				GLog.logRecordTime(8, "Id and Xpath can not be empty at the same time");
				return null;
			}
		}
		
		if(!divId.equals("")) {
			divRoot = driver.findElement(By.id(divId));
		}else{
			divRoot = driver.findElement(By.xpath(divXpath));
		}
		
		List<WebElement> buttons = divRoot.findElements(By.tagName(tarTagName));
		for(WebElement button:buttons){
			if(button.getText().equals(tarKeyword)) {
				res = button;
				GLog.logRecordTime(8, "找到目标，类型为：" + tarTagName + "；元素为[" + res  + "]");
				break;
			}
		}
		
		return res;
	}
	
    /**
    * 根据详细层级元素查询目标元素 全遍历，速度慢，慎用
    * @param driver 全局驱动
    * @param divId 基准元素的id，不为空时以该值为查询条件
    * @param divXpath 基准元素的xpath，divId为空时以该值为查询条件
    * @param tarTagName 目标元素标签类型
    * @param tarPropertyName 属性名
    * @param tarPropertyValue 属性值
    * @param tarText 显示文本
    */
	public static WebElement getWebElementByIdOrXpath(WebDriver driver, String divId, String divXpath, String tarTagName, String tarPropertyName, String tarPropertyValue, String tabText){
		WebElement res = null;
		WebElement divRoot = null;
		if(divId == null || divId.equals("")) {
			if(divXpath == null || divXpath.equals("")) {
				GLog.logRecordTime(8, "Id and Xpath can not be empty at the same time");
				return null;
			}
		}
		
		if(!divId.equals("")) {
			divRoot = driver.findElement(By.id(divId));
		}else{
			divRoot = driver.findElement(By.xpath(divXpath));
		}
		
		List<WebElement> tars = divRoot.findElements(By.tagName(tarTagName));
		
		for(WebElement tar:tars){

			if(!tarPropertyName.equals("") && !tarPropertyValue.equals("")) {
				if(tar.getAttribute(tarPropertyName).equals(tarPropertyValue)) {
					res = tar;
					break;
				}
			}else {
				if(!tabText.equals("")) {
					if(tabText.indexOf("_") != -1) {
						if(tar.getText().indexOf(tabText) != -1) {
							res = tar;
							break;
						}		
					}else {
						if(tar.getText().equals(tabText)) {
							res = tar;
							break;
						}
					}
				}
			}

		}
		
		return res;
	}
	
    /**
    * 根据基准元素查询目标元素 全遍历，速度慢，慎用
    * @param divRoot 基准元素
    * @param tarTagName 目标元素标签类型
    * @param tarPropertyName 属性名
    * @param tarPropertyValue 属性值
    * @param tarText 显示文本
    */
	public static WebElement getWebElementByWebElement(WebElement divRoot,String tarTagName, String tarPropertyName, String tarPropertyValue, String tabText){
		WebElement res = null;
		
		List<WebElement> tars = divRoot.findElements(By.tagName(tarTagName));
		
		for(WebElement tar:tars){

			if(!tarPropertyName.equals("") && !tarPropertyValue.equals("")) {
				if(tar.getAttribute(tarPropertyName).equals(tarPropertyValue)) {
					res = tar;
					break;
				}
			}else {
				if(!tabText.equals("")) {
					if(tar.getText().equals(tabText)) {
						res = tar;
						break;
					}
				}
			}

		}
		
		return res;
	}
}
