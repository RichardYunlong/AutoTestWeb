package AutoTestWeb;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import AutoTest.GLog;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 *  Table控件点击处理
 */
public class GWCtrlTable {
	
	/**
	 *  当前表的结果map
	 */
	public Map<Integer, Map<String, String>> mapTableValue = null;
	
	/**
	 *  声明一个WebElement对象，用于存储页面的表格元素对象
	 */
    private WebElement _table;

	/**
	 *  为构造函数传入页面表格元素对象参数，调用TableUtil类的settable方法，将页面表格元素赋值给TableUtil类的_table成员变量
	 */
    public GWCtrlTable (WebElement table){
        setTable(table);
    }
    
    /**
     *  获取页面表格对象的方法
     */
    public WebElement getTable(){
        return _table;
    }
    
    /**
     *  将页面表格元素赋值给TableUtil类中_table成员变量的方法
     */
    public void setTable(WebElement _table){
        this._table = _table;
    }
    
    /**
     *  获取表格元素的行数，查找表格元素有几个tr元素,有几个tr元素，就可以知道表格有几行，tr数量和表格行数相一致
     */
    public int getRowCount(){
        List<WebElement> tableRows = _table.findElements(By.tagName("tr"));
        return tableRows.size();
    }
    
    /**
     *  获取表格元素的列数，使用get(0)从容器中取出表格第一行的元素，查找有几个“td”,td数量和列数一致
     */
    public int getColumnCount(){
        List<WebElement> tableRows = _table.findElements(By.tagName("tr"));
        return tableRows.get(0).findElements(By.tagName("td")).size();
    }

    /**
     *  获取表格中某行某列的单元格对象
     */
    public WebElement getCell(int rowNo, int colNo)throws NoSuchElementException{
        try{
            List<WebElement> tableRows = _table.findElements(By.tagName("tr"));
            GLog.logRecordTime(8, "行总数：" + tableRows.size());
            GLog.logRecordTime(8, "行号：" + rowNo);
            WebElement currentRow = tableRows.get(rowNo);
            List<WebElement> tableCols = currentRow.findElements(By.tagName("td"));
            GLog.logRecordTime(8, "列总数：" + tableCols.size());
            WebElement cell = tableCols.get(colNo);
            GLog.logRecordTime(8, "列号：" + colNo);
            return cell;
        }catch (NoSuchElementException e){
            throw new NoSuchElementException("没有找到相关元素");
        }
    }
    
    /**
     * 获得表格中某行某列的单元格中的某个页面元素对象，by参数用于定位某个表格中的页面元素，例如by.xpath("input[@type='text']")可以定义到表格中的输入框
     */
    public WebElement getWebElementInCell(int rowNo, int colNo, By by)throws NoSuchElementException{
        try{
            List<WebElement> tableRows = _table.findElements(By.tagName("tr"));
            //找到表格中的某一行，行号从0开始，例如第三行，则需要进行3-1来获取即“2”
            WebElement currentRow = tableRows.get(rowNo);
            List<WebElement> tableCols = currentRow.findElements(By.tagName("td"));
            //找到表格中的某一列，因为也是从0开始，所以要找到第三列，则需要进行3-1来获取即“2”
            WebElement cell = tableCols.get(colNo);
            return cell.findElement(by);
        }catch (NoSuchElementException e){
            throw new NoSuchElementException("没有找到相关元素");
        }
    }

    /**
     *
     * @param driver 浏览器驱动
     * @param row 行号
     * @param column 列号
     * @return 函数接受浏览器驱动，表格行数和列数，注意表头行，返回某个cell的值
     */
    public String getTableCell(WebDriver driver, int row, int column) {
        String text = null;
        //avoid get the head line of the table
        row=row+1;
        String xpath="//*[@id='table138']/tbody/tr["+row+"]/td["+column+"]";
        WebElement table=driver.findElement(By.xpath(xpath));
        text=table.getText();
        return text;
    }
    
    /**
    * 根据table的xpath得到table上的所有数据
    */
	public void getRangeFromRows(WebDriver driver, String tableXpath){
		int dRow = 0;//有效行数
		int dCol = 0;//有效列数
		
		mapTableValue = new HashMap<Integer, Map<String, String>>();
		Map<String, String> mapTableValueTemp = null;
		
		WebElement table= driver.findElement(By.xpath(tableXpath));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		dRow = rows.size();
		
		int index = 0;
		for(WebElement row:rows){
			if(row.getAttribute("style").equals("visibility: hidden;")) {
				GLog.logRecordTime(8, "忽略了不可见的1行");
				dRow--;
				continue;
			}
			
			List<WebElement> col = row.findElements(By.tagName("td"));
			if(col.size() == 0) {
				dRow--;
				GLog.logRecordTime(8, "忽略了值为空的1行");
				continue;
			}

			mapTableValueTemp = new HashMap<String, String>();
			int i = 0;
			for(WebElement cell:col){
				JavascriptExecutor js=(JavascriptExecutor) GParam.g_Dr;
				js.executeScript("arguments[0].scrollIntoView(true);",cell);
				mapTableValueTemp.put(String.valueOf(i), cell.getText());
				i++;
			}
			dCol = i;
			mapTableValue.put(Integer.valueOf(index), mapTableValueTemp);
			index++;//找到一个tr则证明表有一行
			mapTableValueTemp = null;
		}
		
		GLog.logRecordTime(8, "找到" + String.valueOf(dRow) + "行(注意，当搜索到的列数量与实际不符时，可能存在隐藏行)");
		GLog.logRecordTime(8, "找到" + String.valueOf(dCol) + "列(注意，当搜索到的列数量与实际不符时，可能存在隐藏列或新行)");
	}
}
