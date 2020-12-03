package AutoTestWeb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import AutoTest.GLog;
import AutoTest.GText;

/**
 *  Grid处理 目前前端框架使用的是grid3，所以使用以下方式处理表格类数据
 */
public class GWCtrlGrid3 {
	
	/**
	 *  目标grid3
	 *  
	 *  能够确定唯一目标grid3的上层WebElement对象,且该上层元素下仅有一个grid3类型的dom
	 */
	private WebElement divGrid3 = null;
	
	/**
	 *  解析目标grid3后，读取到map中的内容，保存为【行列号-web元素】的键值对
	 */
	public Map<Integer, Map<Integer, WebElement>> table_Row_WebElement = null;
	
	/**
	 *  解析目标grid3后，读取到map中的内容，保存为【行列号-web元素对应文本】的键值对
	 */
	public Map<Integer, Map<Integer, String>> table_Row_WebElement_Text = null;
	
	/**
	 *  解析【合计】目标grid3后，读取到map中的内容，保存为【行列号-web元素】的键值对
	 */
	Map<Integer, Map<Integer, WebElement>> table_Summary_WebElement = null;
	
	/**
	 *  解析【合计】目标grid3后，读取到map中的内容，保存为【行列号-web元素对应文本】的键值对
	 */
	Map<Integer, Map<Integer, String>> table_Summary_WebElement_Text = null;
	
	/**
	 *  构造函数1 根据目标grid3的WebElement对象，读取其包含的表格数据
	 *  
	 *  @param domParent 能够确定唯一目标grid3的上层WebElement对象
	 */
	public GWCtrlGrid3(WebElement domParent){	
		table_Row_WebElement = new HashMap<Integer, Map<Integer, WebElement>>();
		table_Row_WebElement_Text = new HashMap<Integer, Map<Integer, String>>();
		try {
			List<WebElement> grid3s = domParent.findElements(By.cssSelector(GText.getCssSelectorTxt("div", "class", "x-grid3")));
			if(grid3s != null) {
				GLog.logRecordTime(8, "找到目标，类型为：grid3；元素为[" + grid3s.toString() + "]");
				for(WebElement grid3:grid3s){
					if(grid3 != null) {//目前只保存第一个找到的grid3
						divGrid3 = grid3;
						List<WebElement> rows = grid3.findElements(By.cssSelector(GText.getCssSelectorTxt("table", "class", "x-grid3-row-table")));
						int rowIndex = 0;
						Map<Integer, WebElement> colTemp = new HashMap<Integer, WebElement>();
						Map<Integer, String> colTextTemp = new HashMap<Integer, String>();
						for(WebElement row:rows){
							if(row != null) {
								rowIndex++;
								List<WebElement> cols = row.findElements(By.tagName("td"));
								int colIndex = 0;
								for(WebElement col:cols){
									if(col != null) {
										JavascriptExecutor js=(JavascriptExecutor) GParam.g_Dr;
										js.executeScript("arguments[0].scrollIntoView(true);",col);
										List<WebElement> colDivs = col.findElements(By.tagName("div"));
										for(WebElement colDiv:colDivs){
											colIndex++;
											colTemp.put(Integer.valueOf(colIndex), colDiv);
											colTextTemp.put(Integer.valueOf(colIndex), colDiv.getText());
										}	
									}
								}
								table_Row_WebElement.put(Integer.valueOf(rowIndex), colTemp);
								table_Row_WebElement_Text.put(Integer.valueOf(rowIndex), colTextTemp);
							}
						}	
						GLog.logRecordTime(8, "第一个grid3加载完成；元素为[" + grid3.toString() + "]");
						break;
					}
				}
			}
		} catch (Exception e) {
			GWCtrlException.SwtichTo(e, 1, 8, "没有找到有效的grid3元素", true);
		}
	}
	
	/**
	 *  构造函数2 根据目标grid3的WebElement对象关键属性，读取其包含的表格数据
	 *  
	 *  @param domParentType 能够确定唯一目标grid3的上层WebElement对象的某属性名
	 *  @param domParentValue 能够确定唯一目标grid3的上层WebElement对象的某属性值
	 */
	public GWCtrlGrid3(String domParentType, String domParentValue){
		WebElement domParent = null;
		
		
		switch(domParentType) {
			case "id":{
				GWCtrlWait.ViewWaitingById(GTestIndicators.PageShowTime, domParentValue);
				domParent = GParam.g_Dr.findElement(By.id(domParentValue));
				break;
			}
			case "cssSelector":{
				GWCtrlWait.ViewWaitingAllByCssSelector(GTestIndicators.PageShowTime, domParentValue);
				domParent = GParam.g_Dr.findElement(By.cssSelector(domParentValue));
				break;
			}
			case "xpath":{
				GWCtrlWait.ViewWaitingAllByXpath(GTestIndicators.PageShowTime, domParentValue);
				domParent = GParam.g_Dr.findElement(By.xpath(domParentValue));
				break;
			}
			default:{
				break;
			}
		}
		
		//是否执行grid3全局变量赋值
		boolean bSetMap = false;
		for(String[] id_detail:GWCtrlWebElementId.ID_DETAIL) {
			if(domParentValue.equals(id_detail[0])) {
				GLog.logRecordTime(8, "找到目标，类型为：grid3；类型为[" + id_detail[1] + "]");
				bSetMap = true;
				break;
			}
		}
		
		table_Row_WebElement = new HashMap<Integer, Map<Integer, WebElement>>();
		table_Row_WebElement_Text = new HashMap<Integer, Map<Integer, String>>();
		try {
			List<WebElement> grid3s = domParent.findElements(By.cssSelector(GText.getCssSelectorTxt("div", "class", "x-grid3")));
			if(grid3s != null) {
				GLog.logRecordTime(8, "找到目标，类型为：grid3；元素为[" + grid3s.toString() + "]");
				for(WebElement grid3:grid3s){
					if(grid3 != null) {//目前只保存第一个找到的grid3
						divGrid3 = grid3;
						if(bSetMap) {
							List<WebElement> rows = grid3.findElements(By.cssSelector(GText.getCssSelectorTxt("table", "class", "x-grid3-row-table")));
							int rowIndex = 0;
							Map<Integer, WebElement> colTemp = null;
							Map<Integer, String> colTextTemp = null;
							for(WebElement row:rows){
								if(row.getAttribute("style").equals("visibility: hidden;")) {
									GLog.logRecordTime(8, "忽略了不可见的1行");
									continue;
								}
								colTemp = new HashMap<Integer, WebElement>();
								colTextTemp = new HashMap<Integer, String>();
								if(row != null) {
									rowIndex++;
									List<WebElement> cols = row.findElements(By.tagName("td"));
									int colIndex = 0;
									for(WebElement col:cols){
										if(col != null) {
											JavascriptExecutor js=(JavascriptExecutor) GParam.g_Dr;
											js.executeScript("arguments[0].scrollIntoView(true);",col);
											List<WebElement> colDivs = col.findElements(By.tagName("div"));
											for(WebElement colDiv:colDivs){
												if(colDiv.getAttribute("class").indexOf("x-grid3-cell-inner") != -1){
													colIndex++;
													colTemp.put(Integer.valueOf(colIndex), colDiv);
													colTextTemp.put(Integer.valueOf(colIndex), colDiv.getText());
												}
											}
										}
									}
									table_Row_WebElement.put(Integer.valueOf(rowIndex), colTemp);
									table_Row_WebElement_Text.put(Integer.valueOf(rowIndex), colTextTemp);
								}
								colTemp = null;
							}
						}
						
						GLog.logRecordTime(8, "第一个grid3加载完成；元素为[" + grid3.toString() + "]");
						break;
					}
				}
			}
		} catch (Exception e) {
			GWCtrlException.SwtichTo(e, 1, 8, "没有找到有效的grid3元素", true);
		}
	}
	
	/**
	 *  根据条件字符串选中【数据源】中某目标 用于选择包含【col_Code】(材料编码)类型数据
	 *  
	 *  @param tagColCode 选中条件，使用【编码】为选中条件
	 */
	public void ui_C_SELECT_BILLVIEW(String tagColCode){
		if(divGrid3 != null) {
			GWCtrlWait.ViewWaitingTextByWebElement(GTestIndicators.PageShowTime, divGrid3, tagColCode);
			try {
				//获取【单据编号】
				List<WebElement> colCodes = null;
				colCodes = divGrid3.findElements(By.cssSelector(GText.getCssSelectorTxt("div", "class", "x-grid3-cell-inner x-grid3-col-col_Code")));			
				
				//先根据订单编号选中目标
				for(WebElement colCode:colCodes){
					if(colCode.getText().equals(tagColCode)) {//目前只保存第一个找到的grid3
						colCode.click();
						GLog.logRecordTime(8, "目标[" + tagColCode.toString() + "]被点击了");
						break;
					}
				}
				
				GWCtrlWait.ViewWaitingTextByWebElement(GTestIndicators.PageShowTime, divGrid3, tagColCode);
			} catch (Exception e) {
				GWCtrlException.SwtichTo(e, 1, 8, "没有找到有效的编码参数", true);
			}
		}
	}
	
	/**
	 *  根据条件字符串选中【类别树】中某目标
	 *  
	 *  @param tagDisplayCode 选中条件，使用【类别编码】为选中条件
	 */
	public void ui_C_SELECT_TREEVIEW(String tagColCode){
		
		try {
			GWCtrlInputFill.ByIdUnClear(GWCtrlWebElementId.CN_ID.get("类别树-搜索区-搜索框"), tagColCode);
		} catch (Exception e) {
			GLog.logRecordTime(8, "No DisplayCode Exist");
		}
		
		if(divGrid3 != null) {
			GWCtrlWait.ViewWaitingTextByWebElement(GTestIndicators.PageShowTime, divGrid3, tagColCode);
			try {
				List<WebElement> displayCodes = null;
				List<WebElement> colCodes = null;
				displayCodes = divGrid3.findElements(By.cssSelector(GText.getCssSelectorTxt("div", "class", "x-grid3-cell-inner x-grid3-col-col_DisplayCode")));
				colCodes = divGrid3.findElements(By.cssSelector(GText.getCssSelectorTxt("div", "class", "x-grid3-cell-inner x-grid3-col-col_Code x-unselectable")));
				
				if(colCodes != null && colCodes.size() != 0) {
					for(WebElement colCode:colCodes){
						if(colCode.getText().equals(tagColCode)) {//目前只保存第一个找到的grid3
							colCode.click();
							GLog.logRecordTime(8, "目标[" + tagColCode.toString() + "]被点击了");
							break;
						}
					}
				}else {
					for(WebElement colCode:displayCodes){
						if(colCode.getText().equals(tagColCode)) {//目前只保存第一个找到的grid3
							colCode.click();
							GLog.logRecordTime(8, "目标[" + tagColCode.toString() + "]被点击了");
							break;
						}
					}
				}

				GWCtrlWait.ViewWaitingTextByWebElement(GTestIndicators.PageShowTime, divGrid3, tagColCode);
			} catch (Exception e) {
				GWCtrlException.SwtichTo(e, 1, 8, "没有找到有效的编码参数", true);
			}
		}
	}
	
	/**
	 *  根据条件字符串选中【数据源】中某目标 用于选择包含【col_Code】(材料编码)类型数据
	 *  
	 *  @param tagColCode 选中条件，使用【编码】为选中条件
	 */
	public void ui_C_SELECT_SOURCE(String tagColCode){
		if(divGrid3 != null) {
			GWCtrlWait.ViewWaitingTextByWebElement(GTestIndicators.PageShowTime, divGrid3, tagColCode);
			try {
				//获取【字典编号】、【单据编号】、【字典完整编号】、【合同编号】、【商混编号】、【材料编码】、【使用单位】
				List<WebElement> colCodes = null;
				List<WebElement> colDJBHs = null;
				List<WebElement> colCLZDs = null;
				List<WebElement> colHTBHs = null;
				List<WebElement> colCLBMs = null;
				List<WebElement> colSYDWs = null;
				colCodes = divGrid3.findElements(By.cssSelector(GText.getCssSelectorTxt("div", "class", "x-grid3-cell-inner x-grid3-col-col_Code x-unselectable")));
				colDJBHs = divGrid3.findElements(By.cssSelector(GText.getCssSelectorTxt("div", "class", "x-grid3-cell-inner x-grid3-col-col_DJBH x-unselectable")));
				colCLZDs = divGrid3.findElements(By.cssSelector(GText.getCssSelectorTxt("div", "class", "x-grid3-cell-inner x-grid3-col-col_CLZD_FullCode x-unselectable")));		
				colHTBHs = divGrid3.findElements(By.cssSelector(GText.getCssSelectorTxt("div", "class", "x-grid3-cell-inner x-grid3-col-col_Code1")));
				colCLBMs = divGrid3.findElements(By.cssSelector(GText.getCssSelectorTxt("div", "class", "x-grid3-cell-inner x-grid3-col-col_CLBM x-unselectable")));
				colSYDWs = divGrid3.findElements(By.cssSelector(GText.getCssSelectorTxt("div", "class", "x-grid3-cell-inner x-grid3-col-col_SYDW x-unselectable")));
				if (colHTBHs != null && colHTBHs.size() != 0) {//如果合同编号不为空
                  for(WebElement colHTBH:colHTBHs){
                    if(colHTBH.getText().equals(tagColCode)) {//目前只保存第一个找到的grid3
                        colHTBH.click();
                        GLog.logRecordTime(8, "目标[" + tagColCode.toString() + "]被点击了");
                        break;
                        }
                    }
                }else {
                  //如果【单据编号】不为空，则以单据编号为查询条件
                  if(colDJBHs != null && colDJBHs.size() != 0) {
                      for(WebElement colCode:colDJBHs){
                          if(colCode.getText().equals(tagColCode)) {//目前只保存第一个找到的grid3
                              colCode.click();
                              GLog.logRecordTime(8, "目标[" + tagColCode.toString() + "]被点击了");
                              break;
                          }
                      }
                  }else {//如果【字典完整编号】不为空，则以字典完整编号为查询条件
                      if(colCLZDs != null && colCLZDs.size() != 0) {
                          for(WebElement colCode:colCLZDs){
                              if(colCode.getText().equals(tagColCode)) {//目前只保存第一个找到的grid3
                                  colCode.click();
                                  GLog.logRecordTime(8, "目标[" + tagColCode.toString() + "]被点击了");
                                  break;
                              }
                          }
                      }else if(colCLBMs != null && colCLBMs.size() != 0) {
                          for(WebElement colCode:colCLBMs){
                              if(colCode.getText().equals(tagColCode)) {//目前只保存第一个找到的grid3
                                  colCode.click();
                                  GLog.logRecordTime(8, "目标[" + tagColCode.toString() + "]被点击了");
                                  break;
                              }
                          }
                      }else if(colSYDWs != null && colSYDWs.size() != 0) {
                          for(WebElement colCode:colSYDWs){
                              if(colCode.getText().equals(tagColCode)) {//目前只保存第一个找到的grid3
                                  colCode.click();
                                  GLog.logRecordTime(8, "目标[" + tagColCode.toString() + "]被点击了");
                                  break;
                              }
                          }
                      }else {//否则使用【字典编号】为查询条件
                          for(WebElement colCode:colCodes){
                              if(colCode.getText().equals(tagColCode)) {//目前只保存第一个找到的grid3
                                  colCode.click();
                                  GLog.logRecordTime(8, "目标[" + tagColCode.toString() + "]被点击了");
                                  break;
                              }
                          }
                      }
                  }
                }

				
				GWCtrlWait.ViewWaitingTextByWebElement(GTestIndicators.PageShowTime, divGrid3, tagColCode);
			} catch (Exception e) {
				GWCtrlException.SwtichTo(e, 1, 8, "没有找到有效的编码参数", true);
			}
		}
	}
	
	/**
	 *  根据条件字符串选中【数据源】中某目标
	 *  
	 *  @param tagColName 选中条件，字段名称
	 *  @param tagColCode 选中条件，字段值
	 */
	public void ui_C_SELECT_SOURCE(String tagColName, String tagColValue){
		//辅助标记
		List<WebElement> colCodes = null;
		String colCodesCssSelector = "";
		if(divGrid3 != null) {
			//目标区域存在符合【字段值】的文本
			GWCtrlWait.ViewWaitingTextByWebElement(GTestIndicators.PageShowTime, divGrid3, tagColValue);
			//执行搜索
			try {
				switch(tagColName){
					case "单据编号":{
						colCodesCssSelector = GText.getCssSelectorTxt("div", "class", "x-grid3-cell-inner x-grid3-col-col_DJBH x-unselectable");
						break;
					}
					case "材料字典":{
						colCodesCssSelector = GText.getCssSelectorTxt("div", "class", "x-grid3-cell-inner x-grid3-col-col_CLZD_FullCode x-unselectable");
						break;
					}
					case "合同编号":{
						colCodesCssSelector = GText.getCssSelectorTxt("div", "class", "x-grid3-cell-inner x-grid3-col-col_Code1");
						break;
					}
					case "材料编码":{
						colCodesCssSelector = GText.getCssSelectorTxt("div", "class", "x-grid3-cell-inner x-grid3-col-col_CLBM x-unselectable");
						break;
					}
					case "使用单位":{
						colCodesCssSelector = GText.getCssSelectorTxt("div", "class", "x-grid3-cell-inner x-grid3-col-col_SYDW x-unselectable");
						break;
					}
					default:{
						colCodesCssSelector = GText.getCssSelectorTxt("div", "class", "x-grid3-cell-inner x-grid3-col-col_SYDW x-unselectable");
						break;
					}
				}
				colCodes = divGrid3.findElements(By.cssSelector(colCodesCssSelector));
				
				if (colCodes != null && colCodes.size() > 0) {//如果合同编号不为空
                  for(WebElement colCode:colCodes){
                	try {
                		if(colCode.getText().equals(tagColValue)) {
                			colCode.click();
                			GLog.logRecordTime(8, "按照[" + tagColName + "]查找到的目标[" + tagColValue.toString() + "]被点击了");
                    		break;
                		}
                	}catch (Exception e){
                		continue;
                	}
                  }
                }
				
				//再次等待，确保【加载中】蒙版消失
				GWCtrlWait.ViewWaitingTextByWebElement(GTestIndicators.PageShowTime, divGrid3, tagColValue);
			} catch (Exception e) {
				GWCtrlException.SwtichTo(e, 1, 8, "没有找到有效的[" + tagColName + "]参数", true);
			}
		}
	}
	
	/**
	 *  根据条件字符串选中【数据源】中某目标 搜索结果唯一时使用
	 *  
	 *  @param cooName 单位名称
	 */
	public void ui_C_SELECT_COO(String cooCode){
		if(divGrid3 != null) {
			GWCtrlWait.ViewWaitingTextByWebElement(GTestIndicators.PageShowTime, divGrid3, cooCode);
			try {
				List<WebElement> colCodes = divGrid3.findElements(By.cssSelector(GText.getCssSelectorTxt("div", "class", "x-grid3-cell-inner x-grid3-col-0 x-unselectable")));
				for(WebElement colCode:colCodes){
					List<WebElement> spans = colCode.findElements(By.tagName("span"));
					for(WebElement span:spans){
						if(span.getText().equals(cooCode)) {//目前只保存第一个找到的grid3
							colCode.click();
							GLog.logRecordTime(8, "目标[" + cooCode.toString() + "]被点击了");
							break;
						}
					}
				}
				GWCtrlWait.ViewWaitingTextByWebElement(GTestIndicators.PageShowTime, divGrid3, cooCode);
			} catch (Exception e) {
				GWCtrlException.SwtichTo(e, 1, 8, "没有找到有效的编码参数", true);
			}
		}
	}
	
	/**
	 *  根据条件字符串选中【选中值】中某目标
	 *  
	 *  @param tagColCode 选中条件，使用【编码】为选中条件
	 */
	public void ui_C_SELECT_SELECTED(String tagColCode){
		if(divGrid3 != null) {
			GWCtrlWait.ViewWaitingTextByWebElement(GTestIndicators.PageShowTime, divGrid3, tagColCode);
			try {
				List<WebElement> colCodes = divGrid3.findElements(By.cssSelector(GText.getCssSelectorTxt("div", "class", "x-grid3-row-table")));
				for(WebElement colCode:colCodes){
					if(colCode.getText().equals(tagColCode)) {//目前只保存第一个找到的grid3
						colCode.click();
						GLog.logRecordTime(8, "目标[" + tagColCode.toString() + "]被点击了");
						break;
					}
				}
				GWCtrlWait.ViewWaitingTextByWebElement(GTestIndicators.PageShowTime, divGrid3, tagColCode);
			} catch (Exception e) {
				GWCtrlException.SwtichTo(e, 1, 8, "没有找到有效的编码参数", true);
			}
		}
	}
	
    /**
     * 打印WebElement值
     */
    public void showWebElementTableMap(){
		GLog.logRecordTime(8, "----表格对象----");
		GLog.logRecordTime(8, table_Row_WebElement.toString());
    }
    
    /**
     * 打印WebElement对应的Text文本值
     */
    public void showWebElementTextTableMap(){
		GLog.logRecordTime(8, "----表格对象----");
		GLog.logRecordTime(8, table_Row_WebElement_Text.toString());
    }
	
	/**
	 *  根据行列位置坐标点击目标框内的浏览按钮
	 *  
	 *  @param dRow 行号
	 *  @param dCol 列号
	 */
	public void ui_C_GRID3_BROWSE(int dRow, int dCol, String inputId){
		try {
			//按照行号查找行元素
			WebElement inputDiv = (table_Row_WebElement.get(Integer.valueOf(dRow))).get(dCol);
			if(inputDiv != null){
				inputDiv.click();
				WebElement input = GParam.g_Dr.findElement(By.id(inputId));
				WebElement inputRootDiv = input.findElement(By.xpath(".."));
				if(inputRootDiv != null) {
					List<WebElement> spans = inputRootDiv.findElements(By.tagName("span"));
					if(spans != null) {
						for(WebElement span:spans){
							span.click();
							GLog.logRecordTime(8, "点击元素[" + dRow + "][" + dCol + "]浏览器按钮成功");
							break;
						}
					}
				}	
			}
		} catch (Exception e) {
			GWCtrlException.SwtichTo(e, 1, 8, "点击元素[" + dRow + "][" + dCol + "]浏览器按钮失败", true);
			e.printStackTrace();
		}	
	}
    
	/**
	 *  根据行列位置坐标填入指定内容
	 *  
	 *  @param dRow 行号
	 *  @param dCol 列号
	 *  @param inputId 写入位置
	 *  @param str 写入内容
	 *  @param blank 空白处
	 */
	public void ui_C_GRID3_FILL(int dRow, int dCol, String inputId, String str, String blank){
		try {
			//按照行号查找行元素
			WebElement inputDiv = (table_Row_WebElement.get(Integer.valueOf(dRow))).get(dCol);
			if(inputDiv != null){
				GWCtrlInputFill.ByWebElementFromClickDiv(inputDiv, inputId, str, blank, false);
			}
		} catch (Exception e) {
			GWCtrlException.SwtichTo(e, 1, 8, "填写元素[" + dRow + "][" + dCol + "]失败", true);
			e.printStackTrace();
		}	
	}
	
	/**
     *  根据行列位置坐标填入指定内容-适用于类别
     *  
     *  @param dRow 行号
     *  @param dCol 列号
     *  @param inputId 写入位置
     *  @param str 写入内容
     *  @param blank 空白处
     */
	public void ui_C_GRID3_FILL_CATEGORY(int dRow, int dCol, String inputId, String str, String blank){
      try {
          //按照行号查找行元素
          WebElement inputDiv = (table_Row_WebElement.get(Integer.valueOf(dRow))).get(dCol);
          if(inputDiv != null){
              GWCtrlInputFill.ByWebElementFromClickDiv_Category(inputDiv, inputId, str, blank, false);
          }
      } catch (Exception e) {
          GWCtrlException.SwtichTo(e, 1, 8, "填写元素[" + dRow + "][" + dCol + "]失败", true);
          e.printStackTrace();
      }   
  }
	
	/**
	 *  根据行列号获得【数据源】中某目标的值
	 *  
	 *  @param dRow 行号
	 *  @param dCol 列号
	 */
	public String ui_C_GRID3_VALUE(int dRow, int dCol){
		String tValue = "";
		if(table_Row_WebElement != null) {
			try {
				//按照行号查找行元素
				WebElement tDiv = (table_Row_WebElement.get(Integer.valueOf(dRow))).get(dCol);
				GLog.logRecordTime(8, "Get WebElement [" + tDiv.toString() + "]");
				JavascriptExecutor js=(JavascriptExecutor) GParam.g_Dr;
				js.executeScript("arguments[0].scrollIntoView(true);",tDiv);
				tValue = tDiv.getText();
				GLog.logRecordTime(8, "Get WebElement Text [" + tValue.toString() + "]");
			} catch (Exception e) {
				GWCtrlException.SwtichTo(e, 1, 8, "获得元素值 [" + dRow + "][" + dCol + "]失败", true);
			}
		}
		
		return tValue;
	}
	
	/**
	 *  根据行列号获得【合计】中某目标的值
	 *  
	 *  @param dRow 行号
	 *  @param dCol 列号
	 */
	public String ui_C_GRID3_VALUE_SUMMARY(String domParentType, String domParentValue, int dRow, int dCol){
		String tValue = "";
		
		WebElement domParent = null;

		switch(domParentType) {
			case "id":{
				GWCtrlWait.ViewWaitingById(GTestIndicators.PageShowTime, domParentValue);
				domParent = GParam.g_Dr.findElement(By.id(domParentValue));
				break;
			}
			case "cssSelector":{
				GWCtrlWait.ViewWaitingAllByCssSelector(GTestIndicators.PageShowTime, domParentValue);
				domParent = GParam.g_Dr.findElement(By.cssSelector(domParentValue));
				break;
			}
			case "xpath":{
				GWCtrlWait.ViewWaitingAllByXpath(GTestIndicators.PageShowTime, domParentValue);
				domParent = GParam.g_Dr.findElement(By.xpath(domParentValue));
				break;
			}
			default:{
				break;
			}
		}
		
		//是否执行grid3全局变量赋值
		boolean bSetMap = false;
		for(String[] id_detail:GWCtrlWebElementId.ID_DETAIL) {
			if(domParentValue.equals(id_detail[0])) {
				GLog.logRecordTime(8, "找到目标，类型为：grid3；类型为[" + id_detail[1] + "]");
				bSetMap = true;
				break;
			}
		}
		
		table_Summary_WebElement = new HashMap<Integer, Map<Integer, WebElement>>();
		table_Summary_WebElement_Text = new HashMap<Integer, Map<Integer, String>>();
		
		try {
			List<WebElement> grid3s = domParent.findElements(By.cssSelector(GText.getCssSelectorTxt("div", "class", "x-grid3")));
			if(grid3s != null) {
				GLog.logRecordTime(8, "找到目标，类型为：grid3；元素为[" + grid3s.toString() + "]");
				for(WebElement grid3:grid3s){
					if(grid3 != null) {//目前只保存第一个找到的grid3
						if(bSetMap) {
							//【总计】仅在一级窗体时读取
							if(!domParentValue.equals("treeView") && !domParentValue.equals("Source") && !domParentValue.equals("Selected")){
								//读取摘要
								List<WebElement> summarys = grid3.findElements(By.cssSelector(GText.getCssSelectorTxt("table", "class", "x-grid3-summary-table")));
								int summaryIndex = 0;
								Map<Integer, WebElement> summaryTemp = new HashMap<Integer, WebElement>();
								Map<Integer, String> summaryTextTemp = new HashMap<Integer, String>();
								for(WebElement summary:summarys){
									if(summary != null) {
										summaryIndex++;
										List<WebElement> cols = summary.findElements(By.tagName("td"));
										int colIndex = 0;
										for(WebElement col:cols){
											if(col != null) {
												JavascriptExecutor js=(JavascriptExecutor) GParam.g_Dr;
												js.executeScript("arguments[0].scrollIntoView(true);",col);
												List<WebElement> colDivs = col.findElements(By.tagName("div"));
												for(WebElement colDiv:colDivs){
													colIndex++;
													summaryTemp.put(Integer.valueOf(colIndex), colDiv);
													summaryTextTemp.put(Integer.valueOf(colIndex), colDiv.getText());
												}	
											}
										}
										table_Summary_WebElement.put(Integer.valueOf(summaryIndex), summaryTemp);
										table_Summary_WebElement_Text.put(Integer.valueOf(summaryIndex), summaryTextTemp);
									}
								}
//								GLog.logRecordTime(8, "----表格对象----");
//								GLog.logRecordTime(8, table_Summary_WebElement_Text.toString());
							}
						}
						GLog.logRecordTime(8, "第一个grid3加载完成；元素为[" + grid3.toString() + "]");
						break;
					}
				}
			}
		} catch (Exception e) {
			GWCtrlException.SwtichTo(e, 1, 8, "没有找到有效的grid3元素", true);
		}
		
		if(table_Summary_WebElement != null) {
			try {
				//按照行号查找行元素
				WebElement tDiv = (table_Summary_WebElement.get(Integer.valueOf(dRow))).get(dCol);
				GLog.logRecordTime(8, "Get WebElement [" + tDiv.toString() + "]");
				JavascriptExecutor js=(JavascriptExecutor) GParam.g_Dr;
				js.executeScript("arguments[0].scrollIntoView(true);",tDiv);
				tValue = tDiv.getText();
				GLog.logRecordTime(8, "Get WebElement Text [" + tValue.toString() + "]");
			} catch (Exception e) {
				GWCtrlException.SwtichTo(e, 1, 8, "获得[合计]元素值 [" + dRow + "][" + dCol + "]失败", true);
			}
		}
		
		return tValue;
	}
	
	/**
	 *  根据行列号获得【数据源】中某目标的元素
	 *  
	 *  @param dRow 行号
	 *  @param dCol 列号
	 */
	public WebElement ui_C_GRID3_WEBELEMENT(int dRow, int dCol){
		WebElement tWebValue = null;
		if(table_Row_WebElement != null) {
			try {
				//按照行号查找行元素
				WebElement tDiv = (table_Row_WebElement.get(Integer.valueOf(dRow))).get(dCol);
				GLog.logRecordTime(8, "Get WebElement [" + tDiv.toString() + "]");
				JavascriptExecutor js=(JavascriptExecutor) GParam.g_Dr;
				js.executeScript("arguments[0].scrollIntoView(true);",tDiv);
				tWebValue = tDiv;
				GLog.logRecordTime(8, "Get WebElement Text [" + tWebValue.toString() + "]");
			} catch (Exception e) {
				GWCtrlException.SwtichTo(e, 1, 8, "获得元素 [" + dRow + "][" + dCol + "]失败", true);
			}
		}
		
		return tWebValue;
	}
}
