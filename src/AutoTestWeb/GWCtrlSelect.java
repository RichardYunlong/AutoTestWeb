package AutoTestWeb;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import AutoTest.GLog;

/**
 *  搜索框控件
 */
public class GWCtrlSelect {
	

	/**
	 * @param selectId 兄弟节点的table元素的id
	 * @param strValue 要写入的值
	 */
	public static void ByValue(String selectId,String strValue) {
	    GLog.logRecordTime(9, "[功能]----搜索控件输入"+strValue);
		//根据id找到选中值显示框的元素
		WebElement tableld = GParam.g_Dr.findElement(By.id(selectId));
		WebElement inputParent = tableld.findElement(By.xpath("./.."));
		List<WebElement> inputDivs = inputParent.findElements(By.tagName("div"));
		if(inputDivs != null) {
			for (WebElement inputDiv : inputDivs) {
				if(inputDiv != null) {
				    //目前不做处理，选择第一个input标签进行写入
				    WebElement input = inputDiv.findElement(By.tagName("input"));
				    GWCtrlInputFill.ByWebElementUnClear(input, strValue);
				    GWCtrlTime.Pause(1);
					break;
				}
			}
		}	
	}
}
