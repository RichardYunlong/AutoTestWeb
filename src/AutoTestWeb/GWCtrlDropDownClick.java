package AutoTestWeb;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import AutoTest.GLog;

/**
 *  枚举选择功能
 */
public class GWCtrlDropDownClick {
	
	/**
	 *  处理下拉菜单：按照元素序号选中
	 *  @param dropdownId
	 *  @param Index
	 */
	public static void ByIndex(String dropdownId, int Index) {
		//1、根据元素定位找到select这个标签
		Select sel = new Select(GParam.g_Dr.findElement(By.id(dropdownId)));
		//2、getOptions()方法获得的是一个WebElement的集合
		List<WebElement> webElements = sel.getOptions();

		//3、新建一个List，用来存储每个选项的文本值
		List<String> downs = new ArrayList<>();

		//4、for-each循环每个选项        
		for (WebElement webElement : webElements) {
		    GLog.logRecordTime(8, "选项的值："+webElement.getText()); //调试的时候打印看一下
		        //5、将每个选项的文本值添加到List集合
		    downs.add(webElement.getText()); 
		}
		
		//6、获取下拉选项的数量        
		int num = webElements.size();
		//7、根据序号选择
		if(Index >= 0 && Index < num) {
			sel.selectByIndex(Index);
			GLog.logRecordTime(8, "选中了第" + String.valueOf(Index) + "号元素");
		}	
	}
	
	/**
	 *  处理下拉菜单：按照元素文字值选中
	 *  @param dropdownId
	 *  @param strValue
	 */
	public static void ByValue(String dropdownId,String strValue) {
		//1、根据元素定位找到select这个标签
		Select sel = new Select(GParam.g_Dr.findElement(By.id(dropdownId)));
		//2、getOptions()方法获得的是一个WebElement的集合
		List<WebElement> webElements = sel.getOptions();

		//3、新建一个List，用来存储每个选项的文本值
		List<String> downs = new ArrayList<>();

		//4、for-each循环每个选项        
		for (WebElement webElement : webElements) {
		    GLog.logRecordTime(8, "选项的值："+webElement.getText()); //调试的时候打印看一下
		    //5、将每个选项的文本值添加到List集合
		    downs.add(webElement.getText()); 
		    if(webElement.getText().equals(strValue)) {
		    	//6、根据值选择
		    	sel.selectByValue(strValue);
		    	GLog.logRecordTime(8, "选中了值为" + strValue + "的元素");
		    }
		}	
	}
}
