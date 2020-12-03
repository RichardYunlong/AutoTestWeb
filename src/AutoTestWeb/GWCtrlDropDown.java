package AutoTestWeb;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import AutoTest.GText;

/**
 *  下拉选择控件
 */
public class GWCtrlDropDown {
	
	/**
	 *  处理下拉菜单：按照元素文字值选中
	 *  @param dropdownId
	 *  @param strValue
	 */
	public static void ByValue(String dropdownId,String strValue) {
		//根据id找到选中值显示框的元素
		WebElement inputField = GParam.g_Dr.findElement(By.id(dropdownId));
		WebElement inputParent = inputField.findElement(By.xpath(".."));
		List<WebElement> inputSpans = inputParent.findElements(By.tagName("span"));
		if(inputSpans != null) {
			for (WebElement inputSpan : inputSpans) {
				if(inputSpan != null) {
					inputSpan.click();
					break;
				}
			}
		}
		
		List<WebElement> comboLists = GParam.g_Dr.findElements(By.cssSelector(GText.getCssSelectorTxt("div", "class", "x-combo-list-inner")));
		if(comboLists != null) {
			for (WebElement comboList : comboLists) {
				if(comboList.getAttribute("style") != null && !comboList.getAttribute("style").equals("") ) {
					List<WebElement> comboListItems = comboList.findElements(By.cssSelector(GText.getCssSelectorTxt("div", "class", "x-combo-list-item")));
					List<WebElement> comboListItemsSelecteds = comboList.findElements(By.cssSelector(GText.getCssSelectorTxt("div", "class", "x-combo-list-item x-combo-selected")));
					
					if(comboListItemsSelecteds != null) {
						for (WebElement comboListItemsSelected : comboListItemsSelecteds) {
							if(!comboListItemsSelected.getText().equals(strValue)) {
								if(comboListItems != null) {
									for (WebElement comboListItem : comboListItems) {
										if(comboListItem.getText().equals(strValue)) {
											comboListItem.click();
											break;
										}
									}
								}
							}else {
							    comboListItemsSelected.click();
                            }
							
						}
					}
					break;
				}
			}
		}
	}
}
