package Admin.GAuthirity;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import AutoTest.GException;
import AutoTest.GLog;
import AutoTestWeb.GParam;
import AutoTestWeb.GTestIndicators;
import AutoTestWeb.GWCtrlDivClick;
import AutoTestWeb.GWCtrlFrame;
import AutoTestWeb.GWCtrlGrid3;
import AutoTestWeb.GWCtrlInputFill;
import AutoTestWeb.GWCtrlLeftMenu;
import AutoTestWeb.GWCtrlWait;
import AutoTestWeb.GWCtrlWebElementIframe;
import io.qameta.allure.Step;


/**
 * 用户授权
 * @author zhangc-z 2020-10-25 12:25
 *
 */
public class Authirity {
	
		/**
		 *  数据
		 */
		private Data pData = null;

		/**
		 *  用户授权
		 */
		@Step("用户授权")
		public void ui_G_AUTHIRITY() {
		  ui_D_INIT();
		  ui_C_TREE_MODULE();
		  for (int i = 0; i < pData.listUserPower.size(); i++) {
			  ui_C_USER_AUTHIRITY(pData.listUserPower.get(i),i);
	      }
		}
	
		/**
		 *  初始化
		 */
		@Step("初始化")
		private void ui_D_INIT(){
			pData = new Data();
		}
	
		/**
		 *  选择模块
		 */
		@Step("选择模块")
		private void ui_C_TREE_MODULE(){
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

		/**
		 * 根据权限名称和权限项序号给用户授权
		 * 
		 * @param spanname 权限名称
		 * @param index 权限项序号 参考 Data.listUserPower
		 */
		@Step("根据权限名称和权限项序号给用户授权")
		private void ui_C_USER_AUTHIRITY(String spanname,int index) {
		  GLog.logRecordTime(9, "[功能]----执行[" + pData.mapUser.get("用户姓名") + "]授权");
		  try {    
			    GWCtrlFrame.ui_C_SWITCN_ELEMENT(GWCtrlWebElementIframe.getIframe(1));
			    //点击“新建授权”
		        GWCtrlWait.Wait2BeClickableById(GTestIndicators.PageShowTime, pData.mapUser.get("新建授权"));
			    GWCtrlDivClick.ById(pData.mapUser.get("新建授权"));
			    //输入“授权对象”并搜索
			    GWCtrlWait.Wait2BeClickableById(GTestIndicators.PageShowTime, pData.mapUser.get("授权搜索框"));
			    GWCtrlInputFill.ByIdUnClear(pData.mapUser.get("授权搜索框"), pData.mapUser.get("用户姓名"));
			    //选中
			    GWCtrlWait.ViewWaitingTextById(GTestIndicators.PageShowTime, pData.mapUser.get("用户授权树"), pData.mapUser.get("用户姓名"));
			    GWCtrlGrid3 grid3 = new GWCtrlGrid3("id", pData.mapUser.get("用户授权树"));
			    grid3.ui_C_GRID3_WEBELEMENT(1, 1).click();
		        //用户右移
			    GWCtrlWait.Wait2BeClickableById(GTestIndicators.PageShowTime, pData.mapUser.get("授权用户右移按钮"));
			    GWCtrlDivClick.ByIdClick(pData.mapUser.get("授权用户右移按钮"));
	            //等待授权的用户进入到授权用户树中
                GWCtrlWait.ViewWaitingTextById(GTestIndicators.PageShowTime, pData.mapUser.get("授权用户树"), pData.mapUser.get("用户姓名"));
			    //切换至“选择功能操作”
			    GWCtrlWait.Wait2BeClickableById(GTestIndicators.PageShowTime, pData.mapUser.get("选择功能操作"));
		        GWCtrlDivClick.ByIdClick(pData.mapUser.get("选择功能操作"));
		        //勾选权限复选框
		        WebElement Checkbox = ui_C_GET_CHECKBOX(index,spanname);
		        Checkbox.click();
		        //选择功能右移动
		        GWCtrlWait.Wait2BeClickableById(GTestIndicators.PageShowTime, pData.mapUser.get("授权功能右移按钮"));
		        GWCtrlDivClick.ByIdClick(pData.mapUser.get("授权功能右移按钮"));
		        // 使用有数据的div来做判断依据，当下方try中的类存在时，证明数据加载完成
		        WebElement bodyElement;
		        GWCtrlWait.Wait2BeClickableById(GTestIndicators.PageShowTime,
		            "RegDialog_cardPanel_funcSelector_tar");
		        Boolean twBoolean = true;
		        if (index > 0) {
		          while (twBoolean) {
		            try {
		              WebElement tarElement =
		                  GParam.g_Dr.findElement(By.id("RegDialog_cardPanel_funcSelector_tar"));
		              bodyElement = tarElement.findElement(By.cssSelector("div[class=\"x-grid3-body\"]"));
		              bodyElement.findElement(By.cssSelector("div[class=\"x-grid-empty\"]"));
		            } catch (Exception e) {
		              twBoolean = false;
		            }
		          }
		        } else {
		          while (twBoolean) {
		            try {
		              WebElement tarElement =
		                  GParam.g_Dr.findElement(By.id("RegDialog_cardPanel_funcSelector_tar"));
		              bodyElement = tarElement.findElement(By.cssSelector("div[class=\"x-grid3-body\"]"));
		              bodyElement.findElement(By.cssSelector("div"));
		              twBoolean = false;
		            } catch (Exception e) {
		  
		            }
		          }
		  
		        }
		        GWCtrlDivClick.ByIdClick(pData.mapUser.get("授权确定按钮"));
		        WebElement MyElement = GParam.g_Dr.findElement(By.id("RegDialog"));
		        GLog.logRecordTime(9, "[功能]----【"+pData.mapUser.get("用户姓名")+"】用户【"+spanname+"】模块功能开始授权！");
		        //使用while 来进行等待元素的显隐
		        while (MyElement.isDisplayed()) {
		          System.out.println("授权中.......");
		        }
		        GWCtrlFrame.ui_C_SWITCN_DEFAULT();
		        GLog.logRecordTime(9, "[功能]----【"+spanname+"】模块功能授权完成！");
	      } catch (Exception e) {
		        pData.bRES = false;
		        GLog.logRecordTime(9, "[功能]----【"+pData.mapUser.get("用户姓名")+"】用户【"+spanname+"】模块功能授权失败！");
		        if (AutoTest.GTestCase.dTSSTYLE == 1)
		            AutoTest.GParam.gRes = GException.getExceptionAllinformation(e);
		        e.printStackTrace();
	      }
	    }

		/**
		 * 根据权限名称和权限项序号查找复选框
		 * 
		 * @param spanname 复选框名字
		 * @param index 权限项序号 参考 Data.listUserPower
		 * 
		 * @return 复选框元素
		 */
		@Step("根据权限名称和权限项序号查找复选框")
		private WebElement ui_C_GET_CHECKBOX(int index ,String spanname) {
		  GLog.logRecordTime(9, "[功能]----执行查找复选框功能]");
		  try {
		    GWCtrlWait.ViewWaitingByLinkText(GTestIndicators.PageShowTime, "项目管理");
		    WebElement ProjectElement = GParam.g_Dr.findElement(By.linkText("项目管理"));
		    GWCtrlWait.Wait2BeClickableByWebElement(GTestIndicators.PageShowTime, ProjectElement);
		    //双击
		    if (index==0) {
		      Actions action = new Actions(GParam.g_Dr);
		      action.doubleClick(ProjectElement).perform();  
	        }
		    GWCtrlWait.ViewWaitingByLinkText(GTestIndicators.PageShowTime, spanname);
		    WebElement MyElement = GParam.g_Dr.findElement(By.linkText(spanname));
		    GWCtrlWait.Wait2BeClickableByWebElement(GTestIndicators.PageShowTime, MyElement);
	        WebElement Parent = (WebElement) ((JavascriptExecutor) GParam.g_Dr).executeScript("return arguments[0].parentNode;", MyElement);
	        WebElement OldParent = (WebElement) ((JavascriptExecutor) GParam.g_Dr).executeScript("return arguments[0].parentNode;", Parent);
	        WebElement Checkbox = OldParent.findElement(By.cssSelector("input[type=\"checkbox\"]"));
	        GLog.logRecordTime(9, "[功能]----执行[查找复选框功能]成功");
	        return Checkbox;
	      } catch (Exception e) {
	        pData.bRES = false;
	        GLog.logRecordTime(9, "[功能]----执行[查找复选框功能]失败");
	        if (AutoTest.GTestCase.dTSSTYLE == 1)
	            AutoTest.GParam.gRes = GException.getExceptionAllinformation(e);
	        e.printStackTrace();
	        return null;
	      }  
	    }
}
