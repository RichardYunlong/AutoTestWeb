package AutoTestWeb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.alibaba.fastjson.JSON;

import AutoTest.GLog;

/**
 *  用于处理特殊的Div类型的Table
 *  字段名称行为Div类型
 *  字段值行为Table类型
 *  第一列为选中列
 *  第二列为序号列
 * *  主体显示区根divXpath：
 * *  一般包含【上表】和【下表】显示区，每个表显示区
 * *  一般包含【左区】（表格锁定显示的部分）和【右区】（表格可拖动的部分），每个区
 * *  一般包含【表头】和【表数据】
 */
public class GWCtrlDivTable {

	/**
	 * 上表----显示区 使用Xpath定位
	 */
	public Map<String, String> mapTopTableXpath = new HashMap<String,String>();
	
	/**
	 * 上表----左区表头
	 */
	public Map<Integer, Map<String, String>> mapTopLeftValue = new HashMap<Integer, Map<String, String>>();
	
	/**
	 * 上表----右区表头
	 */
	public Map<Integer, Map<String, String>> mapTopRightValue = new HashMap<Integer, Map<String, String>>();
	
	/**
	 *  上表----左区表数据
	 */
	public Map<Integer, Map<String, String>> mapTopLeft = new HashMap<Integer, Map<String, String>>();
	
	/**
	 *  上表----右区表数据
	 */
	public Map<Integer, Map<String, String>> mapTopRight = new HashMap<Integer, Map<String, String>>();
	
	/**
	 *  上表----全表数据
	 */
	public Map<Integer, Map<String, String>> mapTopDivTable = new HashMap<Integer, Map<String, String>>();
	
	
	/**
	 * 下表----显示区 使用Xpath定位
	 */
	public Map<String, String> mapBottomTableXpath = new HashMap<String,String>();
	
	/**
	 * 下表----左区表头
	 */
	public Map<Integer, Map<String, String>> mapBottomLeftValue = new HashMap<Integer, Map<String, String>>();
	
	/**
	 * 下表----右区表头
	 */
	public Map<Integer, Map<String, String>> mapBottomRightValue = new HashMap<Integer, Map<String, String>>();
	
	/**
	 *  下表----左区表数据
	 */
	public Map<Integer, Map<String, String>> mapBottomLeft = new HashMap<Integer, Map<String, String>>();
	
	/**
	 *  下表----右区表数据
	 */
	public Map<Integer, Map<String, String>> mapBottomRight = new HashMap<Integer, Map<String, String>>();
	
	/**
	 *  下表----全表数据
	 */
	public Map<Integer, Map<String, String>> mapBottomDivTable = new HashMap<Integer, Map<String, String>>();
	
	/**
	 *  声明一个WebElement对象，用于存储页面的表格元素对象
	 */
    private WebElement _table;

	/**
	 *  为构造函数传入页面表格元素对象参数，调用TableUtil类的settable方法，将页面表格元素赋值给TableUtil类的_table成员变量
	 */
    public GWCtrlDivTable (WebElement table){
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
	 * 
	 */
	public GWCtrlDivTable(String strXpath) {
		mapTopTableXpath.put("上表根路径", strXpath);
		mapTopTableXpath.put("上表字段名左区table",mapTopTableXpath.get("上表根路径") + "/div[1]/div[1]/div[1]/div/table");
		mapTopTableXpath.put("上表表内容左区div",mapTopTableXpath.get("上表根路径") + "/div[1]/div[2]/div[1]");
		mapTopTableXpath.put("上表字段名右区table",mapTopTableXpath.get("上表根路径") + "/div[2]/div[1]/div[1]/div/table");
		mapTopTableXpath.put("上表表内容右区div",mapTopTableXpath.get("上表根路径") + "/div[2]/div[2]/div");
		
		//左表第0行为字段名称
		GLog.logRecordTime(8, "-----加载左表表头------");
		WebElement tableTopLeftHeaderValue = GParam.g_Dr.findElement(By.xpath(mapTopTableXpath.get("上表字段名左区table")));
		GWCtrlTable tableDivLeft = new GWCtrlTable(tableTopLeftHeaderValue);
		tableDivLeft.getRangeFromRows(GParam.g_Dr, mapTopTableXpath.get("上表字段名左区table"));
		mapTopLeftValue.put(0, tableDivLeft.mapTableValue.get(0));
		GLog.logRecordTime(8, "----左表表头加载完成----");
		
		//右表第0行为字段名称
		GLog.logRecordTime(8, "-----加载右表表头------");
		WebElement tableTopRightHeaderValue = GParam.g_Dr.findElement(By.xpath(mapTopTableXpath.get("上表字段名右区table")));
		GWCtrlTable tableDivRight = new GWCtrlTable(tableTopRightHeaderValue);
		tableDivRight.getRangeFromRows(GParam.g_Dr, mapTopTableXpath.get("上表字段名右区table"));
		mapTopRightValue.put(0, tableDivRight.mapTableValue.get(0));
		GLog.logRecordTime(8, "----右表表头加载完成----");

		//左表主体值
		GLog.logRecordTime(8, "-----加载左表内容------");
		WebElement tableTopLeftValue = GParam.g_Dr.findElement(By.xpath(mapTopTableXpath.get("上表表内容左区div")));
		GWCtrlDivTable tableLeft = new GWCtrlDivTable(tableTopLeftValue);
		mapTopLeft.putAll(tableLeft.getRangeFromRows(GParam.g_Dr, mapTopTableXpath.get("上表表内容左区div")));
		GLog.logRecordTime(8, "----左表内容加载完成----");
		
		//右表主体值
		GLog.logRecordTime(8, "-----加载右表内容------");
		WebElement tableTopRightValue = GParam.g_Dr.findElement(By.xpath(mapTopTableXpath.get("上表表内容右区div")));
		GWCtrlDivTable tableRight = new GWCtrlDivTable(tableTopRightValue);
		mapTopRight.putAll(tableRight.getRangeFromRows(GParam.g_Dr, mapTopTableXpath.get("上表表内容右区div")));
		GLog.logRecordTime(8, "----右表内容加载完成----");
		
		mapTopLeftValue.putAll(mapTopLeft);
		mapTopRightValue.putAll(mapTopRight);
		mapTopDivTable.putAll(mapTopLeftValue);
    	mapTopDivTable.putAll(mapTopRightValue);
	}
	
    /**
     * 打印表格 由于操作性能耗损较大，所以只有智能助理开启时此项开启
     */
    public void showTableMap(){
    	if(AutoTest.GParam.gDragonShow) {
    		GLog.logRecordTime(8, "----全表读取开始----");
    		GLog.logRecordTime(8, JSON.toJSONString(mapTopDivTable));
    		GLog.logRecordTime(8, "----全表读取完成----");
		}
    }
	
    /**
    * 根据divTable的xpath得到table上的所有数据 这是此数据结构的特征如下
    * 一个根div下存在若干个行div
    *              一个行div包含一个行table
    *                        一个行table包含一个行tr
    *                                     一个行tr包含若干个列td
    */
	public Map<Integer, Map<String, String>> getRangeFromRows(WebDriver driver, String tableXpath){
		int dRow = 0;//有效行数
		int dCol = 0;//有效列数
		
		Map<Integer, Map<String, String>> mapTableValue = new HashMap<Integer, Map<String, String>>();
		Map<String, String> mapTableValueTemp = null;
		
		WebElement divTable= driver.findElement(By.xpath(tableXpath));
		
		//
		List<WebElement> divRows = divTable.findElements(By.tagName("div"));
		
		int index = 0;
		for(WebElement rowD:divRows){
			List<WebElement> tableRows = rowD.findElements(By.tagName("table"));
			for(WebElement rowT:tableRows){
				List<WebElement> trRows = rowT.findElements(By.tagName("tr"));			
				for(WebElement rowTR:trRows){
					if(rowTR.getAttribute("style").equals("visibility: hidden;")) {
						GLog.logRecordTime(8, "忽略了不可见的1行");
						continue;
					}
					
					List<WebElement> col = rowTR.findElements(By.tagName("td"));
					if(col.size() == 0) {
						dRow--;
						GLog.logRecordTime(8, "忽略了值为空的1行");
						continue;
					}
					dRow++;
					mapTableValueTemp = new HashMap<String, String>();
					int i = 0;
					for(WebElement cell:col){
						JavascriptExecutor js=(JavascriptExecutor) GParam.g_Dr;
						js.executeScript("arguments[0].scrollIntoView(true);",cell);
						mapTableValueTemp.put(String.valueOf(i), cell.getText());
						i++;
					}
					dCol = i;
				}
				
				index++;
				mapTableValue.put(Integer.valueOf(index), mapTableValueTemp);
				mapTableValueTemp = null;
			}
			
			if(index == 10){
				GLog.logRecordTime(8, "为保证测试的速度，暂时最多读取10行");
				break;
			}
		}
		
		GLog.logRecordTime(8, "找到" + String.valueOf(dRow) + "行(注意，当搜索到的列数量与实际不符时，可能存在隐藏行)");
		GLog.logRecordTime(8, "找到" + String.valueOf(dCol) + "列(注意，当搜索到的列数量与实际不符时，可能存在隐藏列或新行)");
		
		return mapTableValue;
	}
}
