package Admin.GScope;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import AutoTest.GException;
import AutoTest.GLog;
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
 * 管理范围
 * @author zhangc-z 2020-11-2 14：15
 *
 */
public class GScope {

	/**
	 * 数据
	 */
    private Data uData = null;

    /**
     * UI层调用的管理范围方法
     */
    @Step("管理范围")
    public void ui_G_GSCOPE() {
        ui_D_INIT();
        ui_C_TREE_MODULE();
        ui_C_AUTHIRITY_SCOPE();
    }

    /**
     * 数据初始化
     */
    @Step("管理范围")
    public void ui_D_INIT() {
        uData = new Data();
    }

    /**
     * 选择模块
     */
    @Step("选择模块")
    public void ui_C_TREE_MODULE() {
        GLog.logRecordTime(9, "[功能]----执行[选择功能模块]");
        try {
            GWCtrlLeftMenu.ui_C_CHOOSE_MODULE(uData.pageREQ.MODULE_WAIT_ID);
            GLog.logRecordTime(9, "[功能]----执行[选择功能模块]成功");
        } catch (Exception e) {
            uData.bRES = false;
            GLog.logRecordTime(9, "[功能]----执行[选择功能模块]失败");
        if (AutoTest.GTestCase.dTSSTYLE == 1)
            AutoTest.GParam.gRes = GException.getExceptionAllinformation(e);
            e.printStackTrace();
        }
    }

    /**
     * 管理范围的逻辑层代码
     */
    @Step("授权管理范围")
    private void ui_C_AUTHIRITY_SCOPE() {
        // 切换iframe
        GWCtrlFrame.ui_C_SWITCN_ELEMENT(GWCtrlWebElementIframe.getIframe(1));
        // 过滤分类树搜索框输入要授权的用户名
        GWCtrlWait.Wait2BeClickableById(GTestIndicators.PageShowTime, uData.mapUser.get("过滤分类树搜索框"));
        GWCtrlInputFill.ByIdUnClear(uData.mapUser.get("过滤分类树搜索框"), uData.mapUser.get("用户姓名"));
        // 选中查出来的用户
        GWCtrlWait.ViewWaitingTextById(GTestIndicators.PageShowTime, uData.mapUser.get("用户授权树"),
            uData.mapUser.get("用户姓名"));
        GWCtrlGrid3 grid3 = new GWCtrlGrid3("id", uData.mapUser.get("用户授权树"));
        grid3.ui_C_GRID3_WEBELEMENT(1, 1).click();
        // 点击新建
        GWCtrlWait.Wait2BeClickableById(GTestIndicators.PageShowTime, "AddBtn");
        GWCtrlDivClick.ById(uData.mapUser.get("新建"));
        // 选中管理本人数据
        GWCtrlWait.Wait2BeClickableById(GTestIndicators.PageShowTime, uData.mapUser.get("管理本人数据"));
        GWCtrlInputClick.ById(uData.mapUser.get("管理本人数据"));
        // 选中查看组织数据
        GWCtrlWait.Wait2BeClickableById(GTestIndicators.PageShowTime, uData.mapUser.get("查看组织数据"));
        GWCtrlInputClick.ById(uData.mapUser.get("查看组织数据"));
        // 选中管理组织数据
        GWCtrlWait.Wait2BeClickableById(GTestIndicators.PageShowTime, uData.mapUser.get("管理组织数据"));
        GWCtrlInputClick.ById(uData.mapUser.get("管理组织数据"));
        // 等待所属集团出现
        GWCtrlWait.ViewWaitingTextById(GTestIndicators.PageShowTime, uData.mapUser.get("组织管理范围常用对象树"),
            "所属集团");
        grid3 = new GWCtrlGrid3("id", uData.mapUser.get("组织管理范围常用对象树"));
        grid3.ui_C_GRID3_WEBELEMENT(2, 2).click();
        // 右移管理范围
        GWCtrlWait.Wait2BeClickableById(GTestIndicators.PageShowTime, uData.mapUser.get("左移右移"));
        WebElement divElement = GParam.g_Dr.findElement(By.id(uData.mapUser.get("左移右移")));
        WebElement tablElement = divElement.findElement(By.cssSelector("button[class=\" x-btn-text x-tbar-page-next\"]"));
        GWCtrlWait.Wait2BeClickableByWebElement(GTestIndicators.PageShowTime, tablElement);
        tablElement.click();
        // 点击确定
        GWCtrlDivClick.ById(uData.mapUser.get("确定"));
        //切换回顶层
        GWCtrlFrame.ui_C_SWITCN_DEFAULT();
    }
}
