package Admin.GAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import AutoTest.GException;
import AutoTest.GLog;
import AutoTest.GTestCase;
import AutoTestWeb.GParam;
import AutoTestWeb.GTestIndicators;
import AutoTestWeb.GWCtrlDivClick;
import AutoTestWeb.GWCtrlFrame;
import AutoTestWeb.GWCtrlGrid3;
import AutoTestWeb.GWCtrlInputClick;
import AutoTestWeb.GWCtrlInputFill;
import AutoTestWeb.GWCtrlLeftMenu;
import AutoTestWeb.GWCtrlWait;
import AutoTestWeb.GWCtrlWebElementIframe;
import io.qameta.allure.Step;

/**
 * 用户创建并授权
 * @author zhangc-z 2020-10-23 10：02
 *
 */
public class List {
  
	  /**
	   *  数据
	   */
	  private Data pData = null;
  
	  /**
	   * 用户创建
	   */
	  @Step("用户创建")
	  public void ui_G_USER_ADD() {
	    ui_D_INIT();
	    ui_C_TREE_MODULE();
	    ui_C_NEW();  
	  }
  
	  /**
	   * 用户删除
	   */
	  @Step("用户删除")
	  public void ui_G_USER_DELETE() {
	    ui_D_INIT();
	    ui_C_TREE_MODULE();
	    ui_C_DELETE();  
	  }
  
	  /**
	   * 新建
	   */
	  @Step("新建")
	  private void ui_C_NEW() {
		    GLog.logRecordTime(9, "[功能]----执行新建用户[" + pData.mapUser.get("用户姓名") + "]操作");
		    try {
			      GWCtrlFrame.ui_C_SWITCN_ELEMENT(GWCtrlWebElementIframe.getIframe(1));
			      //点击“新建”
			      GWCtrlWait.ViewWaitingById(GTestIndicators.PageShowTime, pData.mapUser.get("新建"));
			      GWCtrlDivClick.ById(pData.mapUser.get("新建"));
			      //填写“用户姓名”
			      GWCtrlWait.ViewWaitingById(GTestIndicators.PageShowTime, pData.mapUser.get("用户姓名id"));
			      GWCtrlInputFill.ById(pData.mapUser.get("用户姓名id"), pData.mapUser.get("用户姓名"));
			      //打开“所属部门”树
			      GWCtrlWait.ViewWaitingById(GTestIndicators.PageShowTime, pData.mapUser.get("所属部门id"));
			      GWCtrlInputClick.ById(pData.mapUser.get("所属部门id"));
			      //输入搜索条件并搜索
			      GWCtrlWait.ViewWaitingById(GTestIndicators.PageShowTime, pData.mapUser.get("搜索框"));
			      GWCtrlInputFill.ById(pData.mapUser.get("搜索框"), pData.mapUser.get("所属部门"));
			      //在结果中选中目标
			      GWCtrlWait.ViewWaitingTextById(GTestIndicators.PageShowTime, pData.mapUser.get("部门搜索结果"), pData.mapUser.get("所属部门"));
			      GWCtrlGrid3 gwCtrlGrid3 = new GWCtrlGrid3("id", pData.mapUser.get("部门搜索结果"));
			      gwCtrlGrid3.ui_C_GRID3_WEBELEMENT(1, 1).click();
			      GWCtrlWait.ViewWaitingById(GTestIndicators.PageShowTime, pData.mapUser.get("确定"));
			      GWCtrlDivClick.ById(pData.mapUser.get("确定"));
			      GWCtrlWait.ViewWaitingById(GTestIndicators.PageShowTime, pData.mapUser.get("提交并关闭"));
			      GWCtrlDivClick.ById(pData.mapUser.get("提交并关闭"));
			      pData.bRES = true;
			      GLog.logRecordTime(9, "[功能]----执行新建[" + pData.mapUser.get("用户姓名") + "]成功");
		    } catch (Exception e) {
			      pData.bRES = false;
			      GLog.logRecordTime(9, "[功能]----执行新建[" + pData.mapUser.get("用户姓名") + "]失败");
			      if (AutoTest.GTestCase.dTSSTYLE == 1)
			          AutoTest.GParam.gRes = GException.getExceptionAllinformation(e);
		    }
		    GTestCase.setTestCaseRst(pData.bRES);
	  }
  
	  /**
	   * 删除
	   */
	  @Step("删除")
	  public void ui_C_DELETE() {
	    GLog.logRecordTime(9, "[功能]----执行删除用户[" + pData.mapUser.get("用户姓名") + "]操作");
	    try {
	      GWCtrlFrame.ui_C_SWITCN_ELEMENT(GWCtrlWebElementIframe.getIframe(1));
	      GWCtrlWait.ViewWaitingById(GTestIndicators.PageShowTime, "edQueryBox");
	      GWCtrlInputFill.ById("edQueryBox",pData.mapUser.get("用户姓名"));
	      WebElement boxElement = GParam.g_Dr.findElement(By.id("edQueryBox"));
	      WebElement OldParent = (WebElement) ((JavascriptExecutor) GParam.g_Dr).executeScript("return arguments[0].parentNode;", boxElement);
	      WebElement imgElement = OldParent.findElement(By.cssSelector("img"));
	      imgElement.click();
          //在结果中选中目标
          GWCtrlWait.ViewWaitingTextById(GTestIndicators.PageShowTime, "userList", pData.mapUser.get("用户姓名"));
          GWCtrlGrid3 gwCtrlGrid3 = new GWCtrlGrid3("id", "userList");
          gwCtrlGrid3.showWebElementTextTableMap();
          gwCtrlGrid3.ui_C_GRID3_WEBELEMENT(1, 1).click();
	      GWCtrlWait.Wait2BeClickableById(GTestIndicators.PageShowTime, "actRemoveUser");
	      GWCtrlDivClick.ById("actRemoveUser");
	      GWCtrlWait.Wait2BeClickableByCssSelector(GTestIndicators.PageShowTime, "div[class=\"x-panel-fbar x-small-editor x-toolbar-layout-ct\"]");
	      WebElement divElement = GParam.g_Dr.findElement(By.cssSelector("div[class=\"x-panel-fbar x-small-editor x-toolbar-layout-ct\"]"));
	      WebElement buttonElement = divElement.findElement(By.xpath("table[@class=\"x-toolbar-ct\"]/tbody/tr/td[2]/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]/em/button"));
	      buttonElement.click();
	      pData.bRES = true;
	      GLog.logRecordTime(9, "[功能]----执行删除用户[" + pData.mapUser.get("用户姓名") + "]成功");  
	    } catch (Exception e) {
	      pData.bRES = false;
	      GLog.logRecordTime(9, "[功能]----执行删除用户[" + pData.mapUser.get("用户姓名") + "]失败");
	      if (AutoTest.GTestCase.dTSSTYLE == 1)
	          AutoTest.GParam.gRes = GException.getExceptionAllinformation(e);
	    }
	    
	  }
	  
	  /**
	   *  初始化
	   */
	  @Step("初始化")
	  public void ui_D_INIT(){
	      pData = new Data();
	  }
  
	  /**
	   *  选择模块
	   */
	  @Step("选择模块")
	  public void ui_C_TREE_MODULE(){
	      GLog.logRecordTime(9, "[功能]----执行[选择功能模块]");
	      try {
	          GWCtrlLeftMenu.ui_C_CHOOSE_MODULE(pData.pageREQ.MODULE_WAIT_ID);
	          GLog.logRecordTime(9, "[功能]----执行[选择功能模块]成功");
	      }catch (Exception e){
	          pData.bRES = false;
	          GLog.logRecordTime(9, "[功能]----执行[选择功能模块]失败");
	          if (AutoTest.GTestCase.dTSSTYLE == 1)
	              AutoTest.GParam.gRes = GException.getExceptionAllinformation(e);
	          e.printStackTrace();
	      }
	  }
}
