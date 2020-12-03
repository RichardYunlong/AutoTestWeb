package AutoTestWeb;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import AutoTest.GText;

/**
 *  下拉多选控件
 */
public class GWCtrlDropDownMutiSelect {
	
	/**
	 *  处理下拉菜单：按照元素文字值选中
	 *  @param dropdownId 控件属性
	 *  @param strValues 需要选中的值得数组
	 */
	public static void ByValue(String dropdownId,String[] strValues) {
		List<WebElement> comboLists = null;
		for(int i = 0;i < strValues.length;i++){
			comboLists = GParam.g_Dr.findElements(By.cssSelector(GText.getCssSelectorTxt("div", "class", "x-combo-list-inner")));
			if(comboLists != null) {
				for (WebElement comboList : comboLists) {
					//先把选中的宣布取消选中
					List<WebElement> comboListItemsSelecteds = comboList.findElements(By.cssSelector(GText.getCssSelectorTxt("div", "class", "x-combo-list-item x-combo-mselect x-combo-selected")));
					if(comboListItemsSelecteds != null) {
						for (WebElement comboListItemsSelected : comboListItemsSelecteds) {
							comboListItemsSelected.click();
							if(comboListItemsSelected.getAttribute("class").equals("x-combo-list-item x-combo-mselect x-combo-selected")){
								//如果仍然未被取消选中，则再次点击
								comboListItemsSelected.click();
							}
						}
					}
				}
			}

			comboLists = GParam.g_Dr.findElements(By.cssSelector(GText.getCssSelectorTxt("div", "class", "x-combo-list-inner")));
			if(comboLists != null) {
				for (WebElement comboList : comboLists) {
					//选中目标
					List<WebElement> comboListItems1 = comboList.findElements(By.cssSelector(GText.getCssSelectorTxt("div", "class", "x-combo-list-item x-combo-selected")));
					List<WebElement> comboListItems2 = comboList.findElements(By.cssSelector(GText.getCssSelectorTxt("div", "class", "x-combo-list-item")));
					if(comboListItems1 != null && comboListItems2 != null) {
						for (WebElement comboListItem : comboListItems1) {
							if(comboListItem.getText().equals(strValues[i])) {
								comboListItem.click();
							}
						}
						for (WebElement comboListItem : comboListItems2) {
							if(comboListItem.getText().equals(strValues[i])) {
								comboListItem.click();
							}
						}
					}
				}
			}
		}
	}
}
