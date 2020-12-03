package Login.GOrgLevel;

import AutoTest.GTestCase;
import AutoTestWeb.GWCtrlChooseOrg;
import AutoTestWeb.GWCtrlPage;
import io.qameta.allure.Step;

/**
 *  用户修改机构层级业务逻辑
 */
public class ChangeOrg {
	
	/**
	 *  数据
	 */
	private Data pData = null;
	
	/**
	 *  修改层级
	 */
	@Step("修改层级")
	public void ui_G_CHANGE_ORG(){
		pData = new Data();
		
		System.out.println("[功能]----修改层级");
		try {
			GWCtrlChooseOrg.SelectOrg("GAT项目部");
			GWCtrlPage.ui_C_REFRESH();
			pData.bOrgStatus = true;
			System.out.println("[功能]----修改层级成功");
		}catch (Exception e){
			pData.bOrgStatus = false;
			System.out.println("[功能]----修改层级失败");
			e.printStackTrace();
		}
		
		GTestCase.setTestCaseRst(pData.bOrgStatus);
	}
	
	/**
	 *  修改层级
	 *  
	 *  @param orgName 机构名称
	 */
	@Step("修改层级-[{0}]")
	public void ui_G_CHANGE_ORG(String orgName){
		pData = new Data();
		
		System.out.println("[功能]----修改层级至[" + orgName + "]");
		try {
			GWCtrlChooseOrg.SelectOrg(orgName);
			GWCtrlPage.ui_C_REFRESH();
			pData.bOrgStatus = true;
			System.out.println("[功能]----修改层级至[" + orgName + "]成功");
		}catch (Exception e){
			pData.bOrgStatus = false;
			System.out.println("[功能]----修改层级至[" + orgName + "]失败");
			e.printStackTrace();
		}
		
		GTestCase.setTestCaseRst(pData.bOrgStatus);
	}
}
