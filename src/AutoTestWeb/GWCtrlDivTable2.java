package AutoTestWeb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class GWCtrlDivTable2 {

	/**
	 * 二级窗体显示区 使用Xpath定位
	 */
	public Map<String, String> mapXpath = new HashMap<String,String>();
	
	/*条件区----------------------------------------------------------------------------------------------*/
	/**
	 * 表头
	 */
	public Map<Integer, Map<String, String>> mapConditionHeader = new HashMap<Integer, Map<String, String>>();
	/**
	 * 表数据
	 */
	public Map<Integer, Map<String, String>> mapCondition = new HashMap<Integer, Map<String, String>>();
	/**
	 * 全表
	 */
	public Map<Integer, Map<String, String>> mapConditionAll = new HashMap<Integer, Map<String, String>>();
	/*---------------------------------------------------------------------------------------------------*/
	
	/*展示区----------------------------------------------------------------------------------------------*/
	/**
	 * 表头
	 */
	public Map<Integer, Map<String, String>> mapDetailHeader = new HashMap<Integer, Map<String, String>>();
	/**
	 * 表数据
	 */
	public Map<Integer, Map<String, String>> mapDetail = new HashMap<Integer, Map<String, String>>();
	/**
	 * 全表
	 */
	public Map<Integer, Map<String, String>> mapDetailAll = new HashMap<Integer, Map<String, String>>();
	/*---------------------------------------------------------------------------------------------------*/
	
	/*选中区----------------------------------------------------------------------------------------------*/
	/**
	 * 表头
	 */
	public Map<Integer, Map<String, String>> mapTargetHeader = new HashMap<Integer, Map<String, String>>();
	/**
	 * 表数据
	 */
	public Map<Integer, Map<String, String>> mapTarget = new HashMap<Integer, Map<String, String>>();
	/**
	 * 全表
	 */
	public Map<Integer, Map<String, String>> mapTargetAll = new HashMap<Integer, Map<String, String>>();
	/*---------------------------------------------------------------------------------------------------*/

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
	public GWCtrlDivTable2(String strXpath) {
		mapXpath.put("二级窗体", strXpath);
		mapXpath.put("条件区",mapXpath.get("二级窗体") + "/div/div/div[1]");
		mapXpath.put("条件区 表头",mapXpath.get("条件区") + "/div/div/div/div/div[2]/div/div[1]/div[1]/div[1]/div/table");
		mapXpath.put("条件区 数据",mapXpath.get("条件区") + "/div/div/div/div/div[2]/div/div[1]/div[2]/div");

		mapXpath.put("展示区",mapXpath.get("二级窗体") + "/div/div/div[2]/div/div/div[1]");
		mapXpath.put("展示区 表头",mapXpath.get("展示区") + "/div/div/div/div/div[2]/div/div[1]/div[1]/div[1]/div/table");
		mapXpath.put("展示区 数据",mapXpath.get("展示区") + "/div/div/div/div/div[2]/div/div[1]/div[2]/div");
		
		mapXpath.put("选中区",mapXpath.get("二级窗体") + "/div/div/div[2]/div/div/div[2]");
		mapXpath.put("选中区 表头",mapXpath.get("选中区") + "/div/div/div/div/div[2]/div/div[1]/div[1]/div[1]/div/table");
		mapXpath.put("选中区 数据",mapXpath.get("选中区") + "/div/div/div/div/div[2]/div/div[1]/div[2]/div");

		//加载条件区
		//条件区第0行为字段名称
		GLog.logRecordTime(8, "-----加载条件区表头------");
		WebElement conditionHeaderValue = GParam.g_Dr.findElement(By.xpath(mapXpath.get("条件区 表头")));
		GWCtrlTable conditionHeader = new GWCtrlTable(conditionHeaderValue);
		conditionHeader.getRangeFromRows(GParam.g_Dr, mapXpath.get("条件区 表头"));
		mapConditionHeader.put(0, conditionHeader.mapTableValue.get(0));
		GLog.logRecordTime(8, "----条件区表头加载完成----");
		//条件区主体值
		GLog.logRecordTime(8, "-----加载条件区内容------");
		WebElement conditionValue = GParam.g_Dr.findElement(By.xpath(mapXpath.get("条件区 数据")));
		GWCtrlDivTable condition = new GWCtrlDivTable(conditionValue);
		mapCondition.putAll(condition.getRangeFromRows(GParam.g_Dr, mapXpath.get("条件区 数据")));
		GLog.logRecordTime(8, "----条件区内容加载完成----");
		
		//加载展示区
		//展示区第0行为字段名称
		GLog.logRecordTime(8, "-----加载展示区表头------");
		WebElement detailHeaderValue = GParam.g_Dr.findElement(By.xpath(mapXpath.get("展示区 表头")));
		GWCtrlTable detailHeader = new GWCtrlTable(detailHeaderValue);
		detailHeader.getRangeFromRows(GParam.g_Dr, mapXpath.get("展示区 表头"));
		mapDetailHeader.put(0, detailHeader.mapTableValue.get(0));
		GLog.logRecordTime(8, "----展示区表头加载完成----");
		//展示区主体值
		GLog.logRecordTime(8, "-----加载展示区内容------");
		WebElement detailValue = GParam.g_Dr.findElement(By.xpath(mapXpath.get("展示区 数据")));
		GWCtrlDivTable detail = new GWCtrlDivTable(detailValue);
		mapDetail.putAll(detail.getRangeFromRows(GParam.g_Dr, mapXpath.get("展示区 数据")));
		GLog.logRecordTime(8, "----展示区内容加载完成----");
		
		//加载展示区
		//展示区第0行为字段名称
		GLog.logRecordTime(8, "-----加载展示区表头------");
		WebElement targetHeaderValue = GParam.g_Dr.findElement(By.xpath(mapXpath.get("展示区 表头")));
		GWCtrlTable targetHeader = new GWCtrlTable(targetHeaderValue);
		targetHeader.getRangeFromRows(GParam.g_Dr, mapXpath.get("展示区 表头"));
		mapTargetHeader.put(0, targetHeader.mapTableValue.get(0));
		GLog.logRecordTime(8, "----展示区表头加载完成----");
		//展示区主体值
		GLog.logRecordTime(8, "-----加载展示区内容------");
		WebElement targetValue = GParam.g_Dr.findElement(By.xpath(mapXpath.get("展示区 数据")));
		GWCtrlDivTable target = new GWCtrlDivTable(targetValue);
		mapTarget.putAll(target.getRangeFromRows(GParam.g_Dr, mapXpath.get("展示区 数据")));
		GLog.logRecordTime(8, "----展示区内容加载完成----");
	}
	
    /**
     * 打印表格
     */
    public void showTableMap(){
		GLog.logRecordTime(8, "----条件区----");
		GLog.logRecordTime(8, JSON.toJSONString(mapCondition));
		GLog.logRecordTime(8, "----展示区----");
		GLog.logRecordTime(8, JSON.toJSONString(mapDetail));
		GLog.logRecordTime(8, "----选中区----");
		GLog.logRecordTime(8, JSON.toJSONString(mapTarget));
    }
	
    /**
    * 根据divTable的xpath得到table上的所有数据 这是此数据结构的特征如下
    * 一个根div下存在若干个行div
    *              一个行div包含一个行table
    *                        一个行table包含一个行tr
    *                                     一个行tr包含若干个列td
    * @param driver 浏览器驱动
    * @param tableXpath 根路劲xpath
    * @return 表值
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
	
    /**
    * 根据divTable的xpath和另外的关键信息，得到divtable上的某行数据赌赢的元素
    * 一个根div下存在若干个行div
    *              一个行div包含一个行table
    *                        一个行table包含一个行tr
    *                                     一个行tr包含若干个列td
    *                                     查找这个td的文本值是否与查询条件匹配
    * @param driver 浏览器驱动
    * @param tableXpath 根路劲xpath
    * @param strParam 查询条件
    * @return 行号 默认返回第1行
    */
	public int getRowFromDivTable(WebDriver driver, String strParam){
		int dRow = 0;//有效行数
		Map<String, String> mapTableValueTemp = null;
		
		WebElement divTable= driver.findElement(By.xpath(this.mapXpath.get("展示区 数据")));
		List<WebElement> divRows = divTable.findElements(By.tagName("div"));

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
						if((strParam != null)//查询条件存在
							&& (!strParam.equals(""))//查询条件不为空
							&& (!cell.getText().equals(""))//查询数据不为空
							&& (cell.getText().equals(strParam))) {//查询数据与查询条件一致
							GLog.logRecordTime(8, "找到目标行号：" + String.valueOf(dRow));
							GLog.logRecordTime(8, "找到目标列号：" + String.valueOf(i));
							return dRow;
						}
						i++;
					}
				}
				mapTableValueTemp = null;
			}
		}
		
		return 1;
	}
}
