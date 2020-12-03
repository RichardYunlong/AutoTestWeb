package AutoTestWeb;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.io.FileUtils;

import AutoTest.GFile;
import AutoTest.GLog;
import AutoTest.GMsg;
import AutoTest.GPath;
import AutoTest.GSys;
import AutoTest.GTransfer;
import io.qameta.allure.Step;

public class GWCtrlMonitorBI {

	/**
	 *  正产-强化
	 */
	private final static String SUCCESS_HIGH_GREEN = "#00CC99";
	
	/**
	 *  异常-强化
	 */
	private final static String FAIL_HIGH_RED = "#FF0000";
	
	/**
	 *  导出html版本测试报告
	 */	
	@Step("导出html版本测试报告")
	public static void outPutHtml() {
		GFile.deleteFolder(GPath.REPORT_PATH);
		GFile.creatDir(GPath.REPORT_PATH);
		GWCtrlSummoryBI.LoadSummary();
		
		if(GFile.copyFile("./config/monitorBI_template.html", GPath.REPORT_PATH + "monitorBI.html")) {
			File templateFile = new File("./report/monitorBI.html");
			String content = null;
			OutputStream fos = null;
			try {
				content = FileUtils.readFileToString(templateFile, "utf-8");
				
				//替换数据
				content = content.replaceAll("###version###", GWCtrlSummoryBI.TAR_VERSION);
				content = content.replaceAll("###tarsrc###", GWCtrlSummoryBI.TAR_SCR);
				content = content.replaceAll("###date###", GWCtrlSummoryBI.TAR_DATE);
				content = content.replaceAll("###startdate###", GWCtrlSummoryBI.TAR_STARTDATE);
				content = content.replaceAll("###enddate###", GWCtrlSummoryBI.TAR_ENDDATE);
				content = content.replaceAll("###spendtime###",  GWCtrlSummoryBI.TAR_SPENDTIME);
				content = content.replaceAll("###total_num###", GWCtrlSummoryBI.TAR_RUNTOTALNO.toString());
				content = content.replaceAll("###success_num###", GWCtrlSummoryBI.TAR_SUCCESS.toString());
				content = content.replaceAll("###failed_num###", GWCtrlSummoryBI.TAR_FAILED.toString());
				
				content = content.replaceAll("###dymic_table###", dynamicTable());
				
				//替换用例类型字段背景颜色
				content = content.replaceAll("###success_status_color###", SUCCESS_HIGH_GREEN);
				content = content.replaceAll("###failed_status_color###", FAIL_HIGH_RED);
				content = content.replaceAll("###success_color###", SUCCESS_HIGH_GREEN);
				content = content.replaceAll("###failed_color###", FAIL_HIGH_RED);
				
				//加载饼图份额
				content = content.replaceAll("###green###", GWCtrlSummoryBI.strProportion_Total[1]);
				content = content.replaceAll("###red###", GWCtrlSummoryBI.strProportion_Total[2]);
				content = content.replaceAll("###blue###", GWCtrlSummoryBI.strProportion_Total[3]);
				content = content.replaceAll("###yellow###", GWCtrlSummoryBI.strProportion_Total[4]);
				
				fos = new FileOutputStream(templateFile);
				fos.write(content.getBytes("UTF-8"));
				fos.flush();
				fos.close();
				Runtime.getRuntime().exec("cmd.exe /c start " + "./report/monitorBI.html");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if(fos != null)fos.close();
				} catch (IOException e) {
					GLog.logShowConsole(GMsg.MSG_CONSOLE[0] + content);
					e.printStackTrace();
				}
			}
		}else {
			GSys.logSys("HTML TEST REPORT OUTPUT FAILED");
		}
	}
	
	/**
	 *  动态生成表格
	 */	
	@Step("动态生成表格")
	public static String dynamicTable() {
		String dynamicTable = "";
		
		int nIndex = 0;
		for(;nIndex < GWCtrlSummoryBI.monitorBI.size();nIndex++){
			String resultColorTemp = "";
			String resultTemp = "";
			String company_Temp = "";
			String menu_l1Temp = "";
			String menu_l2Temp = "";
			String canvas_nameTemp = "";
			String urlTemp = GTransfer.gServerUrl[0];
			String marktemp = "";

			String monitorBITemp = GWCtrlSummoryBI.monitorBI.get(Integer.valueOf(nIndex));
			if(monitorBITemp != null && !monitorBITemp.isEmpty()) {
				String[] strArr = monitorBITemp.split("\\|");
				company_Temp = strArr[0];
				menu_l1Temp = strArr[1];
				menu_l2Temp = strArr[2];
				canvas_nameTemp = strArr[3];
				marktemp = strArr[4];
				
				//仅显示失败
				if(marktemp.equals("Success")) {
					resultColorTemp = "success_color";
					resultTemp = "SUCCESS";
				}else{
					resultColorTemp = "failed_color";
					resultTemp = "FAILED";
					
					dynamicTable +=  "<tr>"
						     + "<td width=\"124\" bgcolor=\"###" + resultColorTemp + "###\">" + resultTemp + "</td>"
						     + "<td width=\"100\" bgcolor=\"#FFFFFF\">"+ company_Temp + "</td>"
							 + "<td width=\"100\" bgcolor=\"#FFFFFF\">"+ menu_l1Temp + "</td>"
							 + "<td width=\"100\" bgcolor=\"#FFFFFF\">"+ menu_l2Temp + "</td>"
							 + "<td width=\"200\" bgcolor=\"#FFFFFF\">"+ canvas_nameTemp + "</td>"
							 + "<td width=\"200\" bgcolor=\"#FFFFFF\"><a href=\"" + urlTemp + "\">访问地址</a></td>"
							 + "<td width=\"200\" bgcolor=\"#FFFFFF\">" + marktemp + "</td>"
						     +"</tr>";
				}
			}
    	}

		return dynamicTable;
	} 
	
	public static void main(String[] agrs) {
//		GWCtrlMonitorBI monitorBI = new GWCtrlMonitorBI();
//		monitorBI.outPutHtml();
//		
//		float a = 18.650001f;
//		int scale = 2;//设置位数   
//		BigDecimal bd = new BigDecimal((double)a);  
//		bd = bd.setScale(scale,BigDecimal.ROUND_DOWN);  
//		a = bd.floatValue();  
//   
//		System.out.print(a);
//		String res = "领导舱|空|本年计划合同额|Success";
//		
//		String[] strArr = res.split("\\|");
//		String s1 = strArr[0];
//		String s2 = strArr[1];
//		String s3 = strArr[2];
//		String s4 = strArr[3];
//		
//		System.out.println(s1);
//		System.out.println(s2);
//		System.out.println(s3);
//		System.out.println(s4);
	}
}
